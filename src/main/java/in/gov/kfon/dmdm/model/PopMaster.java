package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pop_master")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PopMaster {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "master_id", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer masterId;

  @Column(name = "popname", length = 256)
  private String popname;

  @Column(name = "district", length = 100)
  private String district;

  @Column(name = "poptype", length = 50)
  private String poptype;

  @Column(name = "popid", length = 100)
  private String popid;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
