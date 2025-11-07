package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "inv_device_return_tooem")
public class InvDeviceReturnTooem extends Auditor {

  @Id
  @Column(name = "inv_device_return_tooem_id")
  private UUID invDeviceReturnTooemId;

  @Column private Integer id;

  @Column private Integer returncount;

  @Column(name = "request_status")
  private Integer requestStatus;

  @Column(name = "support_doc")
  private String supportDoc;

  @Column(name = "kfondc_id")
  private Integer kfondcId;

  @Column private String remarks;

  @Column(name = "approval_reject_remarks")
  private String approvalRejectRemarks;

  @Column(name = "enable_for_dgm")
  private Integer enableForDgm;

  @Column(name = "created_by_id")
  private Long createdById;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
