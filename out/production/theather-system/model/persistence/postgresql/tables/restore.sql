--
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 9.6.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public."Users" DROP CONSTRAINT "TypeUser_ID";
ALTER TABLE ONLY public."Tickets" DROP CONSTRAINT "Transaccion_ID";
ALTER TABLE ONLY public."Transacciones" DROP CONSTRAINT "TipoDeTransaccion_ID";
ALTER TABLE ONLY public."Obras" DROP CONSTRAINT "Responsable_ID";
ALTER TABLE ONLY public."Funciones" DROP CONSTRAINT "Obra_ID";
ALTER TABLE ONLY public."Transacciones" DROP CONSTRAINT "Funcion_ID";
ALTER TABLE ONLY public."Asientos" DROP CONSTRAINT "Funcion_ID";
ALTER TABLE ONLY public."Tickets" DROP CONSTRAINT "Asiento_ID";
ALTER TABLE ONLY public."Users" DROP CONSTRAINT "Users_pkey";
ALTER TABLE ONLY public."Transacciones" DROP CONSTRAINT "User_ID";
ALTER TABLE ONLY public."TypeUser" DROP CONSTRAINT "TypeUser_pkey";
ALTER TABLE ONLY public."Transacciones" DROP CONSTRAINT "Transacciones_pkey";
ALTER TABLE ONLY public."TipoDeTransacciones" DROP CONSTRAINT "TipoDeTransacciones_pkey";
ALTER TABLE ONLY public."Tickets" DROP CONSTRAINT "Ticket_ID";
ALTER TABLE ONLY public."Responsables" DROP CONSTRAINT "Responsables_pkey";
ALTER TABLE ONLY public."Obras" DROP CONSTRAINT "Obras_pkey";
ALTER TABLE ONLY public."Funciones" DROP CONSTRAINT "Funciones_pkey";
ALTER TABLE ONLY public."Asientos" DROP CONSTRAINT "Asientos_pkey";
DROP TABLE public."Users";
DROP TABLE public."TypeUser";
DROP TABLE public."Transacciones";
DROP TABLE public."TipoDeTransacciones";
DROP TABLE public."Tickets";
DROP TABLE public."Responsables";
DROP TABLE public."Obras";
DROP TABLE public."Funciones";
DROP TABLE public."Asientos";
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: Teatro; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE "Teatro" IS 'DB designated for the "Teatro" project of Software''s Construction and Evolution class.';


--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Asientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Asientos" (
    "Asiento_ID" integer NOT NULL,
    "NoAsiento" integer NOT NULL,
    "Fila" "char" NOT NULL,
    "Estado" "char" NOT NULL,
    "Zona" "char" NOT NULL,
    "Funcion_ID" integer NOT NULL
);


ALTER TABLE "Asientos" OWNER TO postgres;

--
-- Name: Funciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Funciones" (
    "Funcion_ID" integer NOT NULL,
    "Horario" "char"[] NOT NULL,
    "Fecha" "char"[] NOT NULL,
    "Obra_ID" integer NOT NULL,
    "Estado" "char" NOT NULL
);


ALTER TABLE "Funciones" OWNER TO postgres;

--
-- Name: Obras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Obras" (
    "Obra_ID" integer NOT NULL,
    "Nombre" "char"[] NOT NULL,
    "Descripcion " "char"[],
    "Clasificacion" "char"[] NOT NULL,
    "Responsable_ID" integer NOT NULL,
    "Estado" "char" NOT NULL
);


ALTER TABLE "Obras" OWNER TO postgres;

--
-- Name: Responsables; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Responsables" (
    "Responsable_ID" integer NOT NULL,
    "eMail" "char" NOT NULL,
    "Telephone" "char" NOT NULL,
    "Alt_Telephone" "char" NOT NULL,
    "Nombre" "char" NOT NULL
);


ALTER TABLE "Responsables" OWNER TO postgres;

--
-- Name: Tickets; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Tickets" (
    "Ticket_ID" integer NOT NULL,
    "Transaccion_ID" integer NOT NULL,
    "Asiento_ID" integer NOT NULL
);


ALTER TABLE "Tickets" OWNER TO postgres;

--
-- Name: TipoDeTransacciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "TipoDeTransacciones" (
    "TipoDeTransaccion_ID" integer NOT NULL,
    "Nombre" "char" NOT NULL
);


ALTER TABLE "TipoDeTransacciones" OWNER TO postgres;

--
-- Name: Transacciones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Transacciones" (
    "Transaccion_ID" integer NOT NULL,
    "Fecha" "char"[] NOT NULL,
    "QtyBoletos" integer NOT NULL,
    "Funcion_ID" integer NOT NULL,
    "Total" bigint NOT NULL,
    "TipoDeTransaccion_ID" integer NOT NULL,
    "User_ID" integer NOT NULL,
    "NombreCliente" "char"[] NOT NULL
);


ALTER TABLE "Transacciones" OWNER TO postgres;

--
-- Name: TypeUser; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "TypeUser" (
    "TypeUser_ID" integer NOT NULL,
    "Name" "char"
);


ALTER TABLE "TypeUser" OWNER TO postgres;

--
-- Name: Users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Users" (
    "User_ID" integer NOT NULL,
    "TypeUser_ID" integer NOT NULL,
    "eMail" "char" NOT NULL,
    "Password" "char" NOT NULL
);


ALTER TABLE "Users" OWNER TO postgres;

--
-- Data for Name: Asientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Asientos" ("Asiento_ID", "NoAsiento", "Fila", "Estado", "Zona", "Funcion_ID") FROM stdin;
\.
COPY "Asientos" ("Asiento_ID", "NoAsiento", "Fila", "Estado", "Zona", "Funcion_ID") FROM '$$PATH$$/2450.dat';

--
-- Data for Name: Funciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Funciones" ("Funcion_ID", "Horario", "Fecha", "Obra_ID", "Estado") FROM stdin;
\.
COPY "Funciones" ("Funcion_ID", "Horario", "Fecha", "Obra_ID", "Estado") FROM '$$PATH$$/2449.dat';

--
-- Data for Name: Obras; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Obras" ("Obra_ID", "Nombre", "Descripcion ", "Clasificacion", "Responsable_ID", "Estado") FROM stdin;
\.
COPY "Obras" ("Obra_ID", "Nombre", "Descripcion ", "Clasificacion", "Responsable_ID", "Estado") FROM '$$PATH$$/2448.dat';

--
-- Data for Name: Responsables; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Responsables" ("Responsable_ID", "eMail", "Telephone", "Alt_Telephone", "Nombre") FROM stdin;
\.
COPY "Responsables" ("Responsable_ID", "eMail", "Telephone", "Alt_Telephone", "Nombre") FROM '$$PATH$$/2445.dat';

--
-- Data for Name: Tickets; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Tickets" ("Ticket_ID", "Transaccion_ID", "Asiento_ID") FROM stdin;
\.
COPY "Tickets" ("Ticket_ID", "Transaccion_ID", "Asiento_ID") FROM '$$PATH$$/2453.dat';

--
-- Data for Name: TipoDeTransacciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "TipoDeTransacciones" ("TipoDeTransaccion_ID", "Nombre") FROM stdin;
\.
COPY "TipoDeTransacciones" ("TipoDeTransaccion_ID", "Nombre") FROM '$$PATH$$/2452.dat';

--
-- Data for Name: Transacciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Transacciones" ("Transaccion_ID", "Fecha", "QtyBoletos", "Funcion_ID", "Total", "TipoDeTransaccion_ID", "User_ID", "NombreCliente") FROM stdin;
\.
COPY "Transacciones" ("Transaccion_ID", "Fecha", "QtyBoletos", "Funcion_ID", "Total", "TipoDeTransaccion_ID", "User_ID", "NombreCliente") FROM '$$PATH$$/2451.dat';

--
-- Data for Name: TypeUser; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "TypeUser" ("TypeUser_ID", "Name") FROM stdin;
\.
COPY "TypeUser" ("TypeUser_ID", "Name") FROM '$$PATH$$/2446.dat';

--
-- Data for Name: Users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Users" ("User_ID", "TypeUser_ID", "eMail", "Password") FROM stdin;
\.
COPY "Users" ("User_ID", "TypeUser_ID", "eMail", "Password") FROM '$$PATH$$/2447.dat';

--
-- Name: Asientos Asientos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Asientos"
    ADD CONSTRAINT "Asientos_pkey" PRIMARY KEY ("Asiento_ID");


--
-- Name: Funciones Funciones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Funciones"
    ADD CONSTRAINT "Funciones_pkey" PRIMARY KEY ("Funcion_ID");


--
-- Name: Obras Obras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Obras"
    ADD CONSTRAINT "Obras_pkey" PRIMARY KEY ("Obra_ID");


--
-- Name: Responsables Responsables_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Responsables"
    ADD CONSTRAINT "Responsables_pkey" PRIMARY KEY ("Responsable_ID");


--
-- Name: Tickets Ticket_ID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Tickets"
    ADD CONSTRAINT "Ticket_ID" PRIMARY KEY ("Ticket_ID");


--
-- Name: TipoDeTransacciones TipoDeTransacciones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TipoDeTransacciones"
    ADD CONSTRAINT "TipoDeTransacciones_pkey" PRIMARY KEY ("TipoDeTransaccion_ID");


--
-- Name: Transacciones Transacciones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Transacciones"
    ADD CONSTRAINT "Transacciones_pkey" PRIMARY KEY ("Transaccion_ID");


--
-- Name: TypeUser TypeUser_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TypeUser"
    ADD CONSTRAINT "TypeUser_pkey" PRIMARY KEY ("TypeUser_ID");


--
-- Name: Transacciones User_ID; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Transacciones"
    ADD CONSTRAINT "User_ID" UNIQUE ("User_ID");


--
-- Name: Users Users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY ("User_ID", "TypeUser_ID");


--
-- Name: Tickets Asiento_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Tickets"
    ADD CONSTRAINT "Asiento_ID" FOREIGN KEY ("Asiento_ID") REFERENCES "Asientos"("Asiento_ID");


--
-- Name: Asientos Funcion_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Asientos"
    ADD CONSTRAINT "Funcion_ID" FOREIGN KEY ("Funcion_ID") REFERENCES "Funciones"("Funcion_ID");


--
-- Name: Transacciones Funcion_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Transacciones"
    ADD CONSTRAINT "Funcion_ID" FOREIGN KEY ("Funcion_ID") REFERENCES "Funciones"("Funcion_ID");


--
-- Name: Funciones Obra_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Funciones"
    ADD CONSTRAINT "Obra_ID" FOREIGN KEY ("Obra_ID") REFERENCES "Obras"("Obra_ID");


--
-- Name: Obras Responsable_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Obras"
    ADD CONSTRAINT "Responsable_ID" FOREIGN KEY ("Responsable_ID") REFERENCES "Responsables"("Responsable_ID");


--
-- Name: Transacciones TipoDeTransaccion_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Transacciones"
    ADD CONSTRAINT "TipoDeTransaccion_ID" FOREIGN KEY ("TipoDeTransaccion_ID") REFERENCES "TipoDeTransacciones"("TipoDeTransaccion_ID");


--
-- Name: Tickets Transaccion_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Tickets"
    ADD CONSTRAINT "Transaccion_ID" FOREIGN KEY ("Transaccion_ID") REFERENCES "Transacciones"("Transaccion_ID");


--
-- Name: Users TypeUser_ID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Users"
    ADD CONSTRAINT "TypeUser_ID" FOREIGN KEY ("TypeUser_ID") REFERENCES "TypeUser"("TypeUser_ID");


--
-- PostgreSQL database dump complete
--

