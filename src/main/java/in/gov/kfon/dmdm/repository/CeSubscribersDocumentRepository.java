package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeSubscribersDocument;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeSubscribersDocumentRepository
    extends JpaRepository<CeSubscribersDocument, UUID> {}
