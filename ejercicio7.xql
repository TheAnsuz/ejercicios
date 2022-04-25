(:ncrementa el salario a todos los empleados del departamento de INVESTIGACIÓN un 
10% la media de sus salarios:)

for $emp in //EMP_ROW[DEPT_NO=//DEP_ROW[DNOMBRE='INVESTIGACION']/DEPT_NO]
let $sal:=$emp/SALARIO
return update value $emp/SALARIO with $sal*1.10
;

(:Queremos cambiar la etiqueta OFICIO por puesto:)
update rename //EMP_ROW/OFICIO as 'PUESTO'
;
(: Añadir a departamento una nueva etiqueta con el número de empleados que tiene cada 
departamento. <NUMEMPLE>x</NUMEMPLE>:)

for $dep in //DEP_ROW
let $count:=count(//EMP_ROW[DEPT_NO=$dep/DEPT_NO])
return update insert <NUMEMPLE>{$count}</NUMEMPLE> into $dep
;
(: Borrar al empleado que más cobra de cada departamento:)
for $dep in /departamentos/DEP_ROW
let $max:=max(//EMP_ROW[DEPT_NO=$dep/DEPT_NO]/SALARIO)
return update delete //EMP_ROW[SALARIO=$max]
;
(:Modificar la denominación de VENDEDOR por COMERCIAL:)
update value //EMP_ROW[PUESTO='VENDEDOR']/PUESTO with 'COMERCIAL'