/*
 Crear tablas
 Los tipos de datos aceptados son:
 -- CHAR(n) > texto con una longitud prefijada
 -- VARCHAR2(n) > caracteres con una longitud variable, alternativo
 -- NUMBER() > numero
 -- BINARY(n) > sucesion de bytes con longitud fija
 -- TEXT() > texto con longitud variable
 -- DATE() > fecha
 -- TIME() > Hora, minutos, segundos
 -- DATETIME() > fecha y hora completa
 -- ...
 
 */
CREATE TABLE < nombre_tabla > (
    < nombre_columna > < tipo_dato > NOT NULL,
    < nombre_columna > < tipo_dato >,
    < nombre_columna > < tipo_dato > NOT NULL
);

-- Puedes especificar el tablespace al que pertenece la tabla creada
-- (el tablespace es como la supercarpeta en la que se guardan las tablas)
CREATE TABLE < nombre_tabla > (
    < nombre_columna > < tipo_dato > NOT NULL
) grupo_de_tablas;

-- Para ver las tablas creadas usa
USER_TABLES()
/*
 Se puede usar un SELECT para crear una tabla a partir de los resultados
 de una consulta, ten en cuenta que la tabla creada usara los datos que
 ha obtenido de realizar la consulta, al igual que sus columnas
 */
CREATE hola ();