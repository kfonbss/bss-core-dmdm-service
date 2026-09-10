package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DocumentType;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, UUID> {}
