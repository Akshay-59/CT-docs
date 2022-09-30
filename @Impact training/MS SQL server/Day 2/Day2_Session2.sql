--String Func.

SELECT UPPER('tousif'), CONCAT('tousif',' is ','a',' SQL ',' Trainer')

SELECT SUBSTRING ('Hello from SQL Server',2,5)

SELECT ProductID, Name,
SUBSTRING(Name,3,4) AS [ProductName],
Color FROM Production.Product

---Date / Time

SELECT GETDATE()

SELECT YEAR(GETDATE()),MONTH(GETDATE()),DAY(GETDATE())

SELECT DATEADD(QQ,2,GETDATE())

SELECT DATEDIFF(YYYY,'12-Jan-1980',GETDATE())

--Get the age and workexperience (in years) of all employees

Select 
	BusinessEntityID,JobTitle,
	BirthDate, DATEDIFF(YYYY,BirthDate,GETDATE()) AS [Age],
	MaritalStatus,Gender, 
	HireDate, DATEDIFF(YYYY,HireDate,GETDATE()) AS [WorkExp]
FROM HumanResources.Employee


----- Aggregate Functions
/*
MAX,MIN,SUM,AVG,COUNT
*/

SELECT 
	MAX(BirthDate) AS [MAX],
	MIN(BirthDate) AS [MIN]
FROM HumanResources.Employee

Select 
	BusinessEntityID,JobTitle,
	BirthDate, DATEDIFF(YYYY,BirthDate,GETDATE()) AS [Age],
	MaritalStatus,Gender, 
	HireDate, DATEDIFF(YYYY,HireDate,GETDATE()) AS [WorkExp]
FROM HumanResources.Employee


SELECT 
	MAX(BirthDate) AS [MAX]
FROM HumanResources.Employee

---Get count of employees

SELECT COUNT(*) AS [Total Employees] FROM HumanResources.Employee

---Get genderwise count of employees

SELECT 
	Gender, COUNT(*) AS [Total Employees] 
FROM HumanResources.Employee GROUP BY Gender

-- Get ..
SELECT 
	Gender, MaritalStatus, COUNT(*) AS [Total Employees] 
FROM HumanResources.Employee GROUP BY Gender, MaritalStatus


----Get colorwise count of products [Production.Product]

SELECT Color,
	COUNT(*) AS [Total Products]
FROM Production.Product GROUP BY Color

----Get colorwise count of products [Production.Product] only if count is greater than 50
SELECT Color,
	COUNT(*) AS [Total Products]
FROM Production.Product GROUP BY Color
HAVING COUNT(*)>50


SELECT Color,
	COUNT(*) AS [Total Products]
FROM Production.Product GROUP BY Color
HAVING Color IN ('Red','Yellow','White')


/*
Select * FROM HumanResources.Employee WHERE BirthDate =
(
	select max(BirthDate) from HumanResources.Employee
)*/


--Sorting
Select ProductID,Name,StandardCost,Color FROM Production.Product
ORDER BY StandardCost ASC

Select ProductID,Name,StandardCost,Color FROM Production.Product
ORDER BY StandardCost DESC, Name ASC


------------------------------------------------------
SELECT *,COUNT(*) OVER() AS [Total Products]
FROM Production.Product 

----Get all product deatils along with SUm of standard cost for all the products
SELECT 
	ProductID,Name,StandardCost,Color,
	SUM(StandardCost) OVER() AS [Total Cost]
FROM Production.Product 

--get colorwise sum of standardcost products

SELECT 
	ProductID,Name,StandardCost,Color,
	SUM(StandardCost) OVER(Partition BY Color) AS [Total Cost]
FROM Production.Product 

------
--Get the costliest product

--Soln1:
SELECT	ProductID,Name,StandardCost,Color FROM Production.Product WHERE StandardCost =
(
	SELECT MAX(StandardCost) FROM Production.Product
)

--Get the third costliest product

--Soln1:
SELECT	ProductID,Name,StandardCost,Color FROM Production.Product WHERE StandardCost =
(
	SELECT MAX(StandardCost) FROM Production.Product
)


SELECT	ProductID,Name,Color,StandardCost FROM Production.Product ORDER BY StandardCost DESC
--- RANKING Functions
/*
	ROW_NUMBER
	RANK
	DENSE_RANK
	NTILE
*/
SELECT	
	ProductID,Name,Color,StandardCost,
	ROW_NUMBER() OVER(ORDER BY StandardCost DESC) AS [ROW_NUM],
	RANK() OVER(ORDER BY StandardCost DESC) AS [RANK],
	DENSE_RANK() OVER(ORDER BY StandardCost DESC) AS [DENSE_RANK]
FROM Production.Product 


SELECT	
	ProductID,Name,Color,StandardCost,
	ROW_NUMBER() OVER(Partition BY Color ORDER BY StandardCost DESC) AS [ROW_NUM],
	RANK() OVER(Partition BY Color ORDER BY StandardCost DESC) AS [RANK],
	DENSE_RANK() OVER(Partition BY Color ORDER BY StandardCost DESC) AS [DENSE_RANK]
FROM Production.Product 

--Get ths second costliest product
-- Derived Table
SELECT * FROM 
(
	SELECT	
		ProductID,Name,Color,StandardCost,
		DENSE_RANK() OVER(ORDER BY StandardCost DESC) AS [DR]
	FROM Production.Product 
) as PD WHERE [DR] = 2


--Get ths second costliest product in each color
-- Derived Table
SELECT * FROM 
(
	SELECT	
		ProductID,Name,Color,StandardCost,
		DENSE_RANK() OVER(Partition BY Color ORDER BY StandardCost DESC) AS [DR]
	FROM Production.Product 
) as PD WHERE [DR] = 2

---NTILE
SELECT	
		ProductID,Name,Color,StandardCost,
		NTILE(4) OVER(ORDER BY StandardCost DESC) AS [DR]
FROM Production.Product 
-----------------------------------------------------------------------

--JOINS
/*
CROSS JOIN
INNER JOIN --- DEFAULT
OUTER JOIN
	. LEFT
	. RIGHT
	. FULL
SELF JOIN
*/
/*
PATIENT

PatID(PK)	Name
111			RAJ
112			SAM
113			TOM
114			FIONA

PATIENT_ADDRESS

PatID (FK)	City
111			Mumbai
112			Chennai
-- INNER JOIN  (Get all the patients who have address)
SELECT P.PatID, P.Name, PA.City FROM PATIENT P INNER JOIN PATIENT_ADDRESS PA
ON  P.PatID = PA.PatID
PatID(PK)	Name	City
111			RAJ		Mumbai
112			SAM		Chennai


LEFT OUTER -- (Get all the patients who may or may not have address)
SELECT P.PatID, P.Name, PA.City FROM PATIENT P LEFT OUTER JOIN PATIENT_ADDRESS PA
ON  P.PatID = PA.PatID

PatID(PK)	Name	City
111			RAJ		Mumbai
112			SAM		Chennai
113			TOM		NULL
114			FIONA	NULL

CROSS JOIN -- 
SELECT P.PatID, P.Name, PA.City FROM PATIENT P CROSS JOIN PATIENT_ADDRESS PA

*/

SELECT 
	ProductID,Name,Color,StandardCost,ProductSubcategoryID 
FROM Production.Product

SELECT 
	ProductSubcategoryID, Name 
FROM Production.ProductSubcategory


--INNER JOIN
-- GET ALL THE PRODUCTS including subcategory details which BELONGING TO SOME SUBCATEGoRY
SELECT 
	ProductID,PRD.Name AS [ProductName],
	Color,StandardCost,PRD.ProductSubcategoryID, 
	PSC.Name AS [SubCategory] 
FROM Production.Product PRD JOIN Production.ProductSubcategory PSC
ON PRD.ProductSubcategoryID = PSC.ProductSubcategoryID

-- GET ALL THE PRODUCTS including subcategory details irrespective of subcategory

SELECT 
	ProductID,PRD.Name AS [ProductName],
	Color,StandardCost,PRD.ProductSubcategoryID, 
	PSC.Name AS [SubCategory] 
FROM Production.Product PRD LEFT OUTER JOIN Production.ProductSubcategory PSC
ON PRD.ProductSubcategoryID = PSC.ProductSubcategoryID












---CTE
