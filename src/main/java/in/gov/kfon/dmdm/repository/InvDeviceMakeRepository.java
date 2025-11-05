package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceMake;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceMakeRepository extends JpaRepository<InvDeviceMake, UUID> {}
