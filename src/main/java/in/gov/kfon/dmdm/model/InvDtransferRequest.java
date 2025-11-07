package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_dtransfer_request")
@Data
public class InvDtransferRequest extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inv_dtransfer_request_id", nullable = false)
  private UUID invDtransferRequestId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "dtid")
  private Integer dtid;

  @Column(name = "dmid")
  private Integer dmid;

  @Column(name = "dcid")
  private Integer dcid;

  @Column(name = "dmoid")
  private Integer dmoid;

  @Column(name = "noc_id")
  private Integer nocId;

  @Column(name = "kfon_dcid")
  private Integer kfonDcid;

  @Column(name = "device_count")
  private Integer deviceCount;

  @Column(name = "transfer_type")
  private Integer transferType;

  @Column(name = "request_status")
  private Integer requestStatus;

  @Column(name = "remarks", length = 150)
  private String remarks;

  @Column(name = "accepted_count")
  private Integer acceptedCount;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
