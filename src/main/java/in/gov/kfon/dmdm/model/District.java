package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "district")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID districtId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "code")
  private String code;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "state_code", referencedColumnName = "code", nullable = false)
  private State state;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "shortname")
  private String shortName;
}
