package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_service_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeServiceList extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "list_id")
  private UUID listId;

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

  @Column(name = "serviceid")
  private Integer serviceId;

  @Column(name = "servicename")
  private String serviceName;

  @Column(name = "sname_short")
  private String snameShort;
}
