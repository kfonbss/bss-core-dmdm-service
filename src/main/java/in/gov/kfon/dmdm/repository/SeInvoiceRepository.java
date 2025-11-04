package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SeInvoice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeInvoiceRepository extends JpaRepository<SeInvoice, UUID> {}
