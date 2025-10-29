package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CeInovoice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeInovoiceRepository extends JpaRepository<CeInovoice, UUID> {}
