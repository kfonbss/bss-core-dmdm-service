package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_transdetails_movement")
@Data
public class DfTransDetailsMovement extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "df_transdetails_movement_id", nullable = false)
  private UUID dfTransdetailsMovementId;

  @Column(name = "id")
  private Long id;

  @Column(name = "trandsid")
  private Integer trandsId;

  @Column(name = "trands_status")
  private Integer trandsStatus;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "grouplinkid")
  private Integer groupLinkId;

  @Column(name = "linkid")
  private Integer linkId;

  @Column(name = "feeder_id")
  private Integer feederId;

  @Column(name = "starnd_d_status")
  private Integer strandDStatus;

  @Column(name = "starnd_d_status_date")
  private Date strandDStatusDate;

  @Column(name = "back_date_invoice")
  private Integer backDateInvoice;

  @Column(name = "bd_invoice_sdate")
  private Date bdInvoiceStartDate;

  @Column(name = "bd_invoice_edate")
  private Date bdInvoiceEndDate;

  @Column(name = "bd_unit_price")
  private BigDecimal bdUnitPrice;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
