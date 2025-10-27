package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriberdetail")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberDetail extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "subscriberid")
  private Integer subscriberid;

  @Column(length = 64, unique = true)
  private String username;

  @Column(length = 45)
  private String partnerid;

  @Column(length = 64)
  private String firstname;

  @Column(length = 45)
  private String middlename;

  @Column(length = 64)
  private String lastname;

  private Integer premiseid;

  private Long mobileno;

  @Column(length = 128)
  private String email;

  @Column(length = 10)
  private String dateofbirth;

  private LocalDate registrationdate;

  @Column(length = 17)
  private String machineaddress;

  private Integer subscriberprofileid;

  private Long landlineno;

  @Column(length = 10)
  private String doorno;

  @Column(length = 45)
  private String apno;

  private Integer oltabid;

  @Column(length = 300)
  private String address;

  private Integer disabled;

  @Column(length = 20)
  private String gstin;

  @Column(length = 20)
  private String sac;

  @Column(length = 15)
  private String pan;

  @Column(length = 120)
  private String pancard_copy;

  @Column(length = 120)
  private String gstindoc;

  @Column(length = 255)
  private String lutdoc;

  @Column(length = 45)
  private String subprofile;

  private Integer otp;

  private java.util.Date otpstarttime;

  private Integer taxpayertype;

  private Integer gst_status;

  private Integer gender;

  private Integer apptype;

  private Integer sez_verfied;

  @Column(length = 100)
  private String latitude;

  @Column(length = 100)
  private String longitude;

  private Integer ponport_details_sub_id;

  private Integer workorderid;

  @Column(length = 50)
  private String code;

  @Column(length = 150)
  private String name;

  @Column(name = "name_in_local", length = 150)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
