package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "pincodes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pincodes extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pin_id")
  private Long pinId;

  @Column(name = "postofficename", length = 256)
  private String postOfficeName;

  @Column(name = "Pincode", length = 8)
  private String pincode;

  @Column(length = 256)
  private String city;

  @Column(length = 256)
  private String district;

  @Column(name = "district_id")
  private UUID districtId;

  @Column(length = 256)
  private String state;

  @Column(name = "status")
  private Integer status = 1;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
