package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvPoDocuments;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvPoDocumentsRepository extends JpaRepository<InvPoDocuments, UUID> {}
