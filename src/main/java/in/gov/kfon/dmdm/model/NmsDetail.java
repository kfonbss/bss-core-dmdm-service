package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nms_details")
public class NmsDetail extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "nms_detail_id", nullable = false, updatable = false)
  private UUID nmsDetailId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "ip", nullable = false, length = 255)
  private String ip;

  @Column(name = "token", nullable = false, length = 512)
  private String token;

  @Column(name = "state_code", nullable = false, length = 10, unique = true)
  private String stateCode;

  @Column(name = "description", length = 255)
  private String description;

  @Column(name = "is_active")
  private Boolean isActive = true;
}