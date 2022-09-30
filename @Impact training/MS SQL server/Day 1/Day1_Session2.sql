USE AdventureWorks2019;

--DQL
--GET ALL DETAILS of ALL Person
SELECT * FROM Person.Person

--get limited no. of cols. 
--Get Title, FirstName and LAstName of all persons
SELECT Title,FirstName,LastName FROM Person.Person   -- projection

--get persons of type EM and IN
SELECT * FROM Person.Person
WHERE PersonType IN ('EM','IN')
--OR
SELECT * FROM Person.Person
WHERE PersonType = 'EM' OR PersonType = 'IN'

--get persons having Mr as Title and who are of type EM
SELECT * FROM Person.Person
WHERE PersonType = 'EM' AND Title = 'Mr.'

--get persons having Mr, Ms. as Title and who are of type EM
SELECT * FROM Person.Person
WHERE PersonType = 'EM' AND Title IN ('Mr.','Ms.')
--OR
SELECT * FROM Person.Person
WHERE PersonType = 'EM' AND (Title = 'Mr.' OR Title = 'Ms.')

--Handling Null values (IS NULL OR IS NOT NULL)
--get all the persons having title
SELECT * FROM Person.Person
WHERE Title IS NOT NULL

--Replacing Nulls
SELECT ProductID,Name,ProductNumber,Color,StandardCost,ProductSubcategoryID 
FROM Production.Product

--Replace Null values in Color with NoColor
SELECT ProductID,Name AS [ProductName],ProductNumber, ISNULL(Color,'NoColor') AS [Colour],
StandardCost,ProductSubcategoryID 
FROM Production.Product
-- Note: The above query uses column alias which are not the actual column names and hence they cannot be use anywher 
--as an alternative to columns like in filters, etc. They are only for display purpose 
--ISNULL is built-in function-- ISNULL(Expression, 'ReplacementValue')Returns- AS [NewColName]
--eg ISNULL(Color,'NoColor') AS [Colour]

--Pattern matching (LIKE Operator _ for single letter,% - multiple letters
--get all the person starting firstname with letter J
SELECT * FROM Person.Person
WHERE FirstName LIKE 'J%'

--get all the person end firstname with letter es
SELECT * FROM Person.Person
WHERE FirstName LIKE '%es'

--get all the person having ton in their firstname
SELECT * FROM Person.Person
WHERE FirstName LIKE '%ton%'

SELECT * FROM Person.Person
WHERE FirstName LIKE 'D[a-d]%n'

-----------------------------------------------------------------------------
SELECT ProductID,Name,ProductNumber,Color,StandardCost,ProductSubcategoryID 
FROM Production.Product

--Get all the products costing more than 2000
SELECT ProductID,Name,ProductNumber,Color,StandardCost,ProductSubcategoryID 
FROM Production.Product
WHERE StandardCost > 1500


--Get all the products costing more than 500 and less than 1500
SELECT ProductID,Name,ProductNumber,Color,StandardCost,ProductSubcategoryID 
FROM Production.Product
WHERE StandardCost >= 486.7066 AND StandardCost <= 1500
--OR
SELECT ProductID,Name,ProductNumber,Color,StandardCost,ProductSubcategoryID 
FROM Production.Product
WHERE StandardCost BETWEEN 486.7066 AND 1500  -- Between and is inclusive of the given range

-----------------------------------------------------------------
SELECT BusinessEntityID,NationalIDNumber, JobTitle, BirthDate,MaritalStatus,Gender, HireDate 
FROM HumanResources.Employee

--Get all employees hired in year 2009
SELECT BusinessEntityID,NationalIDNumber, JobTitle, BirthDate,MaritalStatus,Gender, HireDate 
FROM HumanResources.Employee
WHERE HireDate LIKE '2009%'
---OR
SELECT BusinessEntityID,NationalIDNumber, JobTitle, BirthDate,MaritalStatus,Gender, HireDate 
FROM HumanResources.Employee
WHERE YEAR(HireDate) = 2009


---Get all female employees born in year 1974
SELECT BusinessEntityID,NationalIDNumber, JobTitle, BirthDate,MaritalStatus,Gender, HireDate 
FROM HumanResources.Employee
WHERE YEAR(BirthDate) = 1974 AND Gender = 'F'

-- Get all single male employees
SELECT BusinessEntityID,NationalIDNumber, JobTitle, BirthDate,MaritalStatus,Gender, HireDate 
FROM HumanResources.Employee
WHERE MaritalStatus = 'S' AND Gender = 'M'


---Case Statement
SELECT ProductID,Name,ProductNumber,Color,StandardCost,ProductSubcategoryID 
FROM Production.Product

--DIsplay color codes in place of color names (e.g R for RED, G for Green, W for white, Y for Yellow, 
---B for Black....else 'N/A')
SELECT ProductID,Name,ProductNumber,
CASE 
	WHEN Color = 'Red' Then 'R'
	WHEN Color = 'White' Then 'W'
	WHEN Color = 'Green' Then 'G'
	WHEN Color = 'Yellow' Then 'Y'
	WHEN Color = 'Black' Then 'B'
	ELSE 'N/A'
END AS [Colour],
StandardCost,ProductSubcategoryID 
FROM Production.Product


--Number functions
SELECT CEILING(12.5689) AS [CEILING], FLOOR(12.5689) AS [FLOOR], 
ROUND(12.5689,2) AS [ROUND]


SELECT 
	ProductID,Name,ProductNumber,Color,
	ROUND(StandardCost,0) AS [Standard Cost],
	ProductSubcategoryID 
FROM Production.Product

