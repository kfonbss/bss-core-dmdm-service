package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles_modules")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RolesModules {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rm_id")
  private Long rmId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "role_id")
  private Integer roleId;

  @Column(name = "module_id")
  private Integer moduleId;

  @Column(name = "submodule_id")
  private Integer submoduleId;

  @Column(name = "permissions", columnDefinition = "TEXT")
  private String permissions;

  @Column(name = "category", length = 25)
  private String category;

  @Column(name = "is_active")
  private Boolean isActive = true;

  @Column(name = "created_by", length = 256)
  private String createdBy;

  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "updated_by", length = 256)
  private String updatedBy;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt = LocalDateTime.now();
}
