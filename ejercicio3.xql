(:Mostrar los nombres de profesores del departamento A:)
for $departamento in /universidad/departamento
let $profesor:= $departamento/empleado
where $departamento/@tipo = 'A'
return <DEPARTAMENTO>{$profesor/nombre}</DEPARTAMENTO>;

(:Mostrar el nombre de los departamentos que son del tipo A y tipo B en dos nodos diferenciados: <tipoA> <tipoB>:)
(:Mostrar el nombre de los departamentos que son del tipo A y tipo B en dos nodos diferenciados: <tipoA> <tipoB>:)
for $departamento in /universidad/departamento
let $nombre:=$departamento/codigo, $tipo:=$departamento/@tipo
return (if ($tipo = 'A')
  then <tipoA>{$nombre}</tipoA>
  else if ($tipo = 'B')
    then <tipoB>{$nombre}</tipoB>
    else <indeterminado>{$nombre}</indeterminado>)
;

(:Mostrar el nombre de departamento y número de empleados que tiene por cada uno de ellos con el siguiente formato:

<depart>Informática</depart>
<emple>2</emple>
<depart>Matemáticas</depart>
<emple>4</emple> :)
for $dep in /universidad/departamento
let $num_emp:= count($dep/empleado)
return (<depart>{data($dep/nombre)}</depart>,
        <emple>{$num_emp}</emple>);

(:Del ejercicio 3 a todos los de productos:)