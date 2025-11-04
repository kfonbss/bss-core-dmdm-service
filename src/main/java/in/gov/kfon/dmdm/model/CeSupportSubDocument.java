package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_supportsub_document")
@Data
public class CeSupportSubDocument {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "document_id")
  private UUID documentId;

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
  private Integer locid;

  @Column(name = "caf_doc")
  private String cafDoc;

  @Column(name = "caf_date")
  private LocalDate cafDate;

  @Column(name = "agr_doc")
  private String agrDoc;

  @Column(name = "agr_date")
  private LocalDate agrDate;

  @Column(name = "icr_doc")
  private String icrDoc;

  @Column(name = "icr_date")
  private LocalDate icrDate;

  @Column(name = "preins_doc")
  private String preinsDoc;

  @Column(name = "preins_date")
  private LocalDate preinsDate;

  @Column(name = "postins_doc")
  private String postinsDoc;

  @Column(name = "postins_date")
  private LocalDate postinsDate;

  @Column(name = "network_doc")
  private String networkDoc;

  @Column(name = "network_date")
  private LocalDate networkDate;

  @Column(name = "kyc_doc")
  private String kycDoc;

  @Column(name = "kyc_date")
  private LocalDate kycDate;

  @Column(name = "hyi_doc")
  private String hyiDoc;

  @Column(name = "hyi_date")
  private LocalDate hyiDate;

  @Column(name = "oth_doc")
  private String othDoc;

  @Column(name = "oth_date")
  private LocalDate othDate;

  @Column(name = "hyi_flag")
  private Integer hyiFlag;
}
