package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payout_charges")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PayoutCharge extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "mode", nullable = false, length = 20)
  private String mode;

  @Column(name = "start_range", nullable = false, precision = 15, scale = 2)
  private BigDecimal startRange;

  @Column(name = "end_range", nullable = false, precision = 15, scale = 2)
  private BigDecimal endRange;

  @Column(name = "rate", nullable = false, precision = 10, scale = 4)
  private BigDecimal rate;

  @Column(name = "is_active")
  private Boolean isActive;
}
