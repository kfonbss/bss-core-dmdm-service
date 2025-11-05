package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_payment_history")
@Data
public class SePaymentHistory extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "history_id")
  private UUID historyId;

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

  @Column(name = "invoiceid")
  private String invoiceId;

  @Column(name = "utr_number")
  private String utrNumber;

  @Column(name = "amount")
  private String amount;

  @Column(name = "it_tdsamount")
  private BigDecimal itTdsAmount;

  @Column(name = "gst_tdsamount")
  private BigDecimal gstTdsAmount;

  @Column(name = "payment_recipt")
  private String paymentReceipt;

  @Column(name = "created_by_name")
  private String createdByName;
}
