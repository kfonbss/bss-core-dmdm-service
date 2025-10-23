package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.State;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, UUID> {}
