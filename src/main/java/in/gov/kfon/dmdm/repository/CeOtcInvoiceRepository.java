package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeOtcInvoice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeOtcInvoiceRepository extends JpaRepository<CeOtcInvoice, UUID> {}
