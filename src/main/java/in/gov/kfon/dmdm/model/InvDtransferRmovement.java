package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_dtransfer_rmovement")
@Data
public class InvDtransferRmovement extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "inv_dtransfer_rmovement_id", nullable = false)
  private UUID invDtransferRmovementId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "reqid")
  private Integer reqid;

  @Column(name = "request_status")
  private Integer requestStatus;

  @Column(name = "remarks", length = 150)
  private String remarks;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
