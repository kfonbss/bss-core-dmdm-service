package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.CafDetails;
import in.gov.kfon.dmdm.repository.CafDetailsRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CafDetailsServiceImpl implements CafDetailsService {
  private final ModelMapper modelMapper;
  private final CafDetailsRepository cafDetailsRepository;
  private static final String NOT_FOUND = "Not found with id: ";

  @PostConstruct
  public void setupMapper() {
    // For caf details
    modelMapper.addMappings(
        new PropertyMap<CafDetails, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
            skip(destination.getPincode());
          }
        });
  }

  @Override
  @Transactional(readOnly = true)
  public List<CommonLookUp> detailsFetchAll() {
    return cafDetailsRepository.findAll().stream()
        .map(
            details -> {
              CommonLookUp lookup = modelMapper.map(details, CommonLookUp.class);
              lookup.setId(details.getDetailsId());
              return lookup;
            })
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public CommonLookUp detailsFetchById(UUID id) {
    CafDetails entity =
        cafDetailsRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND + id));

    CommonLookUp lookup = modelMapper.map(entity, CommonLookUp.class);
    lookup.setId(entity.getDetailsId());

    return lookup;
  }
}
