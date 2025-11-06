package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceCat;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceCatRepository extends JpaRepository<InvDeviceCat, UUID> {}
