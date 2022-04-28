(: Por recortes en la empresa y tras una serie de despidos queremos eliminar de 
empleados.xml, todos aquellos empleados que cobran por encima de la media de su 
departamento:)
for $dep in /departamentos/DEP_ROW
let $max:=avg(//EMP_ROW[DEPT_NO=$dep/DEPT_NO]/SALARIO)
return update delete //EMP_ROW[SALARIO>$max]
;

(:Elimina la etiqueta EMP_NO, convirtiéndola a atributo de la etiqueta EMP_ROW:)
for $emp in //EMPLEADOS/EMP_ROW
let $no:=$emp/EMP_NO/text()
let $delete:= update delete $emp/EMP_NO
return update insert attribute no {$no} into $emp
;

(:Queremos listar en una tabla HTML el número de empleado, nombre de su departamento, 
y lo que cobra (teniendo en cuenta el total de SALARIO+COMISION:)
<html>
<body> {
for $emp in //EMPLEADOS/EMP_ROW
let $numero:=$emp/EMP_NO/text()
let $depart:=//departamentos/DEP_ROW[DEPT_NO=$emp/DEPT_NO]/DNOMBRE7/text()
let $comision:=if ($emp/OFICIO = 'VENDEDOR') then $emp/COMISION/text() else 0
let $sueldo:=$emp/SALARIO/text() + $comision
return 
<empleado>
	<numero>{data($numero)}</numero>
	<depart>{data($depart)}</depart>
	<sueldo>{data($sueldo)}</sueldo>
</empleado>
}</body>
</html>
;

(:Incrementa el salario de los empleados que no son vendedores de Bilbao o Barcelona:)
for $emp in //EMPLEADOS/EMP_ROW
let $ubi:=//departamentos/DEP_ROW[DEPT_NO=$emp/DEPT_NO]/LOC
return if ($ubi = 'BILBAO' or $ubi = 'BARCELONA')
	then ""
	else update value $emp/SALARIO with data($emp/SALARIO)*2
;

(: Listado por cada oficio de las personas que más cobran:)
for $oficio in distinct-values(//EMPLEADOS/EMP_ROW/OFICIO)
let $max:=max(//EMPLEADOS/EMP_ROW[OFICIO=$oficio]/SALARIO)
let $emp:=//EMPLEADOS/EMP_ROW[OFICIO=$oficio and SALARIO=$max]
return $emp
;

(:Cambiar la etiqueta SALARIO por SUELDO:)
update rename //EMP_ROW/SALARIO as 'SUELDO'
;

(: Aquellos que son de un departamento de Valladolid o Barcelona o Madrid se les 
incrementa el sueldo un 10% menos a los DIRECTOR:)
for $emp in //EMPLEADOS/EMP_ROW[OFICIO!='DIRECTOR']
let $ubi:=//departamentos/DEP_ROW[DEPT_NO=$emp/DEPT_NO]/LOC
return if ($ubi = 'VALLADOLID' or $ubi = 'BARCELONA' or $ubi = 'MADRID')
	then update value $emp/SALARIO with round(data($emp/SALARIO)*1.10)
	else ""
