package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CorporatePartnerInvoiceReportService {

  /**
   * @param from inclusive document date (invoice date, else the month's last day); null = open
   * @param to inclusive document date; null = open
   * @param districtId {@code district.district_id}; matches the partner's legacy district text by
   *     the master's name, code or numeric id; null = all
   * @param accountType partner bank account type (CA / SB), case-insensitive exact; null = all
   * @param status approval code (0 pending, 1 approved, 2 / 3 clarification); null = all
   * @param search partner id / name, invoice no, work order, customer or district — contains
   */
  Page<CorporatePartnerInvoiceRegister.Row> fetchRegister(
      CorporatePartnerInvoiceRegister.Kind kind,
      LocalDate from,
      LocalDate to,
      UUID districtId,
      String accountType,
      Integer status,
      String search,
      Pageable pageable);

  CorporatePartnerInvoiceRegister.Totals fetchTotals(
      CorporatePartnerInvoiceRegister.Kind kind,
      LocalDate from,
      LocalDate to,
      UUID districtId,
      String accountType,
      Integer status,
      String search);
}
