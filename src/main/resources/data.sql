--
-- TOC entry 3841 (class 0 OID 14651287)
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "role" ("id", "role_name", "description") VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO "role" ("id", "role_name", "description") VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

--
-- TOC entry 3842 (class 0 OID 14651287)
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "user" ("id", "first_name", "last_name", "password", "username") VALUES (1, 'User', 'Test', 'password', 'user');
INSERT INTO "user" ("id", "first_name", "last_name", "password", "username") VALUES (2, 'Admin', 'Admin', 'password', 'admin');

--
-- TOC entry 3843 (class 0 OID 14651287)
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "user_role" ("user_id", "role_id") VALUES(1,1);
INSERT INTO "user_role" ("user_id", "role_id") VALUES(2,1);
INSERT INTO "user_role" ("user_id", "role_id") VALUES(2,2);

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
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (1, 'Cash', 0, 0, 0, 1);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (2, 'Petty Cash', 0, 0, 0, 1);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (3, 'Inventory', 0, 0, 0, 1);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (4, 'Pre-paid expenses', 0, 0, 0, 1);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (5, 'Leasehold', 0, 0, 0, 2);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (6, 'Property & land', 0, 0, 0, 2);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (7, 'Vehicles', 0, 0, 0, 2);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (8, 'Computer equipment', 0, 0, 0, 2);

INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (9, 'Credit cards payable', 0, 0, 0, 3);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (10, 'Accounts payable', 0, 0, 0, 3);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (11, 'Loans', 0, 0, 0, 4);

INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (12, 'Travel Expenses', 0, 0, 0, 7);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (13, 'Insurance', 0, 0, 0, 7);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (14, 'Advertising  & Promotion ', 0, 0, 0, 7);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (15, 'Product Sales', 0, 0, 0, 6);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (16, 'Other Income', 0, 0, 0, 6);
INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "totalBalance", "accountCategoryId") VALUES (17, 'Preferred Stock', 0, 0, 0, 5);
