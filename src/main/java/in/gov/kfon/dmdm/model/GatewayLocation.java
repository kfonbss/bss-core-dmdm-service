package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gateway_locations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GatewayLocation {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @Column(name = "state_code", nullable = false)
  private String stateCode;

  @Column(name = "district")
  private String district;

  @Column(name = "gatewayname")
  private String gatewayName;

  @Column(name = "status")
  private Integer status;

  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @Column(name = "updated_date")
  private LocalDateTime updatedDate;
}
