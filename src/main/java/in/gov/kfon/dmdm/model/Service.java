package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Service extends Auditor {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "name_in_local", length = 150)
  private String nameInLocal;

  @Column(name = "baserental", precision = 10, scale = 2, nullable = false)
  private BigDecimal baseRental;

  @Column(name = "is_active")
  private Boolean isActive;
}
