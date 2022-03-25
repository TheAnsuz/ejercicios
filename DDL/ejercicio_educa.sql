DROP TABLE clases;

DROP TABLE cursos;

DROP TABLE departamentos;

DROP TABLE estudiantes;

DROP TABLE matriculas;

DROP TABLE claustro;

DROP TABLE personal;

CREATE TABLE cursos (
    codigo_curso char(3) PRIMARY KEY CHECK (codigo_curso = UPPER(codigo_curso)),
    nombre_curso varchar2(30) NOT NULL,
    descripcion_curso varchar2(30),
    creditos number DEFAULT 0,
    tarifa number DEFAULT 0 CHECK (REGEXP_LIKE(tarifa, \ d.\ d { 2 }))
);

CREATE TABLE departamentos (
    codigo_departamento char(4) PRIMARY KEY,
    edificio varchar2(2) NOT NULL,
    despacho number NOT NULL
);

CREATE TABLE clases (
    codigo_curso char(3) NOT NULL CONSTRAINT FK_CLASE_CURSO REFERENCES cursos(codigo_curso),
    seccion varchar2(2) NOT NULL,
    dia varchar(10) NOT NULL,
    hora varchar(5) NOT NULL,
    edificio varchar2(2) NOT NULL,
    despacho number NOT NULL,
    CONSTRAINT PK_CLASE PRIMARY KEY (codigo_curso, seccion)
);

CREATE TABLE estudiantes (
    codigo_estudiante char(3) PRIMARY KEY,
    nombre_estudiante varchar2(30) NOT NULL,
    sexo_estudiante char(1) NOT NULL,
    direccion_estudiante varchar2(50) NOT NULL,
    telefono_estudiante varchar2(9),
    nacimiento_estudiante date NOT NULL
);

CREATE TABLE matriculas (
    codigo_curso char(3) NOT NULL,
    seccion char(2) NOT NULL,
    codigo_estudiante char(3) NOT NULL,
    fecha_matricula varchar2(5) NOT NULL,
    hora_matricula date,
    CONSTRAINT PK_MATRICULA PRIMARY KEY (
        codigo_curso,
        seccion,
        codigo_estudiante
    )
);

CREATE TABLE claustro (
    codigo_profesor char(2) PRIMARY KEY,
    nombre_profesor varchar2(30) NOT NULL,
    direccion_profesor varchar2(50) NOT NULL,
    fecha_contrato_profesor date NOT NULL,
    num_ayudante number DEFAULT 0,
    sueldo_profesor number DEFAULT 0
);

CREATE TABLE personal (
    codigo_personal char(3) PRIMARY KEY,
    nombre_personal varchar2(30) NOT NULL,
    cargo_personal varchar2(20) NOT NULL,
    sueldo_personal number DEFAULT 0
);