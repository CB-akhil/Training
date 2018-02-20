create database phonebook;

use phonebook;

create table data(
name varchar(100),
address varchar(100),
mobile bigint,
home bigint,
work bigint
);

-- Inserting some values to data
insert into data(name,address,mobile,home,work) values ('Akhil','mahabubnagar',9440429022,9633469511,8848786327);
insert into data(name,address,mobile) values ('nikhil','hyderabad',9440429022);