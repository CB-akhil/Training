
      --Rail reservation system queries. total quries:-21
/*	To get the list of all trains 	*/
select train_name from trains;

/*	To get the list of all train routes in the database		*/
select train_name,o.station_code as orgin,d.station_code as destination
from trains,routes,TrainRouteMaps,Stations as o,Stations as d
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId
and TrainRouteMaps.train_No=trains.train_No
and TrainRouteMaps.RouteId=routes.RouteId;

/*	Total number of seats in the each train.		*/
select train_name,sum(no_of_seats) as `number of seats`
from trains,train_coaches
where trains.train_No=train_coaches.train_No
group by train_name;

/*	List of all routes goes to Bangalore (sbc)		*/
select o.station_code as orgin,d.station_code as destination
from routes,Stations as o,Stations as d
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId 
and d.station_code='SBC';

/*	List of all routes starting from bangalore, calcutta and chennai		*/
select o.station_code as orgin,d.station_code as destination
from routes,Stations as o,Stations as d
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId 
and (o.station_code = 'SBC' or o.station_code='CUL' or o.station_code='TBM' or o.station_code='MBM');

/*	List of all the bookings booked between 1st Jan 2005 and 31st Dec 2005		*/
select train_name,o.station_code as orgin,d.station_code as destination,
coach_code,DateofJourney,NoOfTickets,DateOfBooking,NoOfTickets
from bookings,trains,routes,Stations as o,Stations as d,routes
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId
and bookings.train_No=trains.train_name 
and (DateOfBooking between '1st Jan 2005' and '31st Dec 2005');

/*	List of all trains whose name begins with B		*/
select train_name
from trains
where train_name like 'B%';

/*	List of all bookings where DOB is not null		*/
select train_name,o.station_code as orgin,d.station_code as destination,
coach_code,DateofJourney,NoOfTickets,DateOfBooking,NoOfTickets
from bookings,trains,routes,Stations as o,Stations as d,routes
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId
and bookings.train_No=trains.train_name 
and DateOfBooking is not null;

/*	List of all bookings for the booked in 2006, DOJ in 2007		*/
select train_name,o.station_code as orgin,d.station_code as destination,
coach_code,DateofJourney,NoOfTickets,DateOfBooking,NoOfTickets
from bookings,trains,routes,Stations as o,Stations as d,routes
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId
and bookings.train_No=trains.train_name 
and year(DateOfBooking) = 2006 and year(DateofJourney)=2007;

/*	Total number of coaches in the all the trains		*/
select train_name,count(coach_code) as 	`number of coaches`
from train_coaches,trains
where train_coaches.train_No=trains.train_No
group by trains.train_No;

/*	Total number of bookings in the database for the train no 16198		*/
select train_name,o.station_code as orgin,d.station_code as destination,
coach_code,DateofJourney,NoOfTickets,DateOfBooking,NoOfTickets
from bookings,trains,routes,Stations as o,Stations as d,routes
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId
and bookings.train_No=trains.train_name 
and bookings.train_No=16198;

/*	Total no of tickets column 'total' , booked for train no. 14198		*/
select count(NoOfTickets) as total
from bookings
where bookings.train_No=14198
group by bookings.train_No;

/*	Minimum distance route		*/
select o.station_code as orgin,d.station_code as destination
from Stations as o,Stations as d,routes
where o.station_id=routes.OriginStationId and d.station_id=routes.DestinationStationId
and DistanceInKms=(select MIN(DistanceInKms) from routes);

/*	Total number of tickets booked for each train in the database		*/
select count(NoOfTickets) as total,train_No
from bookings
group by bookings.train_No;

/*	cost for 50 kms for each coach.		*/


/*	List the train name and departure time for the trains starting from Bangalore.		*/




/*	List the trains for which the total no of tickets booked is greater than 500		*/




/*	List the trains for which the total no of tickets booked is lesser than 50		*/




/*	List the bookings along with train name, origin station, destination station and coach code after the date of journey ’25th Feb 2015’		*/




/*	List the trains via the route Mysore - Chennai		*/




/*	List the trains for which are booked till now.		*/



