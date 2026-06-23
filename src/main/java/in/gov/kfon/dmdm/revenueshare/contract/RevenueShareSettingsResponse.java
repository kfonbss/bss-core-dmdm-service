package in.gov.kfon.dmdm.revenueshare.contract;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RevenueShareSettingsResponse {

  private UUID id;
  private Integer revenueShareId;
  private String shareName;
  private String code;
  private String name;
  private String nameInLocal;
  private String state;
  private Integer subgroup;
  private UUID providerUuid;
  private BigDecimal ibnpShare;
  private BigDecimal ibwpShare;
  private BigDecimal anpShare;
  private BigDecimal agpShare;
  private BigDecimal cnpShare;
  private BigDecimal mspShare;
  private BigDecimal mktShare;
  private BigDecimal ispShare;
  private BigDecimal permShare;
  private BigDecimal dotShare;
  private BigDecimal provShare;
  private BigDecimal prs;
  private Boolean isActive;
}
