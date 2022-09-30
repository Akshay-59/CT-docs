USE ImpactBatch13;

CREATE TABLE Sales
(
	ID INT IDENTITY(1,1),
	ProductCode VARCHAR(20),
	Price INT,
	DateTransaction Date
)

CREATE PROCEDURE [dbo].[InsertIntoSales]
AS 
BEGIN
DECLARE @PC VARCHAR(20)='A12CB';
DECLARE @Price INT = 50;
DECLARE @COUNT INT = 0;
WHILE @COUNT<200000
BEGIN
	SET @PC=@PC+CAST(@COUNT AS VARCHAR(20));
	SET @Price=@Price+@COUNT;
	INSERT INTO Sales (ProductCode, Price, DateTransaction) 
	VALUES (@PC,@Price,GETDATE());
	SET @PC='A12CB';
	SET @Price=50;
	SET @COUNT+=1;
END;
END;


EXECUTE [dbo].[InsertIntoSales]

SELECT * FROM Sales

SET STATISTICS IO ON
SELECT * FROM SALES WHERE ID = 189923

CREATE CLUSTERED INDEX CL_ID ON Sales(ID);

SET STATISTICS IO ON
SELECT * FROM SALES WHERE ID = 189923
--------------------------------------------------------------------
---EXCEPTION HANDLING

select * from Participants.Batch13Members

/*Below are examples of some runtime exceptions*/

INSERT INTO Participants.Batch13Members VALUES (110,'Harry','2001-03-20','.NET',GETDATE()) 
/*
Msg 8101, Level 16, State 1, Line 48
An explicit value for the identity column in table 'Participants.Batch13Members' can only be specified when a column list is used and IDENTITY_INSERT is ON.
*/

print 12/0
/*
Msg 8134, Level 16, State 1, Line 54
Divide by zero error encountered.
*/
/*
Msg 245, Level 16, State 1, Line 60
Conversion failed when converting the varchar value 'HELLO' to data type int.
*/

-- TRY CATCH Block are used to handle exceptions

BEGIN TRY
	Print 'Attempting to divide a number..'
	print 12/2
	Print 'Division successful!'
	Print 'Attempting to concatinate a string and number'
	print 'HELLO'+ 123
	Print 'Concatination successful!'
END TRY
BEGIN CATCH
	--print 'Something went Wrong! Please try later!'
	PRINT ERROR_NUMBER()
	PRINT ERROR_MESSAGE()
END CATCH

--------------------
CREATE TABLE EMPLOYEE
(
	EmpID INT Primary KEY IDENTITY(1,1),
	EmpName VARCHAR(20),
	Salary Money
)

INSERT INTO EMPLOYEE (EmpName,Salary) VALUES
('Piyush',9000),('Kate',10000)

SELECT * FROM EMPLOYEE


BEGIN TRY
	DECLARE @EName VARCHAR(20) = 'Ravi'
	DECLARE @Sal MONEY = 3000
	IF @Sal>5000
		BEGIN
			INSERT INTO EMPLOYEE (EmpName,Salary) VALUES (@EName,@Sal);
		END;
	ELSE
		BEGIN
			RAISERROR('Salary must be greater than 5000!',16,0);
		END;
	Print 'Emp Record Saved!';
END TRY
BEGIN CATCH
	SELECT ERROR_MESSAGE();
END CATCH
-----------------------------------------------------------------------------





