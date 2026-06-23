package in.gov.kfon.dmdm.revenueshare.service;

import in.gov.kfon.dmdm.model.RevenueShare;
import in.gov.kfon.dmdm.repository.RevenueShareRepository;
import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareRequest;
import in.gov.kfon.dmdm.revenueshare.contract.RevenueShareSettingsResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RevenueShareSettingsServiceImpl implements RevenueShareSettingsService {

  private final RevenueShareRepository revenueShareRepository;

  @Override
  @Transactional
  public RevenueShareSettingsResponse create(RevenueShareRequest request) {
    RevenueShare entity =
        RevenueShare.builder()
            .shareName(request.getShareName())
            .code(request.getCode())
            .name(request.getName())
            .nameInLocal(request.getNameInLocal())
            .state(request.getState())
            .subgroup(request.getSubgroup())
            .providerUuid(request.getProviderUuid())
            .ibnpShare(request.getIbnpShare())
            .ibwpShare(request.getIbwpShare())
            .anpShare(request.getAnpShare())
            .agpShare(request.getAgpShare())
            .cnpShare(request.getCnpShare())
            .mspShare(request.getMspShare())
            .mktShare(request.getMktShare())
            .ispShare(request.getIspShare())
            .permShare(request.getPermShare())
            .dotShare(request.getDotShare())
            .provShare(request.getProvShare())
            .prs(request.getPrs())
            .isActive(request.getIsActive())
            .build();
    return toResponse(revenueShareRepository.save(entity));
  }

  @Override
  @Transactional
  public RevenueShareSettingsResponse update(UUID id, RevenueShareRequest request) {
    RevenueShare entity =
        revenueShareRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Revenue share not found: " + id));
    entity.setShareName(request.getShareName());
    entity.setCode(request.getCode());
    entity.setName(request.getName());
    entity.setNameInLocal(request.getNameInLocal());
    entity.setState(request.getState());
    entity.setSubgroup(request.getSubgroup());
    entity.setProviderUuid(request.getProviderUuid());
    entity.setIbnpShare(request.getIbnpShare());
    entity.setIbwpShare(request.getIbwpShare());
    entity.setAnpShare(request.getAnpShare());
    entity.setAgpShare(request.getAgpShare());
    entity.setCnpShare(request.getCnpShare());
    entity.setMspShare(request.getMspShare());
    entity.setMktShare(request.getMktShare());
    entity.setIspShare(request.getIspShare());
    entity.setPermShare(request.getPermShare());
    entity.setDotShare(request.getDotShare());
    entity.setProvShare(request.getProvShare());
    entity.setPrs(request.getPrs());
    entity.setIsActive(request.getIsActive());
    return toResponse(revenueShareRepository.save(entity));
  }

  @Override
  @Transactional
  public RevenueShareSettingsResponse updateStatus(UUID id, Boolean isActive) {
    RevenueShare entity =
        revenueShareRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Revenue share not found: " + id));
    entity.setIsActive(isActive);
    return toResponse(revenueShareRepository.save(entity));
  }

  @Override
  @Transactional(readOnly = true)
  public RevenueShareSettingsResponse getById(UUID id) {
    return revenueShareRepository
        .findById(id)
        .map(this::toResponse)
        .orElseThrow(() -> new EntityNotFoundException("Revenue share not found: " + id));
  }

  @Override
  @Transactional(readOnly = true)
  public Page<RevenueShareSettingsResponse> getAll(int page, int size) {
    PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "shareName"));
    return revenueShareRepository.findAll(pageable).map(this::toResponse);
  }

  private RevenueShareSettingsResponse toResponse(RevenueShare entity) {
    return RevenueShareSettingsResponse.builder()
        .id(entity.getId())
        .revenueShareId(entity.getRevenueShareId())
        .shareName(entity.getShareName())
        .code(entity.getCode())
        .name(entity.getName())
        .nameInLocal(entity.getNameInLocal())
        .state(entity.getState())
        .subgroup(entity.getSubgroup())
        .providerUuid(entity.getProviderUuid())
        .ibnpShare(entity.getIbnpShare())
        .ibwpShare(entity.getIbwpShare())
        .anpShare(entity.getAnpShare())
        .agpShare(entity.getAgpShare())
        .cnpShare(entity.getCnpShare())
        .mspShare(entity.getMspShare())
        .mktShare(entity.getMktShare())
        .ispShare(entity.getIspShare())
        .permShare(entity.getPermShare())
        .dotShare(entity.getDotShare())
        .provShare(entity.getProvShare())
        .prs(entity.getPrs())
        .isActive(entity.getIsActive())
        .build();
  }
}
