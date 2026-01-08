package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.constant.LocationType;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.VillageTypeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/village-type")
public class VillageTypeController {
  private final VillageTypeService villageTypeService;

  @GetMapping("/{locationType}")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllVillageTypes(
      @PathVariable LocationType locationType) {
    var data = villageTypeService.fetchByLocationType(locationType);
    return ResponseEntity.ok(Response.ok(data, "Fetched all village types"));
  }
}
