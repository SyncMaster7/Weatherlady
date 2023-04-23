use weatherlady;

create table locationinfo (
id int not null auto_increment primary key,
lat double not null,
lon double not null,
region varchar(255),
country_name varchar(255) not null
);

create table weatherinfo (
id int not null auto_increment primary key,
request_date timestamp not null,
city varchar(255) not null,
location varchar(255) not null,

Temperature double not null,
RealFeelTemperature double not null,
RelativeHumidity int not null,
DewPoint double not null,
WindSpeed double not null,
UVIndex int not null,
UVIndexText varchar(255),
Visibility double not null,
Pressure double not null
);