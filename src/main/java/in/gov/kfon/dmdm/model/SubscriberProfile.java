package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriberprofile")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberProfile extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "profileid")
  private Integer profileId;

  @Column(name = "name", length = 80, nullable = false)
  private String name;

  @Column(name = "discount", precision = 10, scale = 2, nullable = false)
  private Double discount;

  @Column(name = "code")
  private String code;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;
}
