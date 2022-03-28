(:===========Utilizando el documento sucursales.xml===========:)
(:Obtén por cada sucursal el mayor saldo haber y el nombre de la cuenta que tiene ese saldo:)
for $suc in //sucursal
  let $max := max($suc/cuenta/saldohaber)
  let $nom := $suc/cuenta[saldohaber=$max]/nombre
return 
  <sucursal nombre='{$suc/@codigo}'>
    <max>{$max}</max>
    <nombre>{data($nom)}</nombre>
  </sucursal>
;
(:Obtén por cada sucursal el nombre de la cuenta del tipo AHORRO cuyo saldo debe sea el máxima:)
for $suc in //sucursal
let $max := max($suc/cuenta[@tipo='AHORRO']/saldodebe)
let $nom := $suc/cuenta[@tipo='AHORRO' and saldodebe=$max]/nombre
return
  <sucursal codigo='{$suc/@codigo}'>
    <nombre>{data($nom)}</nombre>
  </sucursal>
;

(:===========Utilizando los documentos productos.xml y zonas.xml===========:)
(:Visualiza los nombres de productos con su nombre de zona. Utiliza dos for en la consulta:)
for $prod in //produc
let $codz := $prod/cod_zona
let $zona := for $zona in //zona[cod_zona=$codz] return $zona
return <producto>
  <nombre>{data($prod/denominacion)}</nombre>
  <zona>{data($zona/nombre)}</zona>
</producto>
;
(:Visualiza los nombres de productos con stockminimo > 5. su código de zona, su nombre y el director de esa zona. Utiliza dos for en la consulta:)
for $prod in //produc[stock_minimo>5]
let $codigo := data($prod/cod_zona)
let $zona := for $zona in //zona[cod_zona=$codigo] return $zona
return
  <producto nombre='{data($prod/denominacion)}'>
    <codigo>{$codigo}</codigo>
    <zona>
    <nombre>{data($zona/nombre)}</nombre>
      <director>{data($zona/director)}</director>
    </zona>
  </producto>
;
(:Mostrar el nombre de la zona, y la denominación de los productos cuyos precios superar la media de los productos de esa zona:)
for $zona in //zona
let $media := avg(//produc[cod_zona=$zona/cod_zona]/precio)
return 
  <zona nombre='{$zona/nombre}'>
    <productos>
    {
      for $produc in //produc[cod_zona=$zona/cod_zona and precio > $media]
      return 
      <nombre>{data($produc/denominacion)}</nombre>
    }
    </productos>
  </zona>
;
(:Mostrar el nombre de zona y el precio medio de cada zona y todos los nombres de productos que están por debajo de ese precio medio de zona:)
for $zona in //zona
let $media := avg(//produc[cod_zona=$zona/cod_zona]/precio)
return
  <zona>
    <nombre>{data($zona/nombre)}</nombre>
    <media>{data($media)}</media>
    <productos>
    {
      for $produc in //produc[cod_zona=$zona/cod_zona and precio<$media]
      return 
      <nombre>
        {data($produc/denominacion)}
      </nombre>
    }
    </productos>
  </zona>