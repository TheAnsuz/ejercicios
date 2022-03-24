-- ejercicio 1
SELECT
    oficinas.CIUDAD,
    oficinas.REGION,
    oficinas.VENTAS
FROM
    oficinas;


-- ejercicio 2
SELECT
    repventas.NOMBRE,
    repventas.OFICINA_REP,
    repventas.CONTRATO
FROM
    repventas;


-- ejercicio 3
SELECT
    oficinas.ciudad,
    oficinas.region,
    (oficinas.objetivo - oficinas.ventas) "importe"
FROM
    oficinas;


-- ejercicio 4
SELECT
    (productos.precio * productos.existencias) "valor"
FROM
    productos;


-- ejercicio 5
SELECT
    (repventas.cuota * 1.03)
FROM
    repventas;


-- ejercicio 6
SELECT
    oficinas.ciudad,
    oficinas.ventas
FROM
    oficinas;


-- ejercicio 7
SELECT
    repventas.num_empl,
    repventas.titulo
FROM
    repventas
WHERE
    repventas.titulo = 'Dir Ventas';


-- ejercicio 8
SELECT
    repventas.nombre,
    repventas.edad,
    repventas.cuota
FROM
    repventas
WHERE
    repventas.num_empl = 107;


-- ejercicio 9
SELECT
    oficinas.oficina,
    oficinas.ventas
FROM
    oficinas
WHERE
    (oficinas.ventas > 50000 + oficinas.objetivo);


-- ejercicio 10
SELECT
    oficinas.oficina,
    oficinas.ventas
FROM
    oficinas
WHERE
    (oficinas.ventas < oficinas.objetivo * 0.8);


-- ejercicio 11
SELECT
    repventas.nombre
FROM
    repventas
WHERE
    (repventas.ventas < repventas.cuota * 0.8)
    OR (repventas.ventas > repventas.cuota * 1.2);


-- ejercicio 12
SELECT
    repventas.nombre,
    repventas.contrato
FROM
    repventas
WHERE
    repventas.ventas > 100000
    AND repventas.ventas < 300000;


-- ejercicio 13
SELECT
    *
FROM
    oficinas
WHERE
    oficinas.oficina != 21;


-- ejercicio 14
SELECT
    *
FROM
    repventas
WHERE
    oficina_rep IN (11, 13, 22);


-- ejercicio 15
SELECT
    *
FROM
    pedidos
WHERE
    fecha_pedido LIKE '%-JAN-20';


-- ejercicio 16
SELECT
    *
FROM
    repventas
WHERE
    nombre LIKE '%A%';


-- ejercicio 17
SELECT
    *
FROM
    repventas
WHERE
    ventas < cuota
    OR ventas < 300000;


-- ejercicio 18
SELECT
    *
FROM
    repventas
WHERE
    ventas < cuota
    AND ventas >= 150000;


-- ejercicio 19
SELECT
    *
FROM
    repventas
    JOIN oficinas ON oficinas.dir = repventas.num_empl
WHERE
    (
        (
            repventas.ventas > repventas.cuota
            AND repventas.ventas < 600000
        )
        OR (
            oficinas.dir IS NULL
            AND repventas.contrato LIKE '%-JUN-08'
        )
    )
    AND (
        oficinas.ciudad = 'Denver'
        OR oficinas.ciudad = 'New York'
        OR oficinas.ciudad = 'Chicaco'
    );


-- ejercicio 20
SELECT
    *
FROM
    pedidos
WHERE
    rep IN (101, 103, 107, 109);


-- ejercicio 21 - Mostrar los productos cuyo fabricante no empieza por I
SELECT
    *
FROM
    productos
WHERE
    id_fab NOT LIKE 'I%';


-- ejercicio 22 - Mostrar los vendedores que se apellidan Smith
SELECT
    *
FROM
    repventas
WHERE
    nombre LIKE '% Smith';


-- ejercicio 23 - Mostrar los vendedores que aún no tienen asignada una oficina.
SELECT
    *
FROM
    repventas
WHERE
    oficina_rep IS NULL;


-- ejercicio 24 - Mostrar los vendedores a los que se ha asignado ya una oficina
SELECT
    *
FROM
    repventas
WHERE
    oficina_rep IS NOT NULL;


-- ejercicio 25 - Promedio de ventas
SELECT
    AVG(ventas) "Promedio MLG ventas"
FROM
    repventas;


-- ejercicio 26 - importe medio y total de pedidos, limite de credito maximo, 
--cuota media y desviacion
SELECT
    AVG(importe) "Importe medio",
    SUM(importe) "Importe total"
FROM
    pedidos;


SELECT
    MAX(limite_credito) "Limite credito"
FROM
    clientes;


SELECT
    AVG(ventas) "Cuota de ventas media",
    ROUND(STDDEV(ventas), 4) "Desviacion tipica de ventas"
FROM
    repventas;


-- ejercicio 27 - cuota promedio y las ventas promedio
SELECT
    AVG(cuota) "Cuota promedia",
    AVG(ventas) "Promedio de ventas achanta"
FROM
    ventas;


-- ejercicio 28 - rendimiento de cuota promedio de los vendedores 
--(Ventas*100/Cuota)
SELECT
    (AVG(ventas) * 100 / AVG(cuota)) "Rendimiento de ventas promedio"
FROM
    repventas;


-- ejercicio 29 - Mejor rendimiento de ventas
SELECT
    MAX(ventas * 100 / cuota) "Mejor rendimiento de ventas"
FROM
    repventas;


-- ejercicio 30 - Cuotas minima y maxima
SELECT
    MIN(cuota) "Minima",
    MAX(cuota) "Maxima"
FROM
    repventas;


-- ejercicio 31 - ¿Cuál es el total de pedidos aceptados por Bill Adams?
SELECT
    COUNT(cant) "Pedidos totales de bill adams"
FROM
    pedidos
WHERE
    rep = 105;


-- ejercicio 32 - ¿Cuántos vendedores superan su cuota?
SELECT
    COUNT(num_empl) "Cantidad de vendedores que superan su cuota"
FROM
    repventas
WHERE
    ventas >= cuota;


-- ejercicio 33 - ¿Cuántos pedidos tienen un importe superior a 25.000?
SELECT
    COUNT(num_pedido) "Cantidad de pedidos mayores a 25000"
FROM
    pedidos
WHERE
    importe > 25000;


-- ejercicio 34 - ¿Cuál es la fecha de pedido más antigua en la base de datos?
SELECT
    MIN(fecha_pedido)
FROM
    pedidos;


-- ejercicio 35 - Obtén el sueldo medio, el número de comisiones no nulas, el máximo sueldo y 
--el mínimo sueldo de los empleados de la oficina de Nueva York. 
--Emplea el formato adecuado para la salida para las
--cantidades numéricas
SELECT
    ROUND(AVG(ventas), 3) "Ventas",
    COUNT(cuota) "Cuotas totales",
    MAX(ventas) "Mayor venta",
    MIN(ventas)
FROM
    repventas
WHERE
    director = 106;


-- ejercicio 36 - Muestra la titulación de los vendedores en una columna alineando el resultado
--a la derecha, y en mayúsculas
SELECT
    LPAD(UPPER(titulo), 69, ' ') "Titulo formateado"
FROM
    repventas;


-- ejercicio 37 - Muestra el nombre y el apellido de los vendedores en dos columnas 
--independientes.
SELECT
    SUBSTR(nombre, 0, INSTR(nombre, ' ')) "Nombre",
    SUBSTR(nombre, INSTR(nombre, ' ')) "Apellido/s"
FROM
    repventas;


-- ejercicio 38 - Muestra el nombre completo de los vendedores en una columna y 
--en otra diferente sólo el nombre
SELECT
    nombre "Nombre completo",
    SUBSTR(nombre, 0, INSTR(nombre, ' ')) "Nombre"
FROM
    repventas;


-- ejercicio 39 - Muestra el nombre completo de los vendedores en una columna y 
--en otra diferente sólo el apellido.
SELECT
    nombre "Nombre completo",
    SUBSTR(nombre, INSTR(nombre, ' ')) "Apellido/s"
FROM
    repventas;


-- ejercicio 40 - Muestra los nombres de los vendedores ordenados por su número de caracteres
SELECT
    nombre
FROM
    repventas
ORDER BY
    LENGTH(nombre);


-- ejercicio 41 - Muestra el nombre de los vendedores, su fecha de contratación y ésta 
--formateada de la siguiente forma:
--“Contratado el XX de XXXX de XXXX"
SELECT
    nombre,
    'Contratado el ' || TO_CHAR(contrato, 'dd') || ' de ' || TO_CHAR(contrato, 'mm') || ' de ' || TO_CHAR(contrato, 'yyyy') "Fecha"
FROM
    repventas;


-- ejercicio 42 - Muestra los productos “bisagra” ordenados de mayor a menor precio
SELECT
    *
FROM
    productos
WHERE
    descripcion LIKE '%Bisagra%'
ORDER BY
    precio DESC;


-- ejercicio 43 - Convierte la cadena '010221' a fecha y visualiza su nombre de 
--mes en mayúsculas
SELECT
    UPPER(TO_CHAR(TO_DATE('010221', 'ddmmyy'), 'month'))
FROM
    repventas;


-- ejercicio 44 - Muestra los vendedores que lleven más de 25 años trabajando
SELECT
    *
FROM
    repventas
WHERE
    TO_CHAR(contrato, 'yyyy') < (TO_CHAR(SYSDATE, 'yyyy') - 10);


-- contratado hace 25 años
SELECT
    *
FROM
    repventas
WHERE
    months_between(SYSDATE, contrato) / 12 > 10;


-- calculo con los meses
-- ejercicio 45 - Muestre los vendedores de la oficina de Chicago que lleven más
--de 10 años trabajando y tienen un director a su cargo
SELECT
    repventas.*,
    oficinas.*
FROM
    repventas,
    oficinas
WHERE
    repventas.oficina_rep = oficinas.oficina
    AND repventas.director IS NOT NULL
    AND oficinas.ciudad = 'Chicago'
    AND TO_CHAR(repventas.contrato, 'yyyy') < TO_CHAR(SYSDATE, 'yyyy') - 10;


-- ejercicio 46 - Listar los identificadores de fabricante y de producto para los
--productos con precio superior a 2.000 o con pedido de importe 
--superior a 30.000. Obtener también este listado sin productos
--duplicados
SELECT
    DISTINCT producto,
    fab
FROM
    pedidos,
    productos
WHERE
    productos.precio > 2000
    OR pedidos.importe > 30000;


-- ejercicio 47 - Ordenar el resultado del apartado anterior por fabricante y 
--número de producto
SELECT
    DISTINCT producto,
    fab
FROM
    pedidos,
    productos
WHERE
    productos.precio > 2000
    OR pedidos.importe > 30000
ORDER BY
    fab,
    producto;


-- ejercicio 48 - Listar las oficinas con ciudad, nombre y título de sus 
--directores, que presenten un objetivo de ventas superior a 
--600.000.
--inner join oficinas on oficinas.dir = repventas.director (otra forma)
SELECT
    oficinas.*,
    repventas.nombre,
    repventas.titulo
FROM
    oficinas,
    repventas
WHERE
    oficinas.dir = repventas.num_empl
    AND oficinas.ciudad IS NOT NULL
    AND oficinas.objetivo > 600000;


-- ejercicio 49 - Listar todos los pedidos con importe superior a 25.000 
--incluyendo el nombre del vendedor que tomó el pedido y el 
--nombre del cliente que lo solicitó.
SELECT
    pedidos.*,
    repventas.nombre "Vendedor",
    clientes.empresa "Cliente"
FROM
    pedidos,
    repventas,
    clientes
WHERE
    pedidos.rep = num_empl
    AND pedidos.clie = clientes.num_clie
    AND pedidos.importe > 25000;


-- ejercicio 50 - Listar todos los pedidos con importe superior a 25.000 
--incluyendo el nombre del cliente que lo ordenó, el vendedor 
--asociado a ese cliente y la ciudad donde está la oficina en la
--que el vendedor trabaja.
SELECT
    pedidos.importe,
    pedidos.clie,
    repventas.nombre,
    oficinas.ciudad,
    clientes.empresa
FROM
    pedidos,
    repventas,
    oficinas,
    clientes
WHERE
    pedidos.clie = clientes.num_clie
    AND clientes.rep_clie = repventas.num_empl
    AND oficinas.oficina = repventas.oficina_rep
    AND pedidos.importe > 25000
ORDER BY
    pedidos.importe;


-- listar los pedidos que han sido realizados en meses en los que se han
-- contratado vendedores
SELECT
    pedidos.*,
    repventas.contrato
FROM
    pedidos,
    repventas
WHERE
    TO_CHAR(pedidos.fecha_pedido, 'month') = TO_CHAR(repventas.contrato, 'month');


-- listar los pedidos y los vendedores que cumplan que la cuota del vendedor
-- supera al objetivo de la oficina
SELECT
    repventas.nombre,
    oficinas.ciudad
FROM
    repventas,
    oficinas
WHERE
    repventas.cuota > oficinas.objetivo;


-- listar los vendedores junto con sus directores
SELECT
    ven.nombre,
    dir.nombre
FROM
    repventas ven,
    repventas dir
WHERE
    dir.num_empl = ven.director;