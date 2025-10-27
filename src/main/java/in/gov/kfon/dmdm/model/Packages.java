package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "packages")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Packages extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "packageid")
  private Long packageId;

  @Column(name = "name", length = 45)
  private String name;

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "package_type", length = 45)
  private String packageType;

  @Column(name = "customer_type", length = 45)
  private String customerType;

  @Column(length = 45)
  private String category;

  @Column(length = 45)
  private String qos;

  @Column(length = 45)
  private String speed;

  @Column(length = 10)
  private String unit;

  @Column(name = "connection_type", length = 45)
  private String connectionType;

  @Column(name = "allocated_volume", length = 45)
  private String allocatedVolume;

  @Column(length = 45)
  private String validity;

  @Column(length = 45)
  private String offers;

  @Column(precision = 10, scale = 2)
  private Double discount;

  @Column(length = 45)
  private String mrc;

  @Column(precision = 10, scale = 2)
  private Double otc;

  @Column(length = 50)
  private String code;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
