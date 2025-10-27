package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "corp_location_list")
@Getter
@Setter
public class CorpLocationList extends Auditor {

  @Id
  @Column(name = "list_id", nullable = false)
  private UUID listId;

  @Column(name = "id")
  private Integer id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "name_in_local")
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive;

  @Column(name = "corp_enq_id")
  private Integer corpEnqId;

  @Column(name = "status")
  private String status;

  @Column(name = "fe_id")
  private String feId;

  @Column(name = "partnerid")
  private Long partnerId;

  @Column(name = "partnername")
  private String partnerName;

  @Column(name = "service_type")
  private String serviceType;

  @Column(name = "locname")
  private String locName;

  @Column(name = "district")
  private String district;

  @Column(name = "pincode")
  private Integer pincode;

  @Column(name = "location")
  private String location;

  @Column(name = "address")
  private String address;

  @Column(name = "lat")
  private String lat;

  @Column(name = "longt")
  private String longt;

  @Column(name = "created_by_platform")
  private String createdByPlatform;

  @Column(name = "contactno")
  private String contactNo;

  @Column(name = "constituency")
  private String constituency;

  @Column(name = "gramapanchayath")
  private String gramaPanchayath;

  @Column(name = "geolocaddress")
  private String geoLocAddress;

  @Column(name = "contact_person")
  private String contactPerson;

  @Column(name = "email_id")
  private String emailId;

  @Column(name = "no_of_users")
  private Integer noOfUsers;

  @Column(name = "bandwidth_required")
  private String bandwidthRequired;

  @Column(name = "no_of_private_ip")
  private Integer noOfPrivateIp;

  @Column(name = "no_of_static_ip")
  private Integer noOfStaticIp;

  @Column(name = "no_of_eoffice_ip")
  private Integer noOfEofficeIp;

  @Column(name = "pop_name")
  private String popName;

  @Column(name = "scope")
  private String scope;

  @Column(name = "boq")
  private String boq;

  @Column(name = "pppoe_migration")
  private Short pppoeMigration;

  @Column(name = "remarks")
  private String remarks;

  @Column(name = "nearest_box_name")
  private String nearestBoxName;

  @Column(name = "nearest_box_distance")
  private String nearestBoxDistance;

  @Column(name = "nearest_box_pop")
  private String nearestBoxPop;

  @Column(name = "nearest_sub_id")
  private Integer nearestSubId;

  @Column(name = "nearest_sub_partnerid")
  private String nearestSubPartnerId;

  @Column(name = "nearest_sub_partnername")
  private String nearestSubPartnerName;

  @Column(name = "nearest_sub_partnermobile")
  private String nearestSubPartnerMobile;

  @Column(name = "nearest_sub_distance")
  private BigDecimal nearestSubDistance;

  @Column(name = "nearest_partner_id")
  private String nearestPartnerId;

  @Column(name = "nearest_partner_name")
  private String nearestPartnerName;

  @Column(name = "nearest_partner_mobile")
  private String nearestPartnerMobile;

  @Column(name = "nearest_partner_distance")
  private BigDecimal nearestPartnerDistance;

  @Column(name = "nearest_fe_id")
  private Integer nearestFeId;

  @Column(name = "nearest_box_latitude")
  private String nearestBoxLatitude;

  @Column(name = "nearest_box_longitude")
  private String nearestBoxLongitude;

  @Column(name = "est_fibre_qnty")
  private BigDecimal estFibreQnty;

  @Column(name = "bell_connected")
  private Short bellConnected;

  @Column(name = "est_fibre_cost")
  private BigDecimal estFibreCost;

  @Column(name = "feasibility_checked")
  private Short feasibilityChecked;
}
