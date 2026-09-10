package in.gov.kfon.dmdm.service;

import in.gov.kfon.dmdm.contract.DocumentCategoryResponse;
import in.gov.kfon.dmdm.contract.DocumentTypeResponse;
import java.util.List;

public interface SupportingDocumentService {

  List<DocumentTypeResponse> fetchDocumentsByCategory(String categoryCode);

  List<DocumentCategoryResponse> fetchAllCategories();
}
