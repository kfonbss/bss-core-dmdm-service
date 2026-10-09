package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

/** Which service types (sub-services) make up a service category. */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_category_mapping")
public class ServiceCategoryMapping extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Generated
  @Column(name = "mapping_id", unique = true, insertable = false, updatable = false)
  private Integer mappingId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "service_category_id", nullable = false)
  private ServiceCategory serviceCategory;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "service_type_id")
  private ServiceType serviceType;

  @Column(name = "discountable")
  private Boolean discountable;

  @Column(name = "provider_mapping")
  private Boolean providerMapping;

  @Column(name = "is_active")
  private Boolean isActive;
}
