package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfGroupInvoice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfGroupInvoiceRepository extends JpaRepository<DfGroupInvoice, UUID> {}
