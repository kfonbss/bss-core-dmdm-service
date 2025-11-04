package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_customer_details")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DfCustomerDetails extends Auditor {

  @Id
  @Column(name = "details_id", nullable = false, updatable = false)
  private UUID detailsId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "customer_name", length = 250)
  private String customerName;

  @Column(name = "customer_email", length = 156)
  private String customerEmail;

  @Column(name = "customer_contact", length = 20)
  private String customerContact;

  @Column(name = "cperson_name", length = 250)
  private String cpersonName;

  @Column(name = "cperson_email", length = 156)
  private String cpersonEmail;

  @Column(name = "cperson_contact", length = 20)
  private String cpersonContact;

  @Column(name = "address", length = 250)
  private String address;

  @Column(name = "enq_ref")
  private Integer enqRef;

  @Column(name = "code", length = 50)
  private String code;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
