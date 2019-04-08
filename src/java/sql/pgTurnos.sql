--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5 (Debian 10.5-2.pgdg90+1)
-- Dumped by pg_dump version 10.5 (Debian 10.5-2.pgdg90+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: nuevoSchema; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "nuevoSchema";


ALTER SCHEMA "nuevoSchema" OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: test; Type: TABLE; Schema: nuevoSchema; Owner: postgres
--

CREATE TABLE "nuevoSchema".test (
    id integer NOT NULL
);


ALTER TABLE "nuevoSchema".test OWNER TO postgres;

--
-- Name: test_id_seq; Type: SEQUENCE; Schema: nuevoSchema; Owner: postgres
--

CREATE SEQUENCE "nuevoSchema".test_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "nuevoSchema".test_id_seq OWNER TO postgres;

--
-- Name: test_id_seq; Type: SEQUENCE OWNED BY; Schema: nuevoSchema; Owner: postgres
--

ALTER SEQUENCE "nuevoSchema".test_id_seq OWNED BY "nuevoSchema".test.id;


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(355),
    created_on timestamp without time zone DEFAULT now(),
    last_login timestamp without time zone
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: account_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_user_id_seq OWNER TO postgres;

--
-- Name: account_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_user_id_seq OWNED BY public.usuarios.user_id;


--
-- Name: grillas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.grillas (
    grilla_id integer NOT NULL,
    grilla_os integer NOT NULL,
    grilla_medic integer NOT NULL,
    grilla_lugar integer NOT NULL
);


ALTER TABLE public.grillas OWNER TO postgres;

--
-- Name: grilla_grilla_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grilla_grilla_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grilla_grilla_id_seq OWNER TO postgres;

--
-- Name: grilla_grilla_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.grilla_grilla_id_seq OWNED BY public.grillas.grilla_id;


--
-- Name: grilla_grilla_lugar_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grilla_grilla_lugar_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grilla_grilla_lugar_seq OWNER TO postgres;

--
-- Name: grilla_grilla_lugar_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.grilla_grilla_lugar_seq OWNED BY public.grillas.grilla_lugar;


--
-- Name: grilla_grilla_medic_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grilla_grilla_medic_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grilla_grilla_medic_seq OWNER TO postgres;

--
-- Name: grilla_grilla_medic_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.grilla_grilla_medic_seq OWNED BY public.grillas.grilla_medic;


--
-- Name: grilla_grilla_os_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.grilla_grilla_os_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.grilla_grilla_os_seq OWNER TO postgres;

--
-- Name: grilla_grilla_os_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.grilla_grilla_os_seq OWNED BY public.grillas.grilla_os;


--
-- Name: horarios_grilla; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.horarios_grilla (
    horgri_id integer NOT NULL,
    horgri_id_grilla integer NOT NULL,
    horgri_desde timestamp without time zone,
    horgri_hast timestamp without time zone,
    horgri_id_paciente integer
);


ALTER TABLE public.horarios_grilla OWNER TO postgres;

--
-- Name: horarios_grilla_horgri_id_grilla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.horarios_grilla_horgri_id_grilla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.horarios_grilla_horgri_id_grilla_seq OWNER TO postgres;

--
-- Name: horarios_grilla_horgri_id_grilla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.horarios_grilla_horgri_id_grilla_seq OWNED BY public.horarios_grilla.horgri_id_grilla;


--
-- Name: horarios_grilla_horgri_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.horarios_grilla_horgri_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.horarios_grilla_horgri_id_seq OWNER TO postgres;

--
-- Name: horarios_grilla_horgri_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.horarios_grilla_horgri_id_seq OWNED BY public.horarios_grilla.horgri_id;


--
-- Name: lugares_atencion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lugares_atencion (
    lug_id integer NOT NULL,
    lug_nombre character varying(50) NOT NULL
);


ALTER TABLE public.lugares_atencion OWNER TO postgres;

--
-- Name: lugares_atencion_lug_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lugares_atencion_lug_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lugares_atencion_lug_id_seq OWNER TO postgres;

--
-- Name: lugares_atencion_lug_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lugares_atencion_lug_id_seq OWNED BY public.lugares_atencion.lug_id;


--
-- Name: medicos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medicos (
    medic_id integer NOT NULL,
    medic_nombre character varying(50) NOT NULL
);


ALTER TABLE public.medicos OWNER TO postgres;

--
-- Name: medicos_lugares; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medicos_lugares (
    medlug_id integer NOT NULL,
    medlug_lugar integer NOT NULL,
    medlug_medic integer NOT NULL
);


ALTER TABLE public.medicos_lugares OWNER TO postgres;

--
-- Name: medicos_lugares_medlug_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medicos_lugares_medlug_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicos_lugares_medlug_id_seq OWNER TO postgres;

--
-- Name: medicos_lugares_medlug_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medicos_lugares_medlug_id_seq OWNED BY public.medicos_lugares.medlug_id;


--
-- Name: medicos_lugares_medlug_lugar_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medicos_lugares_medlug_lugar_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicos_lugares_medlug_lugar_seq OWNER TO postgres;

--
-- Name: medicos_lugares_medlug_lugar_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medicos_lugares_medlug_lugar_seq OWNED BY public.medicos_lugares.medlug_lugar;


--
-- Name: medicos_lugares_medlug_medic_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medicos_lugares_medlug_medic_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicos_lugares_medlug_medic_seq OWNER TO postgres;

--
-- Name: medicos_lugares_medlug_medic_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medicos_lugares_medlug_medic_seq OWNED BY public.medicos_lugares.medlug_medic;


--
-- Name: medicos_medic_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.medicos_medic_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.medicos_medic_id_seq OWNER TO postgres;

--
-- Name: medicos_medic_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.medicos_medic_id_seq OWNED BY public.medicos.medic_id;


--
-- Name: obras_sociales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.obras_sociales (
    os_id integer NOT NULL,
    os_nombre character varying(50) NOT NULL
);


ALTER TABLE public.obras_sociales OWNER TO postgres;

--
-- Name: obra_social_os_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.obra_social_os_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.obra_social_os_id_seq OWNER TO postgres;

--
-- Name: obra_social_os_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.obra_social_os_id_seq OWNED BY public.obras_sociales.os_id;


--
-- Name: pacientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pacientes (
    paci_id integer NOT NULL,
    paci_nombre character varying(50) NOT NULL
);


ALTER TABLE public.pacientes OWNER TO postgres;

--
-- Name: paciente_paci_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.paciente_paci_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.paciente_paci_id_seq OWNER TO postgres;

--
-- Name: paciente_paci_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.paciente_paci_id_seq OWNED BY public.pacientes.paci_id;


--
-- Name: turnos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.turnos (
    turnos_id integer NOT NULL,
    turnos_id_paciente integer NOT NULL,
    turnos_id_grilla integer NOT NULL,
    turnos_desde timestamp without time zone,
    turnos_hasta timestamp without time zone
);


ALTER TABLE public.turnos OWNER TO postgres;

--
-- Name: turnos_turnos_id_grilla_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.turnos_turnos_id_grilla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.turnos_turnos_id_grilla_seq OWNER TO postgres;

--
-- Name: turnos_turnos_id_grilla_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.turnos_turnos_id_grilla_seq OWNED BY public.turnos.turnos_id_grilla;


--
-- Name: turnos_turnos_id_paciente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.turnos_turnos_id_paciente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.turnos_turnos_id_paciente_seq OWNER TO postgres;

--
-- Name: turnos_turnos_id_paciente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.turnos_turnos_id_paciente_seq OWNED BY public.turnos.turnos_id_paciente;


--
-- Name: turnos_turnos_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.turnos_turnos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.turnos_turnos_id_seq OWNER TO postgres;

--
-- Name: turnos_turnos_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.turnos_turnos_id_seq OWNED BY public.turnos.turnos_id;


--
-- Name: test id; Type: DEFAULT; Schema: nuevoSchema; Owner: postgres
--

ALTER TABLE ONLY "nuevoSchema".test ALTER COLUMN id SET DEFAULT nextval('"nuevoSchema".test_id_seq'::regclass);


--
-- Name: grillas grilla_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas ALTER COLUMN grilla_id SET DEFAULT nextval('public.grilla_grilla_id_seq'::regclass);


--
-- Name: grillas grilla_os; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas ALTER COLUMN grilla_os SET DEFAULT nextval('public.grilla_grilla_os_seq'::regclass);


--
-- Name: grillas grilla_medic; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas ALTER COLUMN grilla_medic SET DEFAULT nextval('public.grilla_grilla_medic_seq'::regclass);


--
-- Name: grillas grilla_lugar; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas ALTER COLUMN grilla_lugar SET DEFAULT nextval('public.grilla_grilla_lugar_seq'::regclass);


--
-- Name: horarios_grilla horgri_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios_grilla ALTER COLUMN horgri_id SET DEFAULT nextval('public.horarios_grilla_horgri_id_seq'::regclass);


--
-- Name: horarios_grilla horgri_id_grilla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios_grilla ALTER COLUMN horgri_id_grilla SET DEFAULT nextval('public.horarios_grilla_horgri_id_grilla_seq'::regclass);


--
-- Name: lugares_atencion lug_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lugares_atencion ALTER COLUMN lug_id SET DEFAULT nextval('public.lugares_atencion_lug_id_seq'::regclass);


--
-- Name: medicos medic_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos ALTER COLUMN medic_id SET DEFAULT nextval('public.medicos_medic_id_seq'::regclass);


--
-- Name: medicos_lugares medlug_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos_lugares ALTER COLUMN medlug_id SET DEFAULT nextval('public.medicos_lugares_medlug_id_seq'::regclass);


--
-- Name: medicos_lugares medlug_lugar; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos_lugares ALTER COLUMN medlug_lugar SET DEFAULT nextval('public.medicos_lugares_medlug_lugar_seq'::regclass);


--
-- Name: medicos_lugares medlug_medic; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos_lugares ALTER COLUMN medlug_medic SET DEFAULT nextval('public.medicos_lugares_medlug_medic_seq'::regclass);


--
-- Name: obras_sociales os_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.obras_sociales ALTER COLUMN os_id SET DEFAULT nextval('public.obra_social_os_id_seq'::regclass);


--
-- Name: pacientes paci_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pacientes ALTER COLUMN paci_id SET DEFAULT nextval('public.paciente_paci_id_seq'::regclass);


--
-- Name: turnos turnos_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnos ALTER COLUMN turnos_id SET DEFAULT nextval('public.turnos_turnos_id_seq'::regclass);


--
-- Name: turnos turnos_id_paciente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnos ALTER COLUMN turnos_id_paciente SET DEFAULT nextval('public.turnos_turnos_id_paciente_seq'::regclass);


--
-- Name: turnos turnos_id_grilla; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnos ALTER COLUMN turnos_id_grilla SET DEFAULT nextval('public.turnos_turnos_id_grilla_seq'::regclass);


--
-- Name: usuarios user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN user_id SET DEFAULT nextval('public.account_user_id_seq'::regclass);


--
-- Data for Name: test; Type: TABLE DATA; Schema: nuevoSchema; Owner: postgres
--

COPY "nuevoSchema".test (id) FROM stdin;
\.


--
-- Data for Name: grillas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.grillas (grilla_id, grilla_os, grilla_medic, grilla_lugar) FROM stdin;
1	3	5	8
3	6	5	8
9	1	5	8
\.


--
-- Data for Name: horarios_grilla; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.horarios_grilla (horgri_id, horgri_id_grilla, horgri_desde, horgri_hast, horgri_id_paciente) FROM stdin;
2	9	2018-11-28 17:00:00	2018-11-28 17:30:00	\N
3	9	2018-11-28 18:00:00	2018-11-28 18:30:00	\N
4	9	2018-11-28 19:00:00	2018-11-28 19:30:00	\N
5	9	2018-11-28 20:00:00	2018-11-28 20:30:00	\N
6	9	2018-11-28 20:00:00	2018-11-28 20:30:00	\N
1	9	2018-11-28 15:00:00	2018-11-28 15:00:00	1
\.


--
-- Data for Name: lugares_atencion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.lugares_atencion (lug_id, lug_nombre) FROM stdin;
1	Av Rivadavia 1300
2	Mitre 970
3	Peru 824
4	Independencia 900
5	Av. 9 de Julio 1000
6	Pacheco 1200
7	Piedras 300
8	Chacabuco 200
9	Bolivar 100
10	Lima 345
11	Irigoyen 234
12	Salta 209
13	Mexico 400
\.


--
-- Data for Name: medicos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medicos (medic_id, medic_nombre) FROM stdin;
1	Alberto Gonzalez
2	Maria Perez
3	Victoria Ocampo
4	Ismael Serrano
5	Bruce Dickinson
6	Carlos Solari
7	Alejandra Pizarnik
8	Alfonsina Stroni
9	Gabriela Mistral
10	Jorge Washington
11	RAMON CARRILLO
12	RAMON CARRILLO
13	RAMON CARRILLO
14	RAMON CARRILLO
17	ALEJANDRO
\.


--
-- Data for Name: medicos_lugares; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medicos_lugares (medlug_id, medlug_lugar, medlug_medic) FROM stdin;
\.


--
-- Data for Name: obras_sociales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.obras_sociales (os_id, os_nombre) FROM stdin;
1	PAMI
2	OSDE
3	OMINT
4	OSTI
5	OSPU
6	OSTA
7	OSBB
8	OSCR
9	OSBS
10	OBTA
11	OSHY
12	OSNT
13	OSCE
\.


--
-- Data for Name: pacientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pacientes (paci_id, paci_nombre) FROM stdin;
1	Bruno Diaz
2	Diego De La Vega
3	Clark Kent
4	Robin Perez
5	Veronica Listerin
6	Juan Fastbender
7	Roberto Johansen
8	Walter Django
9	Lisandro De La Torre
10	Alejandro Polo
11	Pedro Victorino
12	Ramon Jimenez
13	Joaquin Sabina
\.


--
-- Data for Name: turnos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.turnos (turnos_id, turnos_id_paciente, turnos_id_grilla, turnos_desde, turnos_hasta) FROM stdin;
5	1	9	2018-11-28 15:00:00	2018-11-28 15:30:00
6	2	9	2018-11-28 15:00:00	2018-11-28 15:30:00
2	3	3	2018-11-27 19:10:25	\N
3	5	3	2018-11-27 19:00:00	2018-11-22 19:20:00
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (user_id, username, password, email, created_on, last_login) FROM stdin;
4	pedro	123	\N	\N	\N
5	sergio	123	mail	2018-11-30 10:24:53.802253	\N
6	vero	123	mail	2018-11-30 10:29:16.593965	\N
10	vero2	a	a	2018-11-30 11:03:10.559225	\N
\.


--
-- Name: test_id_seq; Type: SEQUENCE SET; Schema: nuevoSchema; Owner: postgres
--

SELECT pg_catalog.setval('"nuevoSchema".test_id_seq', 1, false);


--
-- Name: account_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_user_id_seq', 11, true);


--
-- Name: grilla_grilla_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.grilla_grilla_id_seq', 10, true);


--
-- Name: grilla_grilla_lugar_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.grilla_grilla_lugar_seq', 1, false);


--
-- Name: grilla_grilla_medic_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.grilla_grilla_medic_seq', 1, false);


--
-- Name: grilla_grilla_os_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.grilla_grilla_os_seq', 1, false);


--
-- Name: horarios_grilla_horgri_id_grilla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.horarios_grilla_horgri_id_grilla_seq', 1, false);


--
-- Name: horarios_grilla_horgri_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.horarios_grilla_horgri_id_seq', 6, true);


--
-- Name: lugares_atencion_lug_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lugares_atencion_lug_id_seq', 13, true);


--
-- Name: medicos_lugares_medlug_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medicos_lugares_medlug_id_seq', 1, false);


--
-- Name: medicos_lugares_medlug_lugar_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medicos_lugares_medlug_lugar_seq', 1, false);


--
-- Name: medicos_lugares_medlug_medic_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medicos_lugares_medlug_medic_seq', 1, false);


--
-- Name: medicos_medic_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.medicos_medic_id_seq', 18, true);


--
-- Name: obra_social_os_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.obra_social_os_id_seq', 13, true);


--
-- Name: paciente_paci_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.paciente_paci_id_seq', 26, true);


--
-- Name: turnos_turnos_id_grilla_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.turnos_turnos_id_grilla_seq', 1, false);


--
-- Name: turnos_turnos_id_paciente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.turnos_turnos_id_paciente_seq', 1, false);


--
-- Name: turnos_turnos_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.turnos_turnos_id_seq', 6, true);


--
-- Name: test test_pkey; Type: CONSTRAINT; Schema: nuevoSchema; Owner: postgres
--

ALTER TABLE ONLY "nuevoSchema".test
    ADD CONSTRAINT test_pkey PRIMARY KEY (id);


--
-- Name: usuarios account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT account_pkey PRIMARY KEY (user_id);


--
-- Name: usuarios account_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT account_username_key UNIQUE (username);


--
-- Name: grillas grilla_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas
    ADD CONSTRAINT grilla_pkey PRIMARY KEY (grilla_id);


--
-- Name: horarios_grilla horarios_grilla_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios_grilla
    ADD CONSTRAINT horarios_grilla_pkey PRIMARY KEY (horgri_id);


--
-- Name: lugares_atencion lugares_atencion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lugares_atencion
    ADD CONSTRAINT lugares_atencion_pkey PRIMARY KEY (lug_id);


--
-- Name: medicos_lugares medicos_lugares_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos_lugares
    ADD CONSTRAINT medicos_lugares_pkey PRIMARY KEY (medlug_id);


--
-- Name: medicos medicos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos
    ADD CONSTRAINT medicos_pkey PRIMARY KEY (medic_id);


--
-- Name: obras_sociales obra_social_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.obras_sociales
    ADD CONSTRAINT obra_social_pkey PRIMARY KEY (os_id);


--
-- Name: pacientes paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pacientes
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (paci_id);


--
-- Name: turnos turnos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnos
    ADD CONSTRAINT turnos_pkey PRIMARY KEY (turnos_id);


--
-- Name: grillas grilla_lugar; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas
    ADD CONSTRAINT grilla_lugar FOREIGN KEY (grilla_lugar) REFERENCES public.lugares_atencion(lug_id);


--
-- Name: grillas grilla_medico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas
    ADD CONSTRAINT grilla_medico FOREIGN KEY (grilla_id) REFERENCES public.medicos(medic_id);


--
-- Name: grillas grilla_os; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grillas
    ADD CONSTRAINT grilla_os FOREIGN KEY (grilla_os) REFERENCES public.obras_sociales(os_id);


--
-- Name: horarios_grilla horarios_grilla_grilla; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios_grilla
    ADD CONSTRAINT horarios_grilla_grilla FOREIGN KEY (horgri_id_grilla) REFERENCES public.grillas(grilla_id);


--
-- Name: horarios_grilla horarios_grilla_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.horarios_grilla
    ADD CONSTRAINT horarios_grilla_paciente FOREIGN KEY (horgri_id_paciente) REFERENCES public.pacientes(paci_id);


--
-- Name: medicos_lugares medicos_lugares; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos_lugares
    ADD CONSTRAINT medicos_lugares FOREIGN KEY (medlug_lugar) REFERENCES public.lugares_atencion(lug_id);


--
-- Name: medicos_lugares medicos_lugares_medico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos_lugares
    ADD CONSTRAINT medicos_lugares_medico FOREIGN KEY (medlug_medic) REFERENCES public.medicos(medic_id);


--
-- Name: turnos turnos_grilla; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnos
    ADD CONSTRAINT turnos_grilla FOREIGN KEY (turnos_id_grilla) REFERENCES public.grillas(grilla_id);


--
-- Name: turnos turnos_paciente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.turnos
    ADD CONSTRAINT turnos_paciente FOREIGN KEY (turnos_id_paciente) REFERENCES public.pacientes(paci_id);


--
-- PostgreSQL database dump complete
--

