--liquibase formatted sql
--changeset author:kkozubek:1

CREATE TABLE MEASURING_CITY_COMMUNES
(
    id            BIGINT AUTO_INCREMENT,
    commune_name  varchar,
    district_name varchar,
    province_name varchar,
    CONSTRAINT PK_COMMUNES PRIMARY KEY (id)
);

CREATE TABLE MEASURING_CITY
(
    id        BIGINT AUTO_INCREMENT,
    city_name varchar,
    commune   BIGINT REFERENCES MEASURING_CITY_COMMUNES(id),
    CONSTRAINT PK_CITY PRIMARY KEY (id)
);

CREATE TABLE MEASURING_STATION
(
    id             BIGINT AUTO_INCREMENT,
    station_name   varchar,
    gegr_lat       varchar,
    gegr_lon       varchar,
    city           BIGINT REFERENCES MEASURING_CITY(id),
    address_street varchar,
    CONSTRAINT PK_STATION PRIMARY KEY (id)
);
