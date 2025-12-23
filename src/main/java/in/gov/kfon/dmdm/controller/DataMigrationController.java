package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.DataMigrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/migration")
@RequiredArgsConstructor
public class DataMigrationController {
  @Autowired DataMigrationService dataMigrationService;

  @PostMapping("/district")
  public ResponseEntity<Response<String>> migrateDistrict(
      @RequestParam("file") MultipartFile file) {
    dataMigrationService.migrateDistrict(file);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok("", "District Migration Completed Successfully"));
  }

  @PostMapping("/pop-master")
  public ResponseEntity<Response<String>> migratePopMaster(
      @RequestParam("file") MultipartFile file) {

    dataMigrationService.migratePopMaster(file);

    return ResponseEntity.ok(Response.ok("", "POP Master Migration Completed Successfully"));
  }
}
