--liquibase formatted sql
--changeset author:kkozubek:1

CREATE TABLE MEASURING_DATA
(
    id            bigint NOT NULL AUTO_INCREMENT,
    pollution_key VARCHAR,
    CONSTRAINT PK_DATA PRIMARY KEY (id)
);

CREATE TABLE MEASURING_DATA_VALUES
(
    id              bigint NOT NULL AUTO_INCREMENT,
    date_of_reading DATETIME,
    pollution_value float,
    CONSTRAINT PK_VALUES PRIMARY KEY (id)
);

CREATE TABLE DATA_VALUES
(
    data_id bigint REFERENCES MEASURING_DATA(id),
    value_id bigint REFERENCES MEASURING_DATA_VALUES(id)
);