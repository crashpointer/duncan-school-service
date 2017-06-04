--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-06-04 23:55:23 +03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2199 (class 1262 OID 16384)
-- Dependencies: 2198
-- Name: duncan; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE duncan IS 'Duncan''s school service';


--
-- TOC entry 1 (class 3079 OID 12394)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2201 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 16397)
-- Name: brands; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE brands (
    id integer NOT NULL,
    name character varying(128) NOT NULL
);


ALTER TABLE brands OWNER TO postgres;

--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 187
-- Name: TABLE brands; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE brands IS 'The table is kept brands of vehicle';


--
-- TOC entry 186 (class 1259 OID 16395)
-- Name: brands_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE brands_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE brands_id_seq OWNER TO postgres;

--
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 186
-- Name: brands_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE brands_id_seq OWNED BY brands.id;


--
-- TOC entry 189 (class 1259 OID 16407)
-- Name: models; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE models (
    id integer NOT NULL,
    brand_id integer NOT NULL,
    name character varying(128) NOT NULL
);


ALTER TABLE models OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16405)
-- Name: models_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE models_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE models_id_seq OWNER TO postgres;

--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 188
-- Name: models_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE models_id_seq OWNED BY models.id;


--
-- TOC entry 193 (class 1259 OID 16434)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(64) NOT NULL
);


ALTER TABLE roles OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 16432)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE roles_id_seq OWNER TO postgres;

--
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 192
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- TOC entry 194 (class 1259 OID 16440)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_roles (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


ALTER TABLE user_roles OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16420)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id integer NOT NULL,
    email character varying(256) NOT NULL,
    password character varying(256) NOT NULL,
    name character varying(64) NOT NULL,
    last_name character varying(64) NOT NULL,
    active boolean DEFAULT true NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16418)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 190
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 185 (class 1259 OID 16385)
-- Name: vehicles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE vehicles (
    nickname character varying(128) NOT NULL,
    plate character varying(8) NOT NULL,
    year smallint NOT NULL,
    active boolean DEFAULT true NOT NULL,
    type_of_vehicle smallint DEFAULT 1 NOT NULL,
    model_id integer NOT NULL,
    color character varying(8) DEFAULT '#FFFFFF'::character varying NOT NULL,
    id integer NOT NULL
);


ALTER TABLE vehicles OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 16474)
-- Name: vehicles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE vehicles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vehicles_id_seq OWNER TO postgres;

--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 195
-- Name: vehicles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE vehicles_id_seq OWNED BY vehicles.id;


--
-- TOC entry 2039 (class 2604 OID 16400)
-- Name: brands id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY brands ALTER COLUMN id SET DEFAULT nextval('brands_id_seq'::regclass);


--
-- TOC entry 2040 (class 2604 OID 16410)
-- Name: models id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY models ALTER COLUMN id SET DEFAULT nextval('models_id_seq'::regclass);


--
-- TOC entry 2043 (class 2604 OID 16437)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- TOC entry 2041 (class 2604 OID 16423)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2038 (class 2604 OID 16476)
-- Name: vehicles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vehicles ALTER COLUMN id SET DEFAULT nextval('vehicles_id_seq'::regclass);


--
-- TOC entry 2185 (class 0 OID 16397)
-- Dependencies: 187
-- Data for Name: brands; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY brands (id, name) FROM stdin;
2	Fiat
3	Mercedes
5	BMW
6	Honda
\.


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 186
-- Name: brands_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('brands_id_seq', 6, true);


--
-- TOC entry 2187 (class 0 OID 16407)
-- Dependencies: 189
-- Data for Name: models; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY models (id, brand_id, name) FROM stdin;
1	5	X5
2	5	X7
3	2	Linea
4	3	Mercedes Benz
\.


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 188
-- Name: models_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('models_id_seq', 4, true);


--
-- TOC entry 2191 (class 0 OID 16434)
-- Dependencies: 193
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY roles (id, name) FROM stdin;
1	ADMIN
\.


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 192
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roles_id_seq', 1, true);


--
-- TOC entry 2192 (class 0 OID 16440)
-- Dependencies: 194
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_roles (user_id, role_id) FROM stdin;
2	1
\.


--
-- TOC entry 2189 (class 0 OID 16420)
-- Dependencies: 191
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, email, password, name, last_name, active) FROM stdin;
0	coder1985@gmail.com	$2a$10$.VEn/qO3elzdWiRVkHp62eBYeVJ5Xvndn0MOX2wzdylIrzHsETKm.	Ceren	TOKAY	t
2	smyrna.trk@gmail.com	$2a$10$XbXSiDhfW3gX6Ba1bct3IeG52voYcYUj8pFxXjXzO.JFRquf18kYm	Cihan	TOKAY	t
\.


--
-- TOC entry 2217 (class 0 OID 0)
-- Dependencies: 190
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 2, true);


--
-- TOC entry 2183 (class 0 OID 16385)
-- Dependencies: 185
-- Data for Name: vehicles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY vehicles (nickname, plate, year, active, type_of_vehicle, model_id, color, id) FROM stdin;
Duncan Bus	35LZ123	2016	f	1	4	#4c4bd2	2
MuswelHill Vehicle	60HT23	2007	t	1	4	#000000	3
North fincley Vehicle	34AA22	2003	t	2	3	#c7b930	4
Archway Vehicle	01AD31	2010	f	1	4	#5a0032	5
\.


--
-- TOC entry 2218 (class 0 OID 0)
-- Dependencies: 195
-- Name: vehicles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('vehicles_id_seq', 5, true);


--
-- TOC entry 2049 (class 2606 OID 16402)
-- Name: brands idx_primary_brand_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY brands
    ADD CONSTRAINT idx_primary_brand_id PRIMARY KEY (id);


--
-- TOC entry 2053 (class 2606 OID 16412)
-- Name: models idx_primary_model_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY models
    ADD CONSTRAINT idx_primary_model_id PRIMARY KEY (id);


--
-- TOC entry 2059 (class 2606 OID 16439)
-- Name: roles idx_primary_role_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT idx_primary_role_id PRIMARY KEY (id);


--
-- TOC entry 2055 (class 2606 OID 16429)
-- Name: users idx_primary_user_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT idx_primary_user_id PRIMARY KEY (id);


--
-- TOC entry 2061 (class 2606 OID 16444)
-- Name: user_roles idx_primary_user_role_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT idx_primary_user_role_id PRIMARY KEY (user_id, role_id);


--
-- TOC entry 2051 (class 2606 OID 16404)
-- Name: brands idx_unique_brand_name; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY brands
    ADD CONSTRAINT idx_unique_brand_name UNIQUE (name);


--
-- TOC entry 2057 (class 2606 OID 16431)
-- Name: users idx_unique_user_email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT idx_unique_user_email UNIQUE (email);


--
-- TOC entry 2045 (class 2606 OID 16392)
-- Name: vehicles idx_unique_vehicle_nickname; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vehicles
    ADD CONSTRAINT idx_unique_vehicle_nickname UNIQUE (nickname);


--
-- TOC entry 2047 (class 2606 OID 16394)
-- Name: vehicles idx_unique_vehicle_plate; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vehicles
    ADD CONSTRAINT idx_unique_vehicle_plate UNIQUE (plate);


--
-- TOC entry 2063 (class 2606 OID 16413)
-- Name: models idx_foreign_model_brand_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY models
    ADD CONSTRAINT idx_foreign_model_brand_id FOREIGN KEY (brand_id) REFERENCES brands(id) ON DELETE CASCADE;


--
-- TOC entry 2065 (class 2606 OID 16450)
-- Name: user_roles idx_foreign_role_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT idx_foreign_role_id FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE;


--
-- TOC entry 2064 (class 2606 OID 16445)
-- Name: user_roles idx_foreign_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT idx_foreign_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;


--
-- TOC entry 2062 (class 2606 OID 16462)
-- Name: vehicles idx_foreign_vehicle_model_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vehicles
    ADD CONSTRAINT idx_foreign_vehicle_model_id FOREIGN KEY (model_id) REFERENCES models(id) ON DELETE CASCADE;


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 187
-- Name: brands; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE brands TO PUBLIC;


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 189
-- Name: models; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE models TO PUBLIC;


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 193
-- Name: roles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE roles TO PUBLIC;


--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 194
-- Name: user_roles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE user_roles TO PUBLIC;


--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 191
-- Name: users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE users TO PUBLIC;


--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 185
-- Name: vehicles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE vehicles TO PUBLIC;


-- Completed on 2017-06-04 23:55:23 +03

--
-- PostgreSQL database dump complete
--

