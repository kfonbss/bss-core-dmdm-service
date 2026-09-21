package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerCategoryRepository extends JpaRepository<PartnerCategory, UUID> {}
