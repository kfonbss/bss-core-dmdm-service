package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "ce_subscribers_document")
@Data
public class CeSubscribersDocument {
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

  @Column(name = "sub_document")
  private String subDocument;

  @Column(name = "doc_type")
  private Boolean docType;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "data_collected_date")
  private LocalDate dataCollectedDate;

  @Column(name = "hyi_flag")
  private Integer hyiFlag;
}
