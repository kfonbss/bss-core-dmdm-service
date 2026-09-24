-- Payout Payment Mode and Charges master tables
-- payout_payment_mode: IMPS, NEFT, RTGS payment modes available for partner payouts
-- payout_charges: tiered charge rates per mode (mirrors PHP payoutcharges table)
--   start_range=0 and end_range=0 means flat rate with no range restriction
--   end_range=0 means no upper limit

CREATE TABLE payout_payment_mode (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  mode_code VARCHAR(20) NOT NULL UNIQUE,
  mode_name VARCHAR(100) NOT NULL,
  display_order INT DEFAULT 0,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE TABLE payout_charges (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  mode VARCHAR(20) NOT NULL,
  start_range DECIMAL(15,2) NOT NULL DEFAULT 0,
  end_range DECIMAL(15,2) NOT NULL DEFAULT 0,
  rate DECIMAL(10,4) NOT NULL DEFAULT 0,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

CREATE INDEX idx_payout_charges_mode ON payout_charges(mode);

-- Seed: payment modes
INSERT INTO payout_payment_mode (mode_code, mode_name, display_order, is_active) VALUES
  ('IMPS', 'IMPS - Immediate Payment Service', 1, TRUE),
  ('NEFT', 'NEFT - National Electronic Funds Transfer', 2, TRUE),
  ('RTGS', 'RTGS - Real Time Gross Settlement', 3, TRUE);
