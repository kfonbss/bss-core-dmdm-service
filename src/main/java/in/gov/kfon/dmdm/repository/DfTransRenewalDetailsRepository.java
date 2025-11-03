package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfTransRenewalDetails;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DfTransRenewalDetailsRepository
    extends JpaRepository<DfTransRenewalDetails, UUID> {}
