--liquibase formatted sql

--changeset kfonbss:0.0.132-payment-gateway-availability-swap-kl-kfon
-- The KL and KFON gateway rows were entered the wrong way round: the KFON gateways (HDFC, IKM)
-- sat under KL, and the KL gateways (ATOM, RAZORPAY, BILLDESK, PAYTM) under KFON. Swap the two
-- tenants' rows; display order, maintenance window and active flag move with each row.
UPDATE payment_gateway_availability SET state_code = 'XKL' WHERE state_code = 'KL';
UPDATE payment_gateway_availability SET state_code = 'KL' WHERE state_code = 'KFON';
UPDATE payment_gateway_availability SET state_code = 'KFON' WHERE state_code = 'XKL';

--changeset kfonbss:0.0.132-payment-gateway-availability-kfon-seed
-- On a database where KFON only got the copy of KL from 0.0.131 (so the swap above changed
-- nothing), give KFON its own gateways: subscribers HDFC and IKM, partners HDFC, IKM and PAYTM_NEW.
DELETE FROM payment_gateway_availability a
USING gateway g
WHERE a.gateway_id = g.gateway_id
  AND a.state_code = 'KFON'
  AND UPPER(TRIM(g.code)) IN ('ATOM', 'RAZORPAY', 'BILLDESK', 'PAYTM');

INSERT INTO payment_gateway_availability
  (gateway_id, state_code, user_type, is_active, display_name, display_order, created_date)
SELECT g.gateway_id, 'KFON', v.user_type, TRUE, g.type, v.display_order, NOW()
FROM (VALUES
        ('HDFC', 'SUBSCRIBER', 1),
        ('IKM', 'SUBSCRIBER', 2),
        ('HDFC', 'PARTNER', 1),
        ('IKM', 'PARTNER', 2),
        ('PAYTM_NEW', 'PARTNER', 3)
     ) AS v (code, user_type, display_order)
JOIN gateway g ON UPPER(TRIM(g.code)) = v.code
ON CONFLICT (state_code, gateway_id, user_type) DO NOTHING;
