package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.MasterTypeResponse;
import in.gov.kfon.dmdm.contract.PackageMastersBundle;
import in.gov.kfon.dmdm.contract.PackagePlanTypeResponse;
import in.gov.kfon.dmdm.contract.ServiceTypeResponse;
import in.gov.kfon.dmdm.contract.SpeedResponse;
import in.gov.kfon.dmdm.contract.SubPackageTypeResponse;
import java.util.List;
import java.util.UUID;

/** Read-only package masters (service types, R-codes, plan/package/category types, speeds). */
public interface PackageMasterService {

  /** Every package master, inactive rows included. */
  PackageMastersBundle fetchBundle();

  /** Active service types. */
  List<ServiceTypeResponse> fetchServiceTypes();

  ServiceTypeResponse fetchServiceTypeById(UUID id);

  /** All sub-package types, or only those of {@code serviceTypeId} when it is given. */
  List<SubPackageTypeResponse> fetchSubPackageTypes(UUID serviceTypeId);

  SubPackageTypeResponse fetchSubPackageTypeById(UUID id);

  List<MasterTypeResponse> fetchPackageTypes();

  List<MasterTypeResponse> fetchPlanTypes();

  List<MasterTypeResponse> fetchCategoryTypes();

  List<PackagePlanTypeResponse> fetchPackagePlanTypes();

  /** Active speed profiles, slowest first. */
  List<SpeedResponse> fetchSpeedProfiles();

  /** Active fallback speeds, slowest first. */
  List<SpeedResponse> fetchFallbackSpeeds();
}
