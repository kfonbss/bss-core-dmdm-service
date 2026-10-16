package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvoiceStateCode;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStateCodeRepository extends JpaRepository<InvoiceStateCode, UUID> {}
