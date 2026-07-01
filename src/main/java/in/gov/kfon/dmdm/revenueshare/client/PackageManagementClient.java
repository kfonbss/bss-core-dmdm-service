package in.gov.kfon.dmdm.revenueshare.client;

import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.revenueshare.contract.ServiceTypeLookUp;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "package-management-service", url = "${package.management.service.url}")
public interface PackageManagementClient {

  @GetMapping("/api/fetch/service-types")
  Response<List<ServiceTypeLookUp>> fetchServiceTypes();
}
