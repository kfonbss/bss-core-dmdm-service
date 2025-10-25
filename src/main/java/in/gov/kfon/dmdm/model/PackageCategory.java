package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "packagecategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PackageCategory extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pkg_ctgy_id")
  private Long pkgCtgyId;

  @Column(name = "name", length = 250, nullable = false)
  private String name;

  @Column(length = 50)
  private String code;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
