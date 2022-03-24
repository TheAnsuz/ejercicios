(:Utiliza zonas.xml, contiene información de las zonas donde se venden los productos del 
xml productos.xml. Utilizando estos dos documentos realiza las siguientes consultas XQuery:)

(:Obtén los datos denominación, precio y nombre de zona de cada producto, ordenado por nombre de zona:)
for $prod in /productos/produc
let $den := $prod/denominacion
let $pre := $prod/precio
let $n_zon := /zonas/zona[cod_zona=$prod/cod_zona]/nombre
order by $n_zon
return (<producto>
  <denominacion>{data($den)}</denominacion>
  <precio>{data($pre)}</precio>
  <zona>{data($n_zon)}</zona>
</producto>)

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
return <zona>
  <nombre>{data($nombre)}</nombre>
  <codigo>{data($codigo)}</codigo>
  <producto>{data($produc)}</producto>
</zona>