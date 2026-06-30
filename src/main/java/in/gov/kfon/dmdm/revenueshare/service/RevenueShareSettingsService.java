package in.gov.kfon.dmdm.revenueshare.service;

import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareRequest;
import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareSettingsResponse;
import java.util.UUID;
import org.springframework.data.domain.Page;

public interface RevenueShareSettingsService {

  RevenueShareSettingsResponse create(RevenueShareRequest request);

  RevenueShareSettingsResponse update(UUID id, RevenueShareRequest request);

  RevenueShareSettingsResponse updateStatus(UUID id, Boolean isActive);

  RevenueShareSettingsResponse getById(UUID id);

  Page<RevenueShareSettingsResponse> getAll(
      int page, int size, Integer subgroup, UUID providerUuid, String search, Boolean isActive);

  void delete(UUID id);
}
