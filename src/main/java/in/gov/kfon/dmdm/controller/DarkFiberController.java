package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.DarkFiberService;
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
@RequestMapping("/api/darkfiber")
@RequiredArgsConstructor
public class DarkFiberController {

  private final DarkFiberService darkFiberService;

  @GetMapping("/group-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupDetails() {
    var data = darkFiberService.fetchAllGroupDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group details"));
  }

  @GetMapping("/group-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupDetailsById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched group detail"));
  }

  @GetMapping("/group-movements")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupMovements() {
    var data = darkFiberService.fetchAllGroupMovements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group movements"));
  }

  @GetMapping("/group-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupMovementById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupMovementById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched group movement"));
  }

  @GetMapping("/group-invoices")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupInvoices() {
    var data = darkFiberService.fetchAllGroupInvoices();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all group invoices"));
  }

  @GetMapping("/group-invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupInvoiceById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupInvoiceById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched invoice by ID"));
  }

  @GetMapping("/group-invoice-masters")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllGroupInvoiceMasters() {
    var data = darkFiberService.fetchAllGroupInvoiceMasters();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all invoice masters"));
  }

  @GetMapping("/group-invoice-master/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchGroupInvoiceMasterById(@PathVariable UUID id) {
    var data = darkFiberService.fetchGroupInvoiceMasterById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched invoice master by ID"));
  }

  @GetMapping("/link-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllLinkDetails() {
    var data = darkFiberService.fetchAllLinkDetails();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all link details"));
  }

  @GetMapping("/link-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchLinkDetailById(@PathVariable UUID id) {
    var data = darkFiberService.fetchLinkDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched link detail by ID"));
  }

  @GetMapping("/link-renewal-histories")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllLinkRenewalHistories() {
    var data = darkFiberService.fetchAllLinkRenewalHistories();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all link renewal histories"));
  }

  @GetMapping("/link-renewal-history/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchLinkRenewalHistoryById(@PathVariable UUID id) {
    var data = darkFiberService.fetchLinkRenewalHistoryById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched link renewal history by ID"));
  }

  @GetMapping("/power-ratings")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPowerRatings() {
    var data = darkFiberService.fetchAllPowerRatings();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all power ratings"));
  }

  @GetMapping("/power-rating/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPowerRatingById(@PathVariable UUID id) {
    var data = darkFiberService.fetchPowerRatingById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched power rating by ID"));
  }

  @GetMapping("/purchase-orders")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllPurchaseOrders() {
    var data = darkFiberService.fetchAllPurchaseOrders();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all purchase orders"));
  }

  @GetMapping("/purchase-order/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchPurchaseOrderById(@PathVariable UUID id) {
    var data = darkFiberService.fetchPurchaseOrderById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched purchase order by ID"));
  }

  @GetMapping("/renewal-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllRenewalDetails() {
    var data = darkFiberService.fetchAllRenewalDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all renewal details"));
  }

  @GetMapping("/renewal-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchRenewalDetailById(@PathVariable UUID id) {
    var data = darkFiberService.fetchRenewalDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched renewal detail by ID"));
  }

  @GetMapping("/subfinances")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllSubFinances() {
    var data = darkFiberService.fetchAllSubFinance();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all sub finances"));
  }

  @GetMapping("/subfinance/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchSubFinanceById(@PathVariable UUID id) {
    var data = darkFiberService.fetchSubFinanceById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched sub finance by ID"));
  }

  @GetMapping("/subscribers")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllSubscribers() {
    var data = darkFiberService.fetchAllSubscribers();
    return ResponseEntity.ok(Response.ok(data, "Fetched all subscribers"));
  }

  @GetMapping("/subscriber/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchSubscriberById(@PathVariable UUID id) {
    var data = darkFiberService.fetchSubscriberById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched subscriber by ID"));
  }

  @GetMapping("/trans-renewal-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllTransRenewalDetails() {
    var data = darkFiberService.fetchAllTransRenewalDetails();
    return ResponseEntity.ok(Response.ok(data, "Fetched all trans renewal details"));
  }

  @GetMapping("/trans-renewal-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchTransRenewalDetailById(@PathVariable UUID id) {
    var data = darkFiberService.fetchTransRenewalDetailById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched trans renewal detail by ID"));
  }

  @GetMapping("/trans-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllTransDetails() {
    var data = darkFiberService.fetchAllTransDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all trans details"));
  }

  @GetMapping("/trans-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchTransDetailsById(@PathVariable UUID id) {
    var data = darkFiberService.fetchTransDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched trans detail by ID"));
  }

  @GetMapping("/trans-movements")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllTransDetailsMovements() {
    var data = darkFiberService.fetchAllTransDetailsMovements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all trans movements"));
  }

  @GetMapping("/trans-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchTransDetailsMovementById(
      @PathVariable UUID id) {
    var data = darkFiberService.fetchTransDetailsMovementById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched trans movement by ID"));
  }

  @GetMapping("/workorders")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllWorkorders() {
    var data = darkFiberService.fetchAllWorkorders();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all workorders"));
  }

  @GetMapping("/workorder/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchWorkorderById(@PathVariable UUID id) {
    var data = darkFiberService.fetchWorkorderById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched workorder by ID"));
  }

  @GetMapping("/bank-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllBankDetails() {
    var data = darkFiberService.fetchAllBankDetails();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all bank details"));
  }

  @GetMapping("/bank-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchBankDetailById(@PathVariable UUID id) {
    var data = darkFiberService.fetchBankDetailById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched bank detail by ID"));
  }

  @GetMapping("/customer-details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllCustomerDetails() {
    var data = darkFiberService.fetchAllCustomerDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all customer details"));
  }

  @GetMapping("/customer-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchCustomerDetailsById(@PathVariable UUID id) {
    var data = darkFiberService.fetchCustomerDetailsById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched customer detail by ID"));
  }

  @GetMapping("/demand-notes")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDemandNoteHistory() {
    var data = darkFiberService.fetchAllDemandNoteHistory();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all demand note history"));
  }

  @GetMapping("/demand-note/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDemandNoteHistoryById(@PathVariable UUID id) {
    var data = darkFiberService.fetchDemandNoteHistoryById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched demand note history by ID"));
  }

  @GetMapping("/demand-note-masters")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDemandNotes() {
    var data = darkFiberService.fetchAllDemandNotes();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all demand notes"));
  }

  @GetMapping("/demand-note-master/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDemandNoteById(@PathVariable UUID id) {
    var data = darkFiberService.fetchDemandNoteById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched demand note by ID"));
  }

  @GetMapping("/disbursements")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllDisbursements() {
    var data = darkFiberService.fetchAllDisbursements();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all disbursements"));
  }

  @GetMapping("/disbursement/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchDisbursementById(@PathVariable UUID id) {
    var data = darkFiberService.fetchDisbursementById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched disbursement by ID"));
  }

  @GetMapping("/feeder-lists")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllFeeders() {
    var data = darkFiberService.fetchAllFeeders();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all feeder lists"));
  }

  @GetMapping("/feeder-list/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchFeederById(@PathVariable UUID id) {
    var data = darkFiberService.fetchFeederById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched feeder list by ID"));
  }

  @GetMapping("/master-datas")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllMasterData() {
    var data = darkFiberService.fetchAllMasterData();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all master data"));
  }

  @GetMapping("/master-data/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchMasterDataById(@PathVariable UUID id) {
    var data = darkFiberService.fetchMasterDataById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched master data by ID"));
  }

  @GetMapping("/charges")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllOtcCharges() {
    var data = darkFiberService.fetchAllOtcCharges();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all OTC charges"));
  }

  @GetMapping("/charge/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchOtcChargeById(@PathVariable UUID id) {
    var data = darkFiberService.fetchOtcChargeById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched OTC charge by ID"));
  }

  @GetMapping("/invoices")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllOtcInvoices() {
    var data = darkFiberService.fetchAllOtcInvoices();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched all OTC invoices"));
  }

  @GetMapping("/invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchOtcInvoiceById(@PathVariable UUID id) {
    var data = darkFiberService.fetchOtcInvoiceById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched OTC invoice by ID"));
  }
}
