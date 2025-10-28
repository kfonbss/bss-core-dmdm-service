package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscribergstdetail")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberGstDetail extends Auditor {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "gstin")
  private String gstin;

  @Column(name = "sac")
  private String sac;

  @Column(name = "pan")
  private String pan;

  @Column(name = "pancard_copy")
  private String pancardCopy;

  @Column(name = "gstindoc")
  private String gstindoc;

  @Column(name = "lutdoc")
  private String lutdoc;

  @Column(name = "gst_verfied")
  private Integer gstVerified;

  @Column(name = "verified_date")
  private LocalDate verifiedDate;

  @Column(name = "verfied_by")
  private String verifiedBy;

  @Column(name = "taxpayertype")
  private Integer taxPayerType;

  @Column(name = "gst_status")
  private Integer gstStatus;

  @Column(name = "legalname")
  private String legalName;

  @Column(name = "tradename")
  private String tradeName;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;
}
