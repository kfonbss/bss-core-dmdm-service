package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.InvDeviceVendor;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvDeviceVendorRepository extends JpaRepository<InvDeviceVendor, UUID> {}
