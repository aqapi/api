--liquibase formatted sql
--changeset author:kkozubek:1

INSERT INTO MEASURING_CITY_COMMUNES
VALUES (1, 'Witonia', 'łęczycki', 'ŁÓDZKIE');
INSERT INTO MEASURING_CITY_COMMUNES
VALUES (2, 'Nisko', 'niżański', 'PODKARPACKIE');

INSERT INTO MEASURING_CITY
VALUES (209, 'Gajew', 1);
INSERT INTO MEASURING_CITY
VALUES (600, 'Nisko', 2);

INSERT INTO MEASURING_STATION
VALUES (291, 'Gajew, Ujęcie Wody', '52.143250', '19.233225', 209, 'Ujęcie wody');
INSERT INTO MEASURING_STATION
VALUES (659, 'Nisko, ul. Szklarniowa', '50.529892', '22.112467', 600, 'Szklarniowa');