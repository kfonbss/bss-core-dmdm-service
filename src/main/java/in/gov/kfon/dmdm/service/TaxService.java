package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.TaxTypeResponse;

import java.util.List;
import java.util.UUID;

public interface TaxService {
  List<CommonLookUp> fetchAll();

  CommonLookUp fetchById(UUID id);

  List<CommonLookUp> collectionFetchAll();

  CommonLookUp collectionFetchById(UUID id);

  List<CommonLookUp> typesFetchAll();

  CommonLookUp typeFetchById(UUID id);

  List<CommonLookUp> detailsFetchAll();

  CommonLookUp detailFetchById(UUID id);

  List<CommonLookUp> payersFetchAll();

  CommonLookUp payerFetchAll(UUID id);

  List<CommonLookUp> disbursementFetchAll();

  CommonLookUp disbursementFetch(UUID id);

  List<CommonLookUp> distributionFetchAll();

  CommonLookUp distributionFetch(UUID id);

  List<TaxTypeResponse> fetchByTaxTypeId(int taxTypeId);
}
