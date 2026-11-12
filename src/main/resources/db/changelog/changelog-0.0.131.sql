--liquibase formatted sql

--changeset kfonbss:0.0.131-payment-gateway-availability-kfon
-- KFON is its own tenant for payment gateways, separate from KL (payment gateway lookups use the
-- tenant code as sent, without the KFON -> KL mapping the shared Kerala masters use). Starts with
-- the same gateways as KL: subscribers ATOM and RAZORPAY, partners BILLDESK and PAYTM.
INSERT INTO payment_gateway_availability
  (gateway_id, state_code, user_type, is_active, display_name, display_order, created_date)
SELECT g.gateway_id, 'KFON', v.user_type, TRUE, g.type, v.display_order, NOW()
FROM (VALUES
        ('ATOM', 'SUBSCRIBER', 1),
        ('RAZORPAY', 'SUBSCRIBER', 2),
        ('BILLDESK', 'PARTNER', 1),
        ('PAYTM', 'PARTNER', 2)
     ) AS v (code, user_type, display_order)
JOIN gateway g ON UPPER(TRIM(g.code)) = v.code
ON CONFLICT (state_code, gateway_id, user_type) DO NOTHING;
