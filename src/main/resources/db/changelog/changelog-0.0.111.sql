-- Table: sys_config
CREATE TABLE sys_config (
  id UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
  tenant_id VARCHAR(10) NOT NULL UNIQUE,
  aaa_ip VARCHAR(50) NOT NULL,
  is_active BOOLEAN DEFAULT TRUE NOT NULL
);

INSERT INTO sys_config (tenant_id, aaa_ip, is_active) VALUES
  ('KL', 'newsouthrad', TRUE),
  ('PY', 'newsouthrad', TRUE),
  ('LD', 'newsouthrad', TRUE);
