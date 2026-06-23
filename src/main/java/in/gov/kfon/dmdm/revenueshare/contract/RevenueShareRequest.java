package in.gov.kfon.dmdm.revenueshare.contract;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class RevenueShareRequest {

  @NotBlank private String shareName;

  @NotBlank private String code;

  @NotBlank private String name;

  private String nameInLocal;

  private String state;

  @NotNull private Integer subgroup;

  private UUID providerUuid;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal ibnpShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal ibwpShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal anpShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal agpShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal cnpShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal mspShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal mktShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal ispShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal permShare;

  @NotNull
  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal dotShare;

  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal provShare;

  @DecimalMin("0.00")
  @DecimalMax("100.00")
  private BigDecimal prs;

  @NotNull private Boolean isActive;
}
