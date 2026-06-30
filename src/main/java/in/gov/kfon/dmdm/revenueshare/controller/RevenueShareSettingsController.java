package in.gov.kfon.dmdm.revenueshare.controller;

import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareRequest;
import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareSettingsResponse;
import in.gov.kfon.dmdm.revenueshare.service.RevenueShareSettingsService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/revenue-share/settings")
@RequiredArgsConstructor
public class RevenueShareSettingsController {

  private final RevenueShareSettingsService revenueShareSettingsService;

  @PostMapping
  public ResponseEntity<Response<RevenueShareSettingsResponse>> create(
      @Valid @RequestBody RevenueShareRequest request) {
    RevenueShareSettingsResponse data = revenueShareSettingsService.create(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(Response.created(data, "Created"));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<RevenueShareSettingsResponse>> update(
      @PathVariable UUID id, @Valid @RequestBody RevenueShareRequest request) {
    RevenueShareSettingsResponse data = revenueShareSettingsService.update(id, request);
    return ResponseEntity.ok(Response.ok(data, "Updated"));
  }

  @PatchMapping("/{id}/status")
  public ResponseEntity<Response<RevenueShareSettingsResponse>> updateStatus(
      @PathVariable UUID id, @RequestParam Boolean isActive) {
    RevenueShareSettingsResponse data = revenueShareSettingsService.updateStatus(id, isActive);
    return ResponseEntity.ok(Response.ok(data, "Status updated"));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response<RevenueShareSettingsResponse>> getById(@PathVariable UUID id) {
    RevenueShareSettingsResponse data = revenueShareSettingsService.getById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @GetMapping
  public ResponseEntity<Response<Page<RevenueShareSettingsResponse>>> getAll(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) Integer subgroup,
      @RequestParam(required = false) UUID providerUuid,
      @RequestParam(required = false) String search,
      @RequestParam(required = false) Boolean isActive) {
    Page<RevenueShareSettingsResponse> data =
        revenueShareSettingsService.getAll(page, size, subgroup, providerUuid, search, isActive);
    return ResponseEntity.ok(Response.ok(data, "Fetched"));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    revenueShareSettingsService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
