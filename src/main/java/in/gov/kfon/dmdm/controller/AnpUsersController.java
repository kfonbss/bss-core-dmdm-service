package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.AnpUsersResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.AnpUsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnpUsersController {

  private final AnpUsersService service;

  @GetMapping("/anp-users/fetch-all")
  public ResponseEntity<Response<List<AnpUsersResponse>>> fetchAllAnpUsers() {
    var data = service.fetchAllAnpUsers();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all anp users"));
  }
}
