package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "partner_revenue")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerRevenue extends Auditor {

  @Id
  @Column(name = "revenue_id")
  private UUID revenueId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "partnerid")
  private Long partnerid;

  @Column(name = "partnername")
  private String partnername;

  @Column(name = "state")
  private String state;

  @Column(name = "revenue")
  private String revenue;

  @Column(name = "billtype")
  private String billtype;

  @Column(name = "reportdate")
  private String reportdate;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
