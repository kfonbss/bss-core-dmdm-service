package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.repository.GatewayRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GatewayServiceImpl implements GatewayService {

  private final GatewayRepository repository;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_GATEWAYS)
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(
            gateway ->
                CommonLookUp.builder()
                    .id(gateway.getGatewayId())
                    .masterId(gateway.getId())
                    .code(gateway.getCode())
                    .name(gateway.getType())
                    .isActive(true)
                    .build())
        .toList();
  }
}