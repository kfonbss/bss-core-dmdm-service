package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import java.util.List;
import java.util.UUID;

public interface PackageService {

  List<CommonLookUp> fetchAllPackageMaps();

  CommonLookUp fetchPackageMapById(UUID id);

  List<CommonLookUp> fetchAllPackageCategories();

  CommonLookUp fetchPackageCategoryById(UUID id);

  List<CommonLookUp> fetchAllChangeRequests();

  CommonLookUp fetchChangeRequestById(UUID id);
}
