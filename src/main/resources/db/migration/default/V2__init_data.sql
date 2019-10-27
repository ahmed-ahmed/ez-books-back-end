--
-- TOC entry 3841 (class 0 OID 14651287)
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: -
--
INSERT INTO "PUBLIC"."role" ("id", "role_name", "description") VALUES (1,'ROLE_STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO "PUBLIC"."role" ("id", "role_name", "description") VALUES (2,'ROLE_ADMIN_USER', 'Admin User - Has permission to perform admin tasks');
--
-- --
-- -- TOC entry 3842 (class 0 OID 14651287)
-- -- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: -
-- --
INSERT INTO "PUBLIC"."user" ("id", "first_name", "last_name", "password", "username", "tenant_id") VALUES (1,'User', 'User', '{bcrypt}$2a$09$T6t3qjpZqXXiLoP/1Lv9UOESra9QJp9VVPRm5XY8f3Lxoo4gcsMwS', 'user', 'user');
INSERT INTO "PUBLIC"."user" ("id", "first_name", "last_name", "password", "username", "tenant_id") VALUES (2, 'Admin', 'Admin', '{bcrypt}$2a$09$6NQhK6rkbcjqg5tL4offo.Rf66M9XDJ.qPxN/BRjEH4MEWT420oP6', 'admin', 'admin');
--
-- --
-- -- TOC entry 3843 (class 0 OID 14651287)
-- -- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: -
-- --
INSERT INTO "PUBLIC"."user_role" ("user_id", "role_id") VALUES(1,1);
INSERT INTO "PUBLIC"."user_role" ("user_id", "role_id") VALUES(2,1);
INSERT INTO "PUBLIC"."user_role" ("user_id", "role_id") VALUES(2,2);
