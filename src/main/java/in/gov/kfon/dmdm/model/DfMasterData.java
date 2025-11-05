package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_masterdata")
@Data
public class DfMasterData extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "data_id")
  private UUID dataId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "district")
  private String district;

  @Column(name = "link_type")
  private String linkType;

  @Column(name = "link_type_id")
  private String linkTypeId;

  @Column(name = "link")
  private String link;

  @Column(name = "fiber_type")
  private String fiberType;

  @Column(name = "unit_price")
  private Double unitPrice;

  @Column(name = "noof_strands")
  private Integer noOfStrands;

  @Column(name = "noof_strands_consumed")
  private Integer noOfStrandsConsumed;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
