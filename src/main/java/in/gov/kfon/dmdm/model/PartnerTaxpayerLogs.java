package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "partnertaxpayerlogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerTaxpayerLogs {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "logs_id", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer logsId;

  @Column(name = "partnerid", nullable = false)
  private Long partnerId;

  @Column(name = "partnercompanyname", length = 30)
  private String partnerCompanyName;

  @Column(name = "gstin", length = 50)
  private String gstin;

  @Column(name = "taxpayertype")
  private Integer taxPayerType;

  @Column(name = "stcode")
  private Integer stCode;

  @Column(length = 50)
  private String code;

  @Column(length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
