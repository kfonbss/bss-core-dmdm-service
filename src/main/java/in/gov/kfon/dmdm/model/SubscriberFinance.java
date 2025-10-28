package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriberfinance")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberFinance extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "finid")
  private Long finId;

  @Column private Integer subscriberid;

  @Column(precision = 13, scale = 2)
  private Double amount;

  @Column(length = 100)
  private String cause;

  @Column private Integer partnerfinanceid;

  @Column private Integer rstatus = 1;

  @Column private Long subonlineref;

  @Column private Integer packageid;

  @Column private Integer term_count;

  @Column private Integer cause_detail_id = 0;

  @Column(length = 50)
  private String code;

  @Column(length = 100)
  private String name;

  @Column(length = 100)
  private String name_in_local;

  @Column private Boolean is_active = true;
}
