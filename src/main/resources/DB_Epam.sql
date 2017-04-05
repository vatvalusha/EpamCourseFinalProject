

#drop database epam3;

CREATE SCHEMA IF NOT EXISTS epam3 DEFAULT CHARACTER SET utf8;
use epam3;

#1
 create table if not exists type_transport(
 id int not null auto_increment primary key,
type_transport varchar(30) not null
);#2
create table if not exists geo_point(
id int not null auto_increment primary key,
latitude double  not null,
longtude double  not null
);
#3
create table if not exists stops(
id int auto_increment not null primary key,
name_stop_ru varchar(30) not null,
name_stop_en varchar(30) not null,
 id_geopoint  int not null,
CONSTRAINT foreign key(id_geoPoint) references geo_point(id)
);
#4
create table if not exists route(
id int auto_increment not null primary key,
name_route_ru varchar(50),
name_route_en varchar(50),
id_type int not null,
foreign key(id_type) references type_transport(id)
												on delete cascade
                                                on update cascade
);
create table if not exists transport(
id int auto_increment not null primary key,
route_id int not null,
number_bus int(3) not null,
capacity int not null,
modelRu varchar(30) not null,
modelEn varchar(30)not null,
id_type int  not null,
foreign key(id_type) references type_transport(id)
												on delete cascade
                                                on update cascade,
foreign key(route_id) references route(id)
												on delete cascade
                                                on update no action
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

create table if not exists route_with_stop(
id int not null auto_increment,
id_stop int not null,
id_route int not null,
order_by_route int not null,
primary key(id,id_stop,id_route),
constraint foreign key(id_stop) references stops(id)
												on delete cascade
												on update no action,
constraint foreign key(id_route) references route(id)
												on delete cascade
												on update no action
);

INSERT INTO epam3.type_transport(type_transport) values
('Tram'),
('Trolleybus'),
('Bus');

INSERT INTO epam3.route (name_route_en, name_route_ru, id_type) VALUES
  ( 'STAROVOKZALNA - MIKHAILIVSKA BORSHCHAGOVKA', 'СТАРОВОКЗАЛЬНАЯ - МИХАЙЛОВСКАЯ БОРЩАГОВКА',1),
  ( 'MIKHAILIVSKA BORSHCHAGOVKA - KILTSEVA ROAD', 'МИХАЙЛОВСКАЯ БОРЩАГОВКА - КОЛЬЦЕВАЯ ДОРОГА', 1),
  ( 'STAROVOKZALNA - KILTSEVA ROAD', 'СТАРОВОКЗАЛЬНАЯ - КОЛЬЦЕВАЯ ДОРОГА', 1),
  ( 'LYBIDSKAYA - NAUKI ave.', 'ЛЫБИДСКАЯ - пр.НАУКИ', 2),
  ( 'JEL.MASSIV - DVOREC SPORTA', 'ЖЕЛ.МАССИВ - ДВ.СПОРТА', 2),
  ( 'BILECKAYA STR. - LVA TOLSTOGO', 'УЛ.БИЛЕЦКАЯ - ЛЬВА ТОЛСТОГО', 2),
  ('HOLOSEEVSKAYA - YUJNAYA', 'ГОЛОСЕЕВСКАЯ - ЮЖНАЯ', 3),
  ( 'BULGAKOVA - SHULYAVSKAYA', 'БУЛГАКОВА - ШУЛЯВСКАЯ', 3),
  ( 'DRUJBI NARODOV - PEVCHESKOE POLE', 'ДРУЖБЫ НАРОДОВ - ПЕВЧЕСКОЕ ПОЛЕ', 3);

  insert into epam3.geo_point(latitude,longtude) values
  (50.443677, 30.489220),
  (50.446236, 30.488276),
  (50.446452, 30.467151),
  (50.446431, 30.454770),
  ( 50.443939, 30.442206),
  (50.441195, 30.431256),
  ( 50.438205, 30.419781),
  (50.435947, 30.410897),
  (50.433046, 30.399514),
  (50.429622, 30.386215),
  ( 50.426591, 30.374472),
  (50.425234, 30.367354),
  ( 50.425991, 30.384668),
  (50.420385, 30.381857),
  (50.417343, 30.388119),
  ( 50.415080, 30.394246),
  (50.411737, 30.396788),
  (50.407990, 30.403537),
  (50.407325, 30.407275);

  insert into epam3.stops(name_stop_en, name_stop_ru,id_geopoint) values
  ('STAROVOKZALNAYA', 'СТАРОВОКЗАЛЬНАЯ',1),
  ( 'POBEDY SQUARE', 'ПЛОЩАДЬ ПОБЕДЫ',2),
  ( 'POLITEHNICHESKAYA', 'ПОЛИТЕХНИЧЕСКАЯ',3),
  ( 'POLOVAYA', 'ПОЛЕВАЯ', 4),
  ( 'INDUSTRIALNAYA', 'ИНДУСТРИАЛЬНАЯ', 5),
  ( 'NATIONAL AERO UNIVERSITY', 'АВИАЦИОННЫЙ УНИВЕРСИТЕТ',6),
  ( 'GEROEV SEVASTOPOLA', 'ГЕРОЕВ СЕВАСТОПОЛЯ', 7),
  ( 'IVANA LEPSE', 'ИВАНА ЛЕПСЕ', 8),
  ( 'SEMII SOSNINYKH', 'СЕМЬИ СОСНИНЫХ', 9),
  ( 'GNATA YURI', 'ГНАТА ЮРЫ', 10),
  ( 'ROMEN ROLLANA', 'РОМЕН РОЛЛАНА',11),
  ( 'KILTSEVA ROAD', 'КОЛЬЦЕВАЯ ДОРОГА', 12),
  ( 'GENERALA POTAPOVA', 'ГЕНЕРАЛА ПОТАПОВА', 12),
  ( 'KOLTSOVA BULEVARD', 'БУЛЬВАР КОЛЬЦОВА', 14),
  ( 'ZODCHIKH STREET', 'УЛ. ЗОДЧИХ', 15),
  ( 'JOLUDEVA STREET', 'УЛ ЖОЛУДЕВА', 16),
  ( 'GRIGOROVICHA-BARSKOGO STREET', 'УЛ. ГРИГОРОВИЧА-БАРСКОГО',17),
  ( 'BULGAKOVA STREET', 'УЛ. БУЛГАКОВА', 18),
  ( 'MIKHAILIVSKA BORSHCHAGOVKA', 'МИХАЙЛОВСКАЯ БОРЩАГОВКА',19);


INSERT INTO epam3.transport ( modelEn,modelRu, capacity,number_bus, id_type, route_id) VALUES
  ('KT3UA', 'KT3UA', 60,1, 1,3),
  ('KT3UA', 'KT3UA', 60, 2,1,3),
  ( 'KT3UA', 'KT3UA', 60, 3, 1,3),
  ( 'KT3UA', 'KT3UA', 60, 5, 1,3),
  ( 'KT3UA', 'KT3UA', 60, 7, 1,3),
  ( 'KT3UA', 'KT3UA', 60, 9, 1,3),
  ( 'KT3UA', 'KT3UA', 60,13, 1,1),
  ( 'KT3UA', 'KT3UA', 60,  18, 1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 5, 1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60,  27,1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 401,1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 3, 1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 2, 1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 1,1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 3, 1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 4 ,1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60, 5, 1,1),
  ( 'Tatra-T3', 'Tatra-T3', 60,  6,1,1);
  INSERT INTO epam3.route_with_stop (id_route, id_stop, order_by_route) VALUES
  (1, 1, 1),
  (1, 2, 2),
  (1, 3, 3),
  (1, 4, 4),
  (1, 5, 5),
  (1, 6, 6),
  (1, 7, 7),
  (1, 8, 8),
  (1, 9, 9),
  (1, 10, 10),
  (1, 11, 11),
  (1, 12, 12),
  (1, 13, 13),
  (1, 14, 14),
  (1, 15, 15),
  (1, 16, 16),
  (1, 17, 17),
  (3, 1, 1),
  (3, 2, 2),
  (3, 3, 3),
  (3, 4, 4),
  (3, 5, 5),
  (3, 6, 6),
  (3, 7, 7),
  (3, 8, 8),
  (3, 9, 9),
  (3, 10, 10),
  (3, 11, 11),
  (3, 12, 12);