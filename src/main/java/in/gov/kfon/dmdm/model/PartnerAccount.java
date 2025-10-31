package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partneraccount")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerAccount extends Auditor {

  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "partneraccountid", updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long partnerAccountId;

  @Column(name = "partnerid", nullable = false, unique = true)
  private Long partnerId;

  @Column(name = "balance")
  private Double balance;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
