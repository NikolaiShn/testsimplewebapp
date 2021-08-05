CREATE TABLE IF NOT EXISTS employee (
	employee_id bigserial PRIMARY KEY,
	first_name varchar(40),
	last_name varchar(40),
	department_id int,
	job_title varchar(60),
	gender varchar(40),
	date_of_birth date);
