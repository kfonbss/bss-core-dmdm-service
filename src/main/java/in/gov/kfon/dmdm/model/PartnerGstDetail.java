package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partnergstdetail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerGstDetail extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "gstin", length = 20)
  private String gstin;

  @Column(name = "sac", length = 20)
  private String sac;

  @Column(name = "gstindoc", length = 120)
  private String gstinDoc;

  @Column(name = "service_description", length = 150)
  private String serviceDescription;

  @Column(name = "gst_verfied")
  private Integer gstVerified;

  @Column(name = "verified_date")
  private Timestamp verifiedDate;

  @Column(name = "verfied_by")
  private String verifiedBy;

  @Column(name = "taxpayertype")
  private Integer taxPayerType;

  @Column(name = "gst_status")
  private Integer gstStatus;

  @Column(name = "legalname", length = 250)
  private String legalName;

  @Column(name = "tradename", length = 250)
  private String tradeName;

  @Column(name = "pan", length = 10)
  private String pan;

  @Column(name = "pan_copy", length = 200)
  private String panCopy;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
