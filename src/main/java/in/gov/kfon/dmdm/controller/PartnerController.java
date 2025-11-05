package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.PartnerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
@RequiredArgsConstructor
public class PartnerController {

  private final PartnerService service;

  @GetMapping("/finances/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerFinances() {
    var data = service.fetchAllFinanceDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner financial details"));
  }

  @GetMapping("/finance/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerFinanceById(@PathVariable UUID id) {
    var data = service.fetchFinanceDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner finance detail"));
  }

  @GetMapping("/taxpayer-logs/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerTaxpayerLogs() {
    var data = service.fetchAllTaxpayerLogs();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner taxpayer logs"));
  }

  @GetMapping("/taxpayer-log/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerTaxpayerLogById(@PathVariable UUID id) {
    var data = service.fetchTaxpayerLogById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner taxpayer log"));
  }

  @GetMapping("/groups/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerGroups() {
    var data = service.fetchAllPartnerGroups();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner groups"));
  }

  @GetMapping("/group/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerGroupById(@PathVariable UUID id) {
    var data = service.fetchPartnerGroupById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner group by id"));
  }

  @GetMapping("/gst-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerGstDetails() {
    var data = service.fetchAllPartnerGstDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner GST details"));
  }

  @GetMapping("/gst-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerGstDetailById(@PathVariable UUID id) {
    var data = service.fetchPartnerGstDetailById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner GST detail by id"));
  }

  @GetMapping("/gst-invoices/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGstInvoices() {
    var data = service.fetchAllGstInvoices();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner GST invoices"));
  }

  @GetMapping("/gst-invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGstInvoiceById(@PathVariable UUID id) {
    var data = service.fetchGstInvoiceById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner GST invoice by id"));
  }

  @GetMapping("/online-recharges/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllOnlineRecharges() {
    var data = service.fetchAllOnlineRecharges();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner online recharges"));
  }

  @GetMapping("/online-recharge/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchOnlineRechargeById(@PathVariable UUID id) {
    var data = service.fetchOnlineRechargeById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner online recharge by id"));
  }

  @GetMapping("/receipts/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerReceipts() {
    var data = service.fetchAllPartnerReceipts();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner receipts"));
  }

  @GetMapping("/receipt/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerReceiptById(@PathVariable UUID id) {
    var data = service.fetchPartnerReceiptById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner receipt by id"));
  }

  @GetMapping("/account-reports/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerAccountReports() {
    var data = service.fetchAllPartnerAccountReports();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner account reports"));
  }

  @GetMapping("/account-report/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerAccountReportById(
      @PathVariable UUID id) {
    var data = service.fetchPartnerAccountReportById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner account report by id"));
  }

  @GetMapping("/disbursements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerDisbursements() {
    var data = service.fetchAllPartnerDisbursements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner disbursements"));
  }

  @GetMapping("/disbursement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerDisbursementById(
      @PathVariable UUID id) {
    var data = service.fetchPartnerDisbursementById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner disbursement by id"));
  }

  @GetMapping("/finance-records/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerFinanceRecords() {
    var data = service.fetchAllPartnerFinances();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner finance records"));
  }

  @GetMapping("/finance-record/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerFinanceRecordById(
      @PathVariable UUID id) {
    var data = service.fetchPartnerFinanceById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner finance record by id"));
  }

  @GetMapping("/confirmations/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerConfirmations() {
    var data = service.fetchAllPartnerConfirmationsFromAgnp();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner confirmations from AGNP"));
  }

  @GetMapping("/confirmation/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerConfirmationById(
      @PathVariable UUID id) {
    var data = service.fetchPartnerConfirmationFromAgnpById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner confirmation from AGNP by id"));
  }

  @GetMapping("/confirmation-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerConfirmationMovements() {
    var data = service.fetchAllPartnerConfirmationMovements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner confirmation movements"));
  }

  @GetMapping("/confirmation-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerConfirmationMovementById(
      @PathVariable UUID id) {
    var data = service.fetchPartnerConfirmationMovementById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner confirmation movement by id"));
  }

  @GetMapping("/gst-valets/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGstValets() {
    var data = service.fetchAllGstValets();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner GST valets"));
  }

  @GetMapping("/gst-valet/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGstValetById(@PathVariable UUID id) {
    var data = service.fetchGstValetById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner GST valet by id"));
  }

  @GetMapping("/revenues/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllRevenues() {
    var data = service.fetchAllRevenues();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner revenues"));
  }

  @GetMapping("/revenue/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchRevenueById(@PathVariable UUID id) {
    var data = service.fetchRevenueById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner revenue by id"));
  }

  @GetMapping("/accounts/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllAccounts() {
    var data = service.fetchAllAccounts();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner accounts"));
  }

  @GetMapping("/account/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchAccountById(@PathVariable UUID id) {
    var data = service.fetchAccountById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner account by id"));
  }

  @GetMapping("/details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPartnerDetails() {
    var data = service.fetchAllPartnerDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner details"));
  }

  @GetMapping("/detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPartnerDetailById(@PathVariable UUID id) {
    var data = service.fetchPartnerDetailById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner detail by id"));
  }

  @GetMapping("/demo-users/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDemoUsers() {
    var data = service.fetchAllDemoUsers();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all demo users"));
  }

  @GetMapping("/demo-user/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDemoUserById(@PathVariable UUID id) {
    var data = service.fetchDemoUserById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched demo user by id"));
  }

  @GetMapping("/agreement-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllAgreementDetails() {
    var data = service.fetchAllAgreementDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all partner agreement details"));
  }

  @GetMapping("/agreement-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchAgreementDetailById(@PathVariable UUID id) {
    var data = service.fetchAgreementDetailById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched partner agreement detail by id"));
  }
}
