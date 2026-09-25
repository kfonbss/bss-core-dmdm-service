-- Company Nature master table (replaces the hardcoded CompanyNature enum in user-role-mapping service)
-- Referenced by partnerdetail.companynatureid (added in user-role-mapping service changelog-0.0.74)
CREATE TABLE IF NOT EXISTS company_nature (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  code VARCHAR(64) NOT NULL UNIQUE,
  name VARCHAR(128) NOT NULL,
  display_order INT DEFAULT 0,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO company_nature (code, name, display_order, is_active, created_date) VALUES
  ('AOP', 'AOP', 1, TRUE, NOW()),
  ('BOI', 'BOI', 2, TRUE, NOW()),
  ('PRIVATE_LIMITED', 'Private Limited', 3, TRUE, NOW()),
  ('PROPRIETORSHIP', 'Proprietorship', 4, TRUE, NOW()),
  ('PARTNERSHIP', 'Partnership', 5, TRUE, NOW()),
  ('PUBLIC_LIMITED', 'Public Limited', 6, TRUE, NOW()),
  ('HUF', 'HUF', 7, TRUE, NOW()),
  ('TRUST', 'Trust', 8, TRUE, NOW()),
  ('LLP', 'LLP', 9, TRUE, NOW())
ON CONFLICT (code) DO NOTHING;

-- Bank Account Type master table (replaces the hardcoded BankAccountType enum in user-role-mapping service)
-- Referenced by partnerdetail.bankactypeid (added in user-role-mapping service changelog-0.0.74)
CREATE TABLE IF NOT EXISTS bank_account_type (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  code VARCHAR(64) NOT NULL UNIQUE,
  name VARCHAR(128) NOT NULL,
  display_order INT DEFAULT 0,
  is_active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP,
  modified_date TIMESTAMP,
  created_by UUID,
  modified_by UUID
);

INSERT INTO bank_account_type (code, name, display_order, is_active, created_date) VALUES
  ('SB', 'SB', 1, TRUE, NOW()),
  ('CA', 'CA', 2, TRUE, NOW()),
  ('CB', 'CB', 3, TRUE, NOW())
ON CONFLICT (code) DO NOTHING;
