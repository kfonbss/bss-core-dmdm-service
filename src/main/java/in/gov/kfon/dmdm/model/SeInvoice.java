package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "se_inovoice")
@Data
public class SeInvoice {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "slno")
  private Long slno;

  @Column(name = "locid")
  private Integer locId;

  @Column(name = "custid")
  private Integer custId;

  @Column(name = "finrefid")
  private Integer finRefId;

  @Column(name = "invoiceno")
  private String invoiceNo;

  @Column(name = "invoicedate")
  private LocalDate invoiceDate;

  @Column(name = "grossamount")
  private Double grossAmount;

  @Column(name = "locamount")
  private Double locAmount;

  @Column(name = "servicetax")
  private Double serviceTax;

  @Column(name = "servicestartdate")
  private LocalDate serviceStartDate;

  @Column(name = "serviceenddate")
  private LocalDate serviceEndDate;

  @Column(name = "gst_value")
  private Double gstValue;

  @Column(name = "cgst_value")
  private Double cgstValue;

  @Column(name = "sgst_value")
  private Double sgstValue;

  @Column(name = "igst_value")
  private Double igstValue;

  @Column(name = "cgst_rate")
  private Double cgstRate;

  @Column(name = "sgst_rate")
  private Double sgstRate;

  @Column(name = "igst_rate")
  private Double igstRate;

  @Column(name = "gstin")
  private String gstin;

  @Column(name = "particulars")
  private String particulars;

  @Column(name = "mg_invoiceid")
  private Integer mgInvoiceId;

  @Column(name = "inv_type")
  private Integer invType;
}
