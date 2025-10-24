package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sampletax")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleTax {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "tax_id", nullable = false)
  private UUID taxId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, insertable = false)
  private Integer id;

  @Column(name = "amount", nullable = false, precision = 10, scale = 2)
  private BigDecimal amount;
}
