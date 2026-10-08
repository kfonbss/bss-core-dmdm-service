package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * GST state code (e.g. "32") to 3-letter postal abbreviation (e.g. "KL") mapping, used to print
 * the correct state code on partner invoices (LNP/AGNP/MSP). Table already existed (created
 * empty by changelog-0.0.90.sql) with no owning entity until now — this is the equivalent of
 * legacy's {@code billing_master.state_district} table (columns {@code STCode}/{@code statecode},
 * confusingly swapped in name vs. meaning there too).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "invoice_statecode")
public class InvoiceStateCode {

  @Id
  @GeneratedValue
  @Column(name = "invoice_statecode_id")
  private UUID id;

  @Column(name = "stcode")
  private String stCode;

  @Column(name = "state_code")
  private String stateCode;
}
