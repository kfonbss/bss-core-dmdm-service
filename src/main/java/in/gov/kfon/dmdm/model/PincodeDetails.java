package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "pincode_details")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PincodeDetails extends Auditor {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "details_id")
  private Long details_id;

  @Column(name = "pincode")
  private Integer pincode;

  @Column(name = "post_office_name", length = 250)
  private String postOfficeName;

  @Column(name = "sub_po_name", length = 250)
  private String subPoName;

  @Column(length = 100)
  private String district;

  @Column(name = "districtcode")
  private Integer districtCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "district_id", referencedColumnName = "district_id")
  private District districtMaster;

  @Column(length = 50)
  private String code;

  @Column(length = 250)
  private String name;

  @Column(name = "name_in_local", length = 250)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
