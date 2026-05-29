package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.State;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, UUID> {
  List<State> findByCodeAndIsActive(String code, boolean active);

  List<State> findByCodeInAndIsActive(List<String> codes, boolean active);
}
