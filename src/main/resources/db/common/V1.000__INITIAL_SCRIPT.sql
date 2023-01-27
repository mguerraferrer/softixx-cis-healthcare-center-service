DROP EXTENSION IF EXISTS pgcrypto;
CREATE EXTENSION pgcrypto;

-- SCHEMA: common
DROP SCHEMA IF EXISTS common CASCADE;
CREATE SCHEMA common
    AUTHORIZATION postgres;
	
-- Table: common.clinical_entity
DROP SEQUENCE IF EXISTS common.clinical_entity_id_seq;
CREATE SEQUENCE common.clinical_entity_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity;
CREATE TABLE common.clinical_entity
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_id_seq'::regclass),
    name bytea,
    business_name bytea,
    logo character varying(250) COLLATE pg_catalog."default",
    hash character varying(50) COLLATE pg_catalog."default",
    active boolean DEFAULT false,
    CONSTRAINT clinical_entity_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_uq UNIQUE (business_name)

)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity
    OWNER to postgres;

-- Table: common.clinical_entity_access_info
DROP SEQUENCE IF EXISTS common.clinical_entity_access_info_id_seq;
CREATE SEQUENCE common.clinical_entity_access_info_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_access_info_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_access_info;
CREATE TABLE common.clinical_entity_access_info
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_access_info_id_seq'::regclass),
    clinical_entity_id bigint NOT NULL,
    profile_id bigint NOT NULL,
    access_level_id bigint NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_access_info_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_access_info_uq UNIQUE (clinical_entity_id, profile_id),
    CONSTRAINT clinical_entity_access_info_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_access_info
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_access_info_idx1;
CREATE INDEX clinical_entity_access_info_idx1
    ON common.clinical_entity_access_info USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_access_info_idx2;
CREATE INDEX clinical_entity_access_info_idx2
    ON common.clinical_entity_access_info USING btree
    (profile_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_access_info_idx3;
CREATE INDEX clinical_entity_access_info_idx3
    ON common.clinical_entity_access_info USING btree
    (access_level_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_address
DROP SEQUENCE IF EXISTS common.clinical_entity_address_id_seq;
CREATE SEQUENCE common.clinical_entity_address_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_address_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_address;
CREATE TABLE common.clinical_entity_address
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_address_id_seq'::regclass),
    clinical_entity_id bigint NOT NULL,
    colony_mx_id bigint NOT NULL,
    street bytea,
    btw_street bytea,
    outside_number bytea,
    inside_number bytea,
    reference bytea,
    lat bytea,
    lon bytea,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_address_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_address_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_address
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_address_idx1;
CREATE INDEX clinical_entity_address_idx1
    ON common.clinical_entity_address USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_address_idx2;
CREATE INDEX clinical_entity_address_idx2
    ON common.clinical_entity_address USING btree
    (colony_mx_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_connection_info
DROP SEQUENCE IF EXISTS common.clinical_entity_connection_info_id_seq;
CREATE SEQUENCE common.clinical_entity_connection_info_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_connection_info_id_seq
    OWNER TO postgres;

DROP TABLE IF EXISTS common.clinical_entity_connection_info;
CREATE TABLE common.clinical_entity_connection_info
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_connection_info_id_seq'::regclass),
    clinical_entity_access_info_id bigint NOT NULL,
    ip character varying(20) COLLATE pg_catalog."default",
    ip_range_start character varying(20) COLLATE pg_catalog."default",
    ip_range_end character varying(20) COLLATE pg_catalog."default",
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_connection_info_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_connection_info_uq UNIQUE (clinical_entity_access_info_id),
    CONSTRAINT clinical_entity_connection_info_fk FOREIGN KEY (clinical_entity_access_info_id)
        REFERENCES common.clinical_entity_access_info (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_connection_info
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_connection_info_idx;
CREATE INDEX entidad_clinica_informacion_conexion_idx1
    ON common.clinical_entity_connection_info USING btree
    (clinical_entity_access_info_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_contact_info
DROP SEQUENCE IF EXISTS common.clinical_entity_contact_info_id_seq;
CREATE SEQUENCE common.clinical_entity_contact_info_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_contact_info_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_contact_info;
CREATE TABLE common.clinical_entity_contact_info
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_contact_info_id_seq'::regclass),
    clinical_entity_id bigint NOT NULL,
    phone1 bytea,
    phone2 bytea,
    phone3 bytea,
    email1 bytea,
    email2 bytea,
    email3 bytea,
    web bytea,
    blog bytea,
    facebook bytea,
    twitter bytea,
    instagram bytea,
    linkedin bytea,
    youtube bytea,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_contact_info_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_contact_info_uq UNIQUE (clinical_entity_id),
    CONSTRAINT clinical_entity_contact_info_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_contact_info
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_contact_info_idx1;
CREATE INDEX clinical_entity_contact_info_idx
    ON common.clinical_entity_contact_info USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_custom_role
DROP SEQUENCE IF EXISTS common.clinical_entity_custom_role_id_seq;
CREATE SEQUENCE common.clinical_entity_custom_role_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_custom_role_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_custom_role;
CREATE TABLE common.clinical_entity_custom_role
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_custom_role_id_seq'::regclass),
    clinical_entity_id bigint NOT NULL,
    code character varying(100) COLLATE pg_catalog."default",
    value character varying(100) COLLATE pg_catalog."default",
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_custom_role_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_custom_role_uq UNIQUE (code, value),
    CONSTRAINT clinical_entity_custom_role_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_custom_role
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_custom_role_idx1;
CREATE INDEX clinical_entity_custom_role_idx1
    ON common.clinical_entity_custom_role USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_employment_info
DROP SEQUENCE IF EXISTS common.clinical_entity_employment_info_id_seq;
CREATE SEQUENCE common.clinical_entity_employment_info_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_employment_info_id_seq
    OWNER TO postgres;

DROP TABLE IF EXISTS common.clinical_entity_employment_info;
CREATE TABLE common.clinical_entity_employment_info
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_employment_info_id_seq'::regclass),
    clinical_entity_access_info_id bigint NOT NULL,
    working_day character varying(10) COLLATE pg_catalog."default",
    working_days character varying(100) COLLATE pg_catalog."default",
    start_time time without time zone,
    end_time time without time zone,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_employment_info_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_employment_info_uq UNIQUE (clinical_entity_access_info_id),
    CONSTRAINT clinical_entity_employment_info_fk1 FOREIGN KEY (clinical_entity_access_info_id)
        REFERENCES common.clinical_entity_access_info (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_employment_info
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_employment_info_idx1;
CREATE INDEX clinical_entity_employment_info_idx1
    ON common.clinical_entity_employment_info USING btree
    (clinical_entity_access_info_id)
    TABLESPACE pg_default;

-- Table: common.clinical_entity_functionality
DROP SEQUENCE IF EXISTS common.clinical_entity_functionality_id_seq;
CREATE SEQUENCE common.clinical_entity_functionality_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_functionality_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_functionality;
CREATE TABLE common.clinical_entity_functionality
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_functionality_id_seq'::regclass),
    clinical_entity_id bigint NOT NULL,
    functionality_id bigint NOT NULL,
    hash character varying(50) COLLATE pg_catalog."default" NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_functionality_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_functionality_uq1 UNIQUE (clinical_entity_id, functionality_id),
    CONSTRAINT clinical_entity_functionality_uq2 UNIQUE (hash),
    CONSTRAINT clinical_entity_functionality_fk1 FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_functionality
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_functionality_idx1;
CREATE INDEX clinical_entity_functionality_idx1
    ON common.clinical_entity_functionality USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_functionality_idx2;
CREATE INDEX clinical_entity_functionality_idx2
    ON common.clinical_entity_functionality USING btree
    (functionality_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_functionality_idx3;
CREATE INDEX clinical_entity_functionality_idx3
    ON common.clinical_entity_functionality USING btree
    (clinical_entity_id, functionality_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_preferences
DROP SEQUENCE IF EXISTS common.clinical_entity_preferences_id_seq;
CREATE SEQUENCE common.clinical_entity_preferences_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_preferences_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_preferences;
CREATE TABLE common.clinical_entity_preferences
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_preferences_id_seq'::regclass),
    clinical_entity_id bigint NOT NULL,
    paged integer,
    ip bytea,
    ip_range_start bytea,
    ip_range_end bytea,
    pwd_expiration integer,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_preferences_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_preferences_uq UNIQUE (clinical_entity_id),
    CONSTRAINT clinical_entity_preferences_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_preferences
    OWNER to postgres;

COMMENT ON COLUMN common.clinical_entity_preferences.pwd_expiration
    IS 'Expresa el tiempo que estipula la entidad clínica para que los usuarios cambien la contraseña obligatoriamente. Valores permitidos 1(mes), 3(meses), 6(Meses)';

DROP INDEX IF EXISTS common.clinical_entity_preferences_idx;
CREATE INDEX clinical_entity_preferences_idx
    ON common.clinical_entity_preferences USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;

-- Table: common.clinical_entity_speciality
DROP SEQUENCE IF EXISTS common.clinical_entity_speciality_id_seq;
CREATE SEQUENCE common.clinical_entity_speciality_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_speciality_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_speciality;
CREATE TABLE common.clinical_entity_speciality
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_speciality_id_seq'::regclass),
    clinical_entity_id bigint NOT NULL,
    speciality_id bigint NOT NULL,
    hash character varying(50) COLLATE pg_catalog."default" NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_speciality_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_speciality_uq1 UNIQUE (clinical_entity_id, speciality_id),
    CONSTRAINT clinical_entity_speciality_uq2 UNIQUE (hash),
    CONSTRAINT clinical_entity_speciality_fk1 FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_speciality
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_speciality_idx1;
CREATE INDEX clinical_entity_speciality_idx1
    ON common.clinical_entity_speciality USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_speciality_idx2;
CREATE INDEX clinical_entity_speciality_idx2
    ON common.clinical_entity_speciality USING btree
    (speciality_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_speciality_idx3;
CREATE INDEX clinical_entity_speciality_idx3
    ON common.clinical_entity_speciality USING btree
    (clinical_entity_id, speciality_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_service
DROP SEQUENCE IF EXISTS common.clinical_entity_service_id_seq;
CREATE SEQUENCE common.clinical_entity_service_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_service_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_service;
CREATE TABLE common.clinical_entity_service
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_service_id_seq'::regclass),
    clinical_entity_speciality_id bigint NOT NULL,
    code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    description character varying(500) COLLATE pg_catalog."default" NOT NULL,
    subtotal double precision,
    tax double precision,
    discount double precision,
    total double precision,
    discount_start_date date,
    discount_due_date date,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_service_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_service_uq1 UNIQUE (clinical_entity_speciality_id, code),
    CONSTRAINT clinical_entity_service_uq2 UNIQUE (clinical_entity_speciality_id, description),
    CONSTRAINT clinical_entity_service_fk FOREIGN KEY (clinical_entity_speciality_id)
        REFERENCES common.clinical_entity_speciality (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_service
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_service_idx;
CREATE INDEX clinical_entity_service_idx
    ON common.clinical_entity_service USING btree
    (clinical_entity_speciality_id)
    TABLESPACE pg_default;
	
-- Table: common.clinical_entity_system_option
DROP SEQUENCE IF EXISTS common.clinical_entity_system_option_id_seq;
CREATE SEQUENCE common.clinical_entity_system_option_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.clinical_entity_system_option_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.clinical_entity_system_option;
CREATE TABLE common.clinical_entity_system_option
(
    id bigint NOT NULL DEFAULT nextval('common.clinical_entity_system_option_id_seq'::regclass),
    clinical_entity_id bigint,
    auto_config_system_option_id bigint,
    hash character varying(50) COLLATE pg_catalog."default" NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT clinical_entity_system_option_pk PRIMARY KEY (id),
    CONSTRAINT clinical_entity_system_option_uq1 UNIQUE (clinical_entity_id, auto_config_system_option_id),
    CONSTRAINT clinical_entity_system_option_uq2 UNIQUE (hash),
    CONSTRAINT clinical_entity_system_option_fk1 FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.clinical_entity_system_option
    OWNER to postgres;

DROP INDEX IF EXISTS common.clinical_entity_system_option_idx1;
CREATE INDEX clinical_entity_system_option_idx1
    ON common.clinical_entity_system_option USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.clinical_entity_system_option_idx2;
CREATE INDEX clinical_entity_system_option_idx2
    ON common.clinical_entity_system_option USING btree
    (auto_config_system_option_id)
    TABLESPACE pg_default;
	
-- Table: common.private_practice
DROP SEQUENCE IF EXISTS common.private_practice_id_seq;
CREATE SEQUENCE common.private_practice_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.private_practice_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.private_practice;
CREATE TABLE common.private_practice
(
    id bigint NOT NULL DEFAULT nextval('common.private_practice_id_seq'::regclass),
    doctor_id bigint NOT NULL,
	doctor_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    hash character varying(50) COLLATE pg_catalog."default" NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT private_practice_pk PRIMARY KEY (id),
    CONSTRAINT private_practice_uq1 UNIQUE (doctor_id),
    CONSTRAINT private_practice_uq2 UNIQUE (hash)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.private_practice
    OWNER to postgres;

DROP INDEX IF EXISTS common.private_practice_idx;
CREATE INDEX private_practice_idx
    ON common.private_practice USING btree
    (doctor_id)
    TABLESPACE pg_default;
	
-- Table: common.private_practice_address
DROP SEQUENCE IF EXISTS common.private_practice_address_id_seq;
CREATE SEQUENCE common.private_practice_address_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.private_practice_address_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.private_practice_address;
CREATE TABLE common.private_practice_address
(
    id bigint NOT NULL DEFAULT nextval('common.private_practice_address_id_seq'::regclass),
    private_practice_id bigint NOT NULL,
    colony_mx_id bigint NOT NULL,
    street bytea NOT NULL,
    btw_street bytea,
    outside_number bytea,
    inside_number bytea,
    reference bytea,
    lat bytea,
    lon bytea,
    active boolean DEFAULT true,
    CONSTRAINT private_practice_address_pk PRIMARY KEY (id),
    CONSTRAINT private_practice_address_fk FOREIGN KEY (private_practice_id)
        REFERENCES common.private_practice (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.private_practice_address
    OWNER to postgres;

DROP INDEX IF EXISTS common.private_practice_address_idx1;
CREATE INDEX private_practice_address_idx1
    ON common.private_practice_address USING btree
    (private_practice_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.private_practice_address_idx2;
CREATE INDEX private_practice_address_idx2
    ON common.private_practice_address USING btree
    (colony_mx_id)
    TABLESPACE pg_default;
	
-- Table: common.private_practice_custom_role
DROP SEQUENCE IF EXISTS common.private_practice_custom_role_id_seq;
CREATE SEQUENCE common.private_practice_custom_role_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.private_practice_custom_role_id_seq
    OWNER TO postgres;

DROP TABLE IF EXISTS common.private_practice_custom_role;
CREATE TABLE common.private_practice_custom_role
(
    id bigint NOT NULL DEFAULT nextval('common.private_practice_custom_role_id_seq'::regclass),
    private_practice_id bigint NOT NULL,
    code character varying(100) COLLATE pg_catalog."default",
    value character varying(100) COLLATE pg_catalog."default",
    active boolean DEFAULT true,
    CONSTRAINT private_practice_custom_role_pk PRIMARY KEY (id),
    CONSTRAINT private_practice_custom_role_uq UNIQUE (code, value),
    CONSTRAINT private_practice_custom_role_fk FOREIGN KEY (private_practice_id)
        REFERENCES common.private_practice (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE common.private_practice_custom_role
    OWNER to postgres;

DROP INDEX IF EXISTS common.private_practice_custom_role_idx;
CREATE INDEX private_practice_custom_role_idx
    ON common.private_practice_custom_role USING btree
    (private_practice_id)
    TABLESPACE pg_default;
	
-- Table: common.private_practice_functionality
DROP SEQUENCE IF EXISTS common.private_practice_functionality_id_seq;
CREATE SEQUENCE common.private_practice_functionality_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.private_practice_functionality_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.private_practice_functionality;
CREATE TABLE common.private_practice_functionality
(
    id bigint NOT NULL DEFAULT nextval('common.private_practice_functionality_id_seq'::regclass),
    private_practice_id bigint,
    functionality_id bigint,
    hash character varying(50) COLLATE pg_catalog."default" NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT private_practice_functionality_pk PRIMARY KEY (id),
    CONSTRAINT private_practice_functionality_uq UNIQUE (private_practice_id, functionality_id),
    CONSTRAINT private_practice_functionality_fk1 FOREIGN KEY (private_practice_id)
        REFERENCES common.private_practice (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.private_practice_functionality
    OWNER to postgres;

DROP INDEX IF EXISTS common.private_practice_functionality_idx1;
CREATE INDEX private_practice_functionality_idx1
    ON common.private_practice_functionality USING btree
    (private_practice_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.private_practice_functionality_idx2;
CREATE INDEX private_practice_functionality_idx2
    ON common.private_practice_functionality USING btree
    (functionality_id)
    TABLESPACE pg_default;
	
-- Table: common.private_practice_service
DROP SEQUENCE IF EXISTS common.private_practice_service_id_seq;
CREATE SEQUENCE common.private_practice_service_id_seq
    INCREMENT 1
    START 20
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.private_practice_service_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.private_practice_service;
CREATE TABLE common.private_practice_service
(
    id bigint NOT NULL DEFAULT nextval('common.private_practice_service_id_seq'::regclass),
    private_practice_id bigint NOT NULL,
    doctor_speciality_id bigint NOT NULL,
    code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    description character varying(500) COLLATE pg_catalog."default" NOT NULL,
    subtotal double precision,
    tax double precision,
    discount double precision,
    total double precision,
    discount_start_date date,
    discount_due_date date,
    active boolean DEFAULT true,
    CONSTRAINT private_practice_service_pk PRIMARY KEY (id),
    CONSTRAINT private_practice_service_uq1 UNIQUE (private_practice_id, code),
    CONSTRAINT private_practice_service_uq2 UNIQUE (private_practice_id, description),
    CONSTRAINT private_practice_service_fk FOREIGN KEY (private_practice_id)
        REFERENCES common.private_practice (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.private_practice_service
    OWNER to postgres;

DROP INDEX IF EXISTS common.private_practice_service_idx1;
CREATE INDEX private_practice_service_idx1
    ON common.private_practice_service USING btree
    (private_practice_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.private_practice_service_idx2;
CREATE INDEX private_practice_service_idx2
    ON common.private_practice_service USING btree
    (doctor_speciality_id)
    TABLESPACE pg_default;
	
-- Table: common.private_practice_system_option
DROP SEQUENCE IF EXISTS common.private_practice_system_option_id_seq;
CREATE SEQUENCE common.private_practice_system_option_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.private_practice_system_option_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.private_practice_system_option;
CREATE TABLE common.private_practice_system_option
(
    id bigint NOT NULL DEFAULT nextval('common.private_practice_system_option_id_seq'::regclass),
    private_practice_id bigint,
    auto_config_system_option_id bigint,
    hash character varying(50) COLLATE pg_catalog."default" NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT private_practice_system_option_pk PRIMARY KEY (id),
    CONSTRAINT private_practice_system_option_uq UNIQUE (private_practice_id, auto_config_system_option_id),
    CONSTRAINT private_practice_system_option_fk1 FOREIGN KEY (private_practice_id)
        REFERENCES common.private_practice (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.private_practice_system_option
    OWNER to postgres;

DROP INDEX IF EXISTS common.private_practice_system_option_idx1;
CREATE INDEX private_practice_system_option_idx1
    ON common.private_practice_system_option USING btree
    (private_practice_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.private_practice_system_option_idx2;
CREATE INDEX private_practice_system_option_idx2
    ON common.private_practice_system_option USING btree
    (auto_config_system_option_id)
    TABLESPACE pg_default;
	
-- Table: common.assistant_clinical_entity
DROP SEQUENCE IF EXISTS common.assistant_clinical_entity_id_seq;
CREATE SEQUENCE common.assistant_clinical_entity_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.assistant_clinical_entity_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.assistant_clinical_entity;
CREATE TABLE common.assistant_clinical_entity
(
    id bigint NOT NULL DEFAULT nextval('common.assistant_clinical_entity_id_seq'::regclass),
    assistant_id bigint,
    clinical_entity_id bigint NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT assistant_clinical_entity_pk PRIMARY KEY (id),
    CONSTRAINT assistant_clinical_entity_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.assistant_clinical_entity
    OWNER to postgres;

DROP INDEX IF EXISTS common.assistant_clinical_entity_idx1;
CREATE INDEX assistant_clinical_entity_idx1
    ON common.assistant_clinical_entity USING btree
    (assistant_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.assistant_clinical_entity_idx2;
CREATE INDEX assistant_clinical_entity_idx2
    ON common.assistant_clinical_entity USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;

-- Table: common.doctor_clinical_entity
DROP SEQUENCE IF EXISTS common.doctor_clinical_entity_id_seq;
CREATE SEQUENCE common.doctor_clinical_entity_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.doctor_clinical_entity_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.doctor_clinical_entity;
CREATE TABLE common.doctor_clinical_entity
(
    id bigint NOT NULL DEFAULT nextval('common.doctor_clinical_entity_id_seq'::regclass),
    doctor_id bigint,
    clinical_entity_id bigint,
    active boolean DEFAULT true,
    CONSTRAINT doctor_clinical_entity_pk PRIMARY KEY (id),
    CONSTRAINT doctor_clinical_entity_uq UNIQUE (doctor_id, clinical_entity_id),    
    CONSTRAINT doctor_clinical_entity_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.doctor_clinical_entity
    OWNER to postgres;

DROP INDEX IF EXISTS common.doctor_clinical_entity_idx;
CREATE INDEX doctor_clinical_entity_idx
    ON common.doctor_clinical_entity USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;
	
-- Table: common.assistant_doctor_clinical_entity
DROP SEQUENCE IF EXISTS common.assistant_doctor_clinical_entity_id_seq;
CREATE SEQUENCE common.assistant_doctor_clinical_entity_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.assistant_doctor_clinical_entity_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.assistant_doctor_clinical_entity;
CREATE TABLE common.assistant_doctor_clinical_entity
(
    id bigint NOT NULL DEFAULT nextval('common.assistant_doctor_clinical_entity_id_seq'::regclass),
    assistant_clinical_entity_id bigint,
    doctor_clinical_entity_id bigint,
    active boolean DEFAULT true,
    CONSTRAINT assistant_doctor_clinical_entity_pk PRIMARY KEY (id),
    CONSTRAINT assistant_doctor_clinical_entity_uq UNIQUE (assistant_clinical_entity_id, doctor_clinical_entity_id),
    CONSTRAINT assistant_doctor_clinical_entity_fk1 FOREIGN KEY (assistant_clinical_entity_id)
        REFERENCES common.assistant_clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT assistant_doctor_clinical_entity_fk2 FOREIGN KEY (doctor_clinical_entity_id)
        REFERENCES common.doctor_clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.assistant_doctor_clinical_entity
    OWNER to postgres;

DROP INDEX IF EXISTS common.assistant_doctor_clinical_entity_idx1;
CREATE INDEX assistant_doctor_clinical_entity_idx1
    ON common.assistant_doctor_clinical_entity USING btree
    (assistant_clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.assistant_doctor_clinical_entity_idx2;
CREATE INDEX assistant_doctor_clinical_entity_idx2
    ON common.assistant_doctor_clinical_entity USING btree
    (doctor_clinical_entity_id)
    TABLESPACE pg_default;

-- Table: common.doctor_clinical_entity_speciality
DROP SEQUENCE IF EXISTS common.doctor_clinical_entity_speciality_id_seq;
CREATE SEQUENCE common.doctor_clinical_entity_speciality_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.doctor_clinical_entity_speciality_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.doctor_clinical_entity_speciality;
CREATE TABLE common.doctor_clinical_entity_speciality
(
    id bigint NOT NULL DEFAULT nextval('common.doctor_clinical_entity_speciality_id_seq'::regclass),
    doctor_clinical_entity_id bigint NOT NULL,
    speciality_id bigint NOT NULL,
    professional_license bytea,
    appointment_duration integer,
    active boolean DEFAULT true,
    CONSTRAINT doctor_clinical_entity_speciality_pk PRIMARY KEY (id),
    CONSTRAINT doctor_clinical_entity_speciality_uq UNIQUE (doctor_clinical_entity_id, speciality_id),
    CONSTRAINT doctor_clinical_entity_speciality_fk FOREIGN KEY (doctor_clinical_entity_id)
        REFERENCES common.doctor_clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.doctor_clinical_entity_speciality
    OWNER to postgres;

DROP INDEX IF EXISTS common.doctor_clinical_entity_speciality_idx1;
CREATE INDEX doctor_clinical_entity_speciality_idx1
    ON common.doctor_clinical_entity_speciality USING btree
    (doctor_clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.doctor_clinical_entity_speciality_idx2;
CREATE INDEX doctor_clinical_entity_speciality_idx2
    ON common.doctor_clinical_entity_speciality USING btree
    (speciality_id)
    TABLESPACE pg_default;
	
-- Table: common.doctor_clinical_entity_service
DROP SEQUENCE IF EXISTS common.doctor_clinical_entity_service_id_seq;
CREATE SEQUENCE common.doctor_clinical_entity_service_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.doctor_clinical_entity_service_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.doctor_clinical_entity_service;
CREATE TABLE common.doctor_clinical_entity_service
(
    id bigint NOT NULL DEFAULT nextval('common.doctor_clinical_entity_service_id_seq'::regclass),
    doctor_clinical_entity_speciality_id bigint NOT NULL,
    code character varying(10) COLLATE pg_catalog."default" NOT NULL,
    description character varying(500) COLLATE pg_catalog."default" NOT NULL,
    subtotal double precision,
    tax double precision,
    discount double precision,
    total double precision,
    discount_start_date date,
    discount_due_date date,
    active boolean DEFAULT true,
    CONSTRAINT doctor_clinical_entity_service_pk PRIMARY KEY (id),
    CONSTRAINT doctor_clinical_entity_service_uq1 UNIQUE (doctor_clinical_entity_speciality_id, code),
    CONSTRAINT doctor_clinical_entity_service_uq2 UNIQUE (doctor_clinical_entity_speciality_id, description),
    CONSTRAINT doctor_clinical_entity_service_fk1 FOREIGN KEY (doctor_clinical_entity_speciality_id)
        REFERENCES common.doctor_clinical_entity_speciality (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.doctor_clinical_entity_service
    OWNER to postgres;

DROP INDEX IF EXISTS common.doctor_clinical_entity_service_idx;
CREATE INDEX doctor_clinical_entity_service_idx
    ON common.doctor_clinical_entity_service USING btree
    (doctor_clinical_entity_speciality_id)
    TABLESPACE pg_default;
	
-- Table: common.nurse_clinical_entity
DROP SEQUENCE IF EXISTS common.nurse_clinical_entity_id_seq;
CREATE SEQUENCE common.nurse_clinical_entity_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.nurse_clinical_entity_id_seq
    OWNER TO postgres;

DROP TABLE IF EXISTS common.nurse_clinical_entity;
CREATE TABLE common.nurse_clinical_entity
(
    id bigint NOT NULL DEFAULT nextval('common.nurse_clinical_entity_id_seq'::regclass),
    nurse_id bigint,
    clinical_entity_id bigint NOT NULL,
    active boolean DEFAULT true,
    CONSTRAINT nurse_clinical_entity_pk PRIMARY KEY (id),    
    CONSTRAINT nurse_clinical_entity_fk FOREIGN KEY (clinical_entity_id)
        REFERENCES common.clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.nurse_clinical_entity
    OWNER to postgres;

DROP INDEX IF EXISTS common.nurse_clinical_entity_idx1;
CREATE INDEX nurse_clinical_entity_idx1
    ON common.nurse_clinical_entity USING btree
    (nurse_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.nurse_clinical_entity_idx2;
CREATE INDEX nurse_clinical_entity_idx2
    ON common.nurse_clinical_entity USING btree
    (clinical_entity_id)
    TABLESPACE pg_default;
	
-- Table: common.nurse_doctor_clinical_entity
DROP SEQUENCE IF EXISTS common.nurse_doctor_clinical_entity_id_seq;
CREATE SEQUENCE common.nurse_doctor_clinical_entity_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE common.nurse_doctor_clinical_entity_id_seq
    OWNER TO postgres;
	
DROP TABLE IF EXISTS common.nurse_doctor_clinical_entity;
CREATE TABLE common.nurse_doctor_clinical_entity
(
    id bigint NOT NULL DEFAULT nextval('common.nurse_doctor_clinical_entity_id_seq'::regclass),
    nurse_clinical_entity_id bigint NOT NULL,
    doctor_clinical_entity_id bigint,
    active boolean DEFAULT true,
    CONSTRAINT nurse_doctor_clinical_entity_pk PRIMARY KEY (id),
    CONSTRAINT nurse_doctor_clinical_entity_uq UNIQUE (nurse_clinical_entity_id, doctor_clinical_entity_id),
    CONSTRAINT nurse_doctor_clinical_entity_fk1 FOREIGN KEY (nurse_clinical_entity_id)
        REFERENCES common.nurse_clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT nurse_doctor_clinical_entity_fk2 FOREIGN KEY (doctor_clinical_entity_id)
        REFERENCES common.doctor_clinical_entity (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = TRUE
)
TABLESPACE pg_default;

ALTER TABLE common.nurse_doctor_clinical_entity
    OWNER to postgres;

DROP INDEX IF EXISTS common.nurse_doctor_clinical_entity_idx1;
CREATE INDEX nurse_doctor_clinical_entity_idx1
    ON common.nurse_doctor_clinical_entity USING btree
    (nurse_clinical_entity_id)
    TABLESPACE pg_default;

DROP INDEX IF EXISTS common.nurse_doctor_clinical_entity_idx2;
CREATE INDEX nurse_doctor_clinical_entity_idx2
    ON common.nurse_doctor_clinical_entity USING btree
    (doctor_clinical_entity_id)
    TABLESPACE pg_default;