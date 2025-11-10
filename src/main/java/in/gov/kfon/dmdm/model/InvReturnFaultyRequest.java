package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@Table(name = "inv_return_faulty_request")
public class InvReturnFaultyRequest extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inv_return_faulty_request_id", nullable = false, updatable = false)
  private UUID invReturnFaultyRequestId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "deviceid")
  private Integer deviceId;

  @Column(name = "condition_statusid")
  private Integer conditionStatusId;

  @Column(name = "request_type")
  private Integer requestType;

  @Column(name = "status")
  private Integer status;

  @Column(name = "lnpid")
  private Integer lnpId;

  @Column(name = "mspdc_id")
  private Integer mspdcId;

  @Column(name = "kfondc_id")
  private Integer kfondcId;

  @Column(name = "noc_id")
  private Integer nocId;

  @Column(name = "created_by_id")
  private Integer createdById;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
