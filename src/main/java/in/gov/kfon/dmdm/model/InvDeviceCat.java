package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "inv_device_cat")
@Data
public class InvDeviceCat {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "cat_id")
  private UUID catId;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "id")
  private Integer id;

  @Column(name = "dtid")
  private Integer dtId;

  @Column(name = "dmid")
  private Integer dmId;

  @Column(name = "dc_name")
  private String dcName;

  @Column(name = "dc_desc")
  private String dcDesc;

  @Column(name = "cat_type")
  private Integer catType;

  @Column(name = "ont_type")
  private Integer ontType;

  @Column(name = "no_of_pon_port")
  private Integer noOfPonPort;

  @Column(name = "created_by_name")
  private String createdByName;
}
