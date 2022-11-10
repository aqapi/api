--liquibase formatted sql
--changeset author:kkozubek:1

CREATE TABLE MEASURING_DATA_VALUES
(
    id              bigint NOT NULL generated always as identity (increment by 1),
    date_of_reading VARCHAR,
    pollution_value float,
    CONSTRAINT PK_VALUES PRIMARY KEY (id)
);

CREATE TABLE MEASURING_DATA
(
    id            bigint NOT NULL generated always as identity (increment by 1),
    pollution_key VARCHAR,
    `values`      bigint REFERENCES MEASURING_DATA_VALUES (id),
    CONSTRAINT PK_DATA PRIMARY KEY (id)
);