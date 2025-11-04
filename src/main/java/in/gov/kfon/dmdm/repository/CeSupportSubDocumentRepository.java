package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeSupportSubDocument;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeSupportSubDocumentRepository extends JpaRepository<CeSupportSubDocument, UUID> {}
