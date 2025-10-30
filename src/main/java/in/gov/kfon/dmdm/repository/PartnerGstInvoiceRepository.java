package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerGstInvoice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerGstInvoiceRepository extends JpaRepository<PartnerGstInvoice, UUID> {}
