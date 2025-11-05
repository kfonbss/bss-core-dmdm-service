package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_feeder_list")
@Data
public class DfFeederList extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "list_id")
  private UUID listId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "pop_id", nullable = false)
  private Integer popId;

  @Column(name = "feeder_name")
  private String feederName;

  @Column(name = "noof_strands_consumed")
  private Integer noOfStrandsConsumed;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
