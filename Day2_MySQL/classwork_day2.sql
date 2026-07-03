USE mydatabase;
CREATE TABLE tbl_employee(
    eid INTEGER,
    ename VARCHAR(30),
    esalary INTEGER,
    dno INTEGER
);
-- Error: VARCHAR2 is not supported in MySQL.

CREATE TABLE tbl_employee(
    eid INTEGER,
    ename VARCHAR(50),
    esalary INTEGER,
    dno INTEGER
);

DESC tbl_employee;

INSERT INTO tbl_employee VALUES(&eid,&ename,&esalary,&dno);
-- Error: '&' substitution variables are not supported in MySQL.

INSERT INTO tbl_employee VALUES(101,'Neha',15000,10);
INSERT INTO tbl_employee VALUES(102,'Satvika',15000,20);
INSERT INTO tbl_employee VALUES(103,'Harshika',15000,30);
INSERT INTO tbl_employee VALUES(104,'Miyo',12000,10);

UPDATE tbl_employee
SET dno=20
WHERE eid=102;

SELECT * FROM tbl_employee;

UPDATE tbl_employee
SET dno=20
WHERE eid=104;

UPDATE tbl_employee
SET dno=10
WHERE eid=103;

SELECT * FROM tbl_employee;

SELECT dno, COUNT(*)
FROM tbl_employee
GROUP BY dno;

SELECT dno,
       COUNT(*) AS 'total no. of employees'
FROM tbl_employee
GROUP BY dno;

SELECT dno, SUM(esalary), AVG(esalary), MIN(esalary), MAX(esalary)
FROM tbl_employee GROUP BY dno;

SELECT dno, SUM(esalary), AVG(esalary),MIN(esalary), MAX(esalary) FROM tbl_employee
GROUP BY dno HAVING MIN(esalary) > 12000;

SELECT dno,
       SUM(esalary),
       AVG(esalary),
       MIN(esalary),
       MAX(esalary)
FROM tbl_employee
GROUP BY dno
ORDER BY dno;

SELECT dno,
       SUM(esalary),
       AVG(esalary),
       MIN(esalary),
       MAX(esalary)
FROM tbl_employee
GROUP BY dno
ORDER BY dno DESC;

SELECT dno,
       SUM(esalary),
       AVG(esalary),
       MIN(esalary),
       MAX(esalary)
FROM tbl_employee
ORDER BY dno DESC
GROUP BY dno;
-- Error: GROUP BY must come before ORDER BY.

SELECT *
FROM tbl_employee
ORDER BY eid;

SELECT *
FROM tbl_employee
ORDER BY eid DESC;

CREATE TABLE tbl_department(
    dno INTEGER,
    dname VARCHAR2(20)
);
-- Error: VARCHAR2 is not supported in MySQL.

CREATE TABLE tbl_department(
    dno INTEGER,
    dname VARCHAR(20)
);

INSERT INTO tbl_department VALUES(10,'development');

INSERT INTO tbl_department VALUES(20,'testing');

SELECT * FROM tbl_department;

SELECT eid
FROM tbl_employee
WHERE dno=(SELECT dname FROM tbl_department);
-- Error: Subquery returns multiple rows.

SELECT eid,dname
FROM tbl_employee
WHERE dno=(SELECT dname FROM tbl_department);
-- Error: Unknown column 'dname'.

SELECT eid
FROM tbl_employee
WHERE dno=(SELECT dname FROM tbl_department);
-- Error: Subquery returns multiple rows.

SELECT eid
FROM tbl_employee
WHERE dno=(SELECT dname FROM tbl_department WHERE id=101);
-- Error: Unknown column 'id'.

SELECT eid
FROM tbl_employee
WHERE dno=(SELECT dname FROM tbl_department WHERE eid=101);
-- Error: Unknown column 'eid'.

SELECT dname
FROM tbl_department
WHERE dno=(SELECT do FROM tbl_employee WHERE eid=101);
-- Error: Unknown column 'do'.

SELECT dname
FROM tbl_department
WHERE dno=(SELECT dno FROM tbl_employee WHERE eid=101);

SELECT dname
FROM tbl_department
WHERE dno=(SELECT dno FROM tbl_employee);
-- Error: Subquery returns multiple rows.

SELECT *
FROM tbl_employee
WHERE dno=(SELECT dname FROM tbl_department WHERE dname='testing');

SELECT *
FROM tbl_employee
WHERE dno=(SELECT dno FROM tbl_department WHERE dname='testing');

SELECT dname
FROM tbl_department
WHERE dno=(SELECT dno FROM tbl_employee WHERE ename='Neha');

SELECT dno
FROM tbl_department
WHERE dno=(SELECT dno FROM tbl_employee WHERE eid=101 OR eid=102);
-- Error: Subquery returns multiple rows.

SELECT dname
FROM tbl_department
WHERE dno IN
(SELECT dno FROM tbl_employee WHERE eid=101 OR eid=102);

DROP tbl_employee;
-- Error: Missing TABLE keyword.

DROP TABLE tbl_employee;

CREATE TABLE tbl_employee (
    eid INTEGER PRIMARY KEY,
    ename VARCHAR(50) NOT NULL,
    esalary INTEGER CHECK(esalary > 0),
    email VARCHAR(20) UNIQUE,
    dno INTEGER
);

DESC tbl_employee;

INSERT INTO tbl_employee
VALUES(101,'Neha',15000,'neha@gmail.com',10);

INSERT INTO tbl_employee
VALUES(101,'Miyo',15000,'miyo@gmail.com',10);
-- Error: Duplicate PRIMARY KEY value.

INSERT INTO tbl_employee
VALUES(101,'Miyo',0,'miyo@gmail.com',10);
-- Error: CHECK constraint violated.

INSERT INTO tbl_employee
VALUES(102,'Miyo',10000,'miyo@gmail.com',10);

DROP TABLE tbl_employee;

DROP TABLE tbl_department;

CREATE TABLE tbl_dept(
    dno INTEGER PRIMARY KEY,
    dname VARCHAR(20)
);

CREATE TABLE tbl_employee(
    eid INTEGER PRIMARY KEY,
    ename VARCHAR(30),
    esalary INTEGER,
    dno INTEGER REFERENCES tbl_dept(dno)
);

DESC tbl_employee;

DESC tbl_dept;

INSERT INTO tbl_employee
VALUES(101,'Miyo',25000,10);
-- Error: Foreign key value does not exist in parent table.

DROP TABLE tbl_employee;

CREATE TABLE tbl_employee(
    eid INTEGER PRIMARY KEY,
    ename VARCHAR(30),
    esalary INTEGER,
    FOREIGN KEY(dno) REFERENCES tbl_dept(dno)
);
-- Error: Column 'dno' does not exist.

CREATE TABLE tbl_employee(
    eid INTEGER PRIMARY KEY,
    ename VARCHAR(30),
    esalary INTEGER,
    dno INTEGER,
    FOREIGN KEY(dno) REFERENCES tbl_dept(dno)
);

DELIMITER //

CREATE PROCEDURE insertEmployee(
    IN eid INTEGER,
    IN ename VARCHAR(20),
    IN esalary INTEGER,
    IN dno INTEGER
)
BEGIN
    INSERT INTO tbl_employee(eid,ename,esalary,dno)
    VALUES(eid,ename,esalary,dno);
-- Error: Procedure definition incomplete (missing END and delimiter).

DELIMITER //

CREATE PROCEDURE insertEmployee(
    IN eid INTEGER,
    IN ename VARCHAR(20),
    IN esalary INTEGER,
    IN dno INTEGER
)
BEGIN
    INSERT INTO tbl_employee(eid,ename,esalary,dno)
    VALUES(eid,ename,esalary,dno);
END //

DELIMITER ;

CALL insertEmployee(103,'Hello',3000,10);
-- Error: Foreign key value does not exist in parent table.

INSERT INTO tbl_dept(10,'Dev');
-- Error: Incorrect INSERT syntax.

INSERT INTO tbl_dept
VALUES(10,'Dev');

CALL insertEmployee(103,'Hello',3000,10);

SELECT * FROM tbl_employee;

DELIMITER //

CREATE PROCEDURE getEmployeeName(
    IN empid INTEGER,
    OUT emppname VARCHAR(20)
)
BEGIN
    SELECT ename
    INTO empname
    FROM tbl_employee
    WHERE eid=empid;
END //;
-- Error: Undeclared variable 'empname'.

CREATE PROCEDURE getEmployeeName(
    IN empid INTEGER,
    OUT empname VARCHAR(20)
)
BEGIN
    SELECT ename
    INTO empname
    FROM tbl_employee
    WHERE eid=empid;
END //

CALL getEmployyeName(101,@empname);
-- Error: Procedure name is misspelled.

CALL getEmployeeName(101,@empname);

DELIMITER ;

CALL getEmployeeName(101,@empname);

SELECT @empname;

CALL getEmployeeName(103,@empname);

SELECT @empname;

CREATE FUNCTION getEmpName(empid INTEGER)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE empname VARCHAR(20);
-- Error: Function definition incomplete (delimiter not changed).

DELIMITER //

CREATE FUNCTION getEmpName(empid INTEGER)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE empname VARCHAR(20);

    SELECT ename
    INTO empname
    FROM tbl_employee
    WHERE eid=empid;

    RETURN empname;
END //

DELIMITER ;

SELECT getEmpName(103);
-- joins 
CREATE TABLE tbl_train (
    tid INTEGER PRIMARY KEY, 
    station VARCHAR(30)
);
CREATE TABLE tbl_users (
    userid INTEGER PRIMARY KEY, 
    uname VARCHAR(20),
    hmstn VARCHAR(30)
);
INSERT INTO tbl_train VALUES (1, 'Hyd');
INSERT INTO tbl_train VALUES (2, 'Bengal');
INSERT INTO tbl_train VALUES (3, 'Mumbai');
INSERT INTO tbl_users VALUES (101, 'Neha', 'Hyd');
INSERT INTO tbl_users VALUES (102, 'Satvika', 'Mumbai');
INSERT INTO tbl_users VALUES (103, 'Harshika', 'Hyd');
INSERT INTO tbl_users VALUES (104, 'Miyo', 'Shimla');
SELECT * FROM tbl_train;
SELECT * FROM tbl_users;


SELECT t.tid,t.station, u.uname 
FROM tbl_train t 
JOIN tbl_users u ON t.station = u.hmstn;

SELECT t.tid,t.station, u.uname 
FROM tbl_train t 
JOIN tbl_users u ON t.station != u.hmstn;

SELECT t.tid,t.station, u.uname 
FROM tbl_train t 
LEFT JOIN tbl_users u ON t.station = u.hmstn;

SELECT t.tid,t.station, u.uname 
FROM tbl_train t 
RIGHT JOIN tbl_users u ON t.station = u.hmstn;

SELECT t.tid,t.station, u.uname 
FROM tbl_train t 
LEFT JOIN tbl_users u ON t.station = u.hmstn
UNION
SELECT t.tid,t.station, u.uname 
FROM tbl_train t 
RIGHT JOIN tbl_users u ON t.station = u.hmstn;

SELECT t.tid,t.station, u.uname 
FROM tbl_train t 
CROSS JOIN tbl_users u;

