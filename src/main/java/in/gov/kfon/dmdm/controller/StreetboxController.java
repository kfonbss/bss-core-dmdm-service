package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.StreetboxDto;
import in.gov.kfon.dmdm.service.StreetboxService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/streetbox")
@RequiredArgsConstructor
public class StreetboxController {

  private final StreetboxService streetboxService;

  @GetMapping("/fetch-all")
  public List<StreetboxDto> fetchAllStreetboxes(@RequestHeader("X-Tenant-ID") String tenantId) {
    return streetboxService.fetchAllStreetboxes(tenantId);
  }

  /** Nearest streetbox to a point, as a list of zero or one item. */
  @GetMapping("/nearest")
  public List<StreetboxDto> fetchNearestStreetbox(
      @RequestHeader("X-Tenant-ID") String tenantId,
      @RequestParam double latitude,
      @RequestParam double longitude) {
    return streetboxService.fetchNearestStreetbox(tenantId, latitude, longitude);
  }
}
