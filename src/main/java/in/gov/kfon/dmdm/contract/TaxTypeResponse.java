package in.gov.kfon.dmdm.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxTypeResponse {
    private UUID id;
    private String code;
    private String name;
    private String nameInLocal;
    private Boolean isActive;
    private Integer taxTypeId;
    private BigDecimal taxValuePercent;
}
