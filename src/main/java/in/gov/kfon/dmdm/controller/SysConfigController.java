package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.contract.SysConfigResponse;
import in.gov.kfon.dmdm.service.SysConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sys-config")
@RequiredArgsConstructor
public class SysConfigController {
  private final SysConfigService service;

  @GetMapping("/{tenantId}")
  public ResponseEntity<Response<SysConfigResponse>> resolve(@PathVariable String tenantId) {
    var data = service.resolve(tenantId);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched"));
  }
}
