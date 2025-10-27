package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "corporate_enquiries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporateEnquiry extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "enquiries_id", nullable = false)
  private UUID enquiriesId;

  private String code;

  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "contact_name", nullable = false)
  private String contactName;

  @Column(name = "contact_number", nullable = false)
  private Long contactNumber;

  @Column(name = "email_id", nullable = false)
  private String emailId;

  private String latitude;

  private String longitude;

  @Column(name = "company_address", columnDefinition = "TEXT")
  private String companyAddress;

  @Column(name = "requested_service", columnDefinition = "TEXT")
  private String requestedService;

  @Column(name = "fesible_status")
  private String fesibleStatus;

  private String status = "Open";

  @Column(name = "corp_source")
  private String corpSource = "web";

  @Column(name = "created_by_platform")
  private String createdByPlatform = "web";

  @Column(name = "ticket_id")
  private Integer ticketId;

  @Column(name = "connection_type")
  private String connectionType;

  @Column(name = "file_name")
  private String fileName;

  @Column(name = "corp_enq_doc")
  private String corpEnqDoc;

  @Column(name = "company_type")
  private String companyType;

  private String remarks;

  @Column(name = "otp_value")
  private String otpValue;

  @Column(name = "otp_send_time")
  private Timestamp otpSendTime;
}
