package in.gov.kfon.dmdm.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Sub-package type (R-code / bifurcation) master row (sub_package_type). */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubPackageTypeResponse {
  private UUID id;
  private Integer subPackageTypeId;
  private String code;
  private String name;
  private String nameInLocal;
  private Boolean isActive;

  /** Legacy integer service type (= service_type.type_id). */
  private Integer serviceType;

  private UUID serviceTypeId;
  private Integer disbBefore;
  private Integer disbAfter;
  private Boolean invoiceReport;
  private Boolean disburseReport;
}
