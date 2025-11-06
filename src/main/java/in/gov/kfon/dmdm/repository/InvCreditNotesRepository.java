package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvCreditNotes;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvCreditNotesRepository extends JpaRepository<InvCreditNotes, UUID> {}
