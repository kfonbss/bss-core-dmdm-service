package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.AnpUsersResponse;
import java.util.List;

public interface AnpUsersService {

  List<AnpUsersResponse> fetchAllAnpUsers();
}