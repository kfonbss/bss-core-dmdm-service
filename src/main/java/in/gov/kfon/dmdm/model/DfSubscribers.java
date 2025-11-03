package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "df_subscribers")
public class DfSubscribers extends Auditor {

  @Id
  @Column(name = "df_subscribers_id", nullable = false, updatable = false)
  private UUID dfSubscribersId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subscriberid")
  private Integer subscriberid;

  @Column(name = "username", length = 64)
  private String username;

  @Column(name = "password", length = 50)
  private String password;

  @Column(name = "balance", precision = 10, scale = 2, nullable = false)
  private BigDecimal balance;

  @Column(name = "woid")
  private Integer woid;

  @Column(name = "enq_ref")
  private Integer enqRef;

  @Column(name = "expirydate")
  private LocalDate expirydate;

  @Column(name = "comm_date")
  private LocalDate commDate;

  @Column(name = "activation_date")
  private LocalDateTime activationDate;

  @Column(name = "d_status")
  private Integer dStatus;

  @Column(name = "d_status_date")
  private LocalDate dStatusDate;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
