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
}
