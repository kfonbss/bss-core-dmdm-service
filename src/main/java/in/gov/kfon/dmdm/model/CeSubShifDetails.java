package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_subshifdetails")
@Data
public class CeSubShifDetails extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "details_id")
  private UUID detailsId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Integer id;

  @Column(name = "serviceprovider")
  private Integer serviceprovider;

  @Column(name = "subscriberid")
  private Long subscriberid;

  @Column(name = "frompartnerid")
  private Long frompartnerid;

  @Column(name = "topartnerid")
  private Long topartnerid;

  @Column(name = "slaid")
  private String slaid;
}
