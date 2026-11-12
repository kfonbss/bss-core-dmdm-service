package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.constant.PaymentGatewayUserType;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.GatewayAvailabilityResponse;
import in.gov.kfon.dmdm.model.Gateway;
import in.gov.kfon.dmdm.model.PaymentGatewayAvailability;
import in.gov.kfon.dmdm.model.StateDistrict;
import in.gov.kfon.dmdm.repository.GatewayLocationRepository;
import in.gov.kfon.dmdm.repository.GatewayRepository;
import in.gov.kfon.dmdm.repository.PaymentGatewayAvailabilityRepository;
import in.gov.kfon.dmdm.repository.StateDistrictRepository;
import in.gov.kfon.dmdm.util.TenantStateCodeResolver;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GatewayServiceImpl implements GatewayService {

  private static final int ACTIVE_STATUS = 1;

  private final GatewayRepository repository;
  private final GatewayLocationRepository gatewayLocationRepository;
  private final StateDistrictRepository stateDistrictRepository;
  private final PaymentGatewayAvailabilityRepository paymentGatewayAvailabilityRepository;

  /**
   * Every gateway in the master when {@code userType} is blank. Otherwise the gateways the tenant's
   * state offers to that user type (SUBSCRIBER, or PARTNER / LNP), from
   * payment_gateway_availability; without a tenant, the ones any state offers to it.
   */
  @Override
  @Transactional(readOnly = true)
  @Cacheable(
      cacheNames = CacheNames.ALL_GATEWAYS,
      key =
          "(#userType == null || #userType.isBlank() ? 'ALL' : #userType.trim().toUpperCase())"
              + " + ':' + (#tenantId == null ? '' : #tenantId.trim().toUpperCase())")
  public List<CommonLookUp> fetchAll(String userType, String tenantId) {
    if (userType == null || userType.isBlank()) {
      return repository.findAll().stream().map(this::toCommonLookUp).toList();
    }
    PaymentGatewayUserType type = PaymentGatewayUserType.from(userType);
    String stateCode = TenantStateCodeResolver.resolve(tenantId);
    List<PaymentGatewayAvailability> rows =
        stateCode == null || stateCode.isBlank()
            ? paymentGatewayAvailabilityRepository.findAll().stream()
                .filter(row -> row.getUserType() == type && Boolean.TRUE.equals(row.getIsActive()))
                .sorted(Comparator.comparing(PaymentGatewayAvailability::getDisplayOrder))
                .toList()
            : paymentGatewayAvailabilityRepository
                .findByStateCodeIgnoreCaseAndUserTypeAndIsActiveTrueOrderByDisplayOrderAsc(
                    stateCode, type);
    Map<UUID, Gateway> gateways = new LinkedHashMap<>();
    rows.forEach(row -> gateways.putIfAbsent(row.getGateway().getGatewayId(), row.getGateway()));
    return gateways.values().stream().map(this::toCommonLookUp).toList();
  }

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.GATEWAYS_BY_TENANT, key = "#tenantId")
  public GatewayAvailabilityResponse fetchAvailableGateways(String tenantId) {
    tenantId = TenantStateCodeResolver.resolve(tenantId);
    String numericStateCode =
        stateDistrictRepository
            .findFirstByStateCodeIgnoreCase(tenantId)
            .map(StateDistrict::getStCode)
            .map(String::trim)
            .filter(code -> !code.isEmpty())
            .orElse(null);

    if (numericStateCode == null) {
      return GatewayAvailabilityResponse.builder()
          .gatewayAvailable(false)
          .gateways(List.of())
          .build();
    }

    var locations =
        gatewayLocationRepository.findByStateCodeIgnoreCaseAndStatus(
            numericStateCode, ACTIVE_STATUS);
    var gateways =
        locations.stream()
            .map(
                location ->
                    CommonLookUp.builder()
                        .id(location.getId())
                        .name(location.getGatewayName())
                        .district(location.getDistrict())
                        .isActive(true)
                        .build())
            .toList();
    return GatewayAvailabilityResponse.builder()
        .gatewayAvailable(!gateways.isEmpty())
        .gateways(gateways)
        .build();
  }

  private CommonLookUp toCommonLookUp(Gateway gateway) {
    return CommonLookUp.builder()
        .id(gateway.getGatewayId())
        .masterId(gateway.getId())
        .code(gateway.getCode())
        .name(gateway.getType())
        .isActive(true)
        .build();
  }
}
