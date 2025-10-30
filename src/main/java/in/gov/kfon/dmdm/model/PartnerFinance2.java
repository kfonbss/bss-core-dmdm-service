package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partnerfinance2")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerFinance2 {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "partnerfinanceid", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer partnerFinanceId;

  @Column(name = "partnerid", nullable = false)
  private Long partnerId;

  @Column(name = "cause", nullable = false, length = 128)
  private String cause;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
