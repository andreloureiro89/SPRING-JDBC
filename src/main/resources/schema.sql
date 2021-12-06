create table person (
   id number not null,
   name varchar(255) not null,
   location varchar(255),
   birthday varchar(255),
   primary key(id)
);
 
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTHDAY ) VALUES (1,  'Ranga', 'Hyderabad','25-07-2987');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTHDAY ) VALUES (2,  'James', 'New York','03-03-1991');
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTHDAY ) VALUES (3,  'Pieter', 'Amsterdam','20-02-1988');