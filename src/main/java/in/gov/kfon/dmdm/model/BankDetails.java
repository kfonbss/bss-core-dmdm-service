package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "bank_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bank_id")
  private Long bankId;

  @Column(name = "bank_name", length = 100, nullable = false)
  private String bankName;

  @Column(name = "bank_ifsc_code", length = 100, nullable = false)
  private String bankIfscCode;

  @Column(name = "bank_micr", length = 100, nullable = false)
  private String bankMicr;

  @Column(name = "bank_branch", length = 100, nullable = false)
  private String bankBranch;

  @Column(name = "bank_address", length = 250, nullable = false)
  private String bankAddress;

  @Column(name = "bank_contact", nullable = false)
  private Integer bankContact;

  @Column(name = "bank_city", length = 150, nullable = false)
  private String bankCity;

  @Column(name = "bank_district", length = 150, nullable = false)
  private String bankDistrict;

  @Column(name = "bank_state", length = 150, nullable = false)
  private String bankState;
}
