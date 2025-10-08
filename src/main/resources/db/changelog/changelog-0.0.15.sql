DROP TABLE IF EXISTS Api_order CASCADE;

CREATE TABLE Api_order (
  api_order_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  service_type varchar(60) NOT NULL,
  customer_id varchar(45) DEFAULT NULL,
  customer_short varchar(45) DEFAULT NULL,
  package_id varchar(45) DEFAULT NULL,
  workorder_id varchar(45) DEFAULT NULL,
  locationcode varchar(65) DEFAULT NULL,
  locationname varchar(65) DEFAULT NULL,
  elocationcode varchar(45) DEFAULT NULL,
  elocationname varchar(45) DEFAULT NULL,
  vpn_topology varchar(45) DEFAULT NULL,
  link_topology varchar(45) DEFAULT NULL,
  manged_customer varchar(45) DEFAULT NULL,
  managedCPEPort varchar(45) DEFAULT NULL,
  protocol varchar(45) DEFAULT NULL,
  remote_as int DEFAULT NULL,
  vendorid varchar(45) DEFAULT NULL,
  ip_v varchar(45) DEFAULT NULL,
  wanIpPE varchar(45) DEFAULT NULL,
  wanIpCPE varchar(45) DEFAULT NULL,
  wanIpv6PE varchar(45) DEFAULT NULL,
  wanIpv6CPE varchar(45) DEFAULT NULL,
  lanSubnetIpv4 varchar(45) DEFAULT NULL,
  lanSubnetIpv6 varchar(45) DEFAULT NULL,
  bandwidth varchar(45) DEFAULT NULL,
  bandwidthUOM varchar(45) DEFAULT 'Mbps',
  QoS varchar(45) DEFAULT NULL,
  QosForwardingClass varchar(45) DEFAULT NULL,
  delivered_via_gpon varchar(45) DEFAULT NULL,
  vpnid varchar(45) DEFAULT NULL,
  circuitid varchar(45) DEFAULT NULL,
  serviceid varchar(45) DEFAULT NULL,
  call_type varchar(45) DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  GPONONTSerialNumber varchar(45) DEFAULT NULL,
  eGPONONTSerialNumber varchar(45) DEFAULT NULL,
  CIR int DEFAULT NULL,
  CIR_PIR_unit varchar(45) DEFAULT NULL,
  PIR int DEFAULT NULL,
  api_response text DEFAULT NULL,
  created_at timestamp DEFAULT NULL,
  updated_at timestamp DEFAULT NULL,
  location varchar(45) DEFAULT NULL,
  district varchar(45) DEFAULT NULL,
  agnp varchar(45) DEFAULT NULL,
  anp varchar(45) DEFAULT NULL,
  loccode varchar(45) DEFAULT NULL,
  com_date timestamp DEFAULT NULL
);

CREATE UNIQUE INDEX circuitid_unique ON Api_order (circuitid);
COMMENT ON COLUMN Api_order.api_order_id IS 'Unique identifier for API order records';


DROP TABLE IF EXISTS Api_order_logs CASCADE;

CREATE TABLE Api_order_logs (
  api_order_logs_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  req_q text DEFAULT NULL,
  res_q text DEFAULT NULL,
  circuitid text DEFAULT NULL,
  state varchar(45) DEFAULT NULL,
  created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON COLUMN Api_order_logs.api_order_logs_id IS 'Unique identifier for API order logs';

