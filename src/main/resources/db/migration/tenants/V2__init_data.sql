--
-- TOC entry 3852 (class 0 OID 14651210)
-- Dependencies: 198
-- Data for Name: account_type; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "account_type" ("id", "name", "type") VALUES (2, 'Liabilties', true);
INSERT INTO "account_type" ("id", "name", "type") VALUES (1, 'Assets', false);
INSERT INTO "account_type" ("id", "name", "type") VALUES (3, 'Equity', false);
INSERT INTO "account_type" ("id", "name", "type") VALUES (4, 'Income ', true);
INSERT INTO "account_type" ("id", "name", "type") VALUES (5, 'Expense', true);

--
-- TOC entry 3851 (class 0 OID 14651207)
-- Dependencies: 197
-- Data for Name: account_category; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (1, 'Current Assets', 1);
INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (2, 'Fixed Assets', 1);
INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (3, 'Short-term Liabilities', 2);
INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (4, 'Long-term Liabilities', 2);
INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (5, 'Equity Sub-category', 3);
INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (6, 'Income', 4);
INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (7, 'All Expense', 5);

--
-- TOC entry 3853 (class 0 OID 14651287)
-- Dependencies: 197
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (1, 'Cash', 0, 0, 0, 1);
