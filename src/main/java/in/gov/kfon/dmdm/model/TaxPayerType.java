package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "taxpayertype")
public class TaxPayerType extends Auditor {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "code", length = 45)
  private String code;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "name_in_local", length = 255)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "taxpayertypeid")
  private Integer taxPayerTypeId;

  @Column(name = "taxpayertype", length = 45)
  private String taxPayerType;
}
