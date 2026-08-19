package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.NmsDetailRequest;
import in.gov.kfon.dmdm.contract.NmsDetailResponse;
import in.gov.kfon.dmdm.model.NmsDetail;
import in.gov.kfon.dmdm.repository.NmsDetailRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class NmsDetailServiceImpl implements NmsDetailService {

  private final NmsDetailRepository repository;

  @Override
  public NmsDetailResponse create(NmsDetailRequest request) {
    if (repository.existsByStateCode(request.getStateCode())) {
      throw new IllegalArgumentException(
          "NMS detail already exists for state code: " + request.getStateCode());
    }

    NmsDetail entity =
        NmsDetail.builder()
            .ip(request.getIp())
            .token(request.getToken())
            .stateCode(request.getStateCode())
            .description(request.getDescription())
            .isActive(true)
            .build();

    NmsDetail saved = repository.save(entity);
    return mapToResponse(saved);
  }

  @Override
  public NmsDetailResponse update(UUID id, NmsDetailRequest request) {
    NmsDetail entity =
        repository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException("NMS detail not found for id: " + id));

    entity.setIp(request.getIp());
    entity.setToken(request.getToken());
    entity.setStateCode(request.getStateCode());
    entity.setDescription(request.getDescription());

    NmsDetail saved = repository.save(entity);
    return mapToResponse(saved);
  }

  @Override
  @Transactional(readOnly = true)
  public NmsDetailResponse fetchById(UUID id) {
    return repository
        .findById(id)
        .map(this::mapToResponse)
        .orElseThrow(
            () -> new EntityNotFoundException("NMS detail not found for id: " + id));
  }

  @Override
  @Transactional(readOnly = true)
  public NmsDetailResponse fetchByStateCode(String stateCode) {
    return repository
        .findByStateCodeAndIsActiveTrue(stateCode)
        .map(this::mapToResponse)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    "NMS detail not found for state code: " + stateCode));
  }

  @Override
  @Transactional(readOnly = true)
  public List<NmsDetailResponse> fetchAll() {
    return repository.findByIsActiveTrue().stream().map(this::mapToResponse).toList();
  }

  private NmsDetailResponse mapToResponse(NmsDetail entity) {
    return NmsDetailResponse.builder()
        .nmsDetailId(entity.getNmsDetailId())
        .ip(entity.getIp())
        .token(entity.getToken())
        .stateCode(entity.getStateCode())
        .description(entity.getDescription())
        .isActive(entity.getIsActive())
        .createdDate(entity.getCreatedDate())
        .modifiedDate(entity.getModifiedDate())
        .build();
  }
}
