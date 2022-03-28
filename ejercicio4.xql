(:Utiliza zonas.xml, contiene información de las zonas donde se venden los productos del 
xml productos.xml. Utilizando estos dos documentos realiza las siguientes consultas XQuery:)

(:Obtén los datos denominación, precio y nombre de zona de cada producto, ordenado por nombre de zona:)
for $prod in /productos/produc
  let $den := $prod/denominacion
  let $pre := $prod/precio
  let $n_zon := /zonas/zona[cod_zona=$prod/cod_zona]/nombre
  order by $n_zon
return 
  <producto>
    <denominacion>{data($den)}</denominacion>
    <precio>{data($pre)}</precio>
    <zona>{data($n_zon)}</zona>
  </producto>
;
(:Obtén por cada zona, el nombre de zona y el número de productos que tiene:)

for $zona in /zonas/zona
  let $producs := count(/productos/produc[cod_zona=$zona/cod_zona])
return concat($zona/nombre,' -> ',$producs)
;
(:Obtén por cada zona, el nombre de la zona, su código y el nombre del producto con menos stock actual:)
for $zona in /zonas/zona
  let $nombre := $zona/nombre
  let $codigo := $zona/cod_zona
  let $produc := /productos/produc[stock_actual=min(/productos/produc/stock_actual)]/denominacion
return 
  <zona>
    <nombre>{data($nombre)}</nombre>
    <codigo>{data($codigo)}</codigo>
    <producto>{data($produc)}</producto>
  </zona>
;
(:Cuantos empleados hay por cada puesto de cada departamento:)
for $dep in /universidad/departamento 
  for $pue in distinct-values($dep/empleado/puesto)
  let $cu:=count($dep/empleado[puesto=$pue])
return 
  <departamentos>
    <depart>{data($dep/nombre)}</depart>  
    <puesto>{data($pue)}</puesto>
    <profes>{$cu}</profes>
  </departamentos>
; 
(:Muestra el numero, nombre y empleado de cada departamento:)
<html>
  <body>
    <table>
    {
      for $dept in (//DEP_ROW)
        let $nodept:=$dept/DEPT_NO, 
        $nomdep:=$dept/DNOMBRE
        for $emple in (//EMP_ROW[DEPT_NO=$nodept])
        let $empleado:=$emple/APELLIDO
      return 
        <tr>
          <td>{data($nodept)}</td>
          <td>{data($nomdep)}</td>
          <td>{data($empleado)}</td>
        </tr>
    }
    </table>
  </body>
</html>
;
(:Escribe por cada departamento el empleado con mas salario, o algo asi:)
for $dept in (//DEP_ROW)
  let $nodept:= $dept/DEPT_NO
  let $nomdep:= $dept/DNOMBRE
  let $emplecaro:=//EMP_ROW[SALARIO=max(//EMP_ROW[DEPT_NO=$nodept]/SALARIO) and DEPT_NO=$nodept]/APELLIDO
return 
  <res>
	  <dept>{data($nomdep)}</dept>
	  <nodept>{data($nodept)}</nodept>
	  <empleados>
    {
      for $apellido in $emplecaro
      return 
        concat($apellido,', ')
    }
    </empleados>
  </res>
;

(:Otro ejemplo de algo parecido:)
for $depar in distinct-values(//DEPT_NO)
  let $emple:= //EMP_ROW[DEPT_NO=$depar]
  let $nom:= data(//DEP_ROW[DEPT_NO=$depar]/DNOMBRE)
  let $media:= avg($emple/SALARIO)
  let $emplemed:= $emple[SALARIO>=$media]
return 
  <emp>
    <depart>{$nom}</depart>
    <empleados> 
    {
      for $apellido in $emplemed/APELLIDO
			return 
        concat($apellido,' ')
    }
    </empleados>
  </emp>