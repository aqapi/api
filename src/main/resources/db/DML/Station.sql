--liquibase formatted sql
--changeset author:kkozubek:1

CREATE TABLE MEASURING_CITY_COMMUNES
(
    id            BIGINT NOT NULL AUTO_INCREMENT,
    commune_name  varchar(200),
    district_name varchar(200),
    province_name varchar(200),
    CONSTRAINT PK_COMMUNES PRIMARY KEY (id)
);

CREATE TABLE MEASURING_CITY
(
    id        BIGINT,
    city_name varchar(200),
    commune   BIGINT REFERENCES MEASURING_CITY_COMMUNES (id),
    CONSTRAINT PK_CITY PRIMARY KEY (id)
);

CREATE TABLE MEASURING_STATION
(
    id             BIGINT,
    station_name   varchar(200),
    gegr_lat       varchar(200),
    gegr_lon       varchar(200),
    city           BIGINT REFERENCES MEASURING_CITY (id),
    address_street varchar(200),
    CONSTRAINT PK_STATION PRIMARY KEY (id)
);
