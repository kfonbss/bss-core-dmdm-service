package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister;
import in.gov.kfon.dmdm.contract.CorporatePartnerInvoiceRegister.Kind;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.CorporatePartnerInvoiceReportService;
import java.time.LocalDate;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Raw registers behind the finance "Corporate AGNP Invoices" and "Corporate LNP Invoices" pages.
 * Called by bss-billing-finance-services, which validates the filters and builds labels and totals.
 * {@code kind} is {@code AGNP} or {@code LNP}.
 */
@RestController
@RequestMapping("/api/report/corporate-partner-invoices")
@RequiredArgsConstructor
public class CorporatePartnerInvoiceReportController {

  static final int MAX_PAGE_SIZE = 500;

  private final CorporatePartnerInvoiceReportService service;

  @GetMapping("/{kind}")
  public ResponseEntity<Response<Page<CorporatePartnerInvoiceRegister.Row>>> fetchRegister(
      @PathVariable Kind kind,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
      @RequestParam(required = false) UUID districtId,
      @RequestParam(required = false) String accountType,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) String search,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {

    Page<CorporatePartnerInvoiceRegister.Row> data =
        service.fetchRegister(
            kind,
            from,
            to,
            districtId,
            accountType,
            status,
            search,
            PageRequest.of(Math.max(page, 0), Math.min(Math.max(size, 1), MAX_PAGE_SIZE)));

    return ResponseEntity.ok(
        Response.ok(data, "Corporate " + kind + " invoice rows fetched successfully"));
  }

  /** Sums over the whole filtered window, independent of paging. */
  @GetMapping("/{kind}/summary")
  public ResponseEntity<Response<CorporatePartnerInvoiceRegister.Totals>> fetchTotals(
      @PathVariable Kind kind,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
      @RequestParam(required = false) UUID districtId,
      @RequestParam(required = false) String accountType,
      @RequestParam(required = false) Integer status,
      @RequestParam(required = false) String search) {

    CorporatePartnerInvoiceRegister.Totals data =
        service.fetchTotals(kind, from, to, districtId, accountType, status, search);
    return ResponseEntity.ok(
        Response.ok(data, "Corporate " + kind + " invoice summary fetched successfully"));
  }
}
