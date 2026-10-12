package in.gov.kfon.dmdm.packagemaster.contract;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Lookup row for the package masters. Same fields and JSON as bss-package-management-services'
 * CommonLookUp, so clients can switch from the package service to DMDM without changes.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackageLookUp {
  private UUID id;
  private Integer intId;
  private String name;
  private String code;
  private String nameInLocal;
  private Boolean isActive;
  private int subPackageCount;
  private Boolean requiresRCode;
  private String description;
  private boolean isBod;
  // Only set for sub_package_type: its disbursement state-machine codes. Null otherwise.
  private Integer disbBefore;
  private Integer disbAfter;
}
