package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partnergroup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerGroup extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "partnergroupid")
  private Long partnerGroupId;

  @Column(name = "ibnp")
  private Long ibnp;

  @Column(name = "ibwp")
  private Long ibwp;

  @Column(name = "anp")
  private Long anp;

  @Column(name = "agp")
  private Long agp;

  @Column(name = "cnp")
  private Long cnp;

  @Column(name = "msp")
  private Long msp;

  @Column(name = "mkt")
  private Long mkt;

  @Column(name = "isp")
  private Long isp;

  @Column(name = "perm")
  private Long perm;

  @Column(name = "revenueshareid")
  private Integer revenueShareId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
