package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.AnpUsersResponse;
import in.gov.kfon.dmdm.repository.AnpUsersRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnpUsersServiceImpl implements AnpUsersService {

  private final AnpUsersRepository anpUsersRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional(readOnly = true)
  @Cacheable(cacheNames = CacheNames.ALL_ANP_USERS)
  public List<AnpUsersResponse> fetchAllAnpUsers() {
    return anpUsersRepository.findAll().stream()
        .map(u -> modelMapper.map(u, AnpUsersResponse.class))
        .toList();
  }
}
