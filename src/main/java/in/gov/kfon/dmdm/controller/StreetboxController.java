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
  public List<StreetboxDto> fetchAllStreetboxes() {
    return streetboxService.fetchAllStreetboxes();
  }
}
