package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Full mapping of the legacy-migrated sys_config table (changelog-0.0.8.sql). Columns MSP, ISP,
// ITMSP, TID and STCode were declared unquoted in that DDL, so Postgres folded them to lowercase
// (msp, isp, itmsp, tid, stcode) — mapped here accordingly.
@Entity
@Table(name = "sys_config")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SysConfig {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, unique = true)
  private UUID id;

  @Column(name = "configid")
  private Integer configId;

  @Column(name = "msp", nullable = false, length = 45)
  private String msp;

  @Column(name = "isp", nullable = false, length = 45)
  private String isp;

  @Column(name = "itmsp", length = 45)
  private String itmsp;

  @Column(name = "tid", nullable = false, length = 3)
  private String tid;

  @Column(name = "state", nullable = false, length = 128)
  private String state;

  @Column(name = "state_code", nullable = false, length = 5)
  private String stateCode;

  @Column(name = "app_url", length = 256)
  private String appUrl;

  @Column(name = "smtp_host", length = 256)
  private String smtpHost;

  @Column(name = "smtp_user", length = 100)
  private String smtpUser;

  @Column(name = "smtp_pass", length = 64)
  private String smtpPass;

  @Column(name = "smtp_port", length = 10)
  private String smtpPort;

  @Column(name = "payableat", length = 100)
  private String payableAt;

  @Column(name = "bankdetails", length = 128)
  private String bankDetails;

  @Column(name = "resp_url", length = 300)
  private String respUrl;

  @Column(name = "aaa_ip", length = 128)
  private String aaaIp;

  @Column(name = "paytm_respurl", length = 256)
  private String paytmRespUrl;

  @Column(name = "sub_paytmresp", length = 256)
  private String subPaytmResp;

  @Column(name = "sub_billdeskresp", length = 256)
  private String subBilldeskResp;

  @Column(name = "stcode", length = 45)
  private String stCode;

  @Column(name = "statemap", length = 250)
  private String stateMap;

  @Column(name = "curl", length = 80)
  private String curl;

  @Column(name = "districtcode", length = 5)
  private String districtCode;
}
