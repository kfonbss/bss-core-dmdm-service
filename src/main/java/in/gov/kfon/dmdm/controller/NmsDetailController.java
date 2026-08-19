package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.NmsDetailRequest;
import in.gov.kfon.dmdm.contract.NmsDetailResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.NmsDetailService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nms-details")
@RequiredArgsConstructor
public class NmsDetailController {

  private final NmsDetailService service;
  private static final String FETCHED = "Fetched";

  @PostMapping
  public ResponseEntity<Response<NmsDetailResponse>> create(
      @Valid @RequestBody NmsDetailRequest request) {
    var data = service.create(request);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(Response.created(data, "NMS detail created"));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<NmsDetailResponse>> update(
      @PathVariable UUID id, @Valid @RequestBody NmsDetailRequest request) {
    var data = service.update(id, request);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "NMS detail updated"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<NmsDetailResponse>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/state/{stateCode}")
  public ResponseEntity<Response<NmsDetailResponse>> fetchByStateCode(
      @PathVariable String stateCode) {
    var data = service.fetchByStateCode(stateCode);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<NmsDetailResponse>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }
}