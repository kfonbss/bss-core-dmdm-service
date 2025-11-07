package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "inv_dccredit_notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvDcCreditNote extends Auditor {
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

  @Column(name = "transfer_to")
  private Integer transferTo;

  @Column(name = "kfon_dcid")
  private Integer kfonDcid;

  @Column(name = "msp_dcid")
  private Integer mspDcid;

  @Column(name = "lnpid")
  private Long lnpid;

  @Column(name = "reqid")
  private Integer reqid;

  @Column(name = "dc_reqid")
  private Integer dcReqid;

  @Column(name = "created_by_id")
  private Integer createdById;

  @Column(name = "created_by_name")
  private String createdByName;
}
