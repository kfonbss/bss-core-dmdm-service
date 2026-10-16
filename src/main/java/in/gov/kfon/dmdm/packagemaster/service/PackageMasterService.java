package in.gov.kfon.dmdm.packagemaster.service;

import in.gov.kfon.dmdm.packagemaster.contract.PackageLookUp;
import in.gov.kfon.dmdm.packagemaster.contract.PackageMastersBundle;
import java.util.List;
import java.util.UUID;

public interface PackageMasterService {

  /** Every package master, inactive rows included. */
  PackageMastersBundle fetchBundle();

  /** Active service types. */
  List<PackageLookUp> fetchServiceTypes();

  /** All sub-package types, or only those of {@code serviceTypeId} when it is given. */
  List<PackageLookUp> fetchSubPackageTypes(UUID serviceTypeId);

  List<PackageLookUp> fetchPackageTypes();

  List<PackageLookUp> fetchPlanTypes();

  List<PackageLookUp> fetchCategoryTypes();

  List<PackageLookUp> fetchPackagePlanTypes();

  /** Active speed profiles, slowest first. */
  List<PackageLookUp> fetchSpeedProfiles();

  /** Active fallback speeds, slowest first. */
  List<PackageLookUp> fetchFallbackSpeeds();
}
