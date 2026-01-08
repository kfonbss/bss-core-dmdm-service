package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.BlockDetailService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/block-detail")
@RestController
@RequiredArgsConstructor
public class BlockDetailController {
  private final BlockDetailService blockDetailService;

  @GetMapping("/corporation-name/{districtId}/{villageTypeId}")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchCorporationName(
      @PathVariable int districtId, @PathVariable int villageTypeId) {
    var data = blockDetailService.fetchCorporationName(districtId, villageTypeId);
    return ResponseEntity.ok(Response.ok(data, "Fetched corporation names"));
  }

  @GetMapping("/panchayat-name/{districtId}/{villageTypeId}")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchPanchayatName(
      @PathVariable int districtId, @PathVariable int villageTypeId) {
    var data = blockDetailService.fetchPanchayatName(districtId, villageTypeId);
    return ResponseEntity.ok(Response.ok(data, "Fetched panchayat names"));
  }

  @GetMapping("/block-name/{districtId}/{villageTypeId}")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchBlockName(
      @PathVariable int districtId, @PathVariable int villageTypeId) {
    var data = blockDetailService.fetchBlockName(districtId, villageTypeId);
    return ResponseEntity.ok(Response.ok(data, "Fetched block names"));
  }
}
