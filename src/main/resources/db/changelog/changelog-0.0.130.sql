--liquibase formatted sql

--changeset kfonbss:0.0.130-gateway-atom-razorpay
-- Subscriber online-recharge gateways in the gateway master (only PAYTM and BILLDESK existed).
INSERT INTO gateway (id, code, type, gateid)
SELECT next_ids.id, 'ATOM', 'Atom', next_ids.gateid
FROM (
  SELECT COALESCE(MAX(id), 0) + 1 AS id, COALESCE(MAX(gateid), 0) + 1 AS gateid FROM gateway
) next_ids
WHERE NOT EXISTS (
  SELECT 1 FROM gateway WHERE UPPER(TRIM(code)) = 'ATOM' OR UPPER(TRIM(type)) = 'ATOM'
);

INSERT INTO gateway (id, code, type, gateid)
SELECT next_ids.id, 'RAZORPAY', 'Razorpay', next_ids.gateid
FROM (
  SELECT COALESCE(MAX(id), 0) + 1 AS id, COALESCE(MAX(gateid), 0) + 1 AS gateid FROM gateway
) next_ids
WHERE NOT EXISTS (
  SELECT 1 FROM gateway WHERE UPPER(TRIM(code)) = 'RAZORPAY' OR UPPER(TRIM(type)) = 'RAZORPAY'
);

--changeset kfonbss:0.0.130-payment-gateway-availability
-- Which payment gateways a state offers, and to whom: SUBSCRIBER (online recharge) or PARTNER
-- (wallet top-up). state_code is the tenant state code (KFON resolves to KL). A gateway inside its
-- maintenance window is shown as maintenance_message instead of a payment option.
CREATE TABLE IF NOT EXISTS payment_gateway_availability (
  id                  UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  gateway_id          UUID NOT NULL REFERENCES gateway (gateway_id),
  state_code          VARCHAR(5) NOT NULL,
  user_type           VARCHAR(20) NOT NULL,
  is_active           BOOLEAN NOT NULL DEFAULT TRUE,
  display_name        VARCHAR(50),
  display_order       INT NOT NULL DEFAULT 1,
  maintenance_message VARCHAR(255),
  maintenance_from    TIMESTAMP,
  maintenance_to      TIMESTAMP,
  created_date        TIMESTAMP,
  created_by          UUID,
  modified_date       TIMESTAMP,
  modified_by         UUID,
  CONSTRAINT uq_payment_gateway_availability UNIQUE (state_code, gateway_id, user_type),
  CONSTRAINT ck_payment_gateway_availability_user_type CHECK (user_type IN ('SUBSCRIBER', 'PARTNER'))
);

CREATE INDEX IF NOT EXISTS idx_payment_gateway_availability_state_user
  ON payment_gateway_availability (state_code, user_type);

--changeset kfonbss:0.0.130-payment-gateway-availability-seed
-- Today's gateways, previously hard-coded in GatewayServiceImpl: subscribers ATOM and RAZORPAY,
-- partners BILLDESK and PAYTM, for the KL (KFON) and LD tenants.
INSERT INTO payment_gateway_availability
  (gateway_id, state_code, user_type, is_active, display_name, display_order, created_date)
SELECT g.gateway_id, s.state_code, v.user_type, TRUE, g.type, v.display_order, NOW()
FROM (VALUES
        ('ATOM', 'SUBSCRIBER', 1),
        ('RAZORPAY', 'SUBSCRIBER', 2),
        ('BILLDESK', 'PARTNER', 1),
        ('PAYTM', 'PARTNER', 2)
     ) AS v (code, user_type, display_order)
JOIN gateway g ON UPPER(TRIM(g.code)) = v.code
CROSS JOIN (VALUES ('KL'), ('LD')) AS s (state_code)
ON CONFLICT (state_code, gateway_id, user_type) DO NOTHING;
