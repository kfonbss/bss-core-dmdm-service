package in.gov.kfon.dmdm.controller;

import in.gov.kfon.dmdm.contract.DocumentCategoryResponse;
import in.gov.kfon.dmdm.contract.DocumentTypeResponse;
import in.gov.kfon.dmdm.contract.Response;
import in.gov.kfon.dmdm.service.SupportingDocumentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supporting-documents")
@RequiredArgsConstructor
public class SupportingDocumentController {

  private final SupportingDocumentService service;

  private static final String FETCHED = "Fetched";

  @GetMapping("/by-category/{categoryCode}")
  public ResponseEntity<Response<List<DocumentTypeResponse>>> fetchByCategory(
      @PathVariable String categoryCode) {
    var data = service.fetchDocumentsByCategory(categoryCode);
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }

  @GetMapping("/categories")
  public ResponseEntity<Response<List<DocumentCategoryResponse>>> fetchAllCategories() {
    var data = service.fetchAllCategories();
    return ResponseEntity.status(HttpStatus.OK).body(Response.ok(data, FETCHED));
  }
}
