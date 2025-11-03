package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
@Entity
@Table(name = "df_trans_renewal_details")
public class DfTransRenewalDetails extends Auditor {

  @Id
  @Column(name = "df_trans_renewal_details_id", nullable = false, updatable = false)
  private UUID dfTransRenewalDetailsId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "mg_invoiceid")
  private Integer mgInvoiceid;

  @Column(name = "lrhid")
  private Integer lrhid;

  @Column(name = "transmv_id")
  private Integer transmvId;

  @Column(name = "groupid")
  private Integer groupid;

  @Column(name = "grouplinkid")
  private Integer grouplinkid;

  @Column(name = "linkid")
  private Integer linkid;

  @Column(name = "cost_per_trand", precision = 25, scale = 10, nullable = false)
  private BigDecimal costPerTrand;

  @Column(name = "gst_cost_per_trand", precision = 25, scale = 10, nullable = false)
  private BigDecimal gstCostPerTrand;

  @Column(name = "trand_service_days")
  private Integer trandServiceDays;

  @Column(name = "trands_send_date")
  private LocalDate trandsSendDate;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
