package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.CafDetailsService;
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
@RequestMapping("/api/caf")
@RequiredArgsConstructor
public class CafDetailsController {
  private final CafDetailsService service;
  private static final String FETCHED = "Fetched";

  @GetMapping("details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> detailsFetchAll() {
    var data = service.detailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> detailsFetchById(@PathVariable UUID id) {
    var data = service.detailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }
}
