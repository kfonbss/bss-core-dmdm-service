package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "packagechangerequests")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackageChangeRequests extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "requestno")
  private Long requestNo;

  @Column(name = "requeststatus", nullable = false)
  private Integer requestStatus = 0;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "newpackageid")
  private Integer newPackageId;

  @Column(name = "oldpackageid")
  private Integer oldPackageId;

  @Column(name = "requestdate")
  private LocalDateTime requestDate;

  @Column(length = 50)
  private String code;

  @Column(length = 255)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
