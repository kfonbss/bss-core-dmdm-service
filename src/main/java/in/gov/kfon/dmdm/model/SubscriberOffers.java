package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriber_offers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberOffers extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "slno")
  private Long serialNo;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(name = "applied_date")
  private LocalDateTime appliedDate;

  @Column(name = "partnerid", length = 45)
  private String partnerId;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
