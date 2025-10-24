package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "taxcollection")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TaxCollection {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "taxcollectionid", updatable = false, insertable = false)
  private Integer taxCollectionId;

  @Column(name = "subscriberrecieptid", nullable = false)
  private Long subscriberReceiptId;

  @Column(name = "taxtypeid", nullable = false)
  private Integer taxTypeId = 1;

  @Column(name = "taxamount", nullable = false, precision = 10, scale = 2)
  private BigDecimal taxAmount;

  @Column(name = "lastupdate", nullable = false)
  private LocalDateTime lastUpdate = LocalDateTime.now();
}
