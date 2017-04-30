create database banco;
use banco;

create table conta(
numero int(11) not null primary key,
cliente varchar(15),
saldo float
);
