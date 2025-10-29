package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pop_master_backup2june")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PopMasterBackup {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "master_id", nullable = false)
  private Integer masterId;

  @Column(name = "popname", length = 256)
  private String popname;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
