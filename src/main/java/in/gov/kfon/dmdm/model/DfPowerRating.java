package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_power_rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DfPowerRating extends Auditor {

  @Id
  @Column(name = "df_power_rating_id", nullable = false, updatable = false)
  private UUID dfPowerRatingId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "amount", nullable = false)
  private Integer amount;

  @Column(name = "power_rating", length = 255)
  private String powerRating;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
