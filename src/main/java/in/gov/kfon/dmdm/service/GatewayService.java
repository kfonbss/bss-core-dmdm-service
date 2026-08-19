package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;

public interface GatewayService {
  List<CommonLookUp> fetchAll();
}
