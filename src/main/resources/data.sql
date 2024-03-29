--
-- TOC entry 3841 (class 0 OID 14651287)
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "role" ("id", "role_name", "description") VALUES (1,'ROLE_STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO "role" ("id", "role_name", "description") VALUES (2,'ROLE_ADMIN_USER', 'Admin User - Has permission to perform admin tasks');
--
-- --
-- -- TOC entry 3842 (class 0 OID 14651287)
-- -- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: -
-- --
INSERT INTO "user" ("id", "first_name", "last_name", "password", "username", "tenant_id") VALUES (1,'User', 'User', '{bcrypt}$2a$09$T6t3qjpZqXXiLoP/1Lv9UOESra9QJp9VVPRm5XY8f3Lxoo4gcsMwS', 'user', 'user');
INSERT INTO "user" ("id", "first_name", "last_name", "password", "username", "tenant_id") VALUES (2, 'Admin', 'Admin', '{bcrypt}$2a$09$6NQhK6rkbcjqg5tL4offo.Rf66M9XDJ.qPxN/BRjEH4MEWT420oP6', 'admin', 'admin');
--
-- --
-- -- TOC entry 3843 (class 0 OID 14651287)
-- -- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: -
-- --
INSERT INTO "user_role" ("user_id", "role_id") VALUES(1,1);
INSERT INTO "user_role" ("user_id", "role_id") VALUES(2,1);
INSERT INTO "user_role" ("user_id", "role_id") VALUES(2,2);
--
-- --
-- -- TOC entry 3852 (class 0 OID 14651210)
-- -- Dependencies: 198
-- -- Data for Name: account_type; Type: TABLE DATA; Schema: public; Owner: -
-- --
-- INSERT INTO "account_type" ("id", "name", "type") VALUES (1, 'Assets', false);
-- INSERT INTO "account_type" ("id", "name", "type") VALUES (2, 'Liabilties', true);
-- INSERT INTO "account_type" ("id", "name", "type") VALUES (3, 'Equity', false);
-- -- INSERT INTO "account_type" ("id", "name", "type") VALUES (4, 'Income ', true);
-- -- INSERT INTO "account_type" ("id", "name", "type") VALUES (5, 'Expense', true);
--
-- --
-- -- TOC entry 3851 (class 0 OID 14651207)
-- -- Dependencies: 197
-- -- Data for Name: account_category; Type: TABLE DATA; Schema: public; Owner: -
-- --
-- INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (1, 'Current Assets', 1);
-- INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (2, 'Fixed Assets', 1);
-- INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (3, 'Short-term Liabilities', 2);
-- INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (4, 'Long-term Liabilities', 2);
-- INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (5, 'Equity Sub-category', 3);
-- INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (6, 'Income', 1);
-- INSERT INTO "account_category" ("id", "name", "accountTypeId") VALUES (7, 'Expense', 2);
--
-- --
-- -- TOC entry 3853 (class 0 OID 14651287)
-- -- Dependencies: 197
-- -- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: -
-- --
delete from "account";
-- assets
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (1, 0, 0, 0, 'Fixed Asset', 0, 1, null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (2, 0, 0, 0, 'Other Asset', 0, 1, null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (3, 0, 0, 0, 'Other Current Asset', 0, 1, null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (4, 0, 0, 0, 'Cash', 0, 1, null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (5, 0, 0, 0, 'Bank', 0, 1, null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (6, 0, 0, 0, 'Stock', 0, 1, null);

-- Liability
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (20, 1, 0, 0, 'Other Current Liability', 0,1,null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (21, 1, 0, 0, 'Long Term Liability', 0,1,null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (22, 1, 0, 0, 'Tax Payable', 0,1,null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (23, 1, 0, 0, 'Credit Card', 0, 1, null);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (24, 1, 0, 0, 'Other Liability', 0, 1, null);

-- Equity
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (30, 2, 0, 0, 'Equity', 0, 1, null);

-- Income
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (40, 3, 0, 0, 'Income', 0, 1, null);

-- Expense
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (50, 4, 0, 0, 'Expense', 0, 1, null);



INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (60, 0, 0, 0,'Advance Tax',		0, 0, 3);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (61, 0, 0, 0,'Prepaid Expenses',		0, 0, 3);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (62, 0, 0, 0,'Employee Advance',		0, 0, 3);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (63, 0, 0, 0,'Undeposited Funds',		0, 0, 4);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (64, 0, 0, 0,'Petty Cash',		0, 0, 4);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (65, 0, 0, 0,'Chase Bank',		0, 0, 5);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (66, 0, 0, 0,'Accounts Receivable',		0, 0, 6);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (67, 0, 0, 0,'Furniture, and Equipment',		0, 0, 1);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (68, 1, 0, 0,'Tax Payable',		0, 0, 20);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (69, 1, 0, 0,'Unearned Revenue',		0, 0, 20);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (70, 1, 0, 0, 'Opening, Balance Adjustments',		0, 0, 20);
INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "isCategoryAccount", "parentId" ) VALUES (71, 1, 0, 0,'Employee Reimbursements',		0, 0, 20);




-- INSERT INTO "account" ("id", "accountType", "creditBalance", "debtBalance", "name", "isUserDefined", "parentId" ) VALUES (10, 2, 0, 0, 'Equity', 0, null);


-- {
--       "account_group_formatted": "Equity",
--       "account_type": "equity",
--       "account_type_formatted": "Equity",
--       "account_group": "equity"
--     },
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (1, 'Cash', 0, 0, 0, 1);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (2, 'Petty Cash', 0, 0, 0, 1);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (3, 'Bank', 0, 0, 0, 1);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (4, 'Inventory', 0, 0, 0, 1);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (5, 'Pre-paid expenses', 0, 0, 0, 1);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (6, 'Leasehold', 0, 0, 0, 2);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (7, 'Property & land', 0, 0, 0, 2);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (8, 'Vehicles', 0, 0, 0, 2);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (9, 'Computer equipment', 0, 0, 0, 2);
--
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (10, 'Credit cards payable', 0, 0, 0, 3);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (11, 'Accounts payable', 0, 0, 0, 3);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (12, 'Loans', 0, 0, 0, 4);
--
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (13, 'Travel Expenses', 0, 0, 0, 7);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (14, 'Insurance', 0, 0, 0, 7);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (15, 'Advertising  & Promotion ', 0, 0, 0, 7);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (16, 'Product Sales', 0, 0, 0, 6);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (17, 'Other Income', 0, 0, 0, 6);
-- INSERT INTO "account" ("id", "name", "creditBalance", "debtBalance", "isUserDefined", "accountCategoryId") VALUES (18, 'Preferred Stock', 0, 0, 0, 5);
--
-- --
-- -- TOC entry 3854 (class 0 OID 14651287)
-- -- Dependencies: 197
-- -- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: -
-- --
-- INSERT INTO "journal" ("id", "date", "status" ) VALUES (1, CURRENT_TIMESTAMP(), 0);
--
--
-- --
-- -- TOC entry 3855 (class 0 OID 14651287)
-- -- Dependencies: 197
-- -- Data for Name: journal_detail; Type: TABLE DATA; Schema: public; Owner: -
-- --
-- INSERT INTO "journal_detail" ("id", "debt", "credit", "accountId", "journalId" ) VALUES (1, 100, 100, 1, 1);
