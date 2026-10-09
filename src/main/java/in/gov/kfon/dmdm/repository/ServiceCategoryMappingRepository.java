package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.ServiceCategoryType;
import in.gov.kfon.dmdm.model.ServiceCategory;
import in.gov.kfon.dmdm.model.ServiceCategoryMapping;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceCategoryMappingRepository
    extends JpaRepository<ServiceCategoryMapping, UUID> {

  @EntityGraph(attributePaths = {"serviceCategory", "serviceType"})
  List<ServiceCategoryMapping> findAll();

  @EntityGraph(attributePaths = {"serviceCategory", "serviceType"})
  List<ServiceCategoryMapping> findByIsActiveTrue();

  @EntityGraph(attributePaths = {"serviceCategory", "serviceType"})
  List<ServiceCategoryMapping> findByServiceCategory_IdAndIsActiveTrue(UUID serviceCategoryId);

  @EntityGraph(attributePaths = {"serviceCategory", "serviceType"})
  List<ServiceCategoryMapping> findByServiceCategory_IdInAndIsActiveTrue(
      Collection<UUID> serviceCategoryIds);

  @EntityGraph(attributePaths = {"serviceCategory", "serviceType"})
  List<ServiceCategoryMapping> findByServiceType_IdInAndIsActiveTrue(
      Collection<UUID> serviceTypeIds);

  long countByServiceCategory_IdAndIsActiveTrue(UUID serviceCategoryId);

  @Query(
      value =
          "SELECT sc FROM ServiceCategory sc WHERE EXISTS (SELECT 1 FROM ServiceCategoryMapping m"
              + " WHERE m.serviceCategory = sc AND m.isActive = true)"
              + " AND (:type IS NULL OR sc.serviceCategoryType = :type)"
              + " ORDER BY sc.createdDate DESC")
  Page<ServiceCategory> findServiceCategoriesWithActiveMappings(
      @Param("type") ServiceCategoryType type, Pageable pageable);
}
