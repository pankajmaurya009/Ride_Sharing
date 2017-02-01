use ride_sharing_test;

set FOREIGN_KEY_CHECKS = 0;
truncate table drivers;
truncate table cars;
truncate table cities;
truncate table drivers_city_map;
truncate table passengers;
truncate table trips;
set FOREIGN_KEY_CHECKS = 1;


insert into drivers (name,age,gender,tickets,isban) values
  ('roy',34,'M',1,'N'),
  ('ritt',38,'F',0,'N');

insert into cars (name,type,year,make,model,driver_id) values
  ('car1','LUX',1994,'Make1','Model1',1),
  ('car2','BASIC',2014,'Make2','Model2',1),
  ('car3','LUX',1894,'Make3','Model3',1),
  ('car4','BASIC',1900,'Make4','Model3',2),
  ('car5','LUX',2040,'Make4','Model4',2);

insert into cities (name,state,day_rate_per_km,night_rate_per_km) values
  ('city1','UP',34.00,'56.78'),
  ('city2','AP',24.00,'51.71'),
  ('city3','HP',54.00,'68.78'),
  ('city4','TN',39.00,'48.72'),
  ('city5','KL',34.00,'47.78');

insert into drivers_city_map (drivr_id,city_id) values
  (1,1),
  (1,2),
  (1,5),
  (1,4),
  (2,3),
  (2,2),
  (2,5);


insert into passengers (name,age,gender,credit_balance,isban) values
  ('p1',34,'M',45000.00,'N'),
  ('p2',64,'F',500.00,'N'),
  ('p3',24,'M',15000.00,'N');

insert into trips (city_id1,car_id1,driver_id1,passenger_id1,trip_distance,was_successfull) values
  (1,1,1,2,10.00,'Y'),
  (1,3,1,1,20.00,'Y'),
  (2,1,1,1,40.00,'Y'),
  (1,5,1,2,50.00,'Y');



