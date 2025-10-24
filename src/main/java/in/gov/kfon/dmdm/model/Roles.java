package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Roles {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private Long roleId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "official", length = 100)
  private String official;

  @Column(name = "role_parent_id")
  private Integer roleParentId = 0;

  @Column(name = "description", length = 255)
  private String description;

  @Column(name = "default_role")
  private Integer defaultRole = 0;

  @Column(name = "status")
  private Integer status = 0;

  @Column(name = "is_show")
  private Integer isShow = 0;

  @Column(name = "landing_url", length = 100)
  private String landingUrl;

  @Column(name = "profilemenu")
  private Integer profileMenu = 0;

  @Column(name = "profileurl", length = 100)
  private String profileUrl;

  @Column(name = "access_permission", length = 100)
  private String accessPermission = "Public";

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
