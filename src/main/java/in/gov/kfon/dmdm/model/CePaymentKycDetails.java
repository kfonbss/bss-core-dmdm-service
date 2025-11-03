package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_payment_kyc_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CePaymentKycDetails extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "details_id")
  private UUID detailsId;

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

  @Column(name = "subid")
  private Integer subId;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "cheque_doc")
  private String chequeDoc;

  @Column(name = "cheque_date")
  private LocalDateTime chequeDate;

  @Column(name = "paymentreciept_doc")
  private String paymentRecieptDoc;

  @Column(name = "paymentreciept_date")
  private LocalDateTime paymentRecieptDate;

  @Column(name = "wo_doc")
  private String woDoc;

  @Column(name = "wo_date")
  private LocalDateTime woDate;

  @Column(name = "kyc_doc")
  private String kycDoc;

  @Column(name = "kyc_date")
  private LocalDateTime kycDate;
}
