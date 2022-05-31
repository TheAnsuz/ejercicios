--seleccionar y mostrar una vista
SELECT *
FROM all_views
WHERE owner LIKE 'HR';

--Obtener la informacion de una tabla
DESC scott.emp;

DESC scott.dept;

SELECT *
FROM scott.emp;

SELECT *
FROM scott.dept;

--Crear un sinonimo (nombre alternativo) a una vista
CREATE synonym my_emp FOR scott.emp;

CREATE synonym my_dept FOR scott.dept;

--Crear una vista usando el sinonimo
CREATE OR REPLACE VIEW employeesNY (
        numero,
        nombre,
        trabajo,
        jefe,
        contratacion,
        salario,
        comisiones,
        departamento,
        localidad
    ) AS
SELECT my_emp.*,
    my_dept.loc
FROM my_emp,
    my_dept
WHERE my_dept.loc LIKE 'NEW YORK'
    AND my_emp.deptno = my_dept.deptno WITH READ ONLY;

--Insertar un valor en la vista
INSERT INTO employeesNY (
        numero,
        nombre,
        salario,
        comisiones,
        departamento,
        localidad
    )
VALUES (999, 'MACARENA', 5000, 1000, 10, 'NEW YORK');

--Mostrar la vista
SELECT *
FROM employeesNY;

--Eliminar la vista
DROP VIEW employeesNY;


-- INDICES
--Borrar tabla creada
drop table tabla_ejemplo;
--Crear una tabla
create table tabla_ejemplo (
    columna1 int PRIMARY KEY,
    columna2 varchar2(100)
);

--Crear indice
create index index_tabla_ejemplo on tabla_ejemplo(columna2);

--Eliminar indice
drop index index_tabla_ejemplo;

--Crear una secuencia para dar valores autoincremenet a columna1
create sequence seq_tabla_ejemplo
start with 1
increment by 1
maxvalue 3
minvalue 1
nocycle;

--Insertar en una tabla usando una secuencia
insert into tabla_ejemplo values(seq_tabla_ejemplo.nextval, 'Texto de ejemplo');
insert into tabla_ejemplo values(seq_tabla_ejemplo.nextval, 'Texto de ejemplo');
insert into tabla_ejemplo values(seq_tabla_ejemplo.nextval, 'Texto de ejemplo');