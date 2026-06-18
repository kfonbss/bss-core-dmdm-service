package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anp_users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AnpUsers {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "email", length = 255)
  private String email;

  @Column(name = "mobile", length = 20)
  private String mobile;

  @Column(name = "username", length = 100)
  private String username;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "is_active")
  private Boolean isActive = true;

  @Column(name = "created_by", length = 255)
  private String createdBy;

  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "updated_by", length = 255)
  private String updatedBy;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt = LocalDateTime.now();
}
