package in.gov.kfon.dmdm.Config;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.RevenueShare;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    modelMapper
        .typeMap(RevenueShare.class, CommonLookUp.class)
        .addMapping(RevenueShare::getRevenueShareId, CommonLookUp::setMasterId);

    return modelMapper;
  }
}
