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

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "slno")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer slNo;

  @Column(name = "lco_pan_ind")
  private BigDecimal lcoPanInd;

  @Column(name = "lco_pan_oth")
  private BigDecimal lcoPanOth;

  @Column(name = "lco_nopan")
  private BigDecimal lcoNoPan;

  @Column(name = "agp_pan")
  private BigDecimal agpPan;

  @Column(name = "agp_nopan")
  private BigDecimal agpNoPan;

  @Column(name = "msp_pan")
  private BigDecimal mspPan;

  @Column(name = "msp_nopan")
  private BigDecimal mspNoPan;

  @Column(name = "sgst")
  private BigDecimal sgst;

  @Column(name = "cgst")
  private BigDecimal cgst;

  @Column(name = "sgsttds")
  private BigDecimal sgstTds;

  @Column(name = "cgsttds")
  private BigDecimal cgstTds;

  @Column(name = "kfc")
  private BigDecimal kfc;

  @Column(name = "transcharge")
  private BigDecimal transCharge;

  @Column(length = 10)
  private String status;

  @Column(name = "enddate")
  private Timestamp endDate;

  @Column(length = 100)
  private String remarks;
}
