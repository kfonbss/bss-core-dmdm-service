package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriberdatausege")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberDataUsage extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "data_usage_id")
  private Long dataUsageId;

  @Column(name = "subscriberid")
  private Integer subscriberId;

  @Column(length = 64)
  private String username;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(length = 200)
  private String packagename;

  @Column(length = 45)
  private String uploaded;

  @Column(length = 45)
  private String downloaded;

  @Column(name = "startdate")
  private Date startDate;

  @Column(name = "enddate")
  private Date endDate;

  @Column(length = 30)
  private String billingtype;

  @Column(length = 50)
  private String code;

  @Column(length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
