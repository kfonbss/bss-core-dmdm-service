package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_workorder")
@Data
public class CeWorkOrder extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "workorder_id")
  private UUID workOrderId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "slno")
  private Integer slno;

  @Column(name = "po_id")
  private Integer poId;

  @Column(name = "wo_no")
  private String woNo;

  @Column(name = "short_name")
  private String shortName;

  @Column(name = "wo_start_date")
  private LocalDate woStartDate;

  @Column(name = "wo_end_date")
  private LocalDate woEndDate;
}
