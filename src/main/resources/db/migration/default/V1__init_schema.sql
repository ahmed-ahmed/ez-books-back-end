SET IGNORECASE 1;

CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_A649BE84_B443_46D6_8100_95E818414F39" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_5D6A6CED_114C_4C6D_ACA3_25CF7714F097" START WITH 10 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_FFE6A045_E955_4DD9_9ED9_EDDB5527C76E" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_2AB730D7_38B6_4A25_BBBD_C170AC6A2A7D" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_071CFBF0_EF1E_4E28_B2CE_5BB65D0B125F" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_C1EDF288_6D09_47C3_AD5E_C2FBA5FECFCC" START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_C1EDF288_6D09_47C3_AD5E_C2FCOSOMJAVA" START WITH 100 BELONGS_TO_TABLE;
CREATE TABLE "PUBLIC"."account"(
    "id" BIGINT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_C1EDF288_6D09_47C3_AD5E_C2FCOSOMJAVA") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_C1EDF288_6D09_47C3_AD5E_C2FCOSOMJAVA",
    "accountType" INTEGER,
    "creditBalance" DOUBLE,
    "debtBalance" DOUBLE,
    "name" VARCHAR_IGNORECASE(255),
    "isUserDefined" BOOLEAN,
    "isCategoryAccount" BOOLEAN,
    "parentId" BIGINT
);
ALTER TABLE "PUBLIC"."account" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_B" PRIMARY KEY("id");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.account;
CREATE TABLE "PUBLIC"."customer"(
    "id" BIGINT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_A649BE84_B443_46D6_8100_95E818414F39") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_A649BE84_B443_46D6_8100_95E818414F39",
    "address" VARCHAR_IGNORECASE(255),
    "company" VARCHAR_IGNORECASE(255),
    "emailAddress" VARCHAR_IGNORECASE(255),
    "name" VARCHAR_IGNORECASE(255),
    "phoneNumber" VARCHAR_IGNORECASE(255)
);
ALTER TABLE "PUBLIC"."customer" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("id");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.customer;
CREATE TABLE "PUBLIC"."journal"(
    "id" BIGINT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_2AB730D7_38B6_4A25_BBBD_C170AC6A2A7D") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_2AB730D7_38B6_4A25_BBBD_C170AC6A2A7D",
    "date" DATE NOT NULL,
    "notes" VARCHAR_IGNORECASE(255),
    "status" INTEGER
);
ALTER TABLE "PUBLIC"."journal" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A" PRIMARY KEY("id");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.journal;
CREATE TABLE "PUBLIC"."journal_detail"(
    "id" BIGINT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_FFE6A045_E955_4DD9_9ED9_EDDB5527C76E") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_FFE6A045_E955_4DD9_9ED9_EDDB5527C76E",
    "accountId" BIGINT,
    "credit" DOUBLE,
    "debt" DOUBLE,
    "journalId" BIGINT
);
ALTER TABLE "PUBLIC"."journal_detail" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D" PRIMARY KEY("id");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.journal_detail;
CREATE TABLE "PUBLIC"."product"(
    "id" BIGINT DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_C1EDF288_6D09_47C3_AD5E_C2FBA5FECFCC") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_C1EDF288_6D09_47C3_AD5E_C2FBA5FECFCC",
    "description" VARCHAR_IGNORECASE(255),
    "name" VARCHAR_IGNORECASE(255),
    "price" DOUBLE
);
ALTER TABLE "PUBLIC"."product" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_E" PRIMARY KEY("id");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.product;


CREATE TABLE "PUBLIC"."role"(
    "id" BIGINT NOT NULL,
    "description" VARCHAR_IGNORECASE(255),
    "role_name" VARCHAR_IGNORECASE(255)
);
ALTER TABLE "PUBLIC"."role" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("id");
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.role;
CREATE TABLE "PUBLIC"."user"(
    "id" BIGINT NOT NULL,
    "first_name" VARCHAR_IGNORECASE(255),
    "last_name" VARCHAR_IGNORECASE(255),
    "password" VARCHAR_IGNORECASE(255),
    "tenant_id" VARCHAR_IGNORECASE(255),
    "username" VARCHAR_IGNORECASE(255)
);
ALTER TABLE "PUBLIC"."user" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_36" PRIMARY KEY("id");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.user;
CREATE TABLE "PUBLIC"."user_role"(
    "user_id" BIGINT NOT NULL,
    "role_id" BIGINT NOT NULL
);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.user_role;
ALTER TABLE "PUBLIC"."user_role" ADD CONSTRAINT "PUBLIC"."FKka3w3atry4amefp94rblb52n7" FOREIGN KEY("role_id") REFERENCES "PUBLIC"."role"("id") NOCHECK;
ALTER TABLE "PUBLIC"."user_role" ADD CONSTRAINT "PUBLIC"."FKhjx9nk20h4mo745tdqj8t8n9d" FOREIGN KEY("user_id") REFERENCES "PUBLIC"."user"("id") NOCHECK;
ALTER TABLE "PUBLIC"."account" ADD CONSTRAINT "PUBLIC"."FKrekid6sjpksp58m22flmfwc4m" FOREIGN KEY("parentId") REFERENCES "PUBLIC"."account"("id") NOCHECK;
ALTER TABLE "PUBLIC"."journal_detail" ADD CONSTRAINT "PUBLIC"."FKc9omyrc8ryfcjptnklxr3m821" FOREIGN KEY("journalId") REFERENCES "PUBLIC"."journal"("id") NOCHECK;
