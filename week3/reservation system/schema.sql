   -- create Statements
create table trains(
train_No int(5) primary key auto_increment,
trian_name varchar(10) not null
);

create table coaches(
coach_code varchar(2) primary key,
cost_per_km decimal(5,2)
);

create table stations(
station_id int(11) primary key auto_increment,
station_code varchar(5)
);

create table train_coaches(
train_No int(5),
coach_code varchar(2),
no_of_seats int,
FOREIGN KEY (train_No) REFERENCES trains (train_No),
FOREIGN KEY (coach_code) REFERENCES coaches (coach_code)
);

create table Users(
UserId int primary key auto_increment,
LoginId varchar(20),
Lpassword varchar(20)
);

create table Routes(
RouteId int primary key auto_increment,
OriginStationId int,
DestinationStationId int,
DistanceInKms int,
FOREIGN key (OriginStationId) REFERENCES stations(station_id),
FOREIGN key (DestinationStationId) REFERENCES stations(station_id)
);

create table TrainRouteMaps(
RouteId int ,
train_No int(5),
ArrivalTime time,
DepatureTime time,
DurationInMins int,
FOREIGN key (train_No) REFERENCES trains(train_No),
FOREIGN key (RouteId) REFERENCES Routes(RouteId),
primary key (RouteId,train_No)
);

create table Bookings(
BookingRefNo int primary key auto_increment,
RouteId int,
train_No int(5),
coach_code varchar(2),
DateOfJourney date,
DateOfBooking date,
NoOfTickets int not null,
FOREIGN key (RouteId) REFERENCES Routes(RouteId),
FOREIGN key (train_No) REFERENCES trains(train_No),
FOREIGN key (coach_code) REFERENCES coaches(coach_code)
);





			-- Insert Statements
-- into table trains
insert into trains(train_No,train_name) values (1,'venkatadri');
insert into trains(train_No,train_name) values (2,'chennai ');
insert into trains(train_No,train_name) values (3,'Sabari ');

--into stations
insert into stations(station_id,station_code) values (1,"MBNR");
insert into stations(station_id,station_code) values (2,"MBM");
insert into stations(station_id,station_code) values (3,"TBM");
insert into stations(station_id,station_code) values (4,"SBC");
insert into stations(station_id,station_code) values (5,"CUL");


--INTO routes
insert into routes(RouteId,OriginStationId,DestinationStationId,DistanceInKms) values (1,1,2,500);
insert into routes(RouteId,OriginStationId,DestinationStationId,DistanceInKms) values (2,1,3,550);
insert into routes(RouteId,OriginStationId,DestinationStationId,DistanceInKms) values (3,2,3,50);
insert into routes(RouteId,OriginStationId,DestinationStationId,DistanceInKms) values (4,2,4,220);


--Into train Route Map
insert into TrainRouteMaps(RouteId,train_No,ArrivalTime,DepatureTime,DurationInMins) values (1,1,'5:00','6:30',1.5*60);
insert into TrainRouteMaps(RouteId,train_No,ArrivalTime,DepatureTime) values (2,1,'5:00','12:25');
insert into TrainRouteMaps(RouteId,train_No,ArrivalTime,DepatureTime) values (3,1,'5:00','14:00');
insert into TrainRouteMaps(RouteId,train_No,ArrivalTime,DepatureTime) values (1,3,'6:00','8:00');
insert into TrainRouteMaps(RouteId,train_No,ArrivalTime,DepatureTime) values (2,3,'5:00','18:00');
insert into TrainRouteMaps(RouteId,train_No,ArrivalTime,DepatureTime) values (1,2,'7:00','23:00');

-- INSERT INTO COACHES 
insert into coaches(coach_code,cost_per_km) values ('S1',2.3);
insert into coaches(coach_code,cost_per_km) values ('B1',5);

--intert into train coaches
insert into train_coaches(train_No,coach_code,no_of_seats) values (1,'S1',72);
insert into train_coaches(train_No,coach_code,no_of_seats) values (1,'B1',68);

-- need as ask adding autoincement to coloum of created table . statement - alter table <tableName> modify
