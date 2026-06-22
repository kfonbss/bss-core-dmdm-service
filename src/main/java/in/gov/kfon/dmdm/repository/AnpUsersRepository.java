package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.AnpUsers;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnpUsersRepository extends JpaRepository<AnpUsers, UUID> {}
