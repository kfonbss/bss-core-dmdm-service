package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankDetailsResponse {

  private UUID id;
  private Long bankId;
  private String bankName;
  private String bankIfscCode;
  private String bankMicr;
  private String bankBranch;
  private String bankAddress;
  private Integer bankContact;
  private String bankCity;
  private String bankDistrict;
  private String bankState;
}
