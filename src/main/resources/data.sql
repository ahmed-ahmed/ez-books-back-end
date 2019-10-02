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
-- Data for Name: account_categories; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO "account_categories" ("id", "name", "accountTypeId") VALUES (1, 'Bank', 1);
INSERT INTO "account_categories" ("id", "name", "accountTypeId") VALUES (3, 'Equity', 3);
INSERT INTO "account_categories" ("id", "name", "accountTypeId") VALUES (2, 'Cash', 1);

--
-- TOC entry 3853 (class 0 OID 14651287)
-- Dependencies: 197
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (1, 'Chase Bank', 0, 0, 0, 1);
