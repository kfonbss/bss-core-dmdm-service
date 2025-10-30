package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_kyc_details")
@Data
public class CeKycDetails extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "kyc_id")
  private UUID kycId;

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

  @Column(name = "customerid")
  private Integer customerId;

  @Column(name = "pan_numer")
  private String panNumber;

  @Column(name = "pan_copy")
  private String panCopy;

  @Column(name = "gstin")
  private String gstin;

  @Column(name = "gstindoc")
  private String gstinDoc;

  @Column(name = "supportdoc")
  private String supportDoc;

  @Column(name = "taxpayertype")
  private Boolean taxPayerType;

  @Column(name = "legalname")
  private String legalName;

  @Column(name = "tradename")
  private String tradeName;

  @Column(name = "sac")
  private String sac;

  @Column(name = "service_description")
  private String serviceDescription;

  @Column(name = "gst_status")
  private Boolean gstStatus;

  @Column(name = "lut_doc")
  private String lutDoc;

  @Column(name = "sez_verified")
  private Boolean sezVerified;

  @Column(name = "approve_status")
  private Boolean approveStatus;
}
