INSERT INTO 
	TBL_DOCTORS (first_name, specialist, avail_time) 
VALUES
  	('RadhaKrishnan', 'Gynacologist', 'A'),
  	('ViajayBaskar', 'Dentist', 'B'),
	('PeelaRajesh', 'Neurologist', 'C'),
	('Preethi', 'Cardiologist', 'D'),
	('Aparna', 'Neurologist', 'B'),
	('Suresh', 'Gynacologist', 'C'),
	('Komal', 'Cardiologist', 'A'),
	('Sundar', 'Dentist', 'A'),
	('Helen', 'Neurologist', 'D'),
	('Karthik', 'Gynacologist', 'B'),
	('Vignesh', 'Cardiologist', 'B'),
	('Hema', 'Dentist', 'D');


INSERT INTO 
	TBL_PATIENTS (first_name, age) 
VALUES
  	('Ravi', 60),
	('Ramu', 45),
  	('Suganya', 45);


INSERT INTO 
	TBL_BOOKING (patient_id, doctor_id, booked_slot, comments, status) 
VALUES
	(1, 2, 'A', 'Severe tooth pain', 'UPCOMING'),
	(3, 1, 'B', 'Stomach pain', 'CANCELED'),
	(2, 4, 'C', 'unable to breath', 'COMPLETE');