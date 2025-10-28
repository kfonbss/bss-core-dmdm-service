package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.CommonLookUp;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.SubscriberService;
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
@RequestMapping("/api/subscriber")
@RequiredArgsConstructor
public class SubscriberController {

  private final SubscriberService service;

  @GetMapping("/feedbacks")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllFeedbacks() {
    var data = service.fetchAllFeedbacks();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber feedbacks"));
  }

  @GetMapping("/feedback/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchFeedbackById(@PathVariable UUID id) {
    var data = service.fetchFeedbackById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched subscriber feedback"));
  }

  @GetMapping("/offers")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllOffers() {
    var data = service.fetchAllOffers();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber offers"));
  }

  @GetMapping("/offer/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchOfferById(@PathVariable UUID id) {
    var data = service.fetchOfferById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched subscriber offer"));
  }

  @GetMapping("/status-types")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllStatusTypes() {
    var data = service.fetchAllSubscriberStatusTypes();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber status types"));
  }

  @GetMapping("/status-type/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchStatusTypeById(@PathVariable UUID id) {
    var data = service.fetchSubscriberStatusTypeById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched subscriber status type"));
  }

  @GetMapping("/accounts")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllAccounts() {
    var data = service.fetchAllSubscriberAccounts();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber accounts"));
  }

  @GetMapping("/account/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchAccountById(@PathVariable UUID id) {
    var data = service.fetchSubscriberAccountById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched subscriber account"));
  }

  @GetMapping("/account-static-ips")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllSubscriberAccountStaticIps() {
    var data = service.fetchAllSubscriberAccountStaticIps();
    return ResponseEntity.ok(Response.ok(data, "Fetched all subscriber account static IPs"));
  }

  @GetMapping("/account-static-ip/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchSubscriberAccountStaticIpById(
      @PathVariable UUID id) {
    var data = service.fetchSubscriberAccountStaticIpById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched subscriber account static IP"));
  }

  @GetMapping("/data-usages")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllSubscriberDataUsages() {
    var data = service.fetchAllSubscriberDataUsages();
    return ResponseEntity.ok(Response.ok(data, "Fetched all subscriber data usages"));
  }

  @GetMapping("/data-usage/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchSubscriberDataUsageById(
      @PathVariable UUID id) {
    var data = service.fetchSubscriberDataUsageById(id);
    return ResponseEntity.ok(Response.ok(data, "Fetched subscriber data usage"));
  }

  @GetMapping("/details")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllSubscriberDetails() {
    var data = service.fetchAllSubscriberDetails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber details"));
  }

  @GetMapping("/detail/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchSubscriberDetailById(@PathVariable UUID id) {
    var data = service.fetchSubscriberDetailById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched subscriber detail"));
  }

  @GetMapping("/emails")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllSubscriberEmails() {
    var data = service.fetchAllSubscriberEmails();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber emails"));
  }

  @GetMapping("/email/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchSubscriberEmailById(@PathVariable UUID id) {
    var data = service.fetchSubscriberEmailById(id);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, "Fetched subscriber email"));
  }

  @GetMapping("/finance/fetch-all")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllFinance() {
    var data = service.fetchAllFinance();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber finance records"));
  }

  @GetMapping("/finance/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchFinanceById(@PathVariable UUID id) {
    var data = service.fetchFinanceById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched subscriber finance record"));
  }

  @GetMapping("/contact-informations")
  public ResponseEntity<Response<List<CommonLookUp>>> fetchAllContactInfo() {
    var data = service.fetchAllContactInfo();
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched all subscriber contact information"));
  }

  @GetMapping("/contact-information/{id}")
  public ResponseEntity<Response<CommonLookUp>> fetchContactInfoById(@PathVariable UUID id) {
    var data = service.fetchContactInfoById(id);
    return ResponseEntity.status(HttpStatus.OK)
        .body(Response.ok(data, "Fetched subscriber contact information"));
  }
}
