-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    email character varying(75) NOT NULL,
    password character varying(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers
(
    employer_id integer NOT NULL,
    company_name character varying(50) NOT NULL,
    website character varying(50) NOT NULL,
    phone_number character varying(15) NOT NULL,
    PRIMARY KEY (employer_id)
);

CREATE TABLE public.jobseekers
(
    jobseeker_id integer NOT NULL,
    "first_name " character varying(15) NOT NULL,
    last_name character varying(25) NOT NULL,
    identity_number character varying(11) NOT NULL,
    birth_date date NOT NULL,
    PRIMARY KEY (jobseeker_id)
);

CREATE TABLE public.system_personels
(
    personel_id integer NOT NULL,
    username character varying(20) NOT NULL,
    PRIMARY KEY (personel_id)
);

CREATE TABLE public.jobseekers_activations
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    jobseeker_id integer NOT NULL,
    is_email_confirmed boolean NOT NULL,
    is_mernis_valid boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.employers_activations
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    employer_id integer NOT NULL,
    is_email_confirmed boolean NOT NULL,
    is_employer_activated boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999 CACHE 1 ),
    job_title character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.users
    ADD FOREIGN KEY (id)
    REFERENCES public.employers (employer_id)
    NOT VALID;


ALTER TABLE public.users
    ADD FOREIGN KEY (id)
    REFERENCES public.jobseekers (jobseeker_id)
    NOT VALID;


ALTER TABLE public.users
    ADD FOREIGN KEY (id)
    REFERENCES public.system_personels (personel_id)
    NOT VALID;


ALTER TABLE public.jobseekers_activations
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.jobseekers (jobseeker_id)
    NOT VALID;


ALTER TABLE public.employers_activations
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (employer_id)
    NOT VALID;

END;