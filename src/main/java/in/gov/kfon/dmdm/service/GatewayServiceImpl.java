package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.GatewayAvailabilityResponse;
import in.gov.kfon.dmdm.model.Gateway;
import in.gov.kfon.dmdm.model.StateDistrict;
import in.gov.kfon.dmdm.repository.GatewayLocationRepository;
import in.gov.kfon.dmdm.repository.GatewayRepository;
import in.gov.kfon.dmdm.repository.StateDistrictRepository;
import in.gov.kfon.dmdm.util.TenantStateCodeResolver;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GatewayServiceImpl implements GatewayService {

  private static final int ACTIVE_STATUS = 1;

  private static final Map<String, Set<String>> GATEWAY_CODES_BY_USER_TYPE =
      Map.of(
          "LNP", Set.of("BILLDESK", "PAYTM"),
          "SUBSCRIBER", Set.of("ATOM", "RAZORPAY"));

  private final GatewayRepository repository;
  private final GatewayLocationRepository gatewayLocationRepository;
  private final StateDistrictRepository stateDistrictRepository;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(
      cacheNames = CacheNames.ALL_GATEWAYS,
      key = "#userType == null || #userType.isBlank() ? 'ALL' : #userType.trim().toUpperCase()")
  public List<CommonLookUp> fetchAll(String userType) {
    var gateways = repository.findAll().stream();
    if (userType != null && !userType.isBlank()) {
      var allowedCodes = GATEWAY_CODES_BY_USER_TYPE.get(userType.trim().toUpperCase());
      if (allowedCodes == null) {
        throw new IllegalArgumentException(
            "Invalid userType: "
                + userType
                + ". Allowed values: "
                + GATEWAY_CODES_BY_USER_TYPE.keySet());
      }
      gateways =
          gateways.filter(
              gateway ->
                  gateway.getCode() != null
                      && allowedCodes.contains(gateway.getCode().trim().toUpperCase()));
    }
    return gateways.map(this::toCommonLookUp).toList();
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
