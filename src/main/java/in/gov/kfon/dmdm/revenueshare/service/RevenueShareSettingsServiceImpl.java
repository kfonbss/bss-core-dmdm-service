package in.gov.kfon.dmdm.revenueshare.service;

import in.gov.kfon.dmdm.model.RevenueShare;
import in.gov.kfon.dmdm.repository.RevenueShareRepository;
import in.gov.kfon.dmdm.revenueshare.client.PackageManagementClient;
import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareRequest;
import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareSettingsResponse;
import in.gov.kfon.dmdm.revenueshare.contract.ServiceTypeLookUp;
import in.gov.kfon.dmdm.revenueshare.specification.RevenueShareSpecification;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RevenueShareSettingsServiceImpl implements RevenueShareSettingsService {

  private final RevenueShareRepository revenueShareRepository;
  private final PackageManagementClient packageManagementClient;

  @Override
  @Transactional
  public RevenueShareSettingsResponse create(RevenueShareRequest request) {
    ServiceTypeLookUp serviceType = resolveServiceType(request.getServiceTypeId());
    RevenueShare entity =
        RevenueShare.builder()
            .shareName(request.getShareName())
            .code(request.getCode())
            .name(request.getName())
            .nameInLocal(request.getNameInLocal())
            .state(request.getState())
            .subgroup(serviceType.getIntId())
            .providerUuid(request.getProviderUuid())
            .ibnpShare(request.getIbnpShare())
            .ibwpShare(request.getIbwpShare())
            .anpShare(request.getAnpShare())
            .agpShare(request.getAgpShare())
            .cnpShare(request.getCnpShare())
            .mspShare(request.getMspShare())
            .mktShare(request.getMktShare())
            .ispShare(request.getIspShare())
            .permShare(request.getPermShare())
            .dotShare(request.getDotShare())
            .provShare(request.getProvShare())
            .prs(request.getPrs())
            .isActive(request.getIsActive())
            .build();
    return toResponse(revenueShareRepository.save(entity));
  }

  @Override
  @Transactional
  public RevenueShareSettingsResponse update(UUID id, RevenueShareRequest request) {
    RevenueShare entity =
        revenueShareRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Revenue share not found: " + id));
    ServiceTypeLookUp serviceType = resolveServiceType(request.getServiceTypeId());
    entity.setShareName(request.getShareName());
    entity.setCode(request.getCode());
    entity.setName(request.getName());
    entity.setNameInLocal(request.getNameInLocal());
    entity.setState(request.getState());
    entity.setSubgroup(serviceType.getIntId());
    entity.setProviderUuid(request.getProviderUuid());
    entity.setIbnpShare(request.getIbnpShare());
    entity.setIbwpShare(request.getIbwpShare());
    entity.setAnpShare(request.getAnpShare());
    entity.setAgpShare(request.getAgpShare());
    entity.setCnpShare(request.getCnpShare());
    entity.setMspShare(request.getMspShare());
    entity.setMktShare(request.getMktShare());
    entity.setIspShare(request.getIspShare());
    entity.setPermShare(request.getPermShare());
    entity.setDotShare(request.getDotShare());
    entity.setProvShare(request.getProvShare());
    entity.setPrs(request.getPrs());
    entity.setIsActive(request.getIsActive());
    return toResponse(revenueShareRepository.save(entity));
  }

  @Override
  @Transactional
  public RevenueShareSettingsResponse updateStatus(UUID id, Boolean isActive) {
    RevenueShare entity =
        revenueShareRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Revenue share not found: " + id));
    entity.setIsActive(isActive);
    return toResponse(revenueShareRepository.save(entity));
  }

  @Override
  @Transactional(readOnly = true)
  public RevenueShareSettingsResponse getById(UUID id) {
    return revenueShareRepository
        .findById(id)
        .map(this::toResponse)
        .orElseThrow(() -> new EntityNotFoundException("Revenue share not found: " + id));
  }

  @Override
  @Transactional(readOnly = true)
  public Page<RevenueShareSettingsResponse> getAll(
      int page, int size, UUID serviceTypeId, UUID providerUuid, String search, Boolean isActive) {
    List<ServiceTypeLookUp> serviceTypes = fetchServiceTypes();
    Integer subgroup =
        serviceTypeId != null ? resolveServiceType(serviceTypeId, serviceTypes).getIntId() : null;
    PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "shareName"));
    Specification<RevenueShare> spec =
        RevenueShareSpecification.filter(subgroup, providerUuid, search, isActive);
    return revenueShareRepository.findAll(spec, pageable).map(e -> toResponse(e, serviceTypes));
  }

  @Override
  @Transactional
  public void delete(UUID id) {
    RevenueShare entity =
        revenueShareRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Revenue share not found: " + id));
    entity.setIsActive(false);
    revenueShareRepository.save(entity);
  }

  private RevenueShareSettingsResponse toResponse(RevenueShare entity) {
    return toResponse(entity, fetchServiceTypes());
  }

  private RevenueShareSettingsResponse toResponse(
      RevenueShare entity, List<ServiceTypeLookUp> serviceTypes) {
    UUID serviceTypeId =
        serviceTypes.stream()
            .filter(st -> entity.getSubgroup() != null && entity.getSubgroup().equals(st.getIntId()))
            .findFirst()
            .map(ServiceTypeLookUp::getId)
            .orElse(null);
    return RevenueShareSettingsResponse.builder()
        .id(entity.getId())
        .revenueShareId(entity.getRevenueShareId())
        .shareName(entity.getShareName())
        .code(entity.getCode())
        .name(entity.getName())
        .nameInLocal(entity.getNameInLocal())
        .state(entity.getState())
        .serviceTypeId(serviceTypeId)
        .subgroup(entity.getSubgroup())
        .providerUuid(entity.getProviderUuid())
        .ibnpShare(entity.getIbnpShare())
        .ibwpShare(entity.getIbwpShare())
        .anpShare(entity.getAnpShare())
        .agpShare(entity.getAgpShare())
        .cnpShare(entity.getCnpShare())
        .mspShare(entity.getMspShare())
        .mktShare(entity.getMktShare())
        .ispShare(entity.getIspShare())
        .permShare(entity.getPermShare())
        .dotShare(entity.getDotShare())
        .provShare(entity.getProvShare())
        .prs(entity.getPrs())
        .isActive(entity.getIsActive())
        .build();
  }

  private List<ServiceTypeLookUp> fetchServiceTypes() {
    var response = packageManagementClient.fetchServiceTypes();
    return (response != null && response.getData() != null) ? response.getData() : List.of();
  }

  private ServiceTypeLookUp resolveServiceType(UUID serviceTypeId) {
    return resolveServiceType(serviceTypeId, fetchServiceTypes());
  }

  private ServiceTypeLookUp resolveServiceType(
      UUID serviceTypeId, List<ServiceTypeLookUp> serviceTypes) {
    return serviceTypes.stream()
        .filter(st -> serviceTypeId.equals(st.getId()))
        .findFirst()
        .orElseThrow(
            () -> new EntityNotFoundException("Service type not found: " + serviceTypeId));
  }
}
