alter table marks add average int;

create trigger add_avg before update on marks
for each row set new.average = (new.quarterly + new.half_yearly + new.annual)/3;

create trigger add_avg_atinsert before insert on marks
for each row set new.average = (new.quarterly + new.half_yearly + new.annual)/3;
