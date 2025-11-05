package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.PopService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pop")
@RequiredArgsConstructor
public class PopController {

  private final PopService service;

  @GetMapping("/masters/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPopMasters() {
    var data = service.fetchAllPopMasters();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all pop masters"));
  }

  @GetMapping("/master/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPopMasterById(@PathVariable UUID id) {
    var data = service.fetchPopMasterById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched pop master"));
  }

  @GetMapping("/master-backups/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPopMasterBackups() {
    var data = service.fetchAllPopMasterBackups();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all pop master backups"));
  }

  @GetMapping("/master-backup/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPopMasterBackupById(@PathVariable UUID id) {
    var data = service.fetchPopMasterBackupById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched pop master backup"));
  }

  @GetMapping("/df-pop-lists/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDfPopLists() {
    var data = service.fetchAllDfPopLists();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all DF POP lists"));
  }

  @GetMapping("/df-pop-list/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDfPopById(@PathVariable UUID id) {
    var data = service.fetchDfPopById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched DF POP"));
  }
}
