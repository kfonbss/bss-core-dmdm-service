package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.TerritoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/territory")
@RequiredArgsConstructor
public class TerritoryController {
  private final TerritoryService service;

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAll(
      @RequestHeader("X-Tenant-ID") String tenantId) {
    var data = service.fetchAll(tenantId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }
}