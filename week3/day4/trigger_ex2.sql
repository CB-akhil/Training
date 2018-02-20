
alter table medals change medal_won  medal_received varchar(10);

alter table medals add medal_received varchar(10);

delimiter //
create trigger cp_medal before insert on medals
for each row
BEGIN
IF(new.medal_received = null) then
set new.medal_received=new.medal_won;
else 
set new.medal_won=new.medal_received;
end IF;
end;
//
delimiter ;

delimiter //
create trigger cp_medal_update before update on medals
for each row
BEGIN
IF(new.medal_received = null) then
set new.medal_received=new.medal_won;
else 
set new.medal_won=new.medal_received;
end IF;
end;
//
delimiter ;


# to drop coloum medal_won
alter table medals drop medal_won;
