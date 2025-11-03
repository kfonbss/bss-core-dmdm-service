package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "ce_sub_customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CeSubCustomers extends Auditor {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "customers_id")
  private UUID customersId;

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

  @Column(name = "customerid")
  private String customerId;

  @Column(name = "company_name")
  private String companyName;

  @Column(name = "department_name")
  private String departmentName;

  @Column(name = "billing_category")
  private String billingCategory;
}
