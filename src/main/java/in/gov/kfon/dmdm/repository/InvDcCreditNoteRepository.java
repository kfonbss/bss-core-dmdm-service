package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDcCreditNote;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDcCreditNoteRepository extends JpaRepository<InvDcCreditNote, UUID> {}
