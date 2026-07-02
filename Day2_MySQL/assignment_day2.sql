create database EmployeeManagement;
use EmployeeManagement;
create table Department(DeptID int primary key,
DeptName varchar(20), Location varchar(50));
INSERT INTO Department VALUES
(101,'HR','Hyderabad'),
(102,'Finance','Mumbai'),
(103,'IT','Bangalore'),
(104,'Sales','Chennai');
CREATE TABLE Employee (
   EmpID int primary key,
   EmpName varchar(50),
   Gender varchar(10),
   Age int,
   Salary decimal(10,2),
   Designation varchar(50),
   DeptID int,
   HireDate date,
   foreign key (DeptID) references Department(DeptID)
);
INSERT INTO Employee VALUES
(1,'Amit','Male',28,45000,'Software Engineer',103,'2022-05-10'),
(2,'Priya','Female',30,55000,'HR Manager',101,'2021-03-15'),
(3,'Rahul','Male',27,50000,'Accountant',102,'2023-01-20'),
(4,'Sneha','Female',25,42000,'Sales Executive',104,'2022-09-12'),
(5,'Kiran','Male',31,60000,'Team Lead',103,'2020-11-18');
create table Attendance(AttendanceID int PRIMARY KEY,
   EmpID int,
   AttendanceDate date,
   statuss varchar(10),
   foreign key (EmpID) references Employee(EmpID)
);
INSERT INTO Attendance VALUES
(1,1,'2026-07-01','Present'),
(2,2,'2026-07-01','Present'),
(3,3,'2026-07-01','Absent'),
(4,4,'2026-07-01','Present'),
(5,5,'2026-07-01','Present');

select * from employee;
-- Display employee names and salaries.
select EmpName,Salary from employee;
-- Display employees whose salary is greater than 50,000.
select * from employee where salary>50000;
-- Display employees older than 30 years.
select * from employee where age>30;

select * from employee where DeptID=(select DeptId from Department 
where DeptName ='IT');

select * from employee where Gender='Female';

select * from employee where HireDate>'2022-01-01';

select * from employee order by Salary desc;

select * from employee order by EmpName;

select count(*) as 'total no of employees' from employee;

select max(Salary) from employee;
select min(Salary) from employee;
select avg(Salary) from employee;
select sum(Salary) from employee;

select DeptID,count(*) from employee group by DeptID;
select avg(Salary) from employee group by DeptId;
select max(Salary) from employee group by DeptId;

select e.EmpName , d.DeptName from employee e join department d on
e.deptid=d.deptid;

select e.EmpName , d.DeptName,d.location from employee e join department d on
e.deptid=d.deptid;

SELECT a.AttendanceID,e.EmpName,a.AttendanceDate,a.Statuss
FROM Attendance a
JOIN Employee e
ON a.EmpID = e.EmpID;

update employee set salary=1.1*salary where deptid=
(select deptid from department where deptname='it');

select * from employee;

update employee set designation='HR' where empid=3;
select * from employee;

update employee set deptid=101 where empid=3;
select * from employee;

delete from employee where salary<40000;
select * from employee;

set sql_safe_updates=0;
delete from attendance where attendancedate='2026-06-30';
select * from attendance;
create view EmployeeDetails as select e.EmpID, e.EmpName, d.DeptName, e.Salary
FROM Employee e
JOIN Department d ON e.DeptID = d.DeptID;
select * from EmployeeDetails;
DELIMITER //

CREATE PROCEDURE GetEmployees()
BEGIN
   SELECT * FROM Employee;
END //
DELIMITER ;
CALL GetEmployees();

