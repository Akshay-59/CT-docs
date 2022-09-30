--Views
SELECT * FROM RedProducts

ALTER VIEW v_RedProducts
AS
SELECT * FROM RedProducts WHERE StandardCost>1000
WITH CHECK OPTION

SELECT * FROM v_RedProducts

INSERT INTO v_RedProducts VALUES(10001,'Test Product 1','TP-IMB13-01','Red',1500)

--INSERT INTO v_RedProducts VALUES(10002,'Test Product 2','TP-IMB13-02','Red',999)

INSERT INTO v_RedProducts VALUES(10003,'Test Product 3','TP-IMB13-03','Red',1888)

--SYNONYM : Alias or alternate name for existing database object
CREATE SYNONYM Persons FOR Person.Person

SELECT * FROM Persons

-------------PROCEDURES--------------

--variable
DECLARE
@PName VARCHAR(50);
SET @PName = 'TEST PRODUCT'
SELECT @PName
SELECT @PName = Name FROM Production.Product WHERE ProductID = 317
PRINT @PName

--if--else
DECLARE @i INT
SET @i=10
if (@i % 2)=0 
	BEGIN
		Print 'Even Number'
		Print '------------'
	END
else
	BEGIN
		Print 'Odd Number'
		Print '*************'
	END

---LOOPS
--while
DECLARE @i INT
SET @i=1
WHILE (@i<=10)
BEGIN
	PRINT @i
	SET @i = @i+1
END


----STORED Procedure
---Get employee name and designation by employeeid
DROP PROCEDURE usp_GetEmpName 

CREATE PROCEDURE usp_GetEmpName (@eid int)
AS
BEGIN
	DECLARE @desig VARCHAR(30);
	DECLARE @ename VARCHAR(50);
	SELECT @ename = CONCAT(FirstName,' ',LastName) from Person.Person WHERE BusinessEntityID = @eid
	SELECT @desig = JobTitle FROM HumanResources.Employee WHERE BusinessEntityID = @eid;
	Print 'Emp Name: '+@ename;
	Print 'Designation: '+@desig;
END;

EXECUTE usp_GetEmpName 1
EXECUTE usp_GetEmpName 15

---OUTPUT Parameters :: Used to return data from procudure to the caller
CREATE PROCEDURE usp_GetEmpNameAndDesig 
(
	@eid int,
	@ename VARCHAR(50) OUTPUT,
	@desig VARCHAR(30) OUTPUT
)
AS
BEGIN
	SELECT @ename = CONCAT(FirstName,' ',LastName) from Person.Person WHERE BusinessEntityID = @eid
	SELECT @desig = JobTitle FROM HumanResources.Employee WHERE BusinessEntityID = @eid;
END;

DECLARE @ena VARCHAR(50);
DECLARE @des VARCHAR(30);
EXECUTE usp_GetEmpNameAndDesig 15, @ena OUTPUT, @des OUTPUT
Print 'Emp Name: '+@ena;
Print 'Designation: '+@des;
---------------------------------------------------------------------------
--TEST
SELECT * FROM Production.Product

DECLARE @test int;
SET @test=2
SELECT * FROM Production.Product ORDER BY ProductID OFFSET @test ROWS FETCH NEXT 1 rows only

------------------------------------------------------------------



