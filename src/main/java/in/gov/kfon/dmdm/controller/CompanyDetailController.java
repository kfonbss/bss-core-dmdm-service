package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.CompanyDetailService;
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
public class CompanyDetailController {

  private final CompanyDetailService service;

  @GetMapping("/company-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllCompanyDetails() {
    var data = service.fetchAllCompanyDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all company details"));
  }

  @GetMapping("/company-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchCompanyDetailById(@PathVariable UUID id) {
    var data = service.fetchCompanyDetailById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched company detail"));
  }
}
