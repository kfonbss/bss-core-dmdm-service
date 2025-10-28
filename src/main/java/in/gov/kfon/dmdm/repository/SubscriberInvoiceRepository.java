package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberInvoice;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberInvoiceRepository extends JpaRepository<SubscriberInvoice, UUID> {}
