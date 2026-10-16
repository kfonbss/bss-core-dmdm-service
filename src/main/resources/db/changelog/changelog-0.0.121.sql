--liquibase formatted sql

--changeset kfonbss:0.0.121-invoice-statecode-seed
-- invoice_statecode was created empty by changelog-0.0.90.sql, with no owning entity/endpoint
-- until now (see in.gov.kfon.dmdm.model.InvoiceStateCode). Seed data is the full GST-code ->
-- postal-abbreviation mapping, copied 1:1 from the live legacy MySQL table
-- billing_master.state_district (verified directly via `SHOW CREATE TABLE` + a live distinct
-- SELECT) — legacy's STCode column confusingly holds the numeric GST code and its statecode
-- column holds the 3-letter abbreviation. Mapped here onto this table's own state_code (numeric
-- GST code, the lookup key) / stcode (3-letter abbreviation, the result) columns. Legacy itself
-- has no row for GST codes 28 or 38 (pre-bifurcation AP / Ladakh) — not fabricated here either.
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('59fee1d7-683c-40f9-a8d1-737a006424cc', 'JK', '01');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('6540d7d1-a74a-4d61-ac4c-bcc82ba6724b', 'HP', '02');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('513a855c-61c0-480a-a03f-1bf7b41f342d', 'PB', '03');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('f74ad57b-7a98-4a04-8aaf-6781240cb871', 'CH', '04');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('c7906f13-164c-4db3-bceb-5469c0978648', 'UT', '05');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('16932d3b-c090-4cc9-a5d3-ff611571e50c', 'HR', '06');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('84ee6a9f-7d34-487d-9f5c-88626a44ddb3', 'DL', '07');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('6a7e3f1b-4854-4720-bdbd-9fbca9154d37', 'RJ', '08');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('4e22cf58-0f40-4863-aa98-6c8ac170a7d7', 'UP', '09');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('52673f95-2a74-4706-8d36-ca927f285d18', 'BH', '10');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('6f32ea71-24e0-418a-bafd-4da6897deb35', 'SK', '11');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('81704036-6cdd-4214-9e1f-e8a99e40c8eb', 'AR', '12');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('e52fa1cb-cb30-443c-b265-9be87a99f471', 'NL', '13');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('876278a8-6547-49d4-bbca-77e97084bc0d', 'MN', '14');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('36f44fbf-68b5-4fe4-bc4c-cdee711faa17', 'MZ', '15');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('70ac7d1e-bb69-4f96-acc5-72a4b364f849', 'TR', '16');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('0b0aba7f-8ec9-47b5-9252-f7a09ff20897', 'ML', '17');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('f9bb4636-6e27-4ae3-bd55-92edb9ad477b', 'AS', '18');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('4f97f21c-11f8-4004-bff9-71afe2ab5f8c', 'WB', '19');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('11d663da-ddff-4c3f-bb85-1e404b30c48b', 'JH', '20');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('1046fc64-5431-4bdd-8d4f-a3d98993103a', 'OD', '21');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('33fd3245-fe52-4269-87ff-928e06614119', 'CG', '22');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('e3445379-bb98-48de-b5fc-5f673713f279', 'MP', '23');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('b22e7081-6cfe-4995-bf9a-fe47816302a7', 'GJ', '24');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('ef5167f0-6ac5-494b-867d-6b35687f89b3', 'DD', '25');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('751bc4da-e0d2-4fed-808b-49a9d1192897', 'DN', '26');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('039ca490-d386-43f9-ad44-937c64c0e4fa', 'MH', '27');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('5dd65213-ab12-4a19-a5f5-2c455807019b', 'KA', '29');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('0da0f57a-deb4-4299-8eec-85fc45d2786a', 'GA', '30');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('717193fc-9bc7-4459-b07a-332f03255087', 'LD', '31');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('a7d20f1d-d283-4613-9ce7-3afc9c999414', 'KL', '32');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('12ead88b-1e17-413e-bf05-62baafca1b56', 'TN', '33');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('6f2cd10d-3deb-4eea-9744-963a193897c8', 'PY', '34');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('5a90d384-9561-4827-a374-062ed1bcc873', 'AN', '35');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('ce252dfe-2a70-4518-bbff-48d9245eebbf', 'TS', '36');
INSERT INTO invoice_statecode (invoice_statecode_id, stcode, state_code) VALUES ('41bf6adb-e2e7-4c92-ad7e-69f3f45ec9ba', 'AP', '37');
