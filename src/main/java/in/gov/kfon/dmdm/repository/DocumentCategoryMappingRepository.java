package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DocumentCategoryMapping;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentCategoryMappingRepository
    extends JpaRepository<DocumentCategoryMapping, UUID> {

  List<DocumentCategoryMapping> findByCategory_CategoryCodeAndDocumentType_IsActiveTrue(
      String categoryCode);
}
