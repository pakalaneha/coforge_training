CREATE DATABASE mydatabase;

USE mydatabase;

CREATE TABLE tbl_employee (
    eid INTEGER,
    ename VARCHAR(50),
    esalary INTEGER
);

DESC tbl_employee;

INSERT INTO tbl_employee VALUES (
    101,
    'Neha',
    15000
);

INSERT INTO tbl_employee VALUES (
    102,
    'Priya',
    10000
);

SELECT * FROM tbl_employee;

SELECT eid, esalary FROM tbl_employee;

INSERT INTO tbl_employee VALUES (
    103,
    'Ananya',
    20000
);

INSERT INTO tbl_employee (eid, esalary)
VALUES (
    104,
    30000
);

SELECT * FROM tbl_employee WHERE eid <> 101;

SELECT ename FROM tbl_employee WHERE esalary <= 30000;

SELECT eid, ename FROM tbl_employee WHERE ename IS NULL;

SELECT eid, ename FROM tbl_employee WHERE ename IS NOT NULL;

SELECT * FROM tbl_employee WHERE eid IN (101, 103);

SELECT * FROM tbl_employee WHERE eid NOT IN (101, 103);

SELECT * FROM tbl_employee WHERE eid IN (101, 105);

SELECT * FROM tbl_employee WHERE esalary BETWEEN 10000 AND 40000;

SELECT * FROM tbl_employee WHERE esalary NOT BETWEEN 40000 AND 10000;

SELECT * FROM tbl_employee WHERE ename LIKE '%e%';

SELECT * FROM tbl_employee WHERE ename NOT LIKE '%e%';

SET SQL_SAFE_UPDATES = 0;

UPDATE tbl_employee
SET esalary = 0
WHERE eid = 101;

SELECT * FROM tbl_employee;

ROLLBACK;

DELETE FROM tbl_employee
WHERE ename IS NULL;

SELECT
    eid AS "Employee Id",
    SYSDATE() AS "Current Date",
    'Neha' AS "Name",
    100 + 200 AS "Sum"
FROM tbl_employee;

ALTER TABLE tbl_employee ADD COLUMN dno INTEGER;

ALTER TABLE tbl_employee ADD dsalary INTEGER;

ALTER TABLE tbl_employee DROP COLUMN dno;

ALTER TABLE tbl_employee RENAME COLUMN eid TO empid;

TRUNCATE TABLE tbl_employee;

RENAME TABLE tbl_employee TO tbl_employee1;