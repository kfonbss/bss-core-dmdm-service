package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.BankDetailsResponse;
import java.util.List;
import java.util.UUID;

public interface BankDetailsService {
  List<BankDetailsResponse> fetchAll();

  BankDetailsResponse fetchById(UUID id);

  BankDetailsResponse fetchByIfsc(String ifsc);
}
