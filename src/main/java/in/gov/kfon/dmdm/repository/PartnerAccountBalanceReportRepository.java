package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerAccountBalanceReport;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerAccountBalanceReportRepository
    extends JpaRepository<PartnerAccountBalanceReport, UUID> {}
