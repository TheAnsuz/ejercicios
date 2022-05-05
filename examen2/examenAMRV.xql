(:Listado de nombre de paciente y nombre de vacuna suministrada:)
for $paciente in //pacientes/paciente
let $vacuna:=//vacunacion/vacuna[@id=$paciente/vacuna]/nombre
return concat($paciente/nombre,' vacunado con ',$vacuna)
;
(:Listado de ciudad y número de vacunas suministradas en cada ciudad
(no cuáles han sido suministradas):)
for $ciudad in distinct-values(//pacientes/paciente/ciudad)
let $vacunas:=count(//pacientes/paciente[ciudad=$ciudad])
return concat($ciudad,' ha suministrado ',$vacunas,' vacunas')
;
(:Cuál es el precio medio de todos los tipos de dosis de vacuna existente,
es decir, precio medio de las vacunas de dosis Simple y precio medio de las
vacunas de dosis Doble. Pero no des por sabido que hay Simple y Doble, 
podría haber Triple, Cuádruple:)
for $tipo in distinct-values(//vacunacion/vacuna/precio/@dosis)
let $media:=avg(//vacunacion/vacuna/precio[@dosis=$tipo])
return concat('El precio medio de las vacunas ',$tipo,' es de ',$media)
;
(:Inserta en cada nodo de vacuna cuál es la media de edad de los paciente
vacunados con la misma:)
for $vacuna in //vacunacion/vacuna
let $media:=avg(//pacientes/paciente[vacuna=$vacuna/@id]/edad)
return update insert <media_pacientes>{$media}</media_pacientes> into $vacuna
;
(:Elimina todas las vacunas cuya fecha de fin llega al año 2022:)
for $vacunas in //vacunacion/vacuna