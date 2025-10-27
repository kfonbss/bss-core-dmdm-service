package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CorporateEnquiry;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateEnquiryRepository extends JpaRepository<CorporateEnquiry, UUID> {
  Optional<CorporateEnquiry> findByEnquiriesId(UUID id);
}
