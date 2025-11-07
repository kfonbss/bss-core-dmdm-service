package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "inv_device_condition_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvDeviceConditionStatus extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "status_id")
  private UUID statusId;

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

  @Column(name = "condition_statusid")
  private Integer conditionStatusId;

  @Column(name = "condition_status_name")
  private String conditionStatusName;

  @Column(name = "category")
  private Integer category;
}
