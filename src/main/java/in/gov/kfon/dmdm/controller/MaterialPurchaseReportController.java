package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.MaterialPurchaseRegister;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.MaterialPurchaseReportService;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Raw register behind the finance "Material Purchases from Partners" page. Called by
 * bss-billing-finance-services, which validates the filters and derives the payable fields.
 */
@RestController
@RequestMapping("/api/report/material-purchases")
@RequiredArgsConstructor
public class MaterialPurchaseReportController {

  static final int MAX_PAGE_SIZE = 500;

  private final MaterialPurchaseReportService service;

  @GetMapping
  public ResponseEntity<Response<Page<MaterialPurchaseRegister.Row>>> fetchRegister(
      @RequestParam(required = false) Integer activeFlag,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
      @RequestParam(required = false) String month,
      @RequestParam(required = false) UUID districtId,
      @RequestParam(required = false) String search,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {

    Page<MaterialPurchaseRegister.Row> data =
        service.fetchRegister(
            activeFlag,
            from,
            to,
            month,
            districtId,
            search,
            PageRequest.of(Math.max(page, 0), Math.min(Math.max(size, 1), MAX_PAGE_SIZE)));

    return ResponseEntity.ok(Response.ok(data, "Material purchase rows fetched successfully"));
  }

  /** Sums over the whole filtered window, independent of paging. */
  @GetMapping("/summary")
  public ResponseEntity<Response<MaterialPurchaseRegister.Totals>> fetchTotals(
      @RequestParam(required = false) Integer activeFlag,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
      @RequestParam(required = false) String month,
      @RequestParam(required = false) UUID districtId,
      @RequestParam(required = false) String search) {

    MaterialPurchaseRegister.Totals data =
        service.fetchTotals(activeFlag, from, to, month, districtId, search);
    return ResponseEntity.ok(Response.ok(data, "Material purchase summary fetched successfully"));
  }
}
