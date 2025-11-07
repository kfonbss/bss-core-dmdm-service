package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_device_details_audit")
@Data
public class InvDeviceDetailsAudit {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "audit_id")
  private UUID auditId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "deviceid")
  private Integer deviceId;

  @Column(name = "old_deviceid")
  private Integer oldDeviceId;

  @Column(name = "invoice_date")
  private String invoiceDate;

  @Column(name = "warranty_sdate")
  private String warrantySDate;

  @Column(name = "warranty_edate")
  private String warrantyEDate;

  @Column(name = "po_no")
  private String poNo;

  @Column(name = "created_by_id")
  private Integer createdById;

  @Column(name = "created_by_name")
  private String createdByName;
}
