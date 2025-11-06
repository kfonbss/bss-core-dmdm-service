package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDcCreditNotes;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDcCreditNotesRepository extends JpaRepository<InvDcCreditNotes, UUID> {}
