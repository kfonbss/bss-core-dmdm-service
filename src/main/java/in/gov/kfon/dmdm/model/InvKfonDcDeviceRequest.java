package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "inv_kfondc_device_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvKfonDcDeviceRequest extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "request_id")
  private UUID requestId;

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

  @Column(name = "device_count")
  private Integer deviceCount;

  @Column(name = "status")
  private Integer status;

  @Column(name = "kfon_dcid")
  private Integer kfonDcid;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "rej_app_remarks")
  private String rejAppRemarks;

  @Column(name = "accepted_count")
  private Integer acceptedCount;

  @Column(name = "created_by_id")
  private Integer createdById;

  @Column(name = "created_by_name")
  private String createdByName;
}
