package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@Table(name = "inv_po_details")
public class InvPoDetails extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inv_po_details_id", nullable = false, updatable = false)
  private UUID invPoDetailsId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "po_no", length = 200)
  private String poNo;

  @Column(name = "remarks", length = 250)
  private String remarks;

  @Column(name = "created_by_id")
  private Integer createdById;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
