Select * from stops;
Select * from geo_point;
select * FROM type_transport;
SELECT * FROM  transport;
SELECT * FROM route;
SELECT * FROM route_with_stop;

UPDATE stops set name_stop_en = 'Vasy', name_stop_ru = 'Pety' WHERE id = 4;

INSERT INTO route(id_transport, name_route_ru, name_route_en) VALUES (1,'Paladina','Paladina'),
                                                                      (2,'Ushakova','Ushakova'),
                                                                      (3,'Novovbelichi','Novovbelichi');

DELETE FROM route WHERE id = ?;


INSERT INTO route(id_transport, name_route_ru, name_route_en) VALUE (4,'Paladina','Paladina');
ALTER TABLE route_with_stop DROP id;
INSERT INTO geo_point(latitude, longtude) VALUES ('4567','473'),('1234','4746');

INSERT INTO stops(name_stop_ru, name_stop_en, id_geoPoint)VALUES('Lvivska','Lvivska',1),
                                                                ('Shulavska','Shulavska',2),
                                                                ('Berestayska','Berestayska',3),
                                                                ('Akademmistechko','Akademmistechko',4);

INSERT INTO route_with_stop(id_stop, id_route) VALUES (1,1),(1,2),(2,3),(3,3);

INSERT INTO type_transport(type_transport) VALUES('BUS'),('TRAM'),('TROLLEYBUS');
# INSERT INTO type_transportEnum(type_transport) VALUES('BUS'),('TRAM'),('TROLLEYBUS');

# SELECT * FROM stops st JOIN route_with_stop rs ON st.id = rs.id_stop WHERE id_route = 2 order by id_stop;



INSERT INTO  transport(number_bus, capacity, modelRu, modelEn,id_type)VALUES (187,25,'Honda','Honda',1),(210,25,'Lada','Lada',2),(61,40,'tavriya','tavriya',3);

