package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.RoleService;
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
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

  private final RoleService service;

  @GetMapping("/role-types")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllRoleTypes() {
    var data = service.fetchAllRoleTypes();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all role types"));
  }

  @GetMapping("/role-type/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchRoleTypeById(@PathVariable UUID id) {
    var data = service.fetchRoleTypeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched role type"));
  }

  @GetMapping("/roles")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllRoles() {
    var data = service.fetchAllRoles();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all roles"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchRoleById(@PathVariable UUID id) {
    var data = service.fetchRoleById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched role"));
  }

  @GetMapping("/roles-modules")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllRolesModules() {
    var data = service.fetchAllRolesModules();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all roles modules"));
  }

  @GetMapping("/roles-module/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchRolesModuleById(@PathVariable UUID id) {
    var data = service.fetchRolesModuleById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched roles module"));
  }
}
