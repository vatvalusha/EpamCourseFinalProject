-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.1.39 - MySQL Community Server (GPL)
-- ОС Сервера:                   Mac OS
-- --------------------------------------------------------

CREATE DATABASE IF NOT EXISTS database epam3;
use epam3;

-- Дамп структуры для таблица epam3.type_transport
 create table type_transport(
 id int not null auto_increment primary key,
type_transport varchar(30) not null
);

-- Дамп структуры для таблица epam3.geo_point
DROP TABLE IF EXISTS epam3.geo_point;
create table geo_point(
id int not null auto_increment primary key,
latitude double not null,
longtude double not null
);

-- Дамп структуры для таблица epam3.stops
DROP TABLE IF EXISTS epam3.stops;
create table stops(
id int auto_increment not null primary key,
name_stop_ru varchar(30) not null,
name_stop_en varchar(30) not null,
 id_geopoint  int not null,
CONSTRAINT foreign key(id_geoPoint) references geo_point(id)
);

-- Дамп структуры для таблица epam3.transport
DROP TABLE IF EXISTS epam3.transport;
create table transport(
id int auto_increment not null primary key,
#route_id int not null,
number_bus int(3) not null,
capacity int not null,
modelRu varchar(30) not null,
modelEn varchar(30)not null,
id_type int  not null,
foreign key(id_type) references type_transport(id)
												on delete cascade
												on update cascade
);

-- Дамп структуры для таблица epam3.route
DROP TABLE IF EXISTS epam3.route;
create table route(
id int auto_increment not null primary key,
id_transport int not null,
name_route_ru varchar(50),
name_route_en varchar(50),

index(id_transport),
foreign key(id_transport) references transport(id)
										on delete cascade
                                        on update cascade

);

-- Дамп структуры для таблица epam3.route_with_stop
DROP TABLE IF EXISTS epam3.route_with_stop;
create table route_with_stop(
id int not null auto_increment primary key,
id_stop int not null,
id_route int not null,
foreign key(id_stop) references stops(id)
												on delete cascade
												on update cascade,
foreign key(id_route) references route(id)
												on delete cascade
												on update cascade
);