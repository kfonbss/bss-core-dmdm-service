package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.PartnerAgreementDetail;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerAgreementDetailRepository
    extends JpaRepository<PartnerAgreementDetail, UUID> {

  Optional<PartnerAgreementDetail> findByDetailsId(UUID detailsId);
}
