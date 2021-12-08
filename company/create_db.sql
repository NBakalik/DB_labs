CREATE SCHEMA IF NOT EXISTS lab7_db DEFAULT CHARACTER SET utf8;
USE lab7_db;

DROP TABLE IF EXISTS effect_zone;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS street;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS pharmacy;
DROP TABLE IF EXISTS drug_list;
DROP TABLE IF EXISTS drug_zone_joint;
DROP TABLE IF EXISTS pharmacy_drug_joint;

CREATE TABLE effect_zone
(
    id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE post
(
    name VARCHAR(15) NOT NULL PRIMARY KEY
);

CREATE TABLE street
(
    name VARCHAR(30) NOT NULL PRIMARY KEY
);

CREATE TABLE employee
(
    id              INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(20) NOT NULL,
    surname         VARCHAR(20) NOT NULL,
    id_number       VARCHAR(10) NOT NULL,
    passport_number VARCHAR(9)  NOT NULL,
    experience      INT(2)      NOT NULL,
    birthday        DATE        NOT NULL,
    post            VARCHAR(15) NOT NULL,
    pharmacy_id     INT         NOT NULL
);

CREATE TABLE pharmacy
(
    id                  INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(45) NOT NULL,
    house_number        VARCHAR(5)  NOT NULL,
    url                 VARCHAR(45) NOT NULL,
    work_time_open      TIME        NOT NULL,
    work_time_close     TIME        NOT NULL,
    is_day_off_saturday TINYINT(1)  NOT NULL,
    is_day_off_sunday   TINYINT(1)  NOT NULL,
    street              VARCHAR(30) NOT NULL
);

CREATE TABLE drug_list
(
    id              INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(45) NOT NULL,
    code            VARCHAR(9)  NOT NULL,
    need_receipt    TINYINT     NOT NULL,
    is_narcotic     TINYINT     NOT NULL,
    is_psychotropic TINYINT     NOT NULL
);

CREATE TABLE drug_zone_joint
(
    id_drug INT NOT NULL,
    id_zone INT NOT NULL,
    PRIMARY KEY (id_drug, id_zone)
);

CREATE TABLE pharmacy_drug_joint
(
    id_pharmacy INT NOT NULL,
    id_drug     INT NOT NULL,
    PRIMARY KEY (id_pharmacy, id_drug)
);