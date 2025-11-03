package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_group_details_movent")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DfGroupDetailsMovent extends Auditor {

  @Id
  @Column(name = "movent_id", nullable = false, updatable = false)
  private UUID moventId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "approve_status")
  private Integer approveStatus;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
