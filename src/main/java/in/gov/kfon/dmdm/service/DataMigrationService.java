package in.gov.kfon.dmdm.service;

import org.springframework.web.multipart.MultipartFile;

public interface DataMigrationService {
  void migrateDistrict(MultipartFile file);
}
