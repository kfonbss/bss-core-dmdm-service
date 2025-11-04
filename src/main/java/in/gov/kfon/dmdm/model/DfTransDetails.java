package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "df_transdetails")
@Data
public class DfTransDetails extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "df_transdetails_id", nullable = false)
  private UUID dfTransdetailsId;

  @Column(name = "id")
  private Long id;

  @Column(name = "groupid")
  private Integer groupId;

  @Column(name = "grouplinkid")
  private Integer groupLinkId;

  @Column(name = "linkid")
  private Integer linkId;

  @Column(name = "feeder_id")
  private Integer feederId;

  @Column(name = "trandsid")
  private Integer trandsId;

  @Column(name = "trands_status")
  private Integer trandsStatus;

  @Column(name = "strand_type")
  private Integer strandType;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
