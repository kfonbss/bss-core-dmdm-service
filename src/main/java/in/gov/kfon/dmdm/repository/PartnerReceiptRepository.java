package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerReceipt;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerReceiptRepository extends JpaRepository<PartnerReceipt, UUID> {}
