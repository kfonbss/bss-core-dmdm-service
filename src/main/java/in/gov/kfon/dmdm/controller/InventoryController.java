package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.InventoryService;
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
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

  private final InventoryService inventoryService;

  @GetMapping("/device-makes/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceMakes() {
    var data = inventoryService.fetchAllDeviceMakes();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all device makes"));
  }

  @GetMapping("/device-make/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceMakeById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceMakeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched device make"));
  }

  @GetMapping("/device-models/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDeviceModels() {
    var data = inventoryService.fetchAllDeviceModels();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all device models"));
  }

  @GetMapping("/device-model/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDeviceModelById(@PathVariable UUID id) {
    var data = inventoryService.fetchDeviceModelById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched device model"));
  }
}
