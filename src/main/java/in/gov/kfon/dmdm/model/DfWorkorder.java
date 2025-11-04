package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_workorder")
@Data
public class DfWorkorder extends Auditor {

  @Id
  @Column(name = "df_workorder_id", nullable = false)
  private UUID dfWorkorderId;

  @Column(name = "slno", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer slno;

  @Column(name = "po_id")
  private Integer poId;

  @Column(name = "wo_no")
  private String woNo;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
