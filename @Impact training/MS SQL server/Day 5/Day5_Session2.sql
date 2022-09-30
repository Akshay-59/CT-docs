--Lab
--Register new bank account using stored procedure in the below table
/*
Table: AccountTypeMaster
	.AccountTypeID
	.AccountType (SAVING, CURRENT)

Table: BankAccount
	.AccountID PK IDENTITY
	.AccountType 
	.ConsumerName 
	.BalanceAmount
	.ModifiedDate
*/
--Consider the below rules while registering a bank account
/*
1. Every Account must have minimum balance of Rs. 10000
2. Only account types available in AccountTypeMaster are allowed while registeration
3. ModifiedDate must be not a future date
4. CustomerName must not be alphanumeric
*/
------UDF : USER DEFINED FUNCTIONS------------------
--EX1 (SCALAR VALUED FUNCTIONS)
CREATE FUNCTION udf_getProductNameByID (
	@pid int
) RETURNS VARCHAR(30) AS
BEGIN
	DECLARE @pname VARCHAR(30)
	SELECT @pname = Name FROM Production.Product WHERE ProductID = @pid
	RETURN @pname
END;

Print dbo.udf_getProductNameByID (317)
SELECT dbo.udf_getProductNameByID (317)

--EX2: Table Valued Function
CREATE FUNCTION udf_getProductsByColor (
	@pcol varchar(10)
) RETURNS TABLE AS
RETURN SELECT * FROM Production.Product WHERE Color = @pcol

Select * FROM  dbo.udf_getProductsByColor ('Red')

--EX3: Table Valued Function
--DROP FUNCTION dbo.udf_getProductsByColorPart2
CREATE FUNCTION udf_getProductsByColorPart2 (
	@pcol varchar(10)
)RETURNS @Prods TABLE
(
	ProductID INT,
	PName Varchar(50),
	Color Varchar(10),
	Cost NUMERIC (10,4)
)
AS
BEGIN
	INSERT INTO @Prods
	SELECT ProductID,Name,Color,StandardCost+100 FROM Production.Product WHERE Color = @pcol;
	RETURN;
END;


Select * FROM  dbo.udf_getProductsByColorPart2 ('Yellow')

select * from Production.Product where ProductID=323
---------------------------------------------------------------------------------------------------
--LAB on Functions:: Insert prime numbers from 1 to 1000 in a table. Create a function to check if a number is prime or not

--------------------------------------------------------------------------------------------------------------------------------------
--TRIGGERS

select * from RedProducts

--DROP TABLE Deleted_RedProducts

SELECT * INTO Deleted_RedProducts
FROM RedProducts WHERE 1=2

select * from RedProducts
select * from Deleted_RedProducts

ALTER TABLE Deleted_RedProducts ADD  DeletedDate DATE

--DROP TRIGGER trg_delete_redproducts

CREATE TRIGGER trg_delete_redproducts
ON RedProducts AFTER DELETE 
AS
BEGIN
	INSERT INTO Deleted_RedProducts
	SELECT *,GETDATE() FROM deleted;
	Print 'Deleted product recorded!'
END;


DELETE from RedProducts WHERE ProductID=706

DELETE from RedProducts WHERE ProductID >= 715 AND ProductID <= 720


CREATE TRIGGER tr_upd_prds ON 
Production.Product INSTEAD OF UPDATE
AS
BEGIN
	Print 'Updates not allowed on this table'
END;










