package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "package_map")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PackageMap extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "mapid")
  private Long mapId;

  @Column(name = "partnerid", nullable = false)
  private Long partnerId;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "status", nullable = false)
  private Integer status = 1;

  @Column(length = 50)
  private String code;

  @Column(length = 255)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
