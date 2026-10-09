package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** FUP fallback speed; {@code fallbackSpeedId} is the code package.fallbackspeed holds. */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fallback_speed")
public class FallbackSpeed extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "fallback_speed_id", length = 45)
  private String fallbackSpeedId;

  @Column(name = "name", length = 45)
  private String name;

  @Column(name = "speed_mb", nullable = false)
  private Integer speedMb;

  @Column(name = "is_active")
  private Boolean isActive;
}
