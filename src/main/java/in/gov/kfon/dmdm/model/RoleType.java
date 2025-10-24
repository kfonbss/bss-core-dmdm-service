package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role_type")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoleType {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "type_id")
  private Long typeId;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "official", length = 100)
  private String official;

  @Column(name = "description", length = 100)
  private String description;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
