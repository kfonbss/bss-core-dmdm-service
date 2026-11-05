package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.SubDistrictService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sub-district")
@RequiredArgsConstructor
public class SubDistrictController {
  private final SubDistrictService service;

  /** Sub-district dropdown: active sub-districts of the district, sorted by name. */
  @GetMapping("/fetch-all/{districtId}")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchByDistrictId(
      @PathVariable UUID districtId) {
    var data = service.fetchByDistrictId(districtId);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }
}
