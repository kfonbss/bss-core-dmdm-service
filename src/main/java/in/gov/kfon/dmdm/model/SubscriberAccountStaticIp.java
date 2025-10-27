package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriberaccountstaticip")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberAccountStaticIp extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(precision = 10, scale = 2)
  private Double balance = 0.00;

  @Column(length = 50)
  private String code;

  @Column(length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
