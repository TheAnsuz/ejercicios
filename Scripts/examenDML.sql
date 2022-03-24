REM   Script: examen
REM   Archivo del examen de SQL

alter table COMUNIDADES  
   drop constraint FK_COMUNIDA_RELATIONS_LOCALIDA;

alter table LOCALIDADES 
   drop constraint FK_LOCALIDA_RELATIONS_PROVINCI;

alter table PROVINCIAS 
   drop constraint FK_PROVINCI_RELATIONS_LOCALIDA;

alter table PROVINCIAS 
   drop constraint FK_PROVINCI_RELATIONS_COMUNIDA;

drop index RELATIONSHIP_4_FK;

drop table COMUNIDADES cascade constraints;

drop index RELATIONSHIP_1_FK;

drop table LOCALIDADES cascade constraints;

drop index RELATIONSHIP_3_FK;

drop index RELATIONSHIP_2_FK;

drop table PROVINCIAS cascade constraints;

drop table COMUNIDADES1 cascade constraints;

create table COMUNIDADES  
( 
   ID_COMUNIDAD         NUMBER(2)            not null, 
   ID_CAPITAL           NUMBER(3)            not null, 
   NOMBRE               VARCHAR2(30), 
   IDIOMA               VARCHAR2(25), 
   CLIMA                VARCHAR2(25), 
   constraint PK_COMUNIDADES primary key (ID_COMUNIDAD) 
);

create index RELATIONSHIP_4_FK on COMUNIDADES ( 
   ID_CAPITAL ASC 
);

create table LOCALIDADES  
( 
   ID_LOCALIDAD         NUMBER(3)            not null, 
   ID_PROVINCIA         NUMBER(2), 
   NOMBRE               VARCHAR2(30), 
   POBLACION            NUMBER(7), 
   INMIGRANTES          NUMBER(7), 
   constraint PK_LOCALIDADES primary key (ID_LOCALIDAD) 
);

create index RELATIONSHIP_1_FK on LOCALIDADES ( 
   ID_PROVINCIA ASC 
);

create table PROVINCIAS  
( 
   ID_PROVINCIA         NUMBER(2)            not null, 
   ID_CAPITAL           NUMBER(3)            not null, 
   ID_COMUNIDAD         NUMBER(2), 
   NOMBRE               VARCHAR2(20), 
   SUPERFICIE           NUMBER(7,2), 
   constraint PK_PROVINCIAS primary key (ID_PROVINCIA) 
);

create index RELATIONSHIP_2_FK on PROVINCIAS ( 
   ID_CAPITAL ASC 
);

create index RELATIONSHIP_3_FK on PROVINCIAS ( 
   ID_COMUNIDAD ASC 
);

create table COMUNIDADES1  
( 
   ID_COMUNIDAD         NUMBER(2)            not null, 
   ID_CAPITAL           NUMBER(3)            not null, 
   NOMBRE               VARCHAR2(30), 
   IDIOMA               VARCHAR2(25), 
   CLIMA                VARCHAR2(25), 
   constraint PK_COMUNIDADES1 primary key (ID_COMUNIDAD) 
);

INSERT INTO COMUNIDADES VALUES (1,410,'ANDALUC�','ESPA�L','MEDITERR�NEO-CONTINENTAL');

INSERT INTO COMUNIDADES VALUES (4,70,'BALEARRES','CATAL�N','MEDITERR�NEO');

INSERT INTO COMUNIDADES VALUES (6,470,'CASTILLA Y LE�','ESPA�L','CONTINENTAL');

INSERT INTO COMUNIDADES VALUES (7,80 ,'CATALU�','CATAL�N','MEDITERR�NEO');

INSERT INTO COMUNIDADES VALUES (12, 280,'MADRID','ESPA�L','CONTINENTAL');

COMMIT


INSERT INTO PROVINCIAS VALUES (4,40,1,'ALMER�',8769);

INSERT INTO PROVINCIAS VALUES (11,110,1,'C�DIZ',7442);

INSERT INTO PROVINCIAS VALUES (14,140,1,'C�DOBA',13769);

INSERT INTO PROVINCIAS VALUES (18,180,1,'GRANADA',12635);

INSERT INTO PROVINCIAS VALUES (21,210,1,'HUELVA',10148);

INSERT INTO PROVINCIAS VALUES (23,230,1,'JA�',13484);

INSERT INTO PROVINCIAS VALUES (29,290,1,'M�LAGA',7308);

INSERT INTO PROVINCIAS VALUES (41,410,1,'SEVILLA',14042);

INSERT INTO PROVINCIAS VALUES (7,70,4,'BALEARES',4992);

INSERT INTO PROVINCIAS VALUES (5,50,6,'�VILA',8050);

INSERT INTO PROVINCIAS VALUES (9,90,6,'BURGOS',14292);

INSERT INTO PROVINCIAS VALUES (24,240,6,'LE�',15580);

INSERT INTO PROVINCIAS VALUES (34,340,6,'PALENCIA',8052);

INSERT INTO PROVINCIAS VALUES (37,370,6,'SALAMANCA',12349);

INSERT INTO PROVINCIAS VALUES (40,400,6,'SEGOVIA',6920);

INSERT INTO PROVINCIAS VALUES (42,420,6,'SORIA',10306);

INSERT INTO PROVINCIAS VALUES (47,470,6,'VALLADOLID',8110);

INSERT INTO PROVINCIAS VALUES (49,490,6,'ZAMORA',8027);

INSERT INTO PROVINCIAS VALUES (8,80,7,'BARCELONA',7728);

INSERT INTO PROVINCIAS VALUES (17,170,7,'GERONA',5910);

INSERT INTO PROVINCIAS VALUES (25,250,7,'L�IDA',12150);

INSERT INTO PROVINCIAS VALUES (43,430,7,'TARRAGONA',6303);

INSERT INTO PROVINCIAS VALUES (28,280,12,'MADRID',8030);

COMMIT


INSERT INTO LOCALIDADES VALUES (40,4,'ALMER�',192697,26471);

INSERT INTO LOCALIDADES VALUES (110,11,'C�DIZ',122990,8760);

INSERT INTO LOCALIDADES VALUES (140,14,'C�DOBA',328704,46007);

INSERT INTO LOCALIDADES VALUES (180,18,'GRANADA',237818,12699);

INSERT INTO LOCALIDADES VALUES (210,21,'HUELVA',148101,2568);

INSERT INTO LOCALIDADES VALUES (230,23,'JA�',116176,7528);

INSERT INTO LOCALIDADES VALUES (290,29,'M�LAGA',568479,38952);

INSERT INTO LOCALIDADES VALUES (410,41,'SEVILLA',700169,25000);

INSERT INTO LOCALIDADES VALUES (411,41,'CAMAS',26535,134);

INSERT INTO LOCALIDADES VALUES (412,41,'LEBRIJA',27395,250);

INSERT INTO LOCALIDADES VALUES (413,41,'EL MADRO�',314,0);

INSERT INTO LOCALIDADES VALUES (414,41,'UTRERA',52013,5678);

INSERT INTO LOCALIDADES VALUES (415,41,'SEVILLA',700169,25000);

INSERT INTO LOCALIDADES VALUES (70,7,'PALMA DE MALLORCA',383107,33211);

INSERT INTO LOCALIDADES VALUES (71,7,'ARIANY',799,0);

INSERT INTO LOCALIDADES VALUES (72,7,'MAO',28284,599);

INSERT INTO LOCALIDADES VALUES (73,7,'SOLLER',13194,1003);

INSERT INTO LOCALIDADES VALUES (50,5,'�VILA',59258,1547);

INSERT INTO LOCALIDADES VALUES (90,9,'BURGOS',179097,3250);

INSERT INTO LOCALIDADES VALUES (240,24,'LE�',130601,6587);

INSERT INTO LOCALIDADES VALUES (340,34,'PALENCIA',80649,9874);

INSERT INTO LOCALIDADES VALUES (370,37,'SALAMANCA',149528,14700);

INSERT INTO LOCALIDADES VALUES (400,40,'SEGOVIA',54309,6524);

INSERT INTO LOCALIDADES VALUES (420,42,'SORIA',39753,1478);

INSERT INTO LOCALIDADES VALUES (470,47,'VALLADOLID',316567,10056);

INSERT INTO LOCALIDADES VALUES (471,47,'ARROYO DE LA ENCOMIENDA',9590,152);

INSERT INTO LOCALIDADES VALUES (472,47,'BOECILLO',2999,99);

INSERT INTO LOCALIDADES VALUES (473,47,'CABEZ� DE PISUERGA',2925,63);

INSERT INTO LOCALIDADES VALUES (474,47,'ENCINAS DE ESGUEVA',303,0);

INSERT INTO LOCALIDADES VALUES (475,47,'FUENSALDA�',1316,0);

INSERT INTO LOCALIDADES VALUES (476,47,'GERIA',478,0);

INSERT INTO LOCALIDADES VALUES (477,47,'ISCAR',6775,85);

INSERT INTO LOCALIDADES VALUES (490,49,'ZAMORA',64986,18974);

INSERT INTO LOCALIDADES VALUES (80,8,'BARCELONA',1620943,340678);

INSERT INTO LOCALIDADES VALUES (81,8,'GRANOLLERS',59954,3765);

INSERT INTO LOCALIDADES VALUES (82,8,'LLORET DE MAR',40837,18066);

INSERT INTO LOCALIDADES VALUES (83,8,'MATAR�,124084,3208);

INSERT INTO LOCALIDADES VALUES (84,8,'REUS',107211,2655);

INSERT INTO LOCALIDADES VALUES (85,8,'SABADELL',207938,56300);

INSERT INTO LOCALIDADES VALUES (86,8,'SITGES',29039,211);

INSERT INTO LOCALIDADES VALUES (170,17,'GERONA',96722,24687);

INSERT INTO LOCALIDADES VALUES (250,25,'L�IDA',138418,33250);

INSERT INTO LOCALIDADES VALUES (430,43,'TARRAGONA',134085,45026);

INSERT INTO LOCALIDADES VALUES (280,28,'MADRID',3213271,368144);

INSERT INTO LOCALIDADES VALUES (281,28,'ALCAL� DE HENARES',203686,26743);

INSERT INTO LOCALIDADES VALUES (282,28,'ALCOBENDAS',109705,33001);

INSERT INTO LOCALIDADES VALUES (283,28,'COSLADA',91861,13975);

INSERT INTO LOCALIDADES VALUES (284,28,'FUENLABRADA',198834,56800);

INSERT INTO LOCALIDADES VALUES (285,28,'GETAFE',169043,43712);

COMMIT


alter table COMUNIDADES 
   add constraint FK_COMUNIDA_RELATIONS_LOCALIDA foreign key (ID_CAPITAL) 
      references LOCALIDADES (ID_LOCALIDAD);

alter table LOCALIDADES 
   add constraint FK_LOCALIDA_RELATIONS_PROVINCI foreign key (ID_PROVINCIA) 
      references PROVINCIAS (ID_PROVINCIA);

alter table PROVINCIAS 
   add constraint FK_PROVINCI_RELATIONS_LOCALIDA foreign key (ID_CAPITAL) 
      references LOCALIDADES (ID_LOCALIDAD);

alter table PROVINCIAS 
   add constraint FK_PROVINCI_RELATIONS_COMUNIDA foreign key (ID_COMUNIDAD) 
      references COMUNIDADES (ID_COMUNIDAD);

