package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DocumentCategory;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentCategoryRepository extends JpaRepository<DocumentCategory, UUID> {

  List<DocumentCategory> findByIsActiveTrue();
}
