(:Mostrar los nombres de profesores del departamento A:)
for $departamento in /universidad/departamento
let $profesor:= $departamento/empleado
where $departamento/@tipo = 'A'
return <DEPARTAMENTO>{$profesor/nombre}</DEPARTAMENTO>

;
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
        <emple>{$num_emp}</emple>)
        
;
(:Del ejercicio 3 a todos los de productos:)
for $zona in distinct-values(//produc/cod_zona)
	let $num_productos:=count(//produc[cod_zona=$zona])
	return concat("ZONA->", $zona," PRODUCTOS TOTALES--->", $num_productos)

;
(:Obtén la denominación de los productos entres las etiquetas <zona10></zona10> si son del 
código de zona 10, <zona20></zona20> si son de la zona 20, <zona30></zona30> si son de la 30 
y <zona40></zona40> si son de la 40:)
for $producto in //produc
let $zona := $producto/cod_zona
order by $zona
return concat('<zona',$zona,'>',data($producto/denominacion),'</zona',$zona,'>')

;
(:Obtén por cada zona la denominación del o de los productos más caros:)
for $den in /productos/produc/denominacion
let $zona:=distinct-values(/productos/produc[denominacion=$den]/cod_zona)
return concat('<zona', $zona, '>', $den, '</zona', $zona, '>')

;
(:Obtén la denominación de los productos contenida entre las etiquetas <placa></placa> para los 
productos en cuya denominación aparece la palabra Placa Base, <memoria></memoria> para los que contienen a la palabra Memoria <micro></micro>, para los que contienen la palabra Micro y 
<otros></otros> para el resto de productos:)
for $prod in /productos/produc
let $dat := data($prod/denominacion)
return (if (contains($dat,"Placa Base"))
  then <placa>{$dat}</placa>
  else if (contains($dat,"Memoria"))
    then <memoria>{$dat}</memoria>
    else if (contains($dat,'Micro'))
    then <micro>{$dat}</micro>
    else <otros>{$dat}</otros>)

;
(:Devuelve el código de sucursal y el número de cuentas que tiene de tipo AHORRO y de tipo PENSIONES:)
for $suc in /sucursales/sucursal
let $cuentas_ahorro := count($suc/cuenta[@tipo="AHORRO"]),
$cuentas_pensiones := count($suc/cuenta[@tipo="PENSIONES"])
return concat('Codigo: ',$suc/@codigo,' - Ahorro: ',$cuentas_ahorro, ' - Pensiones ', $cuentas_pensiones)

;
(:Devuelve por cada sucursal el código de sucursal, el director, la población, la suma del total debe y la suma del total haber de sus cuentas:)
for $suc in /sucursales/sucursal
let $cod := $suc/@codigo,
$dir := $suc/director,
$pob := $suc/poblacion,
$total_debe := sum($suc/cuenta/saldodebe),
$total_haber := sum($suc/cuenta/saldohaber)
return (<sucursal>
  {$cod},
  {$dir},
  {$pob},
  <debe>{$total_debe}</debe>,
  <hay>{$total_haber}</hay>
</sucursal>)

;
(:Devuelve el nombre de los directores, el código de sucursal y la población de las sucursales con más de 3 cuentas:)
for $suc in /sucursales/sucursal
let $cod := data($suc/@codigo),
$dir := data($suc/director),
$pob := data($suc/poblacion)
return (if (count($suc/cuenta) > 3)
  then <sucursal>
      <codigo>{$cod}</codigo>,
      <director>{$dir}</director>,
      <poblacion>{$pob}</poblacion>,
    </sucursal>
    else ())

;
(:Devuelve por cada sucursal, el código de sucursal y los datos de las cuentas con más saldo debe:)
for $suc in /sucursales/sucursal
let $cod := data($suc/@codigo)
let $max := max($suc/cuenta/saldodebe)
return (<sucursal>
    <codigo>{$cod}</codigo>
    {$suc/cuenta[saldodebe=$max]}
  </sucursal>)

;
(:Devuelve la cuenta del tipo PENSIONES que ha hecho más aportación:)
for $cue in /sucursales/sucursal/cuenta
let $max := max(/sucursales/sucursal/cuenta[@tipo='PENSIONES']/aportacion)
return if ($cue[@tipo='PENSIONES']/aportacion = $max)
  then $cue
  else ()

