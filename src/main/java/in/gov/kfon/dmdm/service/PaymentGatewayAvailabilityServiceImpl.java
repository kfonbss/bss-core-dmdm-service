package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.constant.PaymentGatewayUserType;
import in.gov.kfon.dmdm.contract.PaymentGatewayAvailabilityRequest;
import in.gov.kfon.dmdm.contract.PaymentGatewayAvailabilityResponse;
import in.gov.kfon.dmdm.model.Gateway;
import in.gov.kfon.dmdm.model.PaymentGatewayAvailability;
import in.gov.kfon.dmdm.repository.GatewayRepository;
import in.gov.kfon.dmdm.repository.PaymentGatewayAvailabilityRepository;
import in.gov.kfon.dmdm.util.TenantStateCodeResolver;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Which payment gateways each state offers to subscribers (online recharge) and partners (wallet
 * top-up). Reads are not cached: whether a gateway is under maintenance depends on the current
 * time. Writes evict the gateway fetch-all cache, which is built from these rows.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PaymentGatewayAvailabilityServiceImpl implements PaymentGatewayAvailabilityService {

  private final PaymentGatewayAvailabilityRepository repository;
  private final GatewayRepository gatewayRepository;

  @Override
  @Transactional(readOnly = true)
  public List<PaymentGatewayAvailabilityResponse> fetchActive(String tenantId, String userType) {
    String stateCode = requireStateCode(tenantId);
    PaymentGatewayUserType type = PaymentGatewayUserType.from(userType);
    LocalDateTime now = LocalDateTime.now();
    return repository
        .findByStateCodeIgnoreCaseAndUserTypeAndIsActiveTrueOrderByDisplayOrderAsc(stateCode, type)
        .stream()
        .map(row -> toResponse(row, now))
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<PaymentGatewayAvailabilityResponse> fetchForState(String stateCode) {
    String state = requireStateCode(stateCode);
    LocalDateTime now = LocalDateTime.now();
    return repository.findByStateCodeIgnoreCaseOrderByUserTypeAscDisplayOrderAsc(state).stream()
        .map(row -> toResponse(row, now))
        .toList();
  }

  @Override
  @CacheEvict(cacheNames = CacheNames.ALL_GATEWAYS, allEntries = true)
  public PaymentGatewayAvailabilityResponse create(PaymentGatewayAvailabilityRequest request) {
    if (request.getGatewayId() == null) {
      throw new IllegalArgumentException("gatewayId is required");
    }
    String stateCode = requireStateCode(request.getStateCode());
    PaymentGatewayUserType type = PaymentGatewayUserType.from(request.getUserType());
    Gateway gateway =
        gatewayRepository
            .findById(request.getGatewayId())
            .orElseThrow(
                () -> new EntityNotFoundException("Gateway not found: " + request.getGatewayId()));
    if (repository.existsByStateCodeIgnoreCaseAndGateway_GatewayIdAndUserType(
        stateCode, gateway.getGatewayId(), type)) {
      throw new IllegalArgumentException(
          gateway.getCode() + " is already set up for " + type + " in " + stateCode);
    }

    PaymentGatewayAvailability row = new PaymentGatewayAvailability();
    row.setGateway(gateway);
    row.setStateCode(stateCode);
    row.setUserType(type);
    row.setDisplayName(gateway.getType());
    applyChanges(row, request);
    return toResponse(repository.save(row), LocalDateTime.now());
  }

  @Override
  @CacheEvict(cacheNames = CacheNames.ALL_GATEWAYS, allEntries = true)
  public PaymentGatewayAvailabilityResponse update(
      UUID id, PaymentGatewayAvailabilityRequest request) {
    PaymentGatewayAvailability row =
        repository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Payment gateway availability not found: " + id));
    applyChanges(row, request);
    return toResponse(repository.save(row), LocalDateTime.now());
  }

  private static void applyChanges(
      PaymentGatewayAvailability row, PaymentGatewayAvailabilityRequest request) {
    if (request.getIsActive() != null) {
      row.setIsActive(request.getIsActive());
    }
    if (StringUtils.hasText(request.getDisplayName())) {
      row.setDisplayName(request.getDisplayName().trim());
    }
    if (request.getDisplayOrder() != null) {
      if (request.getDisplayOrder() < 1) {
        throw new IllegalArgumentException("displayOrder must be 1 or more");
      }
      row.setDisplayOrder(request.getDisplayOrder());
    }
    if (Boolean.TRUE.equals(request.getClearMaintenance())) {
      row.setMaintenanceMessage(null);
      row.setMaintenanceFrom(null);
      row.setMaintenanceTo(null);
      return;
    }
    boolean windowGiven =
        request.getMaintenanceFrom() != null || request.getMaintenanceTo() != null;
    if (windowGiven) {
      if (request.getMaintenanceFrom() == null || request.getMaintenanceTo() == null) {
        throw new IllegalArgumentException("Give both maintenanceFrom and maintenanceTo");
      }
      if (!request.getMaintenanceTo().isAfter(request.getMaintenanceFrom())) {
        throw new IllegalArgumentException("maintenanceTo must be after maintenanceFrom");
      }
      if (!StringUtils.hasText(request.getMaintenanceMessage())
          && !StringUtils.hasText(row.getMaintenanceMessage())) {
        throw new IllegalArgumentException(
            "maintenanceMessage is required for a maintenance window");
      }
      row.setMaintenanceFrom(request.getMaintenanceFrom());
      row.setMaintenanceTo(request.getMaintenanceTo());
    }
    if (StringUtils.hasText(request.getMaintenanceMessage())) {
      row.setMaintenanceMessage(request.getMaintenanceMessage().trim());
    }
  }

  private static String requireStateCode(String tenantOrStateCode) {
    String stateCode = TenantStateCodeResolver.resolve(tenantOrStateCode);
    if (!StringUtils.hasText(stateCode)) {
      throw new IllegalArgumentException("State code (X-Tenant-ID) is required");
    }
    return stateCode.trim().toUpperCase();
  }

  private static PaymentGatewayAvailabilityResponse toResponse(
      PaymentGatewayAvailability row, LocalDateTime now) {
    Gateway gateway = row.getGateway();
    return PaymentGatewayAvailabilityResponse.builder()
        .id(row.getId())
        .gatewayId(gateway.getGatewayId())
        .gatewayCode(gateway.getCode() == null ? null : gateway.getCode().trim().toUpperCase())
        .gatewayName(gateway.getType())
        .stateCode(row.getStateCode())
        .userType(row.getUserType().name())
        .isActive(row.getIsActive())
        .displayName(row.getDisplayName())
        .displayOrder(row.getDisplayOrder())
        .maintenanceMessage(row.getMaintenanceMessage())
        .maintenanceFrom(row.getMaintenanceFrom())
        .maintenanceTo(row.getMaintenanceTo())
        .underMaintenance(row.isUnderMaintenance(now))
        .build();
  }
}
