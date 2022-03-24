select * from hr.employees;

-- mostrarlos datos de los empleados que tienen el mismo puesto que Luis Popp

select *
from hr.employees
where hr.employees.first_name = 'Luis' and hr.employees.last_name = 'Popp';

-- tambien se puede hacer
select *
from hr.employees
where hr.employees.job_id = (
    select hr.employees.job_id
    from hr.employees
    where hr.employees.first_name = 'Luis' and hr.employees.last_name = 'Popp'
);

-- mostrar las oficinas con un objetivo superior a la suma de las cuotas de
-- sus vendedores

select *
from oficinas
where objetivo > (
    select sum(cuota)
    from repventas
    where oficinas.oficina = repventas.oficina_rep
);

-- mostrar los vendedores con cuotas de venta iguales o superiores al objetivo
-- de ventas de la oficina de atlanta

select * from repventas;
select * from oficinas;

select * 
from repventas
where cuota >= (
    select sum(objetivo)
    from oficinas
    where ciudad = 'Atlanta'
);

-- mostrar los clientes atendidos por Bill Adams

select clientes.*, repventas.nombre "Atendido por"
from clientes, repventas
where repventas.nombre = 'Bill Adams' and repventas.num_empl = clientes.rep_clie;

-- mostrar los productos del fabricante ACI cuyas existencias superen las
-- existencias del producto ACI-41004
    
select * from productos;
select * from pedidos;
    
select *
from productos
where productos.id_fab = 'ACI' and existencias > (
    select existencias
    from productos
    where id_producto = '41004' and id_fab = 'ACI'
);
    
-- mostrar los vendedores cuyas ventas son las maximas de las ventas de los 
-- vendedores de cada oficina

select raiz.*
from repventas raiz
where raiz.ventas = (
    select max(des.ventas)
    from repventas des
    group by des.oficina_rep
    having raiz.oficina_rep = des.oficina_rep
);

/* Segunda seccion de ejercicios de subconsultas */
select * from repventas;
select * from oficinas;

-- mostrar los vendedores que trabajan en oficinas que superan su objetivo de
-- ventas

select rep.*
from repventas rep
where rep.ventas > (
    select objetivo
    from oficinas
    where rep.oficina_rep = oficinas.oficina
);

-- mostrar los vendedores que no trabajan en oficinas dirigidas por Bill Adams

select rep.*
from repventas rep
where rep.oficina_rep <> (
    select oficina
    from oficinas, repventas
    where oficinas.dir = 
);

-- mostrar los clientes que han realizado pedidos al fabricante ACI de
-- productos cuyo codigo empieza por 41, entre enero y octubre de 2019

select * from pedidos;
select * from productos;
select * from clientes;

select * 
from clientes, pedidos
where num_clie = clie and fab = 'ACI' and producto like '41%'
 and
fecha_pedido between '1-JAN-19' and '30-OCT-19'

-- mostrar los productos para los que se ha realizado un importe minimo de 25k

select *
from productos, pedidos
where productos.id_producto = pedidos.producto and productos.id_fab = pedidos.fab
and pedidos.importe >= 25000;

-- mostrar los clientes que no han realizado ningun pedido en el año 2020

select * from pedidos;
select * from clientes;

select * 
from clientes
where num_clie not in (
    select clie
    from pedidos
    where fecha_pedido between '1-JAN-20' and '31-DEC-20'
);

-- mostrar los clientes de la cartera de noseque smith que no han realizado
-- pedidos superiores a 3k

/* Copiado de Andres Bless */
select clientes.*
from clientes, repventas
where clientes.rep_clie = repventas.num_empl
and repventas.nombre like 'Sue Smith'
and not exists (
    select *
    from pedidos
    where pedidos.clie = repventas.num_empl
    and pedidos.importe > 3000
);

-- mostrar las oficinas con algun vendedor cuya cuota suponga mas del 50% del
-- objetivo de ventas de su oficina

select oficinas.*
from oficinas
where oficinas.objetivo/2 < (
    select sum(repventas.cuota)
    from repventas
    where repventas.oficina_rep = oficinas.oficina
);

/* Ejercicios 11-3-22 */

-- mostrar los vendedores que han realizado algun pedido que represente 
-- más del 10% de su cuota
---- realiza la consulta de todas las formas posibles

select repventas.*
from repventas, pedidos
where repventas.num_empl = pedidos.rep
and pedidos.importe > repventas.cuota/10;

--  mostrar los los vendedores que no dirigen ninguna oficina.
---- realiza la consulta de todas las formas posibles

select *
from repventas
where num_empl not in (
    select dir
    from oficinas
);

-- mostrar las oficinas junto a sus objetivos de ventas de aquellas en las ventas
-- de sus vendedores superan el 50% del objetivo de la oficina

select oficinas.oficina "Nº Oficina", oficinas.objetivo "Objetivo"
from oficinas
where oficinas.objetivo/2 < (
    select sum(repventas.ventas)
    from repventas
    where repventas.oficina_rep = oficinas.oficina
);

/* Ejercicios 15-3-22 */

-- mostrar los vendedores (nombre y codigo) cuyo importe de pedido medio
-- de productos fabricados por ACI, supera el importe de pedido medio
-- global en la empresa.

select repventas.nombre,repventas.num_empl, avg(pedidos.importe)
from repventas, pedidos
where repventas.num_empl=pedidos.rep
and pedidos.fab like 'ACI'
group by repventas.num_empl, repventas.nombre
having avg(pedidos.importe) > (
        select avg(pedidos.importe)
        from pedidos
);

-- mostrar los vendedores (nombre y codigo) cuyo importe de pedido medio
-- de productos fabricados por ACI, es al menos  tan grande  el importe de 
-- pedido medio global de ese vendedor

-- mostrar los productos que se han pedido un total de veces que supera el 
-- 25% de sus existencias
