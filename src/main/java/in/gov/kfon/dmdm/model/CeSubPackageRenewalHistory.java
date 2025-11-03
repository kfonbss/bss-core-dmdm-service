package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_sub_package_renewal_history")
@Data
public class CeSubPackageRenewalHistory extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "history_id")
  private UUID historyId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Integer id;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "sub_packageid")
  private Integer subPackageId;

  @Column(name = "mg_invoiceid")
  private Integer mgInvoiceId;

  @Column(name = "subfinanceid")
  private Integer subFinanceId;

  @Column(name = "total_sdays")
  private Integer totalSDays;

  @Column(name = "lrhid")
  private Integer lrhId;

  @Column(name = "discount_percent")
  private Double discountPercent;

  @Column(name = "disount_amount")
  private Double discountAmount;

  @Column(name = "original_renewalfee")
  private Double originalRenewalFee;

  @Column(name = "renewalfee_after_disount")
  private Double renewalFeeAfterDiscount;

  @Column(name = "cost_per_day")
  private Double costPerDay;

  @Column(name = "loc_amount")
  private Double locAmount;

  @Column(name = "loc_gst_amount")
  private Double locGstAmount;

  @Column(name = "loc_grand_amount")
  private Double locGrandAmount;

  @Column(name = "description")
  private String description;

  @Column(name = "service_cat")
  private Integer serviceCat;
}
