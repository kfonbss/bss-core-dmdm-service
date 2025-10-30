package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partnerreciept")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerReceipt extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "recieptid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long recieptId;

  @Column(name = "partnerid", nullable = false)
  private Long partnerId;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "reciepttypeid", nullable = false)
  private Integer recieptTypeId;

  @Column(name = "recieptstatusid", nullable = false)
  private Integer recieptStatusId;

  @Column(name = "recieptdate", nullable = false)
  private LocalDateTime recieptDate;

  @Column(name = "reference", nullable = false)
  private String reference;

  @Column(name = "Amtreceived")
  private Double amtReceived;

  @Column(name = "status")
  private String status;

  @Column(name = "receiveddate")
  private LocalDate receivedDate;

  @Column(name = "chqno")
  private String chqNo;

  @Column(name = "pchqno")
  private String pChqNo;

  @Column(name = "pchqdate")
  private LocalDate pChqDate;

  @Column(name = "pchqbank")
  private String pChqBank;

  @Column(name = "attachment")
  private String attachment;

  @Column(name = "remarks")
  private String remarks;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
