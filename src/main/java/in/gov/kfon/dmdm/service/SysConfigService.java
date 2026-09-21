package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.SysConfigResponse;

public interface SysConfigService {
  SysConfigResponse resolve(String tenantId);
}
