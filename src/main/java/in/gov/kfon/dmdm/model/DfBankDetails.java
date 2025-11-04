package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_bank_details")
@Data
public class DfBankDetails extends Auditor {

  @Id
  @Column(name = "details_id", nullable = false)
  private UUID detailsId;

  @Column(name = "beneficiary_name")
  private String beneficiaryName;

  @Column(name = "account_number")
  private String accountNumber;

  @Column(name = "ifsc_code")
  private String ifscCode;

  @Column(name = "bank")
  private String bank;

  @Column(name = "branch")
  private String branch;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
