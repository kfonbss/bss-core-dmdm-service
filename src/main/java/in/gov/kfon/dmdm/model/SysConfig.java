package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sys_config")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SysConfig {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @Column(name = "tenant_id", nullable = false, unique = true)
  private String tenantId;

  @Column(name = "aaa_ip", nullable = false)
  private String aaaIp;

  @Column(name = "is_active")
  private Boolean isActive;
}
