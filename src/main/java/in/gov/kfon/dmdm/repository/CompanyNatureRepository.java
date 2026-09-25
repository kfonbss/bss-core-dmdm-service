package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CompanyNature;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyNatureRepository extends JpaRepository<CompanyNature, UUID> {

  List<CompanyNature> findByIsActiveTrueOrderByDisplayOrderAsc();
}
