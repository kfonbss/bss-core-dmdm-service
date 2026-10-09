package in.gov.kfon.dmdm.model;

import in.gov.kfon.dmdm.constant.BundleType;
import in.gov.kfon.dmdm.constant.ServiceCategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_category")
public class ServiceCategory extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Generated
  @Column(name = "service_category_id", unique = true, insertable = false, updatable = false)
  private Integer serviceCategoryId;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "label", length = 100)
  private String label;

  /** Number of service types this category must be mapped to. */
  @Column(name = "sub_service_count")
  private Integer count;

  @Enumerated(EnumType.STRING)
  @Column(name = "bundle_type")
  private BundleType bundleType;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "is_addon")
  private Boolean isAddon;

  @Column(name = "is_bod")
  private Boolean isBod;

  @Enumerated(EnumType.STRING)
  @Column(name = "service_category_type")
  private ServiceCategoryType serviceCategoryType;
}
