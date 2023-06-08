CREATE TABLE departments(
	dep_id serial PRIMARY KEY,
	dep_name TEXT,
	dep_location TEXT,
	dep_phone TEXT,
	dep_budget int 
);

CREATE TABLE employees(
	emp_id serial PRIMARY KEY,
	first_name TEXT,
	last_name TEXT,
	emp_salary int,
	dep_id_fk int REFERENCES departments(dep_id)

);

SELECT * FROM departments WHERE dep_id = 3;

INSERT INTO departments(dep_name, dep_location, dep_phone, dep_budget)
VALUES 
	('Finance', '123 wolf st', '720 212 6666', 450000),
	('Marketing', '222 euphoria ct', '345 234 5675', 200000),
	('Computer science', '333 plano st', '890 990 7070',800000),
	('Economics', '222 vine st', '555 666 7777', 500000),
	('Physcology', '111 elm ct', '323 434 5544', 100000);

SELECT * FROM departments;


INSERT INTO employees(first_name, last_name, emp_salary, dep_id_fk)
VALUES 
	('John', 'Smith', 50000, 1),
	('Sara', 'Micheal', 45000,4),
	('Tomas', 'Muller', 100000,3),
	('Abel', 'Tesfaye', 70000, 1),
	('Ava', 'Miller', 120000,3),
	('Daniel','Martinez', 80000, 4),
	('Emily', 'Johnson', 30000,5);

SELECT * FROM employees;

DELETE FROM employees WHERE emp_id = 8;

DELETE FROM employees WHERE emp_id=11;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	