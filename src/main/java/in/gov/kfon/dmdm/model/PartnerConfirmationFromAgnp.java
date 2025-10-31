package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partner_confirmation_from_agnp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerConfirmationFromAgnp extends Auditor {

  @Id
  @Column(name = "agnp_id", nullable = false)
  private UUID agnpId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "document", length = 4200)
  private String document;

  @Column(name = "status", length = 45)
  private String status;

  @Column(name = "note", columnDefinition = "TEXT")
  private String note;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
