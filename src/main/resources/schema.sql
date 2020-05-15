DROP TABLE IF EXISTS TBL_DOCTORS;
 
CREATE TABLE TBL_DOCTORS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  specialist VARCHAR(250) NOT NULL,
  avail_time VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS TBL_PATIENTS;
 
CREATE TABLE TBL_PATIENTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  age NUMBER NOT NULL
);

DROP TABLE IF EXISTS TBL_BOOKING;

CREATE TABLE TBL_BOOKING (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  patient_id NUMBER NOT NULL,
  doctor_id NUMBER NOT NULL,
  booked_slot VARCHAR(250) NOT NULL,
  comments VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL
);