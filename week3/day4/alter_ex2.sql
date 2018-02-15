/*	Replace the null values in quarterly, half_yearly and annual columns with 0 
and make those columns as not nullable.	*/

update marks
set annual=ifnull(annual,0),
half_yearly=ifnull(half_yearly,0),
quarterly=ifnull(quarterly,0);

alter table marks modify annual int not null,modify half_yearly int not null,modify quarterly int not null;
