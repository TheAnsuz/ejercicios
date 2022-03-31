/*
 Examen DML sin corregir, de Ismael Magro https://github.com/imag00
 */
--1. Muestra un listado con el nombre de las localidades que tienen idioma catalán,
--   ordenado descendentemente por nº de inmigrantes.
SELECT localidades.nombre
FROM localidades,
    provincias,
    comunidades
WHERE localidades.id_provincia = provincias.id_provincia
    AND provincias.id_comunidad = comunidades.id_comunidad
    AND comunidades.idioma LIKE 'CATAL�N';

! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! --2. Muestra un listado de las capitales de cada comunidad autónoma, con el
--   siguiente formato:
SELECT 'LOCALIDAD ' || localidades.nombre,
    'CAPITAL DE',
    comunidades.nombre
FROM localidades,
    comunidades
WHERE localidades.id_localidad = comunidades.id_capital;

-- Modifica la consulta adecuadamente para que se muestren TODAS las
-- localidades, aunque no sean capitales de comunidad, de tal forma, que para estas últimas
-- en la columna COMUNIDAD aparezcan 3 guiones “N/A”.
SELECT 'LOCALIDAD ' || localidades.nombre,
    'CAPITAL DE',
    comunidades.nombre
FROM localidades
    LEFT OUTER JOIN comunidades ON localidades.id_localidad = comunidades.id_capital;

--3. Muestra el nombre de las localidades “capitales de provincia” con un nº de
--   inmigrantes superior al 25% de su población, mostrando también el nombre de la provincia
--   a la que pertenecen.
SELECT localidades.nombre,
    provincias.nombre "PROVINCIA"
FROM localidades,
    provincias
WHERE localidades.id_localidad = provincias.id_capital
    AND localidades.inmigrantes > localidades.poblacion * 0.25;

--4. Muestra el nombre de las localidades que son “capitales de provincia”. Para ello
--   no puedes realizar composición de tablas.
SELECT localidades.nombre
FROM localidades
WHERE localidades.id_localidad IN (
        SELECT id_capital
        FROM provincias
    );

--5. Muestra el nombre de las comunidades autónomas que no tienen población
--   inmigrante.
SELECT *
FROM localidades
WHERE localidades.inmigrantes = 0;

SELECT nombre
FROM comunidades
HAVING sum(
        (
            SELECT *
            FROM localidades
            WHERE localidades.id_comunidad = comunidades.id_comunidad
        )
    ) = 0 --6. Muestra el nombre y población (con separación de miles) de las localidades con
    --   una población mayor que la de Palencia y menor que la población de Valladolid.
SELECT nombre,
    poblacion
FROM localidades
WHERE poblacion > (
        SELECT poblacion
        FROM localidades
        WHERE nombre LIKE 'PALENCIA'
    )
    AND poblacion < (
        SELECT poblacion
        FROM localidades
        WHERE nombre LIKE 'VALLADOLID'
    );

--7. Muestra el nombre de cada provincia junto con su población total (con
--   separación de miles) y su densidad de población (con 2 decimales).
--   NOTA: densidad de población = población total / superficie
SELECT provincias.nombre,
    sum(localidades.poblacion) "POBLACION TOTAL",
    round(
        sum(localidades.poblacion) / provincias.superficie,
        2
    ) "DENSIDAD"
FROM provincias,
    localidades
WHERE localidades.id_provincia = provincias.id_provincia
GROUP BY provincias.nombre,
    poblacion,
    provincias.superficie;

--8. ¿Cuál es el idioma que se habla en más provincias españolas? Muestra el idioma
--   y el nº de provincias en las que se habla.
SELECT *
FROM provincias;

SELECT *
FROM comunidades;

SELECT idioma,
    COUNT(sprovincias.*)
FROM comunidades,
    provincias
GROUP BY idioma
WHERE comunidades.id_comunidad = provincias.id_comunidad
SELECT id_comunidad,
    COUNT(*)
FROM provincias
GROUP BY id_comunidad;

! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! --9. Muestra el nombre de cada comunidad autónoma junto con el nº de provincias
--   que tiene. Ordena el resultado descendentemente por el nº de provincias.
SELECT comunidades.nombre,
    (
        SELECT COUNT(*)
        FROM provincias
        WHERE provincias.id_comunidad = comunidades.id_comunidad
    ) provincias
FROM comunidades
ORDER BY provincias DESC;

--10. Inserta en la tabla COMUNIDADES1 las comunidades autónomas formadas por
--    una sola provincia.
INSERT INTO COMUNIDADES1
SELECT *
FROM comunidades
WHERE id_comunidad IN (
        SELECT id_comunidad
        FROM provincias
        GROUP BY id_comunidad
        HAVING COUNT(*) = 1
    );

--11. Incrementa el nº de inmigrantes de las localidades andaluzas (nombre de
--    comunidad “Andalucía”), en un 5%.
-- Por si no se inserta la tabla Andalucía:
INSERT INTO COMUNIDADES
VALUES (
        1,
        410,
        'ANDALUCÍA',
        'ESPAÑOL',
        'MEDITERRÁNEO-CONTINENTAL'
    );

UPDATE localidades
SET inmigrantes = inmigrantes * 1.05
WHERE localidades.id_provincia IN (
        SELECT localidades.id_provincia
        FROM localidades,
            provincias,
            comunidades
        WHERE localidades.id_provincia = provincias.id_provincia
            AND provincias.id_comunidad = comunidades.id_comunidad
            AND comunidades.nombre LIKE 'ANDALUCÍA'
    );

--12. Modifica el clima de Castilla y León al clima que tiene Andalucía.
UPDATE comunidades
SET clima = (
        SELECT clima
        FROM comunidades
        WHERE nombre LIKE 'ANDALUCÍA'
    )
WHERE id_comunidad = (
        SELECT id_comunidad
        FROM comunidades
        WHERE nombre LIKE 'CASTILLA Y LE�'
    );

--13. Elimina las provincias que no tienen ninguna localidad con una población superior
--    a 1000 habitantes.
--    Resuelve la consulta de dos formas diferentes.
DELETE provincias
WHERE id_provincia NOT IN (
        SELECT localidades.id_provincia
        FROM localidades
        WHERE poblacion > 1000
            AND localidades.id_provincia = provincias.id_provincia
    );