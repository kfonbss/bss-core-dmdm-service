package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerDetail;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerDetailRepository extends JpaRepository<PartnerDetail, UUID> {}
