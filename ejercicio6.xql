(: Añade un empleado al departamento que ocupa la posición 2. Los datos son el salario 
2340, el puesto Técnico, y nombre Pedro Fraile:)

for $depart in //DEP_ROW[2]/DEPT_NO
return
update insert
<EMP_ROW>
<SALARIO>2340</SALARIO>
<OFICIO>TECNICO</OFICIO>
<APELLIDO>PEDRO FRAILE</APELLIDO>
<DEPT_NO>{data($depart)}</DEPT_NO></EMP_ROW>
into /EMPLEAD
;
(: El empleado 7902 ha causado baja en la empresa, sustitúyelo por el siguiente:
 <EMP_ROW>
    <EMP_NO>8043</EMP_NO>
    <APELLIDO>González</APELLIDO>
    <OFICIO>Programador</OFICIO>
    <DIR>7566</DIR>
    <FECHA_ALT>2013-05-23</FECHA_ALT>
    <SALARIO>2800</SALARIO>
    <DEPT_NO>60</DEPT_NO>
 </EMP_ROW>
:)

;
(:Añade el departamento 60 , que es de informática y está en Valladolid:)

;
(:Actualiza el salario de los empleados del departamento con código de departamento 20. 
Suma al salario 100:)

;
(:Renombra el nodo DEP_ROW del documento departamentos.xml por filadepar:)

;
(:Borra todos los empleados que trabajen en Valladolid:)

;
(:Añade en departamentos un nuevo campo que muestre la media del salario de sus 
empleados en su departamento:)