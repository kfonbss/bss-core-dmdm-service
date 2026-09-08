package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.BankDetailsResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.BankDetailsService;
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
@RequestMapping("/api/bank-details")
@RequiredArgsConstructor
public class BankDetailsController {
  private final BankDetailsService service;
  private static final String FETCHED = "Fetched";

  @GetMapping("/fetch-all")
  public ResponseEntity<Response<List<BankDetailsResponse>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<BankDetailsResponse>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/ifsc/{ifsc}")
  public ResponseEntity<Response<BankDetailsResponse>> fetchByIfsc(@PathVariable String ifsc) {
    BankDetailsResponse data = service.fetchByIfsc(ifsc);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }
}
