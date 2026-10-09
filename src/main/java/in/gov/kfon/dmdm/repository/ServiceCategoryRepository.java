package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.ServiceCategoryType;
import in.gov.kfon.dmdm.model.ServiceCategory;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, UUID> {

  List<ServiceCategory> findByIsActiveTrue();

  List<ServiceCategory> findByServiceCategoryTypeAndIsActiveTrue(ServiceCategoryType type);

  boolean existsByNameIgnoreCaseAndServiceCategoryType(String name, ServiceCategoryType type);

  @Query(
      """
      SELECT sc FROM ServiceCategory sc
      WHERE (:type IS NULL OR sc.serviceCategoryType = :type)
        AND (:search IS NULL
              OR LOWER(sc.name) LIKE LOWER(CONCAT('%', :search, '%'))
              OR LOWER(sc.label) LIKE LOWER(CONCAT('%', :search, '%')))
        AND (:hasServiceTypeFilter = false OR EXISTS (
              SELECT 1 FROM ServiceCategoryMapping scm
              WHERE scm.serviceCategory = sc
                AND scm.serviceType.id IN :serviceTypeIds
                AND scm.isActive = true))
      ORDER BY sc.createdDate DESC
      """)
  Page<ServiceCategory> search(
      @Param("type") ServiceCategoryType type,
      @Param("search") String search,
      @Param("hasServiceTypeFilter") boolean hasServiceTypeFilter,
      @Param("serviceTypeIds") List<UUID> serviceTypeIds,
      Pageable pageable);
}
