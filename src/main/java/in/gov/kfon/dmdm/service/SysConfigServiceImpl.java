package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.SysConfigResponse;
import in.gov.kfon.dmdm.repository.SysConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SysConfigServiceImpl implements SysConfigService {

  private final SysConfigRepository repository;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.SYS_CONFIG_BY_TENANT, key = "#tenantId")
  public SysConfigResponse resolve(String tenantId) {
    return repository
        .findFirstByStateCodeIgnoreCase(tenantId)
        .map(
            sysConfig ->
                SysConfigResponse.builder()
                    .tenantId(sysConfig.getStateCode().trim())
                    .aaaIp(sysConfig.getAaaIp())
                    .build())
        .orElseThrow(
            () -> new IllegalArgumentException("No sys_config found for tenant: " + tenantId));
  }
}
