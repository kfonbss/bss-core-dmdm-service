package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.VillageService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/village")
@RequiredArgsConstructor
public class VillageController {
  private final VillageService service;

  /** Village dropdown: active villages of the sub-district, sorted by name. */
  @GetMapping("/fetch-all/{subDistrictId}")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchBySubDistrictId(
      @PathVariable UUID subDistrictId) {
    var data = service.fetchBySubDistrictId(subDistrictId);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }
}
