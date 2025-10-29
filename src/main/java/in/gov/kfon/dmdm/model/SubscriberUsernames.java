package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriberusernames")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberUsernames extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "username", length = 50)
  private String username;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;
}
