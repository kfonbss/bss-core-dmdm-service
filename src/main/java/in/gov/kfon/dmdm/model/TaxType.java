package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taxtype")
public class TaxType extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "taxtypeid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer taxTypeId;

  @Column(name = "taxvaluepercent", precision = 10, scale = 2, nullable = false)
  private BigDecimal taxValuePercent;
}
