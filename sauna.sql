CREATE DATABASE sauna;

CREATE TABLE sauna
(id SERIAL PRIMARY KEY,
 name VARCHAR(100) not null,
 type VARCHAR(10) not null,
 adress VARCHAR(150) not null,
 url VARCHAR(200) not null,
 point1 VARCHAR(50),
 point2 VARCHAR(50),
 point3 VARCHAR(50),
 impression VARCHAR (400) not null,
 image_data BYTEA,
 star INTEGER);

CREATE TABLE users
(id serial not null,
 name_id varchar,
 pass varchar,
 primary key (id));
