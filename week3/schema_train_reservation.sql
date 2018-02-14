-- Creating Database form the Diagram

#creating table trains
create table trains (train_No int(5),train_name varchar(10),primary key(train_no));

#
create table coaches(coach_code varchar(2),cost_per_km numeric(5,2),primary key (coach_code));

create table stations(station_id int,station_code varchar(5),primary key(station_id));

create table train_coaches (
	train_no int(5),
	foreign key (train_no)  references trains(train_no),
	coach_code varchar(2),
	 foreign key(coach_code) references coaches(coach_code),
	 no_of_seats int
);


