package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriberemail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberEmail extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "email_id")
  private Long email_id;

  private Integer subscriberid;

  @Column(length = 250)
  private String username;

  @Column(length = 250)
  private String email;

  @Column(length = 50)
  private String code;

  @Column(length = 150)
  private String name;

  @Column(name = "name_in_local", length = 150)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
