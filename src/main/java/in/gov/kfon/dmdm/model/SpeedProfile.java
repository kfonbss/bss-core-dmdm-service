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

/** Plan speed; {@code speedProfileId} is the code package.speed_profile holds. */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "speed_profile")
public class SpeedProfile extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "speed_profile_id", length = 45)
  private String speedProfileId;

  @Column(name = "name", length = 45)
  private String name;

  @Column(name = "speed_mb", nullable = false)
  private Integer speedMb;

  @Column(name = "is_active")
  private Boolean isActive;
}
