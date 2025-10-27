package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.model.CorpLocationList;
import in.gov.kfon.dmdm.model.CorporateEnquiry;
import in.gov.kfon.dmdm.repository.CorpLocationListRepository;
import in.gov.kfon.dmdm.repository.CorporateEnquiryRepository;
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
public class CorporateOnboardingServiceImpl implements CorporateOnboardingService {

  private final ModelMapper modelMapper;
  private final CorporateEnquiryRepository repository;
  private final CorpLocationListRepository locationListRepository;

  @PostConstruct
  public void setupMapper() {
    // For CorporateEnquiry
    modelMapper.addMappings(
        new PropertyMap<CorporateEnquiry, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
          }
        });

    // For CorpLocationList
    modelMapper.addMappings(
        new PropertyMap<CorpLocationList, CommonLookUp>() {
          @Override
          protected void configure() {
            skip(destination.getId());
          }
        });
  }

  @Override
  public List<CommonLookUp> fetchAll() {
    return repository.findAll().stream()
        .map(
            enquiry -> {
              CommonLookUp lookup = modelMapper.map(enquiry, CommonLookUp.class);
              lookup.setId(enquiry.getEnquiriesId());
              return lookup;
            })
        .toList();
  }

  @Override
  public CommonLookUp fetchById(UUID id) {
    CorporateEnquiry enquiry =
        repository
            .findByEnquiriesId(id)
            .orElseThrow(
                () -> new EntityNotFoundException("Corporate Enquiry not found with id: " + id));

    CommonLookUp lookup = modelMapper.map(enquiry, CommonLookUp.class);
    lookup.setId(enquiry.getEnquiriesId());

    return lookup;
  }

  @Override
  public List<CommonLookUp> locationFetchAll() {
    return locationListRepository.findAll().stream()
        .map(
            enquiry -> {
              CommonLookUp lookup = modelMapper.map(enquiry, CommonLookUp.class);
              lookup.setId(enquiry.getListId());
              return lookup;
            })
        .toList();
  }

  @Override
  public CommonLookUp locationFetchById(UUID id) {
    CorpLocationList list =
        locationListRepository
            .findByListId(id)
            .orElseThrow(
                () ->
                    new EntityNotFoundException(
                        "Corporate Location List not found with id: " + id));

    CommonLookUp lookup = modelMapper.map(list, CommonLookUp.class);
    lookup.setId(list.getListId());

    return lookup;
  }
}
