-- This is to initialize the database.
-- To launch:
-- myql -u root -p
-- SOURCE <path/to/file>/init.sql

CREATE DATABASE IF NOT EXISTS hrms;
USE hrms;

DROP TABLE IF EXISTS attendance CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

-- CHANGED TO MATCH ERD
CREATE TABLE IF NOT EXISTS employee (
	id INT primary key,
	first VARCHAR(30) NOT NULL,
	last VARCHAR(30) NOT NULL,
	dob DATE NOT NULL,
	role VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	email VARCHAR(32) NOT NULL,
	phone VARCHAR(255) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	last_signin DATE,
	icon VARCHAR(30),
	details VARCHAR(240)
);

CREATE TABLE IF NOT EXISTS attendance (
	employee_id INT,
	start TIME,
	end TIME,
	day DATE,
	CONSTRAINT attendance_fk FOREIGN KEY(employee_id) REFERENCES employee (id) ON DELETE CASCADE
);

INSERT INTO employee VALUES(
	1,
	'joe',
	'doe',
	'1990/11/21',
	'project manager',
	'1 king street',
	'joedoe@gmail.com',
	'5141234567',
	DEFAULT,
	NULL,
	NULL,
	NULL
);
INSERT INTO employee VALUES(
	2,
	'jane',
	'doe',
	'1990/11/23',
	'developer',
	'1 king street',
	'janedoe@gmail.com',
	'4381234567',
	DEFAULT,
	NULL,
	NULL,
	NULL
);

INSERT INTO attendance VALUES(1, '08:00:00', '16:00:00', '2019-11-01');
INSERT INTO attendance VALUES(1, '08:00:00', '16:00:00', '2019-11-02');
INSERT INTO attendance VALUES(1, '08:00:00', '16:00:00', '2019-11-03');
INSERT INTO attendance VALUES(1, '08:00:00', '16:00:00', '2019-11-04');
INSERT INTO attendance VALUES(1, NULL, NULL, CURDATE()); -- must clock in/out today!

INSERT INTO attendance VALUES(2, '09:00:00', '17:00:00', '2019-11-01');
INSERT INTO attendance VALUES(2, '09:00:00', '17:00:00', '2019-11-02');
INSERT INTO attendance VALUES(2, '09:00:00', '17:00:00', '2019-11-03');
INSERT INTO attendance VALUES(2, '09:00:00', '17:00:00', '2019-11-04');
INSERT INTO attendance VALUES(2, NULL, NULL, CURDATE()); -- must clock in/out today!
