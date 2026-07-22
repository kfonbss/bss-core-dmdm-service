package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.LookupMasterRequest;
import in.gov.kfon.dmdm.contract.LookupMasterResponse;
import in.gov.kfon.dmdm.model.ClientApplication;
import in.gov.kfon.dmdm.model.LookupMaster;
import in.gov.kfon.dmdm.repository.ClientApplicationRepository;
import in.gov.kfon.dmdm.repository.LookupMasterRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LookupMasterServiceImpl implements LookupMasterService {

  private final LookupMasterRepository repository;
  private final ClientApplicationRepository applicationRepository;

  @Override
  public LookupMasterResponse create(LookupMasterRequest request) {
    ClientApplication application = null;
    if (request.getApplicationId() != null) {
      application =
          applicationRepository
              .findById(request.getApplicationId())
              .orElseThrow(
                  () ->
                      new EntityNotFoundException(
                          "Application not found: " + request.getApplicationId()));
    }

    LookupMaster lookup =
        LookupMaster.builder()
            .lookupType(request.getLookupType().toUpperCase())
            .lookupCode(request.getLookupCode())
            .lookupValue(request.getLookupValue())
            .parentCode(request.getParentCode())
            .displayOrder(request.getDisplayOrder())
            .isActive(Boolean.TRUE)
            .application(application)
            .tenantId(request.getTenantId())
            .build();

    return toResponse(repository.save(lookup));
  }

  @Override
  @Transactional(readOnly = true)
  public List<LookupMasterResponse> fetchByType(
      String lookupType, String appCode, String tenantId) {
    String type = lookupType.toUpperCase();

    if (appCode == null) {
      return repository
          .findByLookupTypeAndApplicationIsNullAndTenantIdIsNullAndIsActiveTrue(type)
          .stream()
          .map(this::toResponse)
          .toList();
    }

    ClientApplication application =
        applicationRepository
            .findByAppCodeAndIsActive(appCode.toUpperCase(), true)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Application not found: " + appCode));

    // Merge: global + app-level + tenant-level, with tenant overriding by lookupCode
    List<LookupMasterResponse> result = new ArrayList<>();

    // 1. Global values
    result.addAll(
        repository
            .findByLookupTypeAndApplicationIsNullAndTenantIdIsNullAndIsActiveTrue(type)
            .stream()
            .map(this::toResponse)
            .toList());

    // 2. App-level values (add or replace global by lookupCode)
    repository
        .findByLookupTypeAndApplicationAndTenantIdIsNullAndIsActiveTrue(type, application)
        .forEach(
            appLookup -> {
              result.removeIf(r -> r.getLookupCode().equals(appLookup.getLookupCode()));
              result.add(toResponse(appLookup));
            });

    // 3. Tenant-level values (add or replace by lookupCode)
    if (tenantId != null) {
      repository
          .findByLookupTypeAndApplicationAndTenantIdAndIsActiveTrue(type, application, tenantId)
          .forEach(
              tenantLookup -> {
                result.removeIf(r -> r.getLookupCode().equals(tenantLookup.getLookupCode()));
                result.add(toResponse(tenantLookup));
              });
    }

    result.sort(
        Comparator.comparing(
            LookupMasterResponse::getDisplayOrder,
            Comparator.nullsLast(Integer::compare)));

    return result;
  }

  private LookupMasterResponse toResponse(LookupMaster l) {
    return LookupMasterResponse.builder()
        .id(l.getId())
        .lookupType(l.getLookupType())
        .lookupCode(l.getLookupCode())
        .lookupValue(l.getLookupValue())
        .parentCode(l.getParentCode())
        .displayOrder(l.getDisplayOrder())
        .isActive(l.getIsActive())
        .build();
  }
}
