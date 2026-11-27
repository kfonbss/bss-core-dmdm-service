package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister;
import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister.Kind;
import in.gov.kfon.dmdm.repository.CorporatePartnerInvoiceReportRepository;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CorporatePartnerInvoiceReportServiceImpl
    implements CorporatePartnerInvoiceReportService {

  private final CorporatePartnerInvoiceReportRepository repository;

  @Override
  @Transactional(readOnly = true)
  public Page<CorporatePartnerInvoiceRegister.Row> fetchRegister(
      Kind kind,
      LocalDate from,
      LocalDate to,
      UUID districtId,
      String accountType,
      Integer status,
      String search,
      Pageable pageable) {

    String a = blankToNull(accountType);
    String s = searchFilter(search);
    return kind == Kind.AGNP
        ? repository.findAgnpRegister(from, to, districtId, a, status, s, pageable)
        : repository.findLnpRegister(from, to, districtId, a, status, s, pageable);
  }

  @Override
  @Transactional(readOnly = true)
  public CorporatePartnerInvoiceRegister.Totals fetchTotals(
      Kind kind,
      LocalDate from,
      LocalDate to,
      UUID districtId,
      String accountType,
      Integer status,
      String search) {

    String a = blankToNull(accountType);
    String s = searchFilter(search);
    return kind == Kind.AGNP
        ? repository.findAgnpTotals(from, to, districtId, a, status, s)
        : repository.findLnpTotals(from, to, districtId, a, status, s);
  }

  private static String searchFilter(String search) {
    return search != null && !search.isBlank() ? "%" + search.trim() + "%" : null;
  }

  private static String blankToNull(String value) {
    return value != null && !value.isBlank() ? value.trim() : null;
  }
}
