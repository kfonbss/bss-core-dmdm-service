package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "gateway")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Gateway {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "gateway_id", nullable = false, unique = true)
  private UUID gatewayId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "code")
  private String code;

  @Column(name = "type")
  private String type;

  @Column(name = "gateid")
  private Integer gateId;
}