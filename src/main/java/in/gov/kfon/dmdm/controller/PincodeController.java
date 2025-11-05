package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.PincodeService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pincode")
@RequiredArgsConstructor
public class PincodeController {

  private final PincodeService service;

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPincodes() {
    var data = service.fetchAllPincodes();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all pincodes"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPincodeById(@PathVariable UUID id) {
    var data = service.fetchPincodeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched pincode"));
  }

  @GetMapping("/details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDetails() {
    var data = service.fetchAllPincodeDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all pincode details"));
  }

  @GetMapping("/detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDetailsById(@PathVariable UUID id) {
    var data = service.fetchPincodeDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched pincode detail"));
  }
}
