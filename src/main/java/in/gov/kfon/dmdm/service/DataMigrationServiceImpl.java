package in.gov.kfon.dmdm.service;

import static org.apache.commons.lang3.math.NumberUtils.toInt;

import com.opencsv.CSVReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Map;
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
}
