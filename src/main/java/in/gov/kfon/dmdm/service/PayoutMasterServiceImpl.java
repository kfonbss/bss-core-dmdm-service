package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.Config.CacheNames;
import in.gov.kfon.dmdm.contract.PaymentModeResponse;
import in.gov.kfon.dmdm.contract.PayoutChargeResponse;
import in.gov.kfon.dmdm.model.PaymentMode;
import in.gov.kfon.dmdm.model.PayoutCharge;
import in.gov.kfon.dmdm.repository.PaymentModeRepository;
import in.gov.kfon.dmdm.repository.PayoutChargeRepository;
import jakarta.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PayoutMasterServiceImpl implements PayoutMasterService {

  private final PaymentModeRepository paymentModeRepository;
  private final PayoutChargeRepository payoutChargeRepository;

  @Override
  @Cacheable(cacheNames = CacheNames.ALL_PAYOUT_PAYMENT_MODES)
  public List<PaymentModeResponse> fetchPaymentModes() {
    List<PayoutCharge> allCharges =
        payoutChargeRepository.findByIsActiveTrueOrderByModeAscStartRangeAsc();
    return paymentModeRepository.findByIsActiveTrueOrderByDisplayOrderAsc().stream()
        .map(
            mode -> {
              List<PayoutChargeResponse> charges =
                  allCharges.stream()
                      .filter(c -> mode.getModeCode().equals(c.getMode()))
                      .map(this::toChargeResponse)
                      .toList();
              return toModeResponse(mode, charges);
            })
        .toList();
  }

  @Override
  @Cacheable(cacheNames = CacheNames.PAYOUT_CHARGES_BY_MODE, key = "#mode ?: 'all'")
  public List<PayoutChargeResponse> fetchCharges(String mode) {
    List<PayoutCharge> charges =
        mode != null
            ? payoutChargeRepository.findByModeAndIsActiveTrueOrderByStartRangeAsc(mode)
            : payoutChargeRepository.findByIsActiveTrueOrderByModeAscStartRangeAsc();
    return charges.stream().map(this::toChargeResponse).toList();
  }

  @Override
  public PayoutChargeResponse fetchChargeForAmount(String mode, BigDecimal amount) {
    return payoutChargeRepository.findByModeAndIsActiveTrueOrderByStartRangeAsc(mode).stream()
        .filter(
            c -> {
              boolean aboveStart = amount.compareTo(c.getStartRange()) >= 0;
              boolean noUpperLimit = c.getEndRange().compareTo(BigDecimal.ZERO) == 0;
              boolean belowEnd = amount.compareTo(c.getEndRange()) <= 0;
              return aboveStart && (noUpperLimit || belowEnd);
            })
        .findFirst()
        .map(this::toChargeResponse)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    "No charge configured for mode=" + mode + ", amount=" + amount));
  }

  private PaymentModeResponse toModeResponse(PaymentMode mode, List<PayoutChargeResponse> charges) {
    return PaymentModeResponse.builder()
        .id(mode.getId())
        .modeCode(mode.getModeCode())
        .modeName(mode.getModeName())
        .displayOrder(mode.getDisplayOrder())
        .isActive(mode.getIsActive())
        .charges(charges)
        .build();
  }

  private PayoutChargeResponse toChargeResponse(PayoutCharge charge) {
    return PayoutChargeResponse.builder()
        .id(charge.getId())
        .mode(charge.getMode())
        .startRange(charge.getStartRange())
        .endRange(charge.getEndRange())
        .rate(charge.getRate())
        .isActive(charge.getIsActive())
        .build();
  }
}
