package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerTaxpayerLogs;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerTaxpayerLogsRepository extends JpaRepository<PartnerTaxpayerLogs, UUID> {}
