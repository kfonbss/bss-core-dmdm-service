package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CompanyDetail;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDetailRepository extends JpaRepository<CompanyDetail, UUID> {}
