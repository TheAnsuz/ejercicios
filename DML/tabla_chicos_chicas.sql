create table chicos (
    nombre varchar2(100) constraint chicos_pk primary key,
    ciudad varchar2(100)
);

create table chicas (
    nombre varchar2(100) constraint chicas_pk primary key,
    ciudad varchar2(100)
);

insert into chicos values('Mario','VA');
insert into chicos values('Antonio','MU');
insert into chicos values('Fernando','VL');
insert into chicos values('Adrian','VA');
insert into chicos values('Jose');
insert into chicos values('Juan','MU');
insert into chicos values('Eustaquio','MU');
insert into chicos values('Federico','VA');

insert into chicas values('Maria','VA');
insert into chicas values('Antonia','MU');
insert into chicas values('Fernanda','VA');
insert into chicas values('Adriana','VA');
insert into chicas values('Josefa','VA');
insert into chicas values('Juana','MU');
insert into chicas values('Eustaquia','MU');
insert into chicas values('Federica','VA');
