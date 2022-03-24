/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/*==============================================================*/

alter table CLIENTES
   drop constraint FK_CLIENTES_DISPONE_REPVENTA;

alter table OFICINAS
   drop constraint FK_OFICINAS_DIRIGE_REPVENTA;

alter table PEDIDOS
   drop constraint FK_PEDIDOS_CONTIENE_PRODUCTO;

alter table PEDIDOS
   drop constraint FK_PEDIDOS_PIDE_CLIENTES;

alter table PEDIDOS
   drop constraint FK_PEDIDOS_REALIZA_REPVENTA;

alter table REPVENTAS
   drop constraint FK_REPVENTA_ES_DIRECT_REPVENTA;

alter table REPVENTAS
   drop constraint FK_REPVENTA_TIENE_OFICINAS;

drop index DISPONE_FK;

drop table CLIENTES cascade constraints;

drop index DIRIGE_FK;

drop table OFICINAS cascade constraints;

drop index PIDE_FK;

drop index CONTIENE_FK;

drop index REALIZA_FK;

drop table PEDIDOS cascade constraints;

drop table PRODUCTOS cascade constraints;

drop index TIENE_FK;

drop index ES_DIRECTOR_FK;

drop table REPVENTAS cascade constraints;

/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES 
(
   NUM_CLIE             INTEGER              not null,
   REP_CLIE             INTEGER              not null,
   EMPRESA              VARCHAR(20),
   LIMITE_CREDITO       NUMBER,
   constraint PK_CLIENTES primary key (NUM_CLIE)
);

/*==============================================================*/
/* Index: DISPONE_FK                                            */
/*==============================================================*/
create index DISPONE_FK on CLIENTES (
   REP_CLIE ASC
);

INSERT INTO CLIENTES VALUES(2101,106,'Jones Mfg.',65000);
INSERT INTO CLIENTES VALUES(2102,101,'First Corp.',65000);
INSERT INTO CLIENTES VALUES(2103,105,'Acme Mfg.',50000);
INSERT INTO CLIENTES VALUES(2105,101,'AAA Investments',45000);
INSERT INTO CLIENTES VALUES(2106,102,'Fred Lewis Corp.',65000);
INSERT INTO CLIENTES VALUES(2107,110,'Acme International',35000);
INSERT INTO CLIENTES VALUES(2108,109,'Holm and Landis',55000);
INSERT INTO CLIENTES VALUES(2109,103,'Chen Associates',25000);
INSERT INTO CLIENTES VALUES(2111,103,'JCP Inc.',50000);
INSERT INTO CLIENTES VALUES(2112,108,'Zetacorp',50000);
INSERT INTO CLIENTES VALUES(2113,104,'Ian and Schmidt',20000);
INSERT INTO CLIENTES VALUES(2114,102,'Orion Corp.',20000);
INSERT INTO CLIENTES VALUES(2115,101,'Smithson Corp.',20000);
INSERT INTO CLIENTES VALUES(2117,106,'J.P. Sinclair',35000);
INSERT INTO CLIENTES VALUES(2118,108,'Midwest Systems',60000);
INSERT INTO CLIENTES VALUES(2119,109,'Solomon Inc.',25000);
INSERT INTO CLIENTES VALUES(2120,102,'Rico Enterprise',50000);
INSERT INTO CLIENTES VALUES(2121,103,'QMA Assoc.',45000);
INSERT INTO CLIENTES VALUES(2122,105,'Three-Way Lines',30000);
INSERT INTO CLIENTES VALUES(2123,102,'Carter and Sons',40000);
INSERT INTO CLIENTES VALUES(2124,107,'Peter Brothers',40000);

/*==============================================================*/
/* Table: OFICINAS                                              */
/*==============================================================*/
create table OFICINAS 
(
   OFICINA              INTEGER              not null,
   DIR                  INTEGER              not null,
   CIUDAD               VARCHAR(15),
   REGION               VARCHAR(10),
   OBJETIVO             NUMBER,
   VENTAS               NUMBER,
   constraint PK_OFICINAS primary key (OFICINA)
);

/*==============================================================*/
/* Index: DIRIGE_FK                                             */
/*==============================================================*/
create index DIRIGE_FK on OFICINAS (
   DIR ASC
);

INSERT INTO OFICINAS VALUES(11,106,'New York','Este',575000,692637);
INSERT INTO OFICINAS VALUES(12,104,'Chicago','Este',800000,735042);
INSERT INTO OFICINAS VALUES(13,105,'Atlanta','Este',350000,367911);
INSERT INTO OFICINAS VALUES(21,108,'Los �ngeles','Oeste',725000,835915);
INSERT INTO OFICINAS VALUES(22,108,'Denver','Oeste',300000,186042);

/*==============================================================*/
/* Table: PEDIDOS                                               */
/*==============================================================*/
create table PEDIDOS 
(
   NUM_PEDIDO           INTEGER              not null,
   PRODUCTO             VARCHAR(5)           not null,
   FAB                  VARCHAR(3)           not null,
   REP                  INTEGER              not null,
   CLIE                 INTEGER              not null,
   FECHA_PEDIDO         DATE,
   CANT                 INTEGER,
   IMPORTE              NUMBER,
   constraint PK_PEDIDOS primary key (NUM_PEDIDO)
);

INSERT INTO PEDIDOS VALUES(110036,'4100Z','ACI',110,2107,'30-JAN-2020',9,22500);
INSERT INTO PEDIDOS VALUES(112961,'2A44L','REI',106,2117,'17-DEC-2019',7,31500);
INSERT INTO PEDIDOS VALUES(112963,'41004','ACI',105,2103,'17-DEC-2019',28,3276);
INSERT INTO PEDIDOS VALUES(112968,'41004','ACI',101,2102,'12-OCT-2019',34,3978);
INSERT INTO PEDIDOS VALUES(112975,'2A44G','REI',103,2111,'12-OCT-2019',6,2100);
INSERT INTO PEDIDOS VALUES(112979,'4100Z','ACI',102,2114,'12-OCT-2019',6,15000);
INSERT INTO PEDIDOS VALUES(112983,'41004','ACI',15,2103,'27-DEC-2019',6,702);
INSERT INTO PEDIDOS VALUES(112987,'4100Y','ACI',105,2103,'3-DEC-2019',11,27500);
INSERT INTO PEDIDOS VALUES(112989,'114','FEA',106,2101,'03-JAN-2020',6,1458);
INSERT INTO PEDIDOS VALUES(112992,'41002','ACI',108,2118,'04-NOV-2019',10,760);
INSERT INTO PEDIDOS VALUES(112993,'2A45C','REI',102,2106,'04-JAN-2019',24,1896);
INSERT INTO PEDIDOS VALUES(112997,'41003','BIC',107,2124,'08-JAN-2020',1,652);
INSERT INTO PEDIDOS VALUES(113003,'779C','IMM',109,2108,'25-JAN-2020',3,5625);
INSERT INTO PEDIDOS VALUES(113007,'773C','IMM',108,2112,'08-JAN-2020',3,2925);
INSERT INTO PEDIDOS VALUES(113012,'41003','ACI',105,2111,'11-JAN-2020',35,3745);
INSERT INTO PEDIDOS VALUES(113013,'41003','BIC',108,2118,'14-JAN-2020',1,652);
INSERT INTO PEDIDOS VALUES(113024,'XK47','QSA',108,2114,'20-JAN-2020',20,7100);
INSERT INTO PEDIDOS VALUES(113027,'41002','ACI',105,2103,'22-JAN-2020',54,4104);
INSERT INTO PEDIDOS VALUES(113034,'2A45C','REI',110,2107,'29-JAN-2020',8,632);
INSERT INTO PEDIDOS VALUES(113042,'2A44R','REI',101,2113,'02-FEB-2020',5,22500);
INSERT INTO PEDIDOS VALUES(113045,'2A44R','REI',108,2112,'02-FEB-2020',10,45000);
INSERT INTO PEDIDOS VALUES(113048,'779C','IMM',102,2120,'10-FEB-2020',2,3750);
INSERT INTO PEDIDOS VALUES(113049,'XK47','QSA',108,2118,'10-FEB-2020',6,2130);
INSERT INTO PEDIDOS VALUES(113051,'XK47','QSA',108,2118,'10-FEB-2020',4,1420);
INSERT INTO PEDIDOS VALUES(113055,'4100X','ACI',101,2108,'15-FEB-2020',6,150);
INSERT INTO PEDIDOS VALUES(113057,'4100X','ACI',103,2111,'18-FEB-2020',24,600);
INSERT INTO PEDIDOS VALUES(113058,'112','FEA',109,2108,'23-FEB-2020',10,1480);
INSERT INTO PEDIDOS VALUES(113062,'114','FEA',107,2124,'24-FEB-2020',10,2430);
INSERT INTO PEDIDOS VALUES(113065,'XK47','QSA',102,2106,'27-FEB-2020',6,2130);
INSERT INTO PEDIDOS VALUES(113069,'775C','IMM',107,2109,'02-MAR-2020',22,31350);

/*==============================================================*/
/* Index: REALIZA_FK                                            */
/*==============================================================*/
create index REALIZA_FK on PEDIDOS (
   REP ASC
);

/*==============================================================*/
/* Index: CONTIENE_FK                                           */
/*==============================================================*/
create index CONTIENE_FK on PEDIDOS (
   PRODUCTO ASC,
   FAB ASC
);

/*==============================================================*/
/* Index: PIDE_FK                                               */
/*==============================================================*/
create index PIDE_FK on PEDIDOS (
   CLIE ASC
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS 
(
   ID_PRODUCTO          VARCHAR(5)           not null,
   ID_FAB               VARCHAR(3)           not null,
   DESCRIPCION          VARCHAR(20),
   PRECIO               NUMBER,
   EXISTENCIAS          INTEGER,
   constraint PK_PRODUCTOS primary key (ID_PRODUCTO, ID_FAB)
);

INSERT INTO PRODUCTOS VALUES ('41001','ACI','Art�culo Tipo 1',55,277);
INSERT INTO PRODUCTOS VALUES ('41002','ACI','Art�culo Tipo 2',76,167);
INSERT INTO PRODUCTOS VALUES ('41003','ACI','Art�culo Tipo 3',107,207);
INSERT INTO PRODUCTOS VALUES ('41004','ACI','Art�culo Tipo 4',117,139);
INSERT INTO PRODUCTOS VALUES ('4100X','ACI','Ajustador',25,37);
INSERT INTO PRODUCTOS VALUES ('4100Y','ACI','Extractor',2750,25);
INSERT INTO PRODUCTOS VALUES ('4100Z','ACI','Montador',2500,28);
INSERT INTO PRODUCTOS VALUES ('41003','BIC','Manivela',662,3);
INSERT INTO PRODUCTOS VALUES ('41089','BIC','Retn',225,78);
INSERT INTO PRODUCTOS VALUES ('41672','BIC','Plate',180,0);
INSERT INTO PRODUCTOS VALUES ('112','FEA','Cubierta',148,115);
INSERT INTO PRODUCTOS VALUES ('114','FEA','Bancada Motor',243,15);
INSERT INTO PRODUCTOS VALUES ('773C','IMM','Riostra 1/2 Tm',975,28);
INSERT INTO PRODUCTOS VALUES ('775C','IMM','Riostra 1-Tm',1425,5);
INSERT INTO PRODUCTOS VALUES ('779C','IMM','Riostra 2-Tm',1875,9);
INSERT INTO PRODUCTOS VALUES ('878H','IMM','Soporte Riostra',54,223);
INSERT INTO PRODUCTOS VALUES ('887P','IMM','Perno Riostra',250,24);
INSERT INTO PRODUCTOS VALUES ('887X','IMM','Retenedor iostra',475,32);
INSERT INTO PRODUCTOS VALUES ('XK47','QSA','Reductor',355,38);
INSERT INTO PRODUCTOS VALUES ('XK48','QSA','Reductor',134,203);
INSERT INTO PRODUCTOS VALUES ('XK48A','QSA','Reductor',117,37);
INSERT INTO PRODUCTOS VALUES ('2A44G','REI','Pasador Bisagra',350,14);
INSERT INTO PRODUCTOS VALUES ('2A44L','REI','Bisagra Izqda.',4500,12);
INSERT INTO PRODUCTOS VALUES ('2A44R','REI','Bisagra Dcha.',4500,12);
INSERT INTO PRODUCTOS VALUES ('2A45C','REI','V Stago Trinquete',79,210);


/*==============================================================*/
/* Table: REPVENTAS                                             */
/*==============================================================*/
create table REPVENTAS 
(
   NUM_EMPL             INTEGER              not null,
   OFICINA_REP          INTEGER,              
   DIRECTOR             INTEGER,             
   NOMBRE               VARCHAR(15),
   EDAD                 INTEGER,
   TITULO               VARCHAR(10),
   CONTRATO             DATE,
   CUOTA                NUMBER,
   VENTAS               NUMBER,
   constraint PK_REPVENTAS primary key (NUM_EMPL)
);

/*==============================================================*/
/* Index: ES_DIRECTOR_FK                                        */
/*==============================================================*/
create index ES_DIRECTOR_FK on REPVENTAS (
   DIRECTOR ASC
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create index TIENE_FK on REPVENTAS (
   OFICINA_REP ASC
);

INSERT INTO REPVENTAS VALUES (101,12,104,'Dan Roberts',45,'Rep Ventas','20-OCT-2006',300000,305673);
INSERT INTO REPVENTAS VALUES (102,21,108,'Sue Smith',48,'Rep Ventas','12-DEC-2006',350000,474050);
INSERT INTO REPVENTAS VALUES (103,12,104,'Paul Cruz',29,'Rep Ventas','01-MAR-2007',275000,286775);
INSERT INTO REPVENTAS VALUES (104,12,106,'Bob Smith',33,'Dir Ventas','19-MAY-2007',200000,142594);
INSERT INTO REPVENTAS VALUES (105,13,104,'Bill Adams',37,'Rep Ventas','12-FEB-2008',350000,367911);
INSERT INTO REPVENTAS VALUES (106,11,(null),'Sam Clark',52,'VIP Ventas','14-JUN-2008',275000,299912);
INSERT INTO REPVENTAS VALUES (107,22,108,'Nancy Angelli',49,'Rep Ventas','14-NOV-2008',300000,186042);
INSERT INTO REPVENTAS VALUES (108,21,106,'Larry Fitch',62,'Dir Ventas','12-OCT-2009',350000,361865);
INSERT INTO REPVENTAS VALUES (109,11,106,'Mary Jones',31,'Rep Ventas','12-OCT-2009',300000,392725);
INSERT INTO REPVENTAS VALUES (110,(null),101,'Tom Snyder',41,'Rep Ventas','13-JAN-2010',(null),75985);

alter table CLIENTES
   add constraint FK_CLIENTES_DISPONE_REPVENTA foreign key (REP_CLIE)
      references REPVENTAS (NUM_EMPL);

alter table OFICINAS
   add constraint FK_OFICINAS_DIRIGE_REPVENTA foreign key (DIR)
      references REPVENTAS (NUM_EMPL);

alter table PEDIDOS
   add constraint FK_PEDIDOS_CONTIENE_PRODUCTO foreign key (PRODUCTO, FAB)
      references PRODUCTOS (ID_PRODUCTO, ID_FAB);

alter table PEDIDOS
   add constraint FK_PEDIDOS_PIDE_CLIENTES foreign key (CLIE)
      references CLIENTES (NUM_CLIE);

alter table PEDIDOS
   add constraint FK_PEDIDOS_REALIZA_REPVENTA foreign key (REP)
      references REPVENTAS (NUM_EMPL);

alter table REPVENTAS
   add constraint FK_REPVENTA_ES_DIRECT_REPVENTA foreign key (DIRECTOR)
      references REPVENTAS (NUM_EMPL);

alter table REPVENTAS
   add constraint FK_REPVENTA_TIENE_OFICINAS foreign key (OFICINA_REP)
      references OFICINAS (OFICINA);

