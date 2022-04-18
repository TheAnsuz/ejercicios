# XML
XML es un lenguaje de marcas usado para almacenar y enviar informacion de forma plana practicamente cualquier lenguaje puede abrir un archivo XML.

La estructura xml tiene un prologo en la que informa de la codificacion del fichero.
```xml
<?xml version="1.0" encoding="UTF-8"?>
```
Los XML pueden contener un DTD situado al principio del archivo donde se especifica el contenido y el tipo de contenido dentro del archivo.

Cada archivo debe de tener una unica raiz.

- Etiquetas
Son los campos que tiene el xml, por ejemplo `<tag>...</tag>` o `<tag/>`.
Detectan mayusculas y minusculas y deben empezar obligatoriamente por una letra.
Pueden contener subetiquetas representando distintos nodos.

- Atributos
Son especificaciones que van dentro de una etiqueta `<tag atributo=valor>...</tag>`.
No pueden tener valores vacios y deben de ser unicas para esa etiqueta.


##### Atributos por defecto
`<!ATTLIST nombreElemento nombreAtributo tipoAtributo valorPorDefecto>`  
`<!ATTLIST nombreElemento nombreAtributo1 tipoAtributo1 valorInicialAtributo1>`  
`<!ATTLIST nombreElemento nombreAtributo2 tipoAtributo2 valorInicialAtributo2>`  

Equivalente a 