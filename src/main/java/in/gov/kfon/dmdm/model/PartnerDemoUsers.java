package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partnerdemousers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDemoUsers extends Auditor {

  @Id
  @Column(name = "user_id", nullable = false, updatable = false)
  private UUID userId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "demoid")
  private Long demoid;

  @Column(name = "id")
  private UUID id;

  @Column(name = "partnerid")
  private String partnerId;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "status")
  private Integer status;

  @Column(name = "speed")
  private String speed;

  @Column(name = "expirydate")
  private LocalDate expiryDate;

  @Column(name = "startdate")
  private LocalDate startDate;

  @Column(name = "packageid")
  private Integer packageId;

  @Column(name = "alloted_vol")
  private Long allotedVol;

  @Column(name = "consumed_vol")
  private Long consumedVol;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
