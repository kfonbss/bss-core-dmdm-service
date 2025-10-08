DROP TABLE IF EXISTS billdesksub CASCADE;

CREATE TABLE billdesksub (
  billdesksub_id UUID PRIMARY KEY NOT NULL,
  id BIGSERIAL,
  ORDERNUMBER varchar(45) NOT NULL,
  status varchar(45) NOT NULL DEFAULT 'PENDING',
  amount decimal(10,2) NOT NULL,
  order_time timestamp DEFAULT NULL,
  TxnReferenceNo varchar(45) DEFAULT NULL,
  TxnDate timestamp DEFAULT NULL,
  TxnAmount decimal(10,2) DEFAULT NULL,
  AuthStatus_code varchar(45) DEFAULT NULL,
  AuthStatus_desc varchar(200) DEFAULT NULL,
  response_message varchar(300) DEFAULT NULL,
  Reconciliation varchar(45) DEFAULT NULL,
  Reconciliation_date varchar(45) DEFAULT NULL,
  Reconciliation_amount varchar(45) DEFAULT NULL,
  subscriberid bigint DEFAULT NULL,
  ErrorStatus varchar(45) DEFAULT NULL,
  ErrorDescription varchar(200) DEFAULT NULL,
  ChecksumStatus varchar(45) DEFAULT NULL
);

CREATE INDEX order_sub_idx ON billdesksub (ORDERNUMBER, subscriberid);
COMMENT ON COLUMN billdesksub.billdesksub_id IS 'Unique identifier for billdesk subscriber records';


DROP TABLE IF EXISTS billing_plans CASCADE;

CREATE TABLE billing_plans (
  billing_plans_id UUID PRIMARY KEY NOT NULL,
  id SERIAL,
  planName varchar(128) DEFAULT NULL,
  planId varchar(128) DEFAULT NULL,
  planType varchar(128) DEFAULT NULL,
  planTimeBank varchar(128) DEFAULT NULL,
  planTimeType varchar(128) DEFAULT NULL,
  planTimeRefillCost varchar(128) DEFAULT NULL,
  planBandwidthUp varchar(128) DEFAULT NULL,
  planBandwidthDown varchar(128) DEFAULT NULL,
  planTrafficTotal varchar(128) DEFAULT NULL,
  planTrafficUp varchar(128) DEFAULT NULL,
  planTrafficDown varchar(128) DEFAULT NULL,
  planTrafficRefillCost varchar(128) DEFAULT NULL,
  planRecurring varchar(128) DEFAULT NULL,
  planRecurringPeriod varchar(128) DEFAULT NULL,
  planCost varchar(128) DEFAULT NULL,
  planSetupCost varchar(128) DEFAULT NULL,
  planTax varchar(128) DEFAULT NULL,
  planCurrency varchar(128) DEFAULT NULL,
  planGroup varchar(128) DEFAULT NULL,
  creationdate timestamp DEFAULT '1970-01-01 00:00:00',
  creationby varchar(128) DEFAULT NULL,
  updatedate timestamp DEFAULT '1970-01-01 00:00:00',
  updateby varchar(128) DEFAULT NULL
);

CREATE INDEX planName_idx ON billing_plans (planName);
COMMENT ON COLUMN billing_plans.billing_plans_id IS 'Unique identifier for billing plans records';


DROP TABLE IF EXISTS billmimotransaction CASCADE;

CREATE TABLE billmimotransaction (
  billmimotransaction_id UUID PRIMARY KEY NOT NULL,
  id BIGSERIAL,
  subscriberid int NOT NULL,
  amount decimal(13,2) DEFAULT NULL,
  partnerid bigint DEFAULT NULL,
  anpshare decimal(13,2) DEFAULT NULL,
  railtelshare decimal(13,2) DEFAULT NULL,
  ordernumber varchar(64) DEFAULT NULL,
  orderdate timestamp DEFAULT NULL,
  create_date timestamp DEFAULT NULL,
  state varchar(50) DEFAULT NULL,
  utrnumber varchar(150) DEFAULT NULL,
  utrtranscationid varchar(150) DEFAULT NULL,
  amountpaid decimal(13,2) DEFAULT NULL,
  paymentdate date DEFAULT NULL,
  uplodeddate timestamp DEFAULT NULL,
  uploadedby varchar(50) DEFAULT NULL
);

COMMENT ON COLUMN billmimotransaction.billmimotransaction_id IS 'Unique identifier for bill MIMO transaction records';