package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.PartnerCategoryRequest;
import in.gov.kfon.dmdm.contract.PartnerCategoryResponse;
import java.util.List;
import java.util.UUID;

public interface PartnerCategoryService {

  List<PartnerCategoryResponse> fetchAll();

  PartnerCategoryResponse fetchById(UUID id);

  PartnerCategoryResponse create(PartnerCategoryRequest request);

  PartnerCategoryResponse update(UUID id, PartnerCategoryRequest request);
}
