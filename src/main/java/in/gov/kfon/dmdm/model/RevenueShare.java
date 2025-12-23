package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "revenueshare")
public class RevenueShare {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "revenueshareid", updatable = false, insertable = false)
  private Integer revenueShareId;

  @Column(name = "sharename", length = 1000)
  private String shareName;

  @Column(name = "subgroup")
  private Integer subgroup = 0;

  @Column(name = "ibnpshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal ibnpShare;

  @Column(name = "ibwpshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal ibwpShare;

  @Column(name = "anpshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal anpShare;

  @Column(name = "agpshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal agpShare;

  @Column(name = "cnpshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal cnpShare;

  @Column(name = "mspshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal mspShare;

  @Column(name = "mktshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal mktShare;

  @Column(name = "ispshare", precision = 5, scale = 2, nullable = false)
  private BigDecimal ispShare;

  @Column(name = "permshare", precision = 10, scale = 2, nullable = false)
  private BigDecimal permShare;

  @Column(name = "dotshare", precision = 10, scale = 2, nullable = false)
  private BigDecimal dotShare;

  @Column(name = "provshare", precision = 10, scale = 2)
  private BigDecimal provShare;

  @Column(name = "state", length = 64)
  private String state;

  @Column(name = "prs", precision = 10, scale = 2)
  private BigDecimal prs;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 256)
  private String name;

  @Column(name = "name_in_local", length = 256)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
