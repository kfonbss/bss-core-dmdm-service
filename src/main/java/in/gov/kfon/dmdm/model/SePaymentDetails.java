package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_payment_details")
@Data
public class SePaymentDetails extends Auditor {
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

  @Column(name = "poid")
  private Integer poid;

  @Column(name = "utr_number")
  private String utrNumber;

  @Column(name = "paid_amount")
  private BigDecimal paidAmount;

  @Column(name = "paymnet_date")
  private LocalDate paymentDate;

  @Column(name = "created_by_name")
  private String createdByName;
}
