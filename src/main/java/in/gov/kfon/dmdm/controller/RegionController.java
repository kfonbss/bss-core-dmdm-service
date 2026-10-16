package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.RegionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/region")
@RequiredArgsConstructor
public class RegionController {
  private final RegionService service;

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }

  /**
   * Region of a state / circle code, e.g. LD; the region name (South, West, ...) is nameInLocal.
   */
  @GetMapping("/state/{stateCode}")
  public ResponseEntity<Response<CommonLookUp>> fetchByStateCode(@PathVariable String stateCode) {
    var data = service.fetchByStateCode(stateCode);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }
}
