package in.gov.kfon.dmdm.service;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

import com.opencsv.CSVReader;
import in.gov.kfon.dmdm.constant.LocationType;
import jakarta.persistence.EntityNotFoundException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
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

  // -------------------------------------------------District
  // ------------------------------------------------------

  @Override
  public void migrateDistrict(MultipartFile file) {

    // todo implement the state code field mapping when the state table is ready

    if (file == null || file.isEmpty()) {
      throw new RuntimeException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new RuntimeException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (districtTableHasData(conn)) {
        throw new RuntimeException("District table already has data");
      }

      runDistrictMigration(conn, file);

    } catch (Exception e) {
      throw new RuntimeException("District migration failed: " + e.getMessage(), e);
    }
  }

  private boolean districtTableHasData(Connection conn) throws Exception {
    try (ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM district")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  private void runDistrictMigration(Connection conn, MultipartFile file) throws Exception {

    String sql =
        """
        INSERT INTO district (
            id, name, shortname, is_active
        )
        VALUES (?, ?, ?, ?)
    """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext();

      String[] cols;
      int batch = 0;

      while ((cols = reader.readNext()) != null) {

        Integer id = toInt(cols[0]); // id
        String name = toStr(cols[1]); // district
        String shortName = toStr(cols[2]); // shortname

        if (id == null || name == null) {
          continue;
        }

        int p = 1;
        ps.setInt(p++, id);
        ps.setString(p++, name);
        ps.setString(p++, shortName);
        ps.setBoolean(p++, true); // is_active

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
      throw new EntityNotFoundException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new EntityNotFoundException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (popMasterTableHasData(conn)) {
        throw new EntityNotFoundException("POP Master already migrated");
      }

      runPopMasterMigration(conn, file);

    } catch (Exception e) {
      throw new EntityNotFoundException("POP Master migration failed: " + e.getMessage(), e);
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
      throw new RuntimeException("Invalid file format. CSV required");
    }

    try (Connection conn = dataSource.getConnection()) {

      Map<String, UUID> districtLookup = loadDistrictByName(conn);

      runPincodeMigration(conn, file, districtLookup);

    } catch (Exception e) {
      throw new RuntimeException("Pincode migration failed: " + e.getMessage(), e);
    }
  }


  private Map<String, UUID> loadDistrictByName(Connection conn) throws Exception {
    Map<String, UUID> map = new HashMap<>();

    String sql = "SELECT name, district_id FROM district";

    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        String name = rs.getString("name");
        UUID uuid = (UUID) rs.getObject("district_id");

        if (name != null && uuid != null) {
          map.put(name.trim().toLowerCase(), uuid);
        }
      }
    }
    return map;
  }

  private void runPincodeMigration(
          Connection conn,
          MultipartFile file,
          Map<String, UUID> districtLookup
  ) throws Exception {

    String sql = """
        INSERT INTO pincode_details (
            details_id,
            pincode,
            post_office_name,
            sub_po_name,
            district,
            districtcode,
            district_id,
            is_active
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
         PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext(); // skip header
      String[] cols;
      int batch = 0;

      while ((cols = reader.readNext()) != null) {

        int idx = 0;

        Long detailsId = toLong(cols[idx++]);     // id
        Integer pincode = toInt(cols[idx++]);    // pincode
        String postOffice = toStr(cols[idx++]);  // post_office_name
        String subPo = toStr(cols[idx++]);       // sub_po_name
        String district = toStr(cols[idx++]);    // district
        Integer districtCode = toInt(cols[idx++]); // districtcode

        idx += 2; // skip create_date, update_date

        Boolean isActive = toInt(cols[idx++]) == 1;

        UUID districtUUID = null;
        if (district != null) {
          districtUUID = districtLookup.get(district.trim().toLowerCase());
        }

        // DEBUG (keep during first run)
        if (districtUUID == null) {
          System.err.println("⚠ District NOT FOUND: " + district);
        }

        int p = 1;
        ps.setLong(p++, detailsId);
        ps.setInt(p++, pincode);
        ps.setString(p++, postOffice);
        ps.setString(p++, subPo);
        ps.setString(p++, district);
        ps.setInt(p++, districtCode);

        if (districtUUID == null) ps.setNull(p++, Types.OTHER);
        else ps.setObject(p++, districtUUID, Types.OTHER);

        ps.setBoolean(p++, isActive);

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
      throw new EntityNotFoundException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new EntityNotFoundException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (tableHasData(conn)) {
        throw new EntityNotFoundException("Revenue Share already migrated");
      }

      runMigration(conn, file);

    } catch (Exception e) {
      throw new EntityNotFoundException("Migration failed: " + e.getMessage(), e);
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

        int lastColIndex = c.length - 1;
        if (c.length > 0 && c[lastColIndex] != null && !c[lastColIndex].isBlank()) {
          ps.setBoolean(p++, c[lastColIndex].trim().equalsIgnoreCase("TRUE"));
        } else {
          ps.setBoolean(p++, false);
        }

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

  @Override
  @Transactional
  public void migrateBankDetails(MultipartFile file) {

    if (file == null || file.isEmpty()) {
      throw new EntityNotFoundException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new EntityNotFoundException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (tableHasDatas(conn)) {
        throw new EntityNotFoundException("Bank details already migrated");
      }

      runBankMigration(conn, file);

    } catch (Exception e) {
      throw new EntityNotFoundException("Migration failed: " + e.getMessage(), e);
    }
  }

  private void runBankMigration(Connection conn, MultipartFile file) throws Exception {

    String sql =
        """
        INSERT INTO bank_details (
          bank_id, bank_name, bank_ifsc_code, bank_micr,
          bank_branch, bank_address, bank_contact,
          bank_city, bank_district, bank_state
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext();
      String[] c;
      int batch = 0;

      while ((c = reader.readNext()) != null) {
        int p = 1;

        Long bankId = toLong(c[0]);
        ps.setObject(p++, bankId != null ? bankId : null, Types.BIGINT);

        ps.setString(p++, safeString(c[1]));
        ps.setString(p++, safeString(c[2]));

        String micr = safeString(c[3]);
        ps.setString(p++, micr);

        ps.setString(p++, safeString(c[4]));
        ps.setString(p++, safeString(c[5]));

        Integer contact = toInt(c[6]);
        ps.setInt(p++, Objects.requireNonNullElse(contact, 0));

        ps.setString(p++, safeString(c[7]));
        ps.setString(p++, safeString(c[8]));
        ps.setString(p++, safeString(c[9]));

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

  private String safeString(String s) {
    return (s == null || s.isBlank() || s.equalsIgnoreCase("NA") || s.equalsIgnoreCase("WAITING"))
        ? ""
        : s.trim();
  }

  private boolean tableHasDatas(Connection conn) throws Exception {
    try (ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM bank_details")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  @Override
  public void migrateVillageType(MultipartFile file) {

    if (file == null || file.isEmpty()) {
      throw new RuntimeException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new RuntimeException("Invalid file format. Upload CSV only.");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (villageTypeTableHasData(conn)) {
        throw new RuntimeException("Village types already migrated");
      }

      runVillageTypeMigration(conn, file);

    } catch (Exception e) {
      throw new RuntimeException("Village type migration failed: " + e.getMessage(), e);
    }
  }

  private boolean villageTypeTableHasData(Connection conn) throws Exception {
    try (ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM village_types")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  private void runVillageTypeMigration(Connection conn, MultipartFile file) throws Exception {

    String sql =
        """
        INSERT INTO village_types (
            id, village_type_id, village_type, loc_type, is_active,
            created_date, created_by, modified_date, modified_by
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext(); // skip header

      String[] cols;
      int batch = 0;

      while ((cols = reader.readNext()) != null) {

        Long id = toLong(cols[0]);
        Integer villageTypeId = toInt(cols[1]);
        String villageType = toStr(cols[2]);
        Integer locTypeCsv = toInt(cols[3]);
        Integer activeCsv = toInt(cols[6]);

        if (id == null || villageTypeId == null || villageType == null) {
          continue;
        }

        Integer locTypeOrdinal = mapLocType(locTypeCsv);

        boolean isActive = (activeCsv != null && activeCsv == 1);

        int p = 1;
        ps.setLong(p++, id);
        ps.setInt(p++, villageTypeId);
        ps.setString(p++, villageType);

        if (locTypeOrdinal == null) {
          ps.setNull(p++, Types.INTEGER);
        } else {
          ps.setInt(p++, locTypeOrdinal);
        }

        ps.setBoolean(p++, isActive);

        // Auditor fields → NULL
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

  private Integer mapLocType(Integer csvValue) {
    if (csvValue == null) return null;
    if (csvValue == 1) return LocationType.URBAN.ordinal();
    if (csvValue == 2) return LocationType.RURAL.ordinal();
    return null;
  }

  @Override
  public void migrateBlockDetail(MultipartFile file) {

    if (file == null || file.isEmpty()) {
      throw new RuntimeException("CSV file is required");
    }

    String filename = file.getOriginalFilename();
    if (filename == null || !filename.toLowerCase().endsWith(".csv")) {
      throw new RuntimeException("Invalid file format. CSV required");
    }

    try (Connection conn = dataSource.getConnection()) {

      if (blockDetailTableHasData(conn)) {
        throw new RuntimeException("Block details already migrated");
      }

      Map<Integer, UUID> districtLookup = loadDistrictById(conn);

      runBlockMigration(conn, file, districtLookup);

    } catch (Exception e) {
      throw new RuntimeException("Block migration failed: " + e.getMessage(), e);
    }
  }

  private boolean blockDetailTableHasData(Connection conn) throws Exception {
    try (ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM block_details")) {
      rs.next();
      return rs.getInt(1) > 0;
    }
  }

  private Map<Integer, UUID> loadDistrictById(Connection conn) throws Exception {
    Map<Integer, UUID> map = new HashMap<>();

    String sql = "SELECT id, district_id FROM district";

    try (PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {

      while (rs.next()) {
        Integer id = rs.getInt("id");
        UUID uuid = (UUID) rs.getObject("district_id");

        if (!rs.wasNull() && uuid != null) {
          map.put(id, uuid);
        }
      }
    }
    return map;
  }

  private void runBlockMigration(
      Connection conn, MultipartFile file, Map<Integer, UUID> districtLookup) throws Exception {

    String sql =
        """
        INSERT INTO block_details (
            id, village_name, block_id, block_name,
            village_type, village_type_id,
            district, district_id, loc_type,
            is_active, district_entity,
            created_date, created_by, modified_date, modified_by
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
    """;

    conn.setAutoCommit(false);

    try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        PreparedStatement ps = conn.prepareStatement(sql)) {

      reader.readNext(); // skip header
      String[] cols;
      int batch = 0;

      while ((cols = reader.readNext()) != null) {

        int idx = 0;

        Integer id = toInt(cols[idx++]);
        String villageName = toStr(cols[idx++]);
        Integer blockId = toInt(cols[idx++]);
        String blockName = toStr(cols[idx++]);
        String villageType = toStr(cols[idx++]);
        Integer villageTypeId = toInt(cols[idx++]);
        String district = toStr(cols[idx++]);
        Integer districtId = toInt(cols[idx++]);
        Integer locTypeRaw = toInt(cols[idx++]);

        idx += 2; // skip create_date, update_date

        boolean isActive = toInt(cols[idx++]) == 1;

        // ENUM mapping
        Integer locType = null;
        if (locTypeRaw != null) {
          locType = (locTypeRaw == 1) ? 0 : 1; // ORDINAL: URBAN=0, RURAL=1
        }

        UUID districtUUID = districtLookup.get(districtId);

        int p = 1;
        ps.setInt(p++, id);
        ps.setString(p++, villageName);
        ps.setInt(p++, blockId);
        ps.setString(p++, blockName);
        ps.setString(p++, villageType);
        ps.setInt(p++, villageTypeId);
        ps.setString(p++, district);
        ps.setInt(p++, districtId);

        if (locType == null) ps.setNull(p++, Types.INTEGER);
        else ps.setInt(p++, locType);

        ps.setBoolean(p++, isActive);

        if (districtUUID == null) ps.setNull(p++, Types.OTHER);
        else ps.setObject(p++, districtUUID, Types.OTHER);

        // Auditor fields → NULL
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        ps.setTimestamp(p++, now);
        ps.setNull(p++, Types.OTHER);
        ps.setTimestamp(p++, now);
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
}
