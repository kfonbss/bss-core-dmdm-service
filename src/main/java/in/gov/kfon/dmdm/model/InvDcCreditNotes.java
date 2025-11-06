package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_dc_credit_notes")
@Data
public class InvDcCreditNotes {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "notes_id")
  private UUID notesId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Integer id;

  @Column(name = "device_count")
  private Integer deviceCount;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "created_by_id")
  private Integer createdById;

  @Column(name = "created_by_name")
  private String createdByName;
}
