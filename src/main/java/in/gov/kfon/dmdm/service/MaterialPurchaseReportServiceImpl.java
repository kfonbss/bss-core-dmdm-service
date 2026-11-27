package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.MaterialPurchaseRegister;
import in.gov.kfon.dmdm.repository.MaterialPurchaseReportRepository;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MaterialPurchaseReportServiceImpl implements MaterialPurchaseReportService {

  private final MaterialPurchaseReportRepository repository;

  @Override
  @Transactional(readOnly = true)
  public Page<MaterialPurchaseRegister.Row> fetchRegister(
      Integer activeFlag,
      LocalDate from,
      LocalDate to,
      String month,
      UUID districtId,
      String search,
      Pageable pageable) {
    return repository.findRegister(
        activeFlag,
        from,
        exclusiveEnd(to),
        blankToNull(month),
        districtId,
        searchFilter(search),
        pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public MaterialPurchaseRegister.Totals fetchTotals(
      Integer activeFlag,
      LocalDate from,
      LocalDate to,
      String month,
      UUID districtId,
      String search) {
    return repository.findTotals(
        activeFlag, from, exclusiveEnd(to), blankToNull(month), districtId, searchFilter(search));
  }

  /** Inclusive end date → half-open bound, so the whole last day's timestamps match. */
  private static LocalDate exclusiveEnd(LocalDate to) {
    return to != null ? to.plusDays(1) : null;
  }

  private static String searchFilter(String search) {
    return search != null && !search.isBlank() ? "%" + search.trim() + "%" : null;
  }

  private static String blankToNull(String value) {
    return value != null && !value.isBlank() ? value.trim() : null;
  }
}
