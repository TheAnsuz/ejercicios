/*
    Examen DML sin corregir, de Ismael Magro https://github.com/imag00
*/

--1. Muestra un listado con el nombre de las localidades que tienen idioma catalán,
--   ordenado descendentemente por nº de inmigrantes.

select localidades.nombre
from localidades, provincias, comunidades
where localidades.id_provincia = provincias.id_provincia
and provincias.id_comunidad = comunidades.id_comunidad
and comunidades.idioma like 'CATAL�N';

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!                                                 
--2. Muestra un listado de las capitales de cada comunidad autónoma, con el
--   siguiente formato:

select 'LOCALIDAD ' || localidades.nombre, 'CAPITAL DE', comunidades.nombre
from localidades, comunidades
where localidades.id_localidad = comunidades.id_capital;

 -- Modifica la consulta adecuadamente para que se muestren TODAS las
 -- localidades, aunque no sean capitales de comunidad, de tal forma, que para estas últimas
 -- en la columna COMUNIDAD aparezcan 3 guiones “N/A”.
 select 'LOCALIDAD ' || localidades.nombre, 'CAPITAL DE', comunidades.nombre
 from localidades left outer join comunidades
 on localidades.id_localidad = comunidades.id_capital;
 
--3. Muestra el nombre de las localidades “capitales de provincia” con un nº de
--   inmigrantes superior al 25% de su población, mostrando también el nombre de la provincia
--   a la que pertenecen.

select localidades.nombre, provincias.nombre "PROVINCIA"
from localidades, provincias
where localidades.id_localidad = provincias.id_capital
and localidades.inmigrantes > localidades.poblacion * 0.25;

--4. Muestra el nombre de las localidades que son “capitales de provincia”. Para ello
--   no puedes realizar composición de tablas.

select localidades.nombre from localidades
where localidades.id_localidad in (select id_capital from provincias);

--5. Muestra el nombre de las comunidades autónomas que no tienen población
--   inmigrante.

select * from localidades where localidades.inmigrantes = 0;

select nombre from comunidades having sum((select * from localidades
                                      where localidades.id_comunidad = comunidades.id_comunidad)) = 0

--6. Muestra el nombre y población (con separación de miles) de las localidades con
--   una población mayor que la de Palencia y menor que la población de Valladolid.

select nombre, poblacion from localidades where
poblacion > (select poblacion from localidades where nombre like 'PALENCIA')
and
poblacion < (select poblacion from localidades where nombre like 'VALLADOLID');


--7. Muestra el nombre de cada provincia junto con su población total (con
--   separación de miles) y su densidad de población (con 2 decimales).
--   NOTA: densidad de población = población total / superficie

select provincias.nombre,
sum(localidades.poblacion) "POBLACION TOTAL",
round(sum(localidades.poblacion)/provincias.superficie, 2) "DENSIDAD"
from provincias, localidades
where localidades.id_provincia = provincias.id_provincia
group by provincias.nombre, poblacion, provincias.superficie;

--8. ¿Cuál es el idioma que se habla en más provincias españolas? Muestra el idioma
--   y el nº de provincias en las que se habla.

select * from provincias;
select * from comunidades;

select idioma, count(sprovincias.*) from comunidades, provincias
group by idioma
where comunidades.id_comunidad = provincias.id_comunidad

select id_comunidad, count(*) from provincias
group by id_comunidad;!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

--9. Muestra el nombre de cada comunidad autónoma junto con el nº de provincias
--   que tiene. Ordena el resultado descendentemente por el nº de provincias.

select comunidades.nombre,
    (select count(*) from provincias
     where provincias.id_comunidad = comunidades.id_comunidad) provincias
from comunidades
order by provincias desc;

--10. Inserta en la tabla COMUNIDADES1 las comunidades autónomas formadas por
--    una sola provincia.

insert into COMUNIDADES1
select * from comunidades where id_comunidad in (
select id_comunidad from provincias
group by id_comunidad
having count(*) = 1);

--11. Incrementa el nº de inmigrantes de las localidades andaluzas (nombre de
--    comunidad “Andalucía”), en un 5%.

-- Por si no se inserta la tabla Andalucía:
INSERT INTO COMUNIDADES VALUES (1,410,'ANDALUCÍA','ESPAÑOL','MEDITERRÁNEO-CONTINENTAL');

update localidades
set inmigrantes = inmigrantes * 1.05
where localidades.id_provincia in (select localidades.id_provincia 
      from localidades, provincias, comunidades
      where localidades.id_provincia = provincias.id_provincia
      and provincias.id_comunidad = comunidades.id_comunidad
      and comunidades.nombre like 'ANDALUCÍA');
      
      
--12. Modifica el clima de Castilla y León al clima que tiene Andalucía.
      
update comunidades
set clima = (select clima from comunidades where nombre like 'ANDALUCÍA')
where id_comunidad = (select id_comunidad from comunidades where nombre like 'CASTILLA Y LE�');

--13. Elimina las provincias que no tienen ninguna localidad con una población superior
--    a 1000 habitantes.
--    Resuelve la consulta de dos formas diferentes.

delete provincias
where id_provincia not in (select localidades.id_provincia
                           from localidades where poblacion > 1000
                           and localidades.id_provincia = provincias.id_provincia);

