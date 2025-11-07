package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
@Table(name = "inv_po_documnets")
public class InvPoDocuments extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "inv_po_documnets_id", nullable = false, updatable = false)
  private UUID invPoDocumnetsId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "poid")
  private Integer poid;

  @Column(name = "documnet", length = 250)
  private String documnet;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
