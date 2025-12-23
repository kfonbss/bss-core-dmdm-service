package in.gov.kfon.dmdm.service;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

import com.opencsv.CSVReader;
import jakarta.persistence.EntityNotFoundException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class DataMigrationServiceImpl implements DataMigrationService {
  private final DataSource dataSource;
  private static final Map<String, String> DISTRICT_CODE_MAP =
      Map.ofEntries(
          Map.entry("Kottayam", "KTM"),
          Map.entry("Malappuram", "MLP"),
          Map.entry("Thrissur", "TCR"),
          Map.entry("Alappuzha", "ALP"),
          Map.entry("Ernakulam", "EKM"),
          Map.entry("Idukki", "IDK"),
          Map.entry("Kannur", "KNR"),
          Map.entry("Kasaragod", "KGD"),
          Map.entry("Kollam", "KLM"),
          Map.entry("Kozhikode", "KKD"),
          Map.entry("Palakkad", "PLK"),
          Map.entry("Pathanamthitta", "PTA"),
          Map.entry("Thiruvananthapuram", "TVM"),
          Map.entry("Wayanad", "WYD"));

  // -------------------------------------------------District
  // ------------------------------------------------------

  @Override
  public void migrateDistrict(MultipartFile file) {

    if (file == null || file.isEmpty()) {
      throw new RuntimeException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new RuntimeException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (districtsTableHasData(conn)) {
        throw new RuntimeException("Districts already imported successfully");
      }

      runDistrictMigration(conn, file);

    } catch (Exception e) {
      throw new RuntimeException("Migration failed: " + e.getMessage(), e);
    }
  }

  private boolean districtsTableHasData(Connection conn) throws Exception {
    try (ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM districts")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  private void runDistrictMigration(Connection conn, MultipartFile file) throws Exception {

    String sql =
        """
            district_id, district_
        INSERT INTO districts (name, district_code,
            state_name, state_code, is_active,
            created_date, created_by, modified_date, modified_by
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext(); // skip header
      String[] cols;
      int batch = 0;

      while ((cols = reader.readNext()) != null) {

        Integer districtId = toInt(cols[84]); // bu_id
        String districtName = toStr(cols[55]); // District
        String stateName = toStr(cols[54]); // StateName
        Integer stateCode = toInt(cols[49]); // STCode

        if (districtId == null || districtName == null) {
          continue; // skip invalid rows
        }

        String districtCode = DISTRICT_CODE_MAP.getOrDefault(districtName.trim(), null);

        int p = 1;
        ps.setInt(p++, districtId); // district_id (migration value)
        ps.setString(p++, districtName); // district_name

        if (districtCode == null) ps.setNull(p++, Types.VARCHAR);
        else ps.setString(p++, districtCode); // district_code

        ps.setString(p++, stateName); // state_name
        ps.setInt(p++, stateCode); // state_code

        ps.setBoolean(p++, true); // is_active

        // audit fields → NULL
        ps.setNull(p++, Types.TIMESTAMP);
        ps.setNull(p++, Types.OTHER);
        ps.setNull(p++, Types.TIMESTAMP);
        ps.setNull(p++, Types.OTHER);

        ps.addBatch();

        if (++batch % 500 == 0) {
          ps.executeBatch();
        }
      }

      ps.executeBatch();
      conn.commit();

    } catch (Exception ex) {
      conn.rollback();
      throw ex;
    }
  }

  private String toStr(String v) {
    if (v == null) return null;
    v = v.trim();
    return (v.isEmpty() || v.equalsIgnoreCase("NULL")) ? null : v;
  }

  @Override
  public void migratePopMaster(MultipartFile file) {

    if (file == null || file.isEmpty()) {
      throw new RuntimeException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new RuntimeException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (popMasterTableHasData(conn)) {
        throw new RuntimeException("POP Master already migrated");
      }

      runPopMasterMigration(conn, file);

    } catch (Exception e) {
      throw new RuntimeException("POP Master migration failed: " + e.getMessage(), e);
    }
  }

  private boolean popMasterTableHasData(Connection conn) throws Exception {
    try (ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM pop_master")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  private void runPopMasterMigration(Connection conn, MultipartFile file) throws Exception {

    String sql =
        """
                INSERT INTO pop_master (
                    id,
                    master_id,
                    popname,
                    district,
                    poptype,
                    popid,
                    code,
                    name,
                    name_in_local,
                    is_active
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext();

      String[] cols;
      int batch = 0;

      while ((cols = reader.readNext()) != null) {

        Integer masterId = toInt(cols[0]);
        String popName = toStr(cols[1]);
        String district = toStr(cols[2]);
        String popType = toStr(cols[3]);
        String popId = toStr(cols[4]);

        if (masterId == null || popName == null) {
          continue;
        }

        int p = 1;
        ps.setObject(p++, UUID.randomUUID());
        ps.setInt(p++, masterId);
        ps.setString(p++, popName);
        ps.setString(p++, district);
        ps.setString(p++, popType);
        ps.setString(p++, popId);

        if (popId != null && popId.length() >= 3) {
          ps.setString(p++, popId.substring(popId.length() - 3));
        } else {
          ps.setNull(p++, Types.VARCHAR);
        }

        ps.setString(p++, popName);
        ps.setNull(p++, Types.VARCHAR);
        ps.setBoolean(p++, true);

        ps.addBatch();

        if (++batch % 500 == 0) {
          ps.executeBatch();
        }
      }

      ps.executeBatch();
      conn.commit();

    } catch (Exception ex) {
      conn.rollback();
      throw ex;
    }
  }

  private Integer toInt(String v) {
    try {
      return (v == null || v.trim().isEmpty()) ? null : Integer.parseInt(v.trim());
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public void migratePincodeDetails(MultipartFile file) {

    if (file == null || file.isEmpty()) {
      throw new RuntimeException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new RuntimeException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (pincodeTableHasData(conn)) {
        throw new EntityNotFoundException("Pincode details already migrated");
      }

      runPincodeMigration(conn, file);

    } catch (Exception e) {
      throw new RuntimeException("Pincode migration failed: " + e.getMessage(), e);
    }
  }

  private boolean pincodeTableHasData(Connection conn) throws Exception {
    try (ResultSet rs =
        conn.createStatement().executeQuery("SELECT COUNT(*) FROM pincode_details")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  private void runPincodeMigration(Connection conn, MultipartFile file) throws Exception {

    String sql =
        """
                INSERT INTO pincode_details (
                    id,
                    details_id,
                    pincode,
                    post_office_name,
                    sub_po_name,
                    district,
                    districtcode,
                    code,
                    name,
                    name_in_local,
                    is_active,
                    created_date,
                    created_by,
                    modified_date,
                    modified_by
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext();

      String[] cols;
      int batch = 0;

      while ((cols = reader.readNext()) != null) {

        Long detailsId = toLong(cols[0]);
        Integer pincode = toInt(cols[1]);
        String postOffice = toStr(cols[2]);
        String subPo = toStr(cols[3]);
        String district = toStr(cols[4]);
        Integer districtCode = toInt(cols[5]);

        if (pincode == null || postOffice == null) {
          continue;
        }

        int p = 1;
        ps.setObject(p++, UUID.randomUUID());
        ps.setLong(p++, detailsId);
        ps.setInt(p++, pincode);
        ps.setString(p++, postOffice);
        ps.setString(p++, subPo);
        ps.setString(p++, district);
        ps.setInt(p++, districtCode);

        ps.setString(p++, String.valueOf(pincode));

        ps.setString(p++, postOffice);

        ps.setNull(p++, Types.VARCHAR);
        ps.setBoolean(p++, true);

        ps.setNull(p++, Types.TIMESTAMP);
        ps.setNull(p++, Types.OTHER);
        ps.setNull(p++, Types.TIMESTAMP);
        ps.setNull(p++, Types.OTHER);

        ps.addBatch();

        if (++batch % 500 == 0) {
          ps.executeBatch();
        }
      }

      ps.executeBatch();
      conn.commit();

    } catch (Exception ex) {
      conn.rollback();
      throw ex;
    }
  }

  private Long toLong(String v) {
    try {
      return (v == null || v.trim().isEmpty()) ? null : Long.parseLong(v.trim());
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public void migrateRevenueShare(MultipartFile file) {

    if (file == null || file.isEmpty()) {
      throw new RuntimeException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new RuntimeException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (tableHasData(conn)) {
        throw new RuntimeException("Revenue Share already migrated");
      }

      runMigration(conn, file);

    } catch (Exception e) {
      throw new RuntimeException("Migration failed: " + e.getMessage(), e);
    }
  }

  private boolean tableHasData(Connection conn) throws Exception {
    try (ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM revenueshare")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  private void runMigration(Connection conn, MultipartFile file) throws Exception {

    String sql =
        """
                INSERT INTO revenueshare (
                  revenueshareid, sharename, subgroup,
                  ibnpshare, ibwpshare, anpshare, agpshare,
                  cnpshare, mspshare, mktshare, ispshare,
                  permshare, dotshare, provshare,
                  state, prs,
                  code,
                  name,
                  name_in_local,
                  is_active
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext();
      String[] c;
      int batch = 0;

      while ((c = reader.readNext()) != null) {

        int p = 1;

        ps.setInt(p++, toInt(c[0]));
        ps.setString(p++, toStr(c[1]));
        ps.setInt(p++, toInt(c[2]));

        ps.setBigDecimal(p++, toDec(c[3]));
        ps.setBigDecimal(p++, toDec(c[4]));
        ps.setBigDecimal(p++, toDec(c[5]));
        ps.setBigDecimal(p++, toDec(c[6]));
        ps.setBigDecimal(p++, toDec(c[7]));
        ps.setBigDecimal(p++, toDec(c[8]));
        ps.setBigDecimal(p++, toDec(c[9]));
        ps.setBigDecimal(p++, toDec(c[10]));
        ps.setBigDecimal(p++, toDec(c[11]));
        ps.setBigDecimal(p++, toDec(c[12]));

        if (isNull(c[13])) ps.setNull(p++, Types.NUMERIC);
        else ps.setBigDecimal(p++, toDec(c[13]));

        ps.setString(p++, toStr(c[14]));

        if (isNull(c[15])) ps.setNull(p++, Types.NUMERIC);
        else ps.setBigDecimal(p++, toDec(c[15]));

        ps.setString(p++, toStr(c[0]));

        ps.setString(p++, toStr(c[1]));

        if (c.length > 17 && !isNull(c[17])) ps.setString(p++, toStr(c[17]));
        else ps.setNull(p++, Types.VARCHAR);

        if (c.length > 18 && !isNull(c[18])) ps.setBoolean(p++, Boolean.parseBoolean(c[18]));
        else ps.setBoolean(p++, true);

        ps.addBatch();

        if (++batch % 500 == 0) {
          ps.executeBatch();
        }
      }

      ps.executeBatch();
      conn.commit();

    } catch (Exception ex) {
      conn.rollback();
      throw ex;
    }
  }

  private BigDecimal toDec(String v) {
    if (isNull(v)) return BigDecimal.ZERO;
    return new BigDecimal(v.trim());
  }

  private boolean isNull(String v) {
    return v == null || v.trim().isEmpty() || v.equalsIgnoreCase("NULL");
  }
}
