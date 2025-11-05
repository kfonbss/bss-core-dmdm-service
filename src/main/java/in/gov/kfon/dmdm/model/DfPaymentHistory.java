package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_payment_history")
@Data
public class DfPaymentHistory extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "history_id")
  private UUID historyId;

  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "invoiceid")
  private Integer invoiceId;

  @Column(name = "utr_number", length = 25)
  private String utrNumber;

  @Column(name = "amount", precision = 26, scale = 10)
  private BigDecimal amount;

  @Column(name = "it_tdsamount", precision = 10, scale = 2)
  private BigDecimal itTdsAmount;

  @Column(name = "gst_tdsamount", precision = 10, scale = 2)
  private BigDecimal gstTdsAmount;

  @Column(name = "payment_recipt", length = 150)
  private String paymentReceipt;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
