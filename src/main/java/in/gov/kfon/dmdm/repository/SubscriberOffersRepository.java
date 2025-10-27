package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.SubscriberOffers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriberOffersRepository extends JpaRepository<SubscriberOffers, UUID> {
}
