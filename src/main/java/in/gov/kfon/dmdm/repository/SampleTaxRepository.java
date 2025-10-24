package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SampleTax;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleTaxRepository extends JpaRepository<SampleTax, UUID> {}
