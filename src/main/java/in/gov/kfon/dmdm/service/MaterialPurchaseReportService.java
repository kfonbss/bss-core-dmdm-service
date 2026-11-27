package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.MaterialPurchaseRegister;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MaterialPurchaseReportService {

  /**
   * @param activeFlag {@code 1} active, {@code 0} cancelled, null = both
   * @param from inclusive invoice create date; null = open
   * @param to inclusive invoice create date; null = open
   * @param month exact {@code invoicemonth}; null = all
   */
  Page<MaterialPurchaseRegister.Row> fetchRegister(
      Integer activeFlag,
      LocalDate from,
      LocalDate to,
      String month,
      UUID districtId,
      String search,
      Pageable pageable);

  MaterialPurchaseRegister.Totals fetchTotals(
      Integer activeFlag,
      LocalDate from,
      LocalDate to,
      String month,
      UUID districtId,
      String search);
}
