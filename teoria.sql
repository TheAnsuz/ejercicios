/* Forma de sintaxis */
+,
-,
*,
/ -- sirven para operaciones aritmeticas
|| -- concatenar textos
"" -- dar nombres a columnas
'' -- cadenas de texto
/* Sintaxis basica SELECT - Selecciona columnas de X tablas */
select
    nombre_columna,
    nombre_otra_columna "Nombre personalizado de la columna al mostrarse"
from
    nombre_tabla;

-- Distinct permite que de esa columna solo muestre valores no repetidos
select
    distinct nombre_columna,
    nombre_otra_columna
from
    nombre_tabla;

-- Seleccionar todas las columnas de una tabla
select
    *
from
    nombre_tabla;

/* Sintaxis basica FROM - Especifica las tablas a las que hace referencia el SELECT */
-- La raiz de la tabla debe de especificarse en el from
select
    nombre
from
    Raiz.tabla;

-- Se le pueden dar alias a las tablas
select
    Alias.nombre
from
    tabla Alias;

/* Sintaxis basica WHERE - Agrega una condicion a las consultas */
select
    columna
from
    tabla
where
    columna is not null;

/* 
 = (igual)
 < (menor que)
 > (mayor que)
 <= (menor o igual)
 >= (mayor o igual)
 <> o != (no es igual)
 and (y)
 or (o)
 not (no)
 (para comprobar valores nulos debe de ponerse delante un is [... is (not) null])
 */
-- BETWEEN valor AND valor2 (comprueba un rango de valores, los valores son inclusivos)
where
    precio between 1
    and 1000;

-- LIKE busca un patron: (los caracteres especiales cambian segun el tipo de bases de datos)
/*
 '_' representa un caracter ('s_l' valida cualquier palabra que tenga un letra o espacio entre la 's' y 'l')
 '%' nº de caracteres ('s%' valida cualquier texto que tenga algo despues de la primera 's')
 '[]' algun caracter de los escritos ('chic[ao]' validara 'chico' y 'chica') (no funciona en oracle SQL live)
 '[^...]' algun caracter que no este dentro de los corchetes ('chic[^e]' validara 'chica' y 'chico' pero no 'chice')
 '[...-...]' algun caracter en el rango de los corchetes ('ca[a-c]a' validara 'caaa' 'caba' 'caca' pero nada mas)
 */
where
    nombre like '___ %';

-- IN (basicamente es como concatenar ors)
where
    codigo_postal in (47192, 47193, 12034, 47000);

-- el WHERE se puede usar para agrupar tablas
select
    *
from
    usuarios,
    clientes
where
    usuario.id = cliente.id_usuario
    /** Sintaxis basica ORDER BY */
select
    producto,
    precio
from
    productos
where
    precio > 1000
order by
    -- puedes determinar si el orden es ASC (ascendente) o DESC (descendente)
    -- puedes escribir varias columnas separandolas por comas (precios, productos)
    precio desc;

/* Funciones */
-- Las funciones tienen la sintaxis nombre(parametros...)
-- Si una funcion no tiene parametros, no hace falta escribir los parentesis
MIN(valor);

-- no lleva parentesis porque no requiere ningun valor
SYSDATE;

/* Sintaxis group by */
-- El group by tiene que tener obligatoriamente en su SELECT el resultado de la operacion de un conjunto de datos
-- AVG, COUNT, SUM, MAX, MIN...
-- Obtiene la suma de las ventas de cada numero de oficina
select
    sum(ventas),
    oficina_rep "Oficina"
from
    repventas
group by
    oficina_rep;

-- Pueden tener una condicion para los valores obtenidos de la agrupacion usando el HAVING
-- en este caso se esta haciendo lo mismo que en el apartado anterior pero solo si al agruparalas y sumarlas, las ventas superan 100.000€
select
    sum(ventas),
    oficina_rep "Oficina"
from
    repventas
group by
    oficina_rep
having
    sum(ventas) > 100000;

/* Uniones de tablas */
--Join: une dos tablas con un valor en comun
select
    oficina.director,
    usuarios.nombre
from
    oficinas
    join usuarios on oficina.director = usuarios.id;

--es lo mismo que: 
select
    oficina.director,
    usuarios.nombre
from
    oficinas,
    usuarios
where
    oficinas.director = usuarios.id;

-- Left/Right Join: usando de ejemplo (oficinas.director = usuarios.id)
-- left se refiere a la columna de la tabla de la izquierda y right a la de la derecha
-- su función es unir las tablas y dejar como nulas las filas en las que no haya valor
-- como ejemplo:
select
    oficina.director,
    usuarios.nombre
from
    oficinas
    left join usuarios on oficinas.director = usuarios.id;

-- Si usuarios contiene una id que no contenga la columna de director de oficinas
-- entonces la oficina de esa fila será nula, porque no existe pero el join especifica
-- que aun asi debe de aparecer esa fila
left join usuarios on oficinas.director = usuarios.id;

-- esto es igual que
where
    oficinas.director (+) = usuarios.id;

-- en cambio si existiera el id de un director que no existe en los usuarios, esa fila simplemente
-- no aparecería en la consulta
--
-- esto mismo ocurre con el RIGHT JOIN
right join usuarios on oficinas.director = usuarios.id;

where
    oficinas.director = usuarios.id (+);

-- Full Join: es la union entre un RIGHT JOIN y/o un LEFT JOIN, de tal modo que si alguno de los valores
-- es nulo en alguna de las dos columnas comparadas, aparecerá igualmente, tanto si es la columna LEFT como RIGHT
----------------------------------------------------------------
/* Combinacion de tablas */
-- UNION
-- combina los resultados de las dos consultas en una misma tabla
-- el numero de columnas que se muestran debe de ser el mismo
select
    nombre -- 1 unica tabla
from
    usuarios
union
-- puedes espeficiar 'union all' para que no elimine los duplicados
select
    nombre -- 1 unica tabla
from
    oficinas;

-- INTERSECT
-- muestra los resultados solo si aparecen en las dos consultas
-- el numero de columnas que se muestran debe de ser el mismo
-- elimina automaticamente los duplicados
select
    nombre -- 1 unica tabla
from
    usuarios
intersect
select
    nombre -- 1 unica tabla
from
    oficinas;

-- MINUS
-- muestra los resultados que no estan en la primera consulta
-- el numero de columnas que se muestran debe de ser el mismo
-- elimina automaticamente duplicaods antes de comprobar el MINUS
select
    nombre -- 1 unica tabla
from
    usuarios
intersect
select
    nombre -- 1 unica tabla
from
    oficinas