package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_credit_notes")
@Data
public class InvCreditNotes extends Auditor {
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

  @Column(name = "dtid")
  private Integer dtId;

  @Column(name = "dmid")
  private Integer dmId;

  @Column(name = "dcid")
  private Integer dcId;

  @Column(name = "dmoid")
  private Integer dmoId;

  @Column(name = "device_count")
  private BigDecimal deviceCount;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "created_by_name")
  private String createdByName;
}
