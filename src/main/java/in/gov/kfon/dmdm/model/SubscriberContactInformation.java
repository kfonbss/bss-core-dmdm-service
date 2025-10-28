package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriber_contact_information")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberContactInformation extends Auditor {

  @Id
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "information_id")
  private Long informationId;

  @Column(length = 30)
  private String name;

  @Column(length = 12)
  private String mobile;

  @Column(length = 100)
  private String email;

  @Column(length = 6)
  private String pincode;

  @Column(length = 250)
  private String address;

  @Column(length = 100)
  private String district;

  @Column(length = 100)
  private String postoffice;

  @Column private Integer connection_type;

  @Column(length = 250)
  private String comments;

  @Column(length = 100)
  private String rationcard;

  @Column(length = 50)
  private String code;

  @Column(length = 100)
  private String name_in_local;

  @Column private Boolean is_active = true;
}
