package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.DarkFiberService;
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
@RequestMapping("/api/darkfiber")
@RequiredArgsConstructor
public class DarkFiberController {

  private final DarkFiberService darkFiberService;

  @GetMapping("/group-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupDetails() {
    var data = darkFiberService.fetchAllGroupDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group details"));
  }

  @GetMapping("/group-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupDetailsById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched group detail"));
  }

  @GetMapping("/group-movements")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupMovements() {
    var data = darkFiberService.fetchAllGroupMovements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group movements"));
  }

  @GetMapping("/group-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupMovementById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupMovementById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched group movement"));
  }
}
