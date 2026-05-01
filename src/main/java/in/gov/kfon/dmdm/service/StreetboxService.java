package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.StreetboxDto;
import java.util.List;

public interface StreetboxService {

  List<StreetboxDto> fetchAllStreetboxes();
}
