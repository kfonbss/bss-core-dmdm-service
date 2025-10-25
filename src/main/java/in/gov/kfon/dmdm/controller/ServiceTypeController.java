package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.ServiceTypeService;
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
@RequestMapping("/api")
@RequiredArgsConstructor
public class ServiceTypeController {

  private final ServiceTypeService service;

  @GetMapping("/service-types")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllServiceTypes() {
    var data = service.fetchAllServiceTypes();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all service types"));
  }

  @GetMapping("/service-type/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchServiceTypeById(@PathVariable UUID id) {
    var data = service.fetchServiceTypeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched service type"));
  }

  @GetMapping("/services")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllServices() {
    var data = service.fetchAllServices();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all services"));
  }

  @GetMapping("/service/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchServiceById(@PathVariable UUID id) {
    var data = service.fetchServiceById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched service"));
  }
}
