package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerGstDetail;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerGstDetailRepository extends JpaRepository<PartnerGstDetail, UUID> {}
