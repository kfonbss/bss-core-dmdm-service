package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfOtcInvoice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfOtcInvoiceRepository extends JpaRepository<DfOtcInvoice, UUID> {}
