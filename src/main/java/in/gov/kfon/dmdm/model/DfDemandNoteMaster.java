package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_demandnote_master")
@Data
public class DfDemandNoteMaster extends Auditor {

  @Id
  @Column(name = "master_id", nullable = false, updatable = false)
  private UUID masterId;

  @Column(name = "slno")
  private Integer slno;

  @Column(name = "subscriberid")
  private Long subscriberId;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "dnno")
  private String dnNo;

  @Column(name = "dndate")
  private Date dnDate;

  @Column(name = "dngrossamount", precision = 26, scale = 10)
  private BigDecimal dnGrossAmount;

  @Column(name = "dnamount", precision = 26, scale = 10)
  private BigDecimal dnAmount;

  @Column(name = "servicetax", precision = 10, scale = 10)
  private BigDecimal serviceTax;

  @Column(name = "servicetaxrate", precision = 10, scale = 2)
  private BigDecimal serviceTaxRate;

  @Column(name = "servicestartdate")
  private Date serviceStartDate;

  @Column(name = "serviceenddate")
  private Date serviceEndDate;

  @Column(name = "quarter_start_date")
  private Date quarterStartDate;

  @Column(name = "quarter_end_date")
  private Date quarterEndDate;

  @Column(name = "gst_value", precision = 26, scale = 10)
  private BigDecimal gstValue;

  @Column(name = "cgst_value", precision = 26, scale = 10)
  private BigDecimal cgstValue;

  @Column(name = "sgst_value", precision = 26, scale = 10)
  private BigDecimal sgstValue;

  @Column(name = "igst_value", precision = 26, scale = 10)
  private BigDecimal igstValue;

  @Column(name = "cgst_rate", precision = 26, scale = 10)
  private BigDecimal cgstRate;

  @Column(name = "sgst_rate", precision = 26, scale = 10)
  private BigDecimal sgstRate;

  @Column(name = "igst_rate", precision = 26, scale = 10)
  private BigDecimal igstRate;

  @Column(name = "gstin", length = 18)
  private String gstin;

  @Column(name = "pan", length = 10)
  private String pan;

  @Column(name = "taxpayertype")
  private Short taxPayerType;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
