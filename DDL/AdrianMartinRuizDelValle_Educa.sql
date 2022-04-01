/* Eliminar las tablas si ya existen */

ALTER TABLE cursos
    DROP CONSTRAINT fkCursoDeparamento;

ALTER TABLE claustro
    DROP CONSTRAINT fkClaustroDepartamento;

ALTER TABLE clases
    DROP CONSTRAINT fkClaseClaustro;

ALTER TABLE clases
    DROP CONSTRAINT fkClaseCurso;

ALTER TABLE estudiantes
    DROP CONSTRAINT fkEstudianteClaustro;

ALTER TABLE matriculas
    DROP CONSTRAINT fkMatriculaEstudiante;

ALTER TABLE matriculas
    DROP CONSTRAINT fkMatriculaClase;

DROP TABLE personal;

DROP TABLE matriculas;

DROP TABLE estudiantes;

DROP TABLE clases;

DROP TABLE departamentos;

DROP TABLE claustro;

DROP TABLE cursos;

/* CREAR LAS TABLAS */

CREATE TABLE departamentos 
(
    codigoDepartamento  char(4)             PRIMARY KEY,
    edificio            varchar2(2),
    despacho            number              DEFAULT 0 UNIQUE,
    codigoProfesor      char(2),
    CONSTRAINT edificioMayuscDepartamentos CHECK (edificio = UPPER(edificio)),
    CONSTRAINT codigoDepartamentoMayusc CHECK (codigoDepartamento = UPPER(codigoDepartamento)),
    CONSTRAINT despachoValidoDepartamentos CHECK (despacho >= 0)
);

CREATE TABLE cursos
(
    codigoCurso             char(3)             PRIMARY KEY,
    nombreCurso             varchar2(30)        NOT NULL,
    descCurso               varchar2(30),
    creditos                number              DEFAULT 0,
    tarifa                  decimal(10,2),
    codigoDepartamento      char(4)             NOT NULL,
    CONSTRAINT fkCursoDeparamento FOREIGN KEY (codigoDepartamento) REFERENCES departamentos(codigoDepartamento),
    CONSTRAINT codigoCursoMayuscCursos CHECK (codigoCurso = UPPER(codigoCurso))
);

CREATE TABLE claustro 
(
    codigoProfesor         char(2)          PRIMARY KEY,
    nombreProfesor         varchar2(30)     NOT NULL,
    direccionProfresor     varchar2(50),
    fechaContratoProfesor  date             NOT NULL,
    numAyudante            number           DEFAULT 0,
    sueldoProfesor         decimal(10,2),
    codigoDepartamento     char(4),
    CONSTRAINT codigoProfesorValido CHECK (REGEXP_LIKE(codigoProfesor,'[0-9]+')),
    CONSTRAINT direccionProfesorValido CHECK (direccionProfresor = INITCAP(direccionProfresor)),
    CONSTRAINT numAyudanteValido CHECK (numAyudante >= 0),
    CONSTRAINT fkClaustroDepartamento FOREIGN KEY (codigoDepartamento) REFERENCES departamentos(codigoDepartamento)
);

ALTER TABLE departamentos
    add CONSTRAINT fkDepartamentoClaustro FOREIGN KEY (codigoProfesor) REFERENCES claustro(codigoProfesor);

CREATE TABLE clases 
(
    codigoCurso             char(3)             NOT NULL,
    seccion                 varchar2(2)         NOT NULL,
    dia                     varchar2(10),
    hora                    varchar2(5),
    edificio                varchar2(2),
    despacho                number,
    codigoProfesor          char(2),
    CONSTRAINT seccionNumericoClases CHECK (REGEXP_LIKE(seccion,'[0-9]+')), 
    CONSTRAINT codigoCursoMayuscClases CHECK (codigoCurso = UPPER(codigoCurso)),
    CONSTRAINT edificioMayuscClases CHECK (edificio = UPPER(edificio)),
    CONSTRAINT fkClaseClaustro FOREIGN KEY (codigoProfesor) REFERENCES claustro(codigoProfesor),
    CONSTRAINT fkClaseCurso FOREIGN KEY (codigoCurso) REFERENCES cursos(codigoCurso),
    CONSTRAINT pkClase PRIMARY KEY (codigoCurso, seccion),
    CONSTRAINT despachoValidoClases CHECK (despacho >= 0)
);

CREATE TABLE estudiantes 
(
    codigoEstudiante        char(3)         PRIMARY KEY,
    nombreEstudiante        varchar2(30)    NOT NULL,
    sexoEstudiante          char(1),
    direccionEstudiante     varchar2(50),
    telefonoEstudiante      varchar2(9),
    nacimientoEstudiante    date,
    codigoProfesor          char(2),
    CONSTRAINT fkEstudianteClaustro FOREIGN KEY (codigoProfesor) REFERENCES claustro(codigoProfesor),
    CONSTRAINT codigoEstudianteNumerico CHECK (REGEXP_LIKE(codigoEstudiante,'[0-9]+')),
    CONSTRAINT sexoValido CHECK (UPPER(sexoEstudiante) = 'H' or UPPER(sexoEstudiante) = 'M'),
    CONSTRAINT telefonoValido CHECK (REGEXP_LIKE(telefonoEstudiante,'[0-9]+'))
);

CREATE TABLE matriculas 
(
    codigoCurso             char(3)         NOT NULL,
    seccion                 varchar2(2)     NOT NULL,
    codigoEstudiante        char(3)         NOT NULL,
    fechaMatricula          date,
    horaMatricula           char(5),
    CONSTRAINT fkMatriculaEstudiante FOREIGN KEY (codigoEstudiante) REFERENCES estudiantes(codigoEstudiante),
    CONSTRAINT fkMatriculaClase FOREIGN KEY (codigoCurso, seccion) REFERENCES clases(codigoCurso, seccion),
    CONSTRAINT codigoCursoMayuscMatriculas CHECK (codigoCurso = UPPER(codigoCurso)),
    CONSTRAINT seccionValido CHECK (REGEXP_LIKE(seccion,'[0-9]+')),
    CONSTRAINT codigoEstudianteValido CHECK (REGEXP_LIKE(codigoEstudiante,'[0-9]+')),
    CONSTRAINT pkMatriculas PRIMARY KEY (codigoCurso, seccion, codigoEstudiante)
);

CREATE TABLE personal 
(
    codigoPersonal          char(3)         PRIMARY KEY,
    nombrePersonal          varchar2(30)    NOT NULL,
    cargoPersonal           varchar2(20),
    sueldoPersonal          decimal(10,2),
    CONSTRAINT codigoPersonalValido CHECK (REGEXP_LIKE(codigoPersonal,'[0-9]+'))
);

/* INSERTAR DATOS */
ALTER TABLE claustro 
    DISABLE CONSTRAINT fkClaustroDepartamento;

INSERT INTO departamentos VALUES ('INFO','CI',100,null);
INSERT INTO departamentos VALUES ('LET','HU',200,null);

INSERT INTO claustro VALUES('15','Sánchez Prieto, María','Plaza Madrid, 16 1º - 47001',date '2010-09-01',0,1500.00,'LET');
INSERT INTO claustro VALUES('47','Cuesta Arriba, Tomás','Calle Góndola, 74 3ºB – 47014',date '2005-06-30',1,1800.00,'INFO');
INSERT INTO claustro VALUES('25','Zalama Bueno, Inés','Calle Cerrada, 3 – 47012 ',date '2012-09-25',0,1250.00,'INFO');

INSERT INTO cursos VALUES ('C10','Bases de datos','Imprescindible',9,15.00,'INFO');
INSERT INTO cursos VALUES ('C11','Programación','Imprescindible',8,12.75,'INFO');
INSERT INTO cursos VALUES ('C20','Existencialimo','Opcional',3,0.00,'LET');

INSERT INTO clases VALUES ('C10','01','Lunes','10:00','CI',101,'25');
INSERT INTO clases VALUES ('C11','01','Miércoles','9:00','CI',102,'47');
INSERT INTO clases VALUES ('C20','02','Jueves','9:00','CI',201,'15');

INSERT INTO estudiantes VALUES ('123','García García, Luis','H','Calle Norte, 25 2ºC - 47007','983001122',date '1988-05-02','25');
INSERT INTO estudiantes VALUES ('255','Martín Pescador, Ana','M','Plaza Mayor, 14 - 47400','600998877',date '1982-07-15','25');
INSERT INTO estudiantes VALUES ('789','Blanco Casas, Carlos','H','Avda. Palencia, 3 7ºA – 47011','983123456',date '1986-04-09','25');

INSERT INTO matriculas VALUES('C11','01','123',date '2020-09-05','10:05');
INSERT INTO matriculas VALUES('C11','01','255',date '2020-09-06','10:32');
INSERT INTO matriculas VALUES('C11','01','789',date '2020-09-10','11:10');
INSERT INTO matriculas VALUES('C20','02','255',date '2020-09-09','13:07');

INSERT INTO personal VALUES ('900','Flores Rosas, Carmen','Administrativo',980.00);
INSERT INTO personal VALUES ('909','Prada Barrios, Alberto','Ayudante',650.00);
INSERT INTO personal VALUES ('920','Puertas Gómez, Santiago','Conserje',1050.00);

update departamentos set codigoProfesor = '47' 
    where codigoDepartamento like 'INFO';

update departamentos set codigoProfesor = '15' 
    where codigoDepartamento like 'LET ';

ALTER TABLE claustro
    ENABLE CONSTRAINT fkClaustroDepartamento;