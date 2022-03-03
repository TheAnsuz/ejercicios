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

/* Sintaxis JOIN */
--continuara...