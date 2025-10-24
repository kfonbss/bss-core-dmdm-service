package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "taxdetail")
public class TaxDetail extends Auditor {

  @Id @GeneratedValue private UUID id;

  @Column(length = 45)
  private String code;

  @Column(length = 255)
  private String name;

  @Column(name = "name_in_local", length = 255)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "slno")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer slNo;

  @Column(name = "lco_pan_ind", precision = 4, scale = 2)
  private BigDecimal lcoPanInd;

  @Column(name = "lco_pan_oth", precision = 4, scale = 2)
  private BigDecimal lcoPanOth;

  @Column(name = "lco_nopan", precision = 4, scale = 2)
  private BigDecimal lcoNoPan;

  @Column(name = "agp_pan", precision = 4, scale = 2)
  private BigDecimal agpPan;

  @Column(name = "agp_nopan", precision = 4, scale = 2)
  private BigDecimal agpNoPan;

  @Column(name = "msp_pan", precision = 4, scale = 2)
  private BigDecimal mspPan;

  @Column(name = "msp_nopan", precision = 4, scale = 2)
  private BigDecimal mspNoPan;

  @Column(name = "sgst", precision = 4, scale = 2)
  private BigDecimal sgst;

  @Column(name = "cgst", precision = 4, scale = 2)
  private BigDecimal cgst;

  @Column(name = "sgsttds", precision = 4, scale = 2)
  private BigDecimal sgstTds;

  @Column(name = "cgsttds", precision = 4, scale = 2)
  private BigDecimal cgstTds;

  @Column(name = "kfc", precision = 4, scale = 2)
  private BigDecimal kfc;

  @Column(name = "transcharge", precision = 4, scale = 2)
  private BigDecimal transCharge;

  @Column(length = 10)
  private String status;

  @Column(name = "enddate")
  private Timestamp endDate;

  @Column(length = 100)
  private String remarks;
}
