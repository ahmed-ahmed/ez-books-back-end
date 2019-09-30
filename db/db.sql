PGDMP         '                w           ezbook    11.5    11.5 $    x           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            y           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            z           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            {           1262    16393    ezbook    DATABASE     d   CREATE DATABASE ezbook WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C';
    DROP DATABASE ezbook;
             postgres    false            �            1259    16593    Account    TABLE     �   CREATE TABLE public."Account" (
    id bigint NOT NULL,
    "creditBalance" numeric(19,2),
    "debtBalance" numeric(19,2),
    name character varying(255),
    "totalBalance" numeric(19,2)
);
    DROP TABLE public."Account";
       public         postgres    false            �            1259    16399    AccountCategories    TABLE     �   CREATE TABLE public."AccountCategories" (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    "accountTypeId" bigint NOT NULL
);
 '   DROP TABLE public."AccountCategories";
       public         postgres    false            �            1259    16394    AccountType    TABLE     �   CREATE TABLE public."AccountType" (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    type boolean NOT NULL
);
 !   DROP TABLE public."AccountType";
       public         postgres    false            �            1259    16417    Journal    TABLE     R   CREATE TABLE public."Journal" (
    id bigint NOT NULL,
    date date NOT NULL
);
    DROP TABLE public."Journal";
       public         postgres    false            �            1259    16422    JournalDetail    TABLE     �   CREATE TABLE public."JournalDetail" (
    id bigint NOT NULL,
    "journalId" bigint,
    debt numeric,
    credit numeric,
    "accountId" bigint
);
 #   DROP TABLE public."JournalDetail";
       public         postgres    false            �            1259    16568    account    TABLE     �   CREATE TABLE public.account (
    id bigint NOT NULL,
    credit_balance numeric(19,2),
    debt_balance numeric(19,2),
    name character varying(255),
    total_balance numeric(19,2)
);
    DROP TABLE public.account;
       public         postgres    false            �            1259    16573    account_categories    TABLE     d   CREATE TABLE public.account_categories (
    id bigint NOT NULL,
    name character varying(255)
);
 &   DROP TABLE public.account_categories;
       public         postgres    false            �            1259    16578    account_type    TABLE     p   CREATE TABLE public.account_type (
    id bigint NOT NULL,
    name character varying(255),
    type boolean
);
     DROP TABLE public.account_type;
       public         postgres    false            �            1259    16583    journal    TABLE     G   CREATE TABLE public.journal (
    id bigint NOT NULL,
    date date
);
    DROP TABLE public.journal;
       public         postgres    false            �            1259    16588    journal_detail    TABLE     q   CREATE TABLE public.journal_detail (
    id bigint NOT NULL,
    credit numeric(19,2),
    debt numeric(19,2)
);
 "   DROP TABLE public.journal_detail;
       public         postgres    false            u          0    16593    Account 
   TABLE DATA               ]   COPY public."Account" (id, "creditBalance", "debtBalance", name, "totalBalance") FROM stdin;
    public       postgres    false    205   �%       m          0    16399    AccountCategories 
   TABLE DATA               H   COPY public."AccountCategories" (id, name, "accountTypeId") FROM stdin;
    public       postgres    false    197   &       l          0    16394    AccountType 
   TABLE DATA               7   COPY public."AccountType" (id, name, type) FROM stdin;
    public       postgres    false    196   O&       n          0    16417    Journal 
   TABLE DATA               -   COPY public."Journal" (id, date) FROM stdin;
    public       postgres    false    198   �&       o          0    16422    JournalDetail 
   TABLE DATA               U   COPY public."JournalDetail" (id, "journalId", debt, credit, "accountId") FROM stdin;
    public       postgres    false    199   �&       p          0    16568    account 
   TABLE DATA               X   COPY public.account (id, credit_balance, debt_balance, name, total_balance) FROM stdin;
    public       postgres    false    200   �&       q          0    16573    account_categories 
   TABLE DATA               6   COPY public.account_categories (id, name) FROM stdin;
    public       postgres    false    201   �&       r          0    16578    account_type 
   TABLE DATA               6   COPY public.account_type (id, name, type) FROM stdin;
    public       postgres    false    202   '       s          0    16583    journal 
   TABLE DATA               +   COPY public.journal (id, date) FROM stdin;
    public       postgres    false    203   6'       t          0    16588    journal_detail 
   TABLE DATA               :   COPY public.journal_detail (id, credit, debt) FROM stdin;
    public       postgres    false    204   S'       �           2606    16403 (   AccountCategories AccountCategories_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public."AccountCategories"
    ADD CONSTRAINT "AccountCategories_pkey" PRIMARY KEY (id);
 V   ALTER TABLE ONLY public."AccountCategories" DROP CONSTRAINT "AccountCategories_pkey";
       public         postgres    false    197            �           2606    16398    AccountType AccountType_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public."AccountType"
    ADD CONSTRAINT "AccountType_pkey" PRIMARY KEY (id);
 J   ALTER TABLE ONLY public."AccountType" DROP CONSTRAINT "AccountType_pkey";
       public         postgres    false    196            �           2606    16597    Account Account_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Account"
    ADD CONSTRAINT "Account_pkey" PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."Account" DROP CONSTRAINT "Account_pkey";
       public         postgres    false    205            �           2606    16429     JournalDetail JournalDetail_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."JournalDetail"
    ADD CONSTRAINT "JournalDetail_pkey" PRIMARY KEY (id);
 N   ALTER TABLE ONLY public."JournalDetail" DROP CONSTRAINT "JournalDetail_pkey";
       public         postgres    false    199            �           2606    16421    Journal Journal_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."Journal"
    ADD CONSTRAINT "Journal_pkey" PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."Journal" DROP CONSTRAINT "Journal_pkey";
       public         postgres    false    198            �           2606    16577 *   account_categories account_categories_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.account_categories
    ADD CONSTRAINT account_categories_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.account_categories DROP CONSTRAINT account_categories_pkey;
       public         postgres    false    201            �           2606    16572    account account_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public         postgres    false    200            �           2606    16582    account_type account_type_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.account_type
    ADD CONSTRAINT account_type_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.account_type DROP CONSTRAINT account_type_pkey;
       public         postgres    false    202            �           2606    16592 "   journal_detail journal_detail_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.journal_detail
    ADD CONSTRAINT journal_detail_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.journal_detail DROP CONSTRAINT journal_detail_pkey;
       public         postgres    false    204            �           2606    16587    journal journal_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.journal DROP CONSTRAINT journal_pkey;
       public         postgres    false    203            �           2606    16404     AccountCategories accountType_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public."AccountCategories"
    ADD CONSTRAINT "accountType_fk" FOREIGN KEY ("accountTypeId") REFERENCES public."AccountType"(id);
 N   ALTER TABLE ONLY public."AccountCategories" DROP CONSTRAINT "accountType_fk";
       public       postgres    false    3038    197    196            �           2606    16435    JournalDetail journal_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public."JournalDetail"
    ADD CONSTRAINT journal_fk FOREIGN KEY ("journalId") REFERENCES public."Journal"(id);
 D   ALTER TABLE ONLY public."JournalDetail" DROP CONSTRAINT journal_fk;
       public       postgres    false    3042    199    198            u      x������ � �      m   )   x�3�tJ���4�2�t-,�,��4�2�tN,� ���qqq �A�      l   F   x�3���LL��)�L-�,�2�t,.N-)�L�2�t-,�,�2M8=��sS�*L9]+
R�S��=... ���      n      x������ � �      o      x������ � �      p      x������ � �      q      x������ � �      r      x������ � �      s      x������ � �      t      x������ � �     