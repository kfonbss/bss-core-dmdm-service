DROP TABLE IF EXISTS circle CASCADE;

CREATE TABLE circle (
  circle_id UUID DEFAULT gen_random_uuid() NOT NULL,
  slno SERIAL,
  circlecode varchar(50) DEFAULT NULL,
  circlename varchar(50) DEFAULT NULL,
  msp varchar(40) DEFAULT NULL,
  region varchar(40) DEFAULT NULL,
  db varchar(100) DEFAULT NULL,
  CONSTRAINT pk_circle PRIMARY KEY (circle_id)
);


DROP TABLE IF EXISTS city CASCADE;

CREATE TABLE city (
  city_id UUID DEFAULT gen_random_uuid() NOT NULL,
  cityid SERIAL,
  cityname varchar(250) DEFAULT NULL,
  stateid int DEFAULT NULL,
  CONSTRAINT pk_city PRIMARY KEY (city_id)
);


DROP TABLE IF EXISTS closeddisbursement CASCADE;

CREATE TABLE closeddisbursement (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  closeddisbursementid SERIAL,
  partnergroupid int NOT NULL,
  sumrevenue decimal(10,2) NOT NULL,
  revenueshareid int NOT NULL,
  done int DEFAULT 0,
  lastupdate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_closeddisbursement PRIMARY KEY (id)
);

CREATE INDEX Index_2_closeddisb ON closeddisbursement (partnergroupid);


DROP TABLE IF EXISTS companydetail CASCADE;

CREATE TABLE companydetail (
  id UUID DEFAULT gen_random_uuid() NOT NULL,
  companyid bigint NOT NULL,
  partnercompanyname varchar(150) DEFAULT NULL,
  status boolean NOT NULL DEFAULT false,
  companyregistrationno varchar(64) DEFAULT NULL,
  servicetaxno varchar(64) DEFAULT NULL,
  incometaxno varchar(45) DEFAULT NULL,
  vatno varchar(45) DEFAULT NULL,
  state varchar(64) DEFAULT NULL,
  pin int DEFAULT NULL,
  registrationdate date DEFAULT NULL,
  agreementno varchar(100) DEFAULT NULL,
  agreementdate date DEFAULT NULL,
  keycontactname varchar(45) DEFAULT NULL,
  keycontactnumber bigint DEFAULT NULL,
  keycontactemail varchar(128) DEFAULT NULL,
  lastupdate timestamp DEFAULT NULL,
  supportcontactname varchar(128) DEFAULT NULL,
  supportcontactno varchar(15) DEFAULT NULL,
  supportcontactemail varchar(128) DEFAULT NULL,
  managercontactname varchar(45) DEFAULT NULL,
  managercontactno bigint DEFAULT NULL,
  managercontactemail varchar(128) DEFAULT NULL,
  allocated_bw varchar(45) DEFAULT NULL,
  consumed_bw varchar(45) DEFAULT NULL,
  pgiopt int NOT NULL DEFAULT 0,
  statecode varchar(5) DEFAULT NULL,
  acholdername varchar(100) DEFAULT NULL,
  actype varchar(5) DEFAULT NULL,
  bankname varchar(100) DEFAULT NULL,
  branchname varchar(100) DEFAULT NULL,
  acnumber varchar(50) DEFAULT NULL,
  IFSC varchar(30) DEFAULT NULL,
  ptype char(25) DEFAULT NULL,
  address varchar(300) DEFAULT NULL,
  approval_date timestamp DEFAULT NULL,
  approval_cl varchar(300) DEFAULT NULL,
  approval_response varchar(300) DEFAULT NULL,
  agreementcopy varchar(256) DEFAULT NULL,
  bankpasscopy varchar(256) DEFAULT NULL,
  incometaxproof varchar(256) DEFAULT NULL,
  servicetaxproof varchar(256) DEFAULT NULL,
  bank_acholder varchar(128) DEFAULT NULL,
  bank_actype varchar(45) DEFAULT NULL,
  bank_name varchar(128) DEFAULT NULL,
  bank_branch varchar(128) DEFAULT NULL,
  bank_acno varchar(64) DEFAULT NULL,
  bank_ifsc varchar(64) DEFAULT NULL,
  companynature varchar(64) DEFAULT NULL,
  STCode char(3) DEFAULT NULL,
  address_line1 varchar(120) DEFAULT NULL,
  address_line2 varchar(120) DEFAULT NULL,
  city varchar(64) DEFAULT NULL,
  PinCode varchar(7) DEFAULT NULL,
  StateName varchar(64) DEFAULT NULL,
  District varchar(64) DEFAULT NULL,
  gstin varchar(45) DEFAULT NULL,
  service_description varchar(180) DEFAULT NULL,
  SAC varchar(45) DEFAULT NULL,
  gstindoc varchar(120) DEFAULT NULL,
  gst_verfied boolean NOT NULL DEFAULT false,
  taxpayertype boolean NOT NULL DEFAULT false,
  gstdeclartionstatus boolean NOT NULL DEFAULT false,
  subonrecharge boolean DEFAULT false,
  onlinepaymode varchar(100) DEFAULT NULL,
  mspverified smallint DEFAULT 1,
  otp varchar(20) DEFAULT NULL,
  otp_time timestamp DEFAULT NULL,
  remarks varchar(100) DEFAULT NULL,
  paymodedate timestamp DEFAULT NULL,
  mspverfieddate timestamp DEFAULT NULL,
  bankverfieddate timestamp DEFAULT NULL,
  lastrenewed_agreementdate date DEFAULT NULL,
  updated_by varchar(20) DEFAULT NULL,
  lastrenewed_agreementcopy varchar(256) DEFAULT NULL,
  loc_type int DEFAULT NULL,
  gst_status smallint DEFAULT NULL,
  catagory varchar(30) DEFAULT NULL,
  vas_enabled varchar(45) DEFAULT NULL,
  cbldoc varchar(256) DEFAULT NULL,
  railtelflag boolean DEFAULT true,
  territory_name varchar(45) DEFAULT NULL,
  ptnrattid varchar(100) DEFAULT NULL,
  ptnrlang varchar(100) DEFAULT NULL,
  code varchar(50) DEFAULT NULL,
  name varchar(150) DEFAULT NULL,
  name_in_local varchar(150) DEFAULT NULL,
  is_active boolean DEFAULT true,
  CONSTRAINT pk_companydetail PRIMARY KEY (id)
);

CREATE INDEX index2_companydetail ON companydetail (statecode);
COMMENT ON COLUMN companydetail.loc_type IS '1 Urban 2 Rural';

INSERT INTO companydetail (id, companyid, code, name, name_in_local, is_active, partnercompanyname, status, companyregistrationno, servicetaxno, incometaxno, vatno, state, pin, registrationdate, agreementno, agreementdate, keycontactname, keycontactnumber, keycontactemail, lastupdate, supportcontactname, supportcontactno, supportcontactemail, managercontactname, managercontactno, managercontactemail, allocated_bw, consumed_bw, pgiopt, statecode, acholdername, actype, bankname, branchname, acnumber, IFSC, ptype, address, approval_date, approval_cl, approval_response, agreementcopy, bankpasscopy, incometaxproof, servicetaxproof, bank_acholder, bank_actype, bank_name, bank_branch, bank_acno, bank_ifsc, companynature, STCode, address_line1, address_line2, city, PinCode, StateName, District, gstin, service_description, SAC, gstindoc, gst_verfied, taxpayertype, gstdeclartionstatus, subonrecharge, onlinepaymode, mspverified, otp, otp_time, remarks, paymodedate, mspverfieddate, bankverfieddate, lastrenewed_agreementdate, updated_by, lastrenewed_agreementcopy, loc_type, gst_status, catagory, vas_enabled, cbldoc, railtelflag, territory_name, ptnrattid, ptnrlang)
VALUES (gen_random_uuid(), 1001, 'COMP001', 'ABC Pvt Ltd', 'എബിസി പ്രൈവറ്റ് ലിമിറ്റഡ്', TRUE, 'ABC Pvt Ltd', TRUE, 'REG123456', 'ST123456', 'IT123456', 'VAT123456', 'Kerala', 682001, CURRENT_DATE, 'AGR001', CURRENT_DATE, 'John Doe', 9876543210, 'john.doe@example.com', CURRENT_TIMESTAMP, 'Support Name', '9876543210', 'support@example.com', 'Manager Name', 9876543211, 'manager@example.com', '100Mbps', '50Mbps', 1, 'KL', 'John Doe', 'SAV', 'ABC Bank', 'Main Branch', '1234567890', 'IFSC00123', 'Type1', '123, ABC Street', CURRENT_TIMESTAMP, 'Approved', 'Approved by CEO', NULL, NULL, NULL, NULL, 'John Doe', 'SAV', 'ABC Bank', 'Main Branch', '1234567890', 'IFSC00123', 'Private Limited', '32', 'Address Line1', 'Address Line2', 'Kochi', '682001', 'Kerala', 'Ernakulam', 'GSTIN12345', 'Internet Service', 'SAC001', NULL, FALSE, FALSE, FALSE, FALSE, 'Online', 1, NULL, NULL, 'Initial record', NULL, NULL, NULL, NULL, 'admin', NULL, 1, 1, 'CAT1', 'VAS1', NULL, TRUE, 'Territory1', 'PTNR001', 'EN');
