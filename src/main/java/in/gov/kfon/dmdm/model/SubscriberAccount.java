package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subscriberaccount")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberAccount extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  private Integer subscriberid;

  @Column(precision = 13, scale = 2)
  private BigDecimal balance;

  @Column(length = 50)
  private String code;

  @Column(length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
