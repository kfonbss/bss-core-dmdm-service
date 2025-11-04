package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.CorporateOnboardingService;
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
@RequestMapping("/api/corporate")
@RequiredArgsConstructor
public class CorporateOnboardingController {
  private final CorporateOnboardingService service;
  private static final String FETCHED = "Fetched";

  @GetMapping("enquires/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAll() {
    var data = service.fetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("enquiry/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchById(@PathVariable UUID id) {
    var data = service.fetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location-lists/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locationFetchAll() {
    var data = service.locationFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location-list/{id}")
  public ResponseEntity<Response<CommonLookUp>> locationFetchById(@PathVariable UUID id) {
    var data = service.locationFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("connection/breakups/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> connectionsFetchAll() {
    var data = service.connectionsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("connection/breakup/{id}")
  public ResponseEntity<Response<CommonLookUp>> connectionFetchById(@PathVariable UUID id) {
    var data = service.connectionFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("connection/breakup-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> movementsFetchAll() {
    var data = service.movementsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("connection/breakup-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> movementFetchById(@PathVariable UUID id) {
    var data = service.movementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("connection/breakup-movements/revisions/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> cMovementsFetchAll() {
    var data = service.cMovementsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("connection/breakup-movement/revision/{id}")
  public ResponseEntity<Response<CommonLookUp>> cMovementFetchById(@PathVariable UUID id) {
    var data = service.cMovementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("customers/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> customersFetchAll() {
    var data = service.customersFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("customer/{id}")
  public ResponseEntity<Response<CommonLookUp>> customerFetchById(@PathVariable UUID id) {
    var data = service.customerFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("disbursements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> disbursementsFetchAll() {
    var data = service.disbursementsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("disbursement/{id}")
  public ResponseEntity<Response<CommonLookUp>> disbursementFetchById(@PathVariable UUID id) {
    var data = service.disbursementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("disbursement-histories/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> disbursementsHisFetchAll() {
    var data = service.disbursementsHisFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("disbursement-history/{id}")
  public ResponseEntity<Response<CommonLookUp>> disbursementHisFetchById(@PathVariable UUID id) {
    var data = service.disbursementHisFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("dNoteMasters/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> mastersFetchAll() {
    var data = service.mastersFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("dNoteMaster/{id}")
  public ResponseEntity<Response<CommonLookUp>> masterFetchById(@PathVariable UUID id) {
    var data = service.masterFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("dNote/Renewal-histories/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> renewalsHistoryFetchAll() {
    var data = service.renewalsHistoryFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("dNote/Renewal-history/{id}")
  public ResponseEntity<Response<CommonLookUp>> renewalHistoryFetchById(@PathVariable UUID id) {
    var data = service.renewalHistoryFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("eoDetails/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> eoDetailsFetchAll() {
    var data = service.eoDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("eoDetail/{id}")
  public ResponseEntity<Response<CommonLookUp>> eoDetailFetchById(@PathVariable UUID id) {
    var data = service.eoDetailFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoices/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> invoicesFetchAll() {
    var data = service.invoicesFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> invoiceFetchById(@PathVariable UUID id) {
    var data = service.invoiceFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoice-masters/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> invoiceMasterFetchAll() {
    var data = service.invoiceMasterFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("invoice-master/{id}")
  public ResponseEntity<Response<CommonLookUp>> invoiceMasterFetchById(@PathVariable UUID id) {
    var data = service.invoiceMasterFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("kyc-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> kycDetailsFetchAll() {
    var data = service.kycDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("kyc-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> kycDetailsFetchById(@PathVariable UUID id) {
    var data = service.kycDetailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location/movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locationMovementFetchAll() {
    var data = service.locationMovementFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location/movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> locationMovementFetchById(@PathVariable UUID id) {
    var data = service.locationMovementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location/renewal-histories/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locationRenewalHistoryFetchAll() {
    var data = service.locationRenewalHistoryFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location/renewal-history/{id}")
  public ResponseEntity<Response<CommonLookUp>> locationRenewalHistoryFetchById(
      @PathVariable UUID id) {
    var data = service.locationRenewalHistoryFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("locations/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> locationsFetchAll() {
    var data = service.locationsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("location/{id}")
  public ResponseEntity<Response<CommonLookUp>> locationsFetchById(@PathVariable UUID id) {
    var data = service.locationsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("online-applications/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> onlineApplicationFetchAll() {
    var data = service.onlineApplicationFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("online-application/{id}")
  public ResponseEntity<Response<CommonLookUp>> onlineApplicationFetchById(@PathVariable UUID id) {
    var data = service.onlineApplicationFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("otc-invoices/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> otcInvoiceFetchAll() {
    var data = service.otcInvoiceFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("otc-invoice/{id}")
  public ResponseEntity<Response<CommonLookUp>> otcInvoiceFetchById(@PathVariable UUID id) {
    var data = service.otcInvoiceFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("packages/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> packageFetchAll() {
    var data = service.packageFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("package/{id}")
  public ResponseEntity<Response<CommonLookUp>> packageFetchById(@PathVariable UUID id) {
    var data = service.packageFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("parent-customers/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> parentCustomersFetchAll() {
    var data = service.parentCustomersFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("parent-customer/{id}")
  public ResponseEntity<Response<CommonLookUp>> parentCustomersFetchById(@PathVariable UUID id) {
    var data = service.parentCustomersFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("payment-histories/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> paymentHistoryFetchAll() {
    var data = service.paymentHistoryFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("payment-history/{id}")
  public ResponseEntity<Response<CommonLookUp>> paymentHistoryFetchById(@PathVariable UUID id) {
    var data = service.paymentHistoryFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("payment/kyc-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> paymentKycDetailsFetchAll() {
    var data = service.paymentKycDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("payment/kyc-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> paymentKycDetailsFetchById(@PathVariable UUID id) {
    var data = service.paymentKycDetailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("po-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> poMovementFetchAll() {
    var data = service.poMovementFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("po-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> poMovementFetchById(@PathVariable UUID id) {
    var data = service.poMovementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("quotations/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> quotationsFetchAll() {
    var data = service.quotationsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("quotation/{id}")
  public ResponseEntity<Response<CommonLookUp>> quotationsFetchById(@PathVariable UUID id) {
    var data = service.quotationsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("purchase-orders/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> purchaseOrderFetchAll() {
    var data = service.purchaseOrderFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("purchase-order/{id}")
  public ResponseEntity<Response<CommonLookUp>> purchaseOrderFetchById(@PathVariable UUID id) {
    var data = service.purchaseOrderFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("quotations-movements/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> quotationsMovementFetchAll() {
    var data = service.quotationsMovementFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("quotations-movement/{id}")
  public ResponseEntity<Response<CommonLookUp>> quotationsMovementFetchById(@PathVariable UUID id) {
    var data = service.quotationsMovementFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("quotations-revisions/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> quotationsRevisionFetchAll() {
    var data = service.quotationsRevisionFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("quotations-revision/{id}")
  public ResponseEntity<Response<CommonLookUp>> quotationsRevisionFetchById(@PathVariable UUID id) {
    var data = service.quotationsRevisionFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("renewal-details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> renewalDetailsFetchAll() {
    var data = service.renewalDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("renewal-detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> renewalDetailsFetchById(@PathVariable UUID id) {
    var data = service.renewalDetailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("revision/connection-breakups/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> revisionConnectionBreakupFetchAll() {
    var data = service.revisionConnectionBreakupFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("revision/connection-breakup/{id}")
  public ResponseEntity<Response<CommonLookUp>> revisionConnectionBreakupFetchById(
      @PathVariable UUID id) {
    var data = service.revisionConnectionBreakupFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("services-list/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> servicesListFetchAll() {
    var data = service.servicesListFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("service-list/{id}")
  public ResponseEntity<Response<CommonLookUp>> servicesListFetchById(@PathVariable UUID id) {
    var data = service.servicesListFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-customers/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subCustomersFetchAll() {
    var data = service.subCustomersFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-customer/{id}")
  public ResponseEntity<Response<CommonLookUp>> subCustomersFetchById(@PathVariable UUID id) {
    var data = service.subCustomersFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-packages/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subPackageFetchAll() {
    var data = service.subPackageFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-package/{id}")
  public ResponseEntity<Response<CommonLookUp>> subPackageFetchById(@PathVariable UUID id) {
    var data = service.subPackageFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-package/renewal-histories/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subPackageRenewalHistoryFetchAll() {
    var data = service.subPackageRenewalHistoryFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-package/renewal-history/{id}")
  public ResponseEntity<Response<CommonLookUp>> subPackageRenewalHistoryFetchById(
      @PathVariable UUID id) {
    var data = service.subPackageRenewalHistoryFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-service/lists/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subServiceListsFetchAll() {
    var data = service.subServiceListsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-service/list/{id}")
  public ResponseEntity<Response<CommonLookUp>> subServiceListsFetchById(@PathVariable UUID id) {
    var data = service.subServiceListsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-finances/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subFinancesFetchAll() {
    var data = service.subFinancesFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-finance/{id}")
  public ResponseEntity<Response<CommonLookUp>> subFinancesFetchById(@PathVariable UUID id) {
    var data = service.subFinancesFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subscriber-Details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subscriberDetailsFetchAll() {
    var data = service.subscriberDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subscriber-Detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> subscriberDetailsFetchById(@PathVariable UUID id) {
    var data = service.subscriberDetailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-online/recharges/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subOnlineRechargesFetchAll() {
    var data = service.subOnlineRechargesFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("sub-online/recharge/{id}")
  public ResponseEntity<Response<CommonLookUp>> subOnlineRechargesFetchById(@PathVariable UUID id) {
    var data = service.subOnlineRechargesFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subscribers-documents/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subScribersDocumentFetchAll() {
    var data = service.subScribersDocumentFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subscribers-document/{id}")
  public ResponseEntity<Response<CommonLookUp>> subScribersDocumentFetchById(
      @PathVariable UUID id) {
    var data = service.subScribersDocumentFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subscribers/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subscribersFetchAll() {
    var data = service.subscribersFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subscriber/{id}")
  public ResponseEntity<Response<CommonLookUp>> subscribersFetchById(@PathVariable UUID id) {
    var data = service.subscribersFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subshift-Details/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> subShiftDetailsFetchAll() {
    var data = service.subShiftDetailsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("subshift-Detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> subShiftDetailsFetchById(@PathVariable UUID id) {
    var data = service.subShiftDetailsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("support-sub/documents/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> supportSubdocumentsFetchAll() {
    var data = service.supportSubdocumentsFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("support-sub/document/{id}")
  public ResponseEntity<Response<CommonLookUp>> supportSubdocumentsFetchById(
      @PathVariable UUID id) {
    var data = service.supportSubdocumentsFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("workOrders/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> workOrderFetchAll() {
    var data = service.workOrderFetchAll();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("workOrder/{id}")
  public ResponseEntity<Response<CommonLookUp>> workOrderFetchById(@PathVariable UUID id) {
    var data = service.workOrderFetchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }
}
