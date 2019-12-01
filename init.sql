-- This is to initialize the database.
-- To launch:
-- myql -u root -p
-- SOURCE <path>/<to>/<file>/init.sql

CREATE DATABASE IF NOT EXISTS hrms;
USE hrms;

DROP TABLE IF EXISTS schedule CASCADE;
DROP TABLE IF EXISTS employee CASCADE;

CREATE TABLE IF NOT EXISTS employee (
	id INT NOT NULL AUTO_INCREMENT primary key,
	first VARCHAR(255),
	last VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS schedule(
	employee_id INT NOT NULL,
	start TIME DEFAULT '08:00:00',
	end TIME DEFAULT '16:00:00',
	day ENUM('monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday') NOT NULL,
	CONSTRAINT schedule_fk foreign key(employee_id) references employee (id) on delete cascade
);

CREATE UNIQUE INDEX one_shift_per_day ON schedule (employee_id, day);

INSERT INTO employee VALUES(DEFAULT, 'joe', 'doe');
INSERT INTO employee VALUES(DEFAULT, 'joe2', 'doe');

INSERT INTO schedule VALUES(1, DEFAULT, DEFAULT, 'monday');
INSERT INTO schedule VALUES(1, DEFAULT, DEFAULT, 'tuesday');
INSERT INTO schedule VALUES(1, DEFAULT, DEFAULT, 'wednesday');
INSERT INTO schedule VALUES(1, DEFAULT, DEFAULT, 'thursday');
INSERT INTO schedule VALUES(1, DEFAULT, DEFAULT, 'friday');

INSERT INTO schedule VALUES(2, '09:00:00', '17:00:00', 'monday');
INSERT INTO schedule VALUES(2, '09:00:00', '17:00:00', 'tuesday');
INSERT INTO schedule VALUES(2, '09:00:00', '17:00:00', 'wednesday');
INSERT INTO schedule VALUES(2, '09:00:00', '17:00:00', 'thursday');
INSERT INTO schedule VALUES(2, '09:00:00', '17:00:00', 'friday');
