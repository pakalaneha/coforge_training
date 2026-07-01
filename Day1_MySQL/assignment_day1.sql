CREATE DATABASE School;

USE School;

CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Gender VARCHAR(10),
    City VARCHAR(50)
);

INSERT INTO Students VALUES
(101, 'Rahul', 20, 'Male', 'Hyderabad'),
(102, 'Priya', 19, 'Female', 'Chennai'),
(103, 'Arjun', 21, 'Male', 'Bengaluru'),
(104, 'Sneha', 20, 'Female', 'Mumbai'),
(105, 'Kiran', 22, 'Male', 'Pune');

-- Display all student records.
SELECT * FROM Students;

-- Display only Name and City.
SELECT Name, City FROM Students;

-- Display students whose age is greater than 20.
SELECT * FROM Students
WHERE Age > 20;

-- Display female students.
SELECT * FROM Students
WHERE Gender = 'Female';

-- Display students from Hyderabad.
SELECT * FROM Students
WHERE City = 'Hyderabad';

-- Sort students by Name (A–Z).
SELECT * FROM Students
ORDER BY Name ASC;

-- Sort students by Age (highest first).
SELECT * FROM Students
ORDER BY Age DESC;

-- Sort by City and then Name.
SELECT * FROM Students
ORDER BY City, Name;

-- Find students aged between 19 and 21.
SELECT * FROM Students
WHERE Age BETWEEN 19 AND 21;

-- Find students whose name starts with 'R'.
SELECT * FROM Students
WHERE Name LIKE 'R%';

-- Find students whose city ends with 'i'.
SELECT * FROM Students
WHERE City LIKE '%i';

-- Find students whose age is 20 or 22.
SELECT * FROM Students
WHERE Age IN (20, 22);

SET SQL_SAFE_UPDATES = 0;

-- Change Rahul's city to Delhi.
UPDATE Students
SET City = 'Delhi'
WHERE Name = 'Rahul';

-- Increase Arjun's age by 1.
UPDATE Students
SET Age = Age + 1
WHERE Name = 'Arjun';

-- Change Sneha's city to Kolkata.
UPDATE Students
SET City = 'Kolkata'
WHERE Name = 'Sneha';

-- Delete the student whose StudentID is 105.
DELETE FROM Students
WHERE StudentID = 105;

-- Delete all students from Chennai.
DELETE FROM Students
WHERE City = 'Chennai';