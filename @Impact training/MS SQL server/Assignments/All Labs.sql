CREATE SCHEMA Sales

CREATE TABLE Sales.Country(
CountryID INT NOT NULL PRIMARY KEY,
CountryName VARCHAR(50) NOT NULL
)

CREATE SCHEMA HumanResources

CREATE TABLE HumanResources.Department(
DepartmentID INT NOT NULL PRIMARY KEY,
DepartmentName VARCHAR(50) NOT NULL,
)

CREATE SCHEMA Person 

CREATE TABLE Person.Person(
PersonID INT NOT NULL PRIMARY KEY,
Title VARCHAR(50) NOT NULL,
FirstName VARCHAR(50) ,
MiddleName VARCHAR(50),
LastName VARCHAR(50),
Gender VARCHAR(50),
ModifiedDate DATE
)

CREATE SCHEMA Production

CREATE TABLE Production.ProductCategory(
ProductCategoryID INT NOT NULL PRIMARY KEY,
ProductCategoryName VARCHAR (50) NOT NULL,
)

CREATE TABLE Production.ProductSubCategory(
ProductSubCategoryID INT IDENTITY(500,1) NOT NULL,
ProductSubCategoryName VARCHAR(50) NOT NULL,
PRIMARY KEY(ProductSubCategoryID),
FOREIGN KEY(ProductSubCategoryID) REFERENCES Production.ProductCategory(ProductCategoryID)
)

CREATE TABLE Production.Product
( ProductID INT IDENTITY(101,1) NOT NULL ,
  ProductName VARCHAR(50) NOT NULL,
  ProductCost INT DEFAULT'100.00',
  QuantityInStock INT ,
  ProductSubCategoryID INT , 
  PRIMARY KEY(ProductID),
 FOREIGN KEY(ProductSubCategoryID) REFERENCES Production.ProductSubCategory(ProductSubCategoryID)
)

CREATE TABLE Sales.Territory(
TerritoryID INT NOT NULL PRIMARY KEY,
TerritoryName VARCHAR(50) NOT NULL,
CountryID INT,
FOREIGN KEY (CountryID) REFERENCES Sales.Country(CountryID)
)

CREATE TABLE Sales.Customer(
CustomerID INT NOT NULL,
PersonID INT NOT NULL,
TerritoryID INT NOT NULL,
CustomerGrade INT ,
PRIMARY KEY(CustomerID),
FOREIGN KEY (PersonID) REFERENCES Person.Person(PersonID),
FOREIGN KEY(TerritoryID) REFERENCES Sales.Territory(TerritoryID)
)

CREATE TABLE HumanResources.Employee(
EmployeeID INT NOT NULL,
Designation VARCHAR(50),
ManagerID INT NOT NULL,
DateOfJoining DATE,
DepartmentID INT NOT NULL,
PersonID INT NOT NULL,
PRIMARY KEY(EmployeeID),

FOREIGN KEY(PersonID) REFERENCES Person.Person(PersonID),
FOREIGN KEY(DepartmentID) REFERENCES HumanResources.Department(DepartmentID)
)

CREATE TABLE Sales.SalesOrderHeader(
SalesOrderHeaderID INT NOT NULL,
OrderDate DATE,
CustomerID INT NOT NULL,
SalesPersonID INT, 
PRIMARY KEY(SalesOrderHeaderID),
FOREIGN KEY(CustomerID) REFERENCES Sales.Customer(CustomerID),
FOREIGN KEY(SalesPersonID) REFERENCES HumanResources.Employee(EmployeeID)
)

CREATE TABLE Sales.SalesOrderDetail(
SalesOrderDetailID INT NOT NULL,
SalesOrderHeaderID INT,
ProductID INT NOT NULL,
OrderQuantity INT,
PRIMARY KEY(SalesOrderDetailID),
FOREIGN KEY(ProductID) REFERENCES Production.Product(ProductID),
FOREIGN KEY(SalesOrderHeaderID) REFERENCES Sales.SalesOrderHeader(SalesOrderHeaderID)
)
-----------------------------------------------------------------------------------------
Select * from Person.Person
/* 1) Write a query that displays all the rows from the Person.Person table where the rows 
were modified after December 29, 2000. Display the business entity ID number, the name 
columns, and the modified date.   */
Select BusinessEntityID, Title, FirstName, MiddleName, LastName, ModifiedDate
From Person.Person
Where ModifiedDate > 2000-12-29

/* 2)Rewrite the query from question 1 so that it displays the rows that were not modified 
during December 2000.   */
Select BusinessEntityID, Title, FirstName, MiddleName, LastName, ModifiedDate
From Person.Person
Where ModifiedDate NOT Between '2000-12-01' AND '2000-12-31'

/* 3)Write a query that displays the product ID and name for each product from the 
Production.Product table with the name starting with Chain.  */
Select * from Production.Product

Select ProductID, Name from Production.Product
Where Name LIKE 'Chain%'

/* 4) Write a query that displays the business entity ID number, first name, middle name, 
and last name from the Person.Person table for only those rows that have E or B stored 
in the middle name column.  */
Select * from Person.Person

Select BusinessEntityID, FirstName, MiddleName, LastName From Person.Person
Where MiddleName IN('E', 'B')

/* 5) Write a query displaying the order ID, order date, and total due from the
Sales.SalesOrderHeader table. Retrieve only those rows where the order was
placed during the month of September 2001 and the total due exceeded $1,000.  */
Select * from Sales.SalesOrderHeader
Select SalesOrderID, OrderDate, TotalDue From Sales.SalesOrderHeader 
Where OrderDate Between '2001-09-01' AND '2001-09-30'
And TotalDue >1000 

/* 6) Write a query displaying the sales orders where the total due exceeds $1,000. Retrieve only those rows where the salesperson ID 
is 279 or the territory ID is 6.  */
Select SalesOrderID, OrderDate, TotalDue,SalesPersonID, TerritoryID  From Sales.SalesOrderHeader
Where TotalDue>1000 AND (SalesPersonID= 279 OR  TerritoryID= 6)

/* 7) Write a query displaying the ProductID, Name, and Color columns from rows in the Production.Product table. Display only those rows 
in which the color is not blue.  */
Select * from Production.Product
Select ProductID, Name, Color from Production.Product
Where Color ='Blue'


/* 8) Write a query that returns the business entity ID and name columns from the Person.Person table. Sort the results by LastName, 
FirstName, and MiddleName.   */
Select * from Person.Person
Select BusinessEntityID, FirstName, MiddleName, LastName From Person.Person
Order By LastName, FirstName, MiddleName 

-- 9) Write a query that displays in the “AddressLine1 (City PostalCode)” format from the Person.Address table.  
Select * from Person.Address
Select AddressLine1, PostalCode, City,  AddressLine1+(postalCode) AS [H1] From Person.Address

/* 10) Write a query using the Production.Product table displaying the product ID, color, and name columns. If the color column 
contains a NULL value, replace the color with No Color. */
Select ProductID, Color, Name, ISNULL(Color,'NoColor') AS [Colour]
From Production.Product

/* 11) Modify the query written in question 2 so that the description of the product is displayed in the “Name: Color” format.
Make sure that all rows display a value even if the Color value is missing.  */
Select ProductID, Name, Color, "Name: Color" AS [Product Description]
from Production.Product

/* 12)Write a query using the Sales.SpecialOffer table. Display the difference between the MinQty and MaxQty columns along with the
SpecialOfferID and Description columns. */
select * from Sales.SpecialOffer

Select SpecialOfferID, Description, MinQty, MaxQty, MaxQty-MinQty AS[Diff] from Sales.SpecialOffer

/* Write a query using the Sales.SpecialOffer table that multiplies the MaxQty column by the DiscountPCT column.
If the MaxQty value is null, replace it with the value 10.Include the SpecialOfferID and Description columns in the results. */
Select SpecialOfferID, Description, MinQty, MaxQty,DiscountPct, ISNULL(MaxQty,10) AS[Hi], MaxQty*DiscountPct AS [Mul]
from Sales.SpecialOffer
 

 --14)Write a query that displays the first 10 characters of the AddressLine1 column in the Person.Address table. 
 Select * From Person.Address
  Select  AddressID, AddressLine1, substring(AddressLine1,1,10) AS[subString  Name]  From Person.Address

  
/* 15) Write a query that calculates the number of days between the date an order was placed and the date that it was shipped using
the Sales.SalesOrderHeader table. Include the SalesOrderID, OrderDate, and ShipDate columns. */
Select SalesOrderID, OrderDate,ShipDate, DATEDIFF(DAY,OrderDate,ShipDate) AS[DeliveryPeriod in Days] From Sales.SalesOrderHeader

/* 16) Write a query that displays only the date, not the time, for the order date and ship date in the Sales.SalesOrderHeader table.
(Use any of the styles that return only date) */
--Select SalesOrderID, OrderDate, ShipDate, OrderDate From Sales.SalesOrderHeader
Select SalesOrderID,Format(OrderDate, 'yyyy-MM-dd') AS[Order Date],Format(ShipDate,'yyyy-MM-dd')AS[Ship Date] From Sales.SalesOrderHeader

/* 17) Write a query that adds six months to each order date in the Sales.SalesOrderHeader table. Include the SalesOrderID and
OrderDate columns.  */

Select SalesOrderID, ShipDate, OrderDate, DATEADD(MONTH,6,OrderDate) AS[Modified Order Date] From Sales.SalesOrderHeader


/* 18) Write a query that displays the year of each order date and the numeric month of each order date in separate columns in the 
results. Include the SalesOrderID and OrderDate columns. */

Select ORDERDATE, Format(OrderDate, 'yyyy'),Format(OrderDate, 'MM') From Sales.SalesOrderHeader

/* 19) Write a statement that generates a random number between 1 and 10 each time it is run.  */

SELECT FLOOR(RAND()*(10-1+1)+1); 

/*20) Write a query using the Sales.SalesOrderHeader table to display the orders placed during 2001 by using a function. 
Include the SalesOrderID and OrderDate columns in the results.  */
Select SalesOrderID,OrderDate From Sales.SalesOrderHeader
Where YEAR(OrderDate)= 2011


Select * From Sales.SalesOrderHeader
/* 21) Write a query using the Sales.SalesOrderHeader table listing the sales in order of the month the order was placed 
and then the year the order was placed. Include the SalesOrderID and OrderDate columns in the results.  
*/
Select SalesOrderID,OrderDate,  Format(OrderDate, 'MM-yyyy-dd') AS[Formatted-OrderDate] From Sales.SalesOrderHeader

/* 22)The HumanResources.Employee table does not contain the employee names. Join that table to the Person.Person table on 
the BusinessEntityID column. Display the job title, birth date, first name, and last name.  */
Select * from HumanResources.Employee

Select H.JobTitle, H.BirthDate, P.Firstname, P.LastName from HumanResources.Employee H
INNER JOIN Person.Person P ON H.BusinessEntityID = P.BusinessEntityID


/*23) The customer names also appear in the Person.Person table. Join the Sales.Customer table to the Person.Person table. 
The BusinessEntityID column in the Person.Person table matches the PersonID column in the Sales.Customer table. Display the 
CustomerID, StoreID, and TerritoryID columns along with the name columns. */
Select S.CustomerID, S.StoreID, S.TerritoryID, P.FirstName, P.MiddleName, P.LastName From Sales.Customer S 
INNER JOIN Person.Person p ON P.BusinessEntityID = S.PersonID

/* 24) Write a query that joins the Sales.SalesOrderHeader table to the Sales. SalesPerson table. Join the BusinessEntityID column 
from the Sales.SalesPerson table to the SalesPersonID column in the Sales.SalesOrderHeader table. Display the SalesOrderID along 
with the SalesQuota and Bonus.  */

Select OH.SalesOrderID, OH.SalesOrderNumber, SP.Bonus From Sales.SalesOrderHeader OH 
INNER JOIN Sales.SalesPerson SP ON SP.BusinessEntityID=OH.SalesPersonID


/* 25) The catalog description for each product is stored in the Production.ProductModel table. Display the columns that describe 
the product from the Production.Product table, such as the color and size along with the catalog description for each product. */ 
select * from Production.Product
select * from Production.ProductModel

Select P.ProductID, P.Color, P.Size, P.StandardCost, M.CatalogDescription from Production.Product P
LEFT JOIN  Production.ProductModel M ON P.ProductID= M.ProductModelID

/* 26)Write a query that displays the names of the customers along with the product names that they have purchased. 
Hint: Five tables will be required to write this query!  */

/* 27)Write a query that displays all the products along with the SalesOrderID even if an order has never been placed for that product. 
Join to the Sales.SalesOrderDetail table using the ProductID column.  */

Select *, S.ProductID FRom Production.Product P
Left Join Sales.SalesOrderDetail S On S.SalesOrderID = P.ProductID

/* 28)The Sales.SalesOrderHeader table contains foreign keys to the Sales.CurrencyRate and Purchasing.ShipMethod tables. Write a query 
joining all three tables, making sure it contains all rows from Sales.SalesOrderHeader. Include the CurrencyRateID, AverageRate, 
SalesOrderID, and ShipBase columns.  
*/

Select SCR.CurrencyRateID, SCR.AverageRate, SOH.SalesOrderID, PSM.ShipBase from Sales.SalesOrderHeader SOH 
Left Outer Join Sales.CurrencyRate SCR On SCR.CurrencyRateID= SOH.CurrencyRateID
Left outer join Purchasing.ShipMethod PSM On SCR.CurrencyRateID= PSM.ShipMethodID

/* 29) Write a query to determine the number of customers in the Sales.Customer table. */ 

Select count(*) AS [Number of customers] from Sales.Customer

/* 30) Write a query using the Production.Product table that displays the minimum, maximum, and average ListPrice.  */
Select * from Production.Product
Select productID, Name, ListPrice from Production.Product
WHERE ListPrice=(
	SELECT MAX(ListPrice) From Production.Product
	)
	Select productID, Name, ListPrice from Production.Product
WHERE ListPrice=(
	SELECT MIN(ListPrice) From Production.Product
	) 
	Select productID, Name, ListPrice from Production.Product
WHERE ListPrice=(SELECT AVG(ListPrice) From Production.Product
	)


/* 31)Write a query that shows the total number of items ordered for each product. Use the Sales.SalesOrderDetail table to write 
the query. */
Select * from Sales.SalesOrderDetail

Select ProductID, count(*) AS [Items ordered] From Sales.SalesOrderDetail group by ProductID 

/* 32) Write a query using the Sales.SalesOrderDetail table that displays a count of the detail lines for each SalesOrderID. */
Select SalesOrderID, count(*) AS [Count ] From Sales.SalesOrderDetail group by SalesOrderID 

/* 33) Write a query using the Production.Product table that lists a count of the products in each product line.  */
Select  ProductLine, count(*) AS [Count ] From Production.Product group by ProductLine


/* 34)Write a query that displays the count of orders placed by year for each customer using the Sales.SalesOrderHeader table.  */
Select  Format(OrderDate, 'yyyy') AS[OrderYear], count(*) AS [Orders placed] From Sales.SalesOrderHeader 
group by  OrderDate

select * from Sales.SalesOrderHeader

/* 35) Write a query that creates a sum of the LineTotal in the Sales.SalesOrderDetail table grouped by the SalesOrderID. Include 
only those rows where the sum exceeds 1,000.  
*/
select * from Sales.SalesOrderDetail
Select SalesOrderID, SUM(Linetotal ) AS[Sum of LineTotal] from Sales.SalesOrderDetail group by SalesOrderID

/* 36) Write a query that groups the products by ProductModelID along with a count. Display the rows that have a count that equals 1.
*/
Select ProductModelID, count(*)AS [Count] From Production.ProductModel Group by ProductModelID

/*37) Write a query using the Sales.SalesOrderHeader, Sales.SalesOrderDetail, and Production.Product tables to display the total sum 
of products by ProductID and OrderDate. */

/*38)Display the 3rd joined employee. */
SELECT * FROM 
(
	SELECT	
		BusinessEntityID,jobTitle,gender,HireDate,
		DENSE_RANK() OVER(ORDER BY HireDate ASC) AS [HD]
	FROM HumanResources.Employee 
) as PD WHERE [HD] = 3
/*
39)Display the customer who has placed 2nd highest orders  
*/
Select Distinct(SalesOrderID), OrderQTY,
Count(OrderQty) OVER(Partition By SalesOrderID) AS[HighestOrder]
  From Sales.SalesOrderDetail Order By HighestOrder DESC

----------------------------------------------------------------------------------------------------

CREATE SCHEMA PatientAdministration
CREATE TABLE PatientAdministration.Patient
(
	PatientID INT IDENTITY(101,1) PRIMARY KEY,
	PatName VARCHAR(50) NOT NULL,
	DOB DATE CHECK(DOB< GETDATE()),
	IdProofType VARCHAR(20) CHECK(IdProoftype IN ('Aadhar', 'Pancard')),
	IdProofNumber VARCHAR(20),
	Gender VARCHAR(10) CHECK(Gender IN ('MALE', 'FEMALE'))
)

INSERT INTO PatientAdministration.Patient
(PatName, DOB, IdProoftype, IdProofNumber, Gender)
VALUES
('John', '10-Oct-1994', 'Aadhar', '276885680445', 'Male'),
('David', '15-Oct-1992', 'Pancard', 'GFYPS15T', 'Male')

select * from PatientAdministration.Patient

CREATE TABLE PatientAdministration.NextOfKin
(
	KinId INT IDENTITY(101,1) PRIMARY KEY,
	RelativeName VARCHAR(20),
	Relation VARCHAR(20),
	PatientID INT REFERENCES PatientAdministration.Patient(PatientId) NOT NULL
)
INSERT INTO PatientAdministration.NextOfKin
(RelativeName,Relation,PatientID)
VALUES
('James','Father', 101),
('Newton', 'Brother',102 )

SELECT * FROM PatientAdministration.NextOfKin

------------------------------------------------------------------------------------------
/*
Create a seq and insert data into multiple tables from the seq.
**Start with 5 maxvalue 10 minvalue 1 cycle
*/
Create Sequence SeqDemo
Start with 5
Increment By 1
Minvalue 1
Maxvalue 10
Cycle
 INsert into patientVisits(PatientID, VisitPurpose,VisitTime) Values
 (Next value for SeqDemo, 'P',35)

 INsert into patientVisits(PatientID, VisitPurpose,VisitTime) Values
 (Next value for SeqDemo, 'C',25),
  (Next value for SeqDemo, 'R',15),
   (Next value for SeqDemo, 'R',30),
    (Next value for SeqDemo, 'P',40)


Create table  PatientVisits(
VisitID INT  Primary Key IDENTITY(1,1),
PatientID INT , 
VisitPurpose VArchar(5),
VisitTime INT
)

Insert Into PatientVisits VAlues
(101,'C',15),
(999,'P',15),
(101,'R',15),
(222,'C',15),
(222,'C',15),
(101,'P',15),
(222,'R',15),
(888,'R',15),
(777,'P',15),
(999,'R',15)
Select * from PatientVisits
-------------------------------------------------------------------------------------------

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

Create Schema Bank
Create table Bank.Accounttypemaster(
AccounttypeId int primary key identity (1500,1),
Accounttype varchar(50) Not null check(Accounttype In ('Savings','Current')),
)
Register new bank account using stored procedure in the below table
dDate

Create Table Bank.BankAccount (
BankAccountId int Primary key identity(1500,1),
AccounttypeId int,
Foreign Key (AccounttypeId) References Bank.Accounttypemaster(AccounttypeId),
ConsumerName Varchar(50),
BalanceAmount decimal,
ModifiedDate Date
)
Alter Procedure RegisterBankAccount
@AccounttypeID int,
@ConsumerName varchar(50),
@BalanceAmount Decimal,
@ModifiedDate Date
As
Begin
if Not exists (Select * from Bank.Accounttypemaster where AccounttypeId = @AccounttypeID)
begin
raiserror('Account type not found',1,1)
return
Endif (@BalanceAmount < 10000)
begin
raiserror('Balance should be Greater that 10000 while Registering',1,1)
Return
Endif(@ModifiedDate > GETDATE())
begin
raiserror('Modified date should not be future date',1,1)
Return
Endif (@ConsumerName Like '%[^a-z][^A-Z][^0-9]%')
begin
raiserror('Consumer Name should not be Alpha Numeric',1,1)
Return
EndInsert into Bank.BankAccount (AccounttypeID,ConsumerName,BalanceAmount,ModifiedDate)
values(@AccounttypeID,@ConsumerName,@BalanceAmount,@ModifiedDate)
EndExec RegisterBankAccount 1500,'test',16000,'2022-05-24'
select * from Bank.BankAccount

--------------------------------------------------------------------------------------------
--LAB on Functions:: Create a function to check if a number is prime or not
Create schema numbers
Create Table numbers.Prime(
Numbers INT
)
Insert into numbers.Prime values()


Select *(
Create function isPrime (@number int) 
returns int  as 
Begin
	Declare @result bit = 1,@i int = 2
	While (@i<@number)
	Begin
		if(@number % @i = 0)
		Begin
			Set @result = 0
			break
		End
		Set @i += 1
	End
	return @result
End
) From PrimeNumbers


Select dbo.isPrime(67)
Select dbo.isPrime(7)
----------------------------------------------------------
/*
Lab: Suppose you have two tables:
Tab1: CodeQuantityMaster (CodeID, Code, Quantity)
CodeID Code Quantity
111 WRIUPI 10
112 S20@QO 15
113 HKP#4E 12
114 OYT$7R 50
115 JJ**L25 25Tab2: 
TestProduct (ProductID,ProductName, Color, Code)
**Note: Fill some sample data in TestProductTable using the below query
INSERT INTO TestProduct(ProductID,ProductName,Color)
SELECT ProductID,Name,Color FROM Production.Product 
As a sql dveloper you are asked to update code against each product in TestProduct table.
The value of code should come from CodeQuantityMaster table for the no. of products mentioned in Quantity column of
CodeQuantityMaster. Reapeat the codes from intital one after all the codes are used.
*/
Create table CodeQuantityMaster(
CodeID INT, Code VARCHAR(50), Quantity INT
)
INSERT INTO CodeQuantityMaster  (CodeID, Code, Quantity) 
VALUES (111, 'WRIUPI', 10)
INSERT INTO CodeQuantityMaster VALUES (112, 'S20@QO',	15)
INSERT INTO CodeQuantityMaster VALUES (113, 'HKP#4E',	12)
INSERT INTO CodeQuantityMaster VALUES (114, 'OYT$7R',	50)
INSERT INTO CodeQuantityMaster VALUES (115, 'JJ**L25',	25)
Select * from CodeQuantityMaster

Create Table TestProduct (
ProductID INT,ProductName VARCHAR(20), Color VARCHAR(20), Code VARCHAR(20))
INSERt Into TestProduct (ProductID,ProductName,Color) Values(101,'ABS', 'Blue')
INSERt Into TestProduct (ProductID,ProductName,Color)Values(101,'MNK', 'Black')
INSERt Into TestProduct (ProductID,ProductName,Color)Values(101,'XYZ', 'Red')
Select * from TestProduct


SELECT ProductID,Name,Color FROM Production.Product 
/*
LAB:::
Explore and document:
a. What are Analytical functions. Document Description and examples on any 5 analytical functions
b. What are grouping sets with examples and variations
*/
a) Analytic functions calculate an aggregate value based on a group of rows. Unlike aggregate functions, however, analytic functions can return multiple rows for each group. 
Use analytic functions to compute moving averages, running totals, percentages or top-N results within a group.
An analytic function generally looks like this:
function_name ( arguments ) OVER ( [query_partition_clause] 
[ORDER BY order_by_clause [windowing_clause] ] )

SQL Server supports these analytic functions:
•	CUME_DIST (Transact-SQL)
•	FIRST_VALUE (Transact-SQL)
•	LAG (Transact-SQL)
•	LAST_VALUE (Transact-SQL)
•	LEAD (Transact-SQL)
•	PERCENT_RANK (Transact-SQL)
•	PERCENTILE_CONT (Transact-SQL)  
•	PERCENTILE_DISC (Transact-SQL)
•	SELECT address_state,
•	COUNT(*)
•	FROM student
•	GROUP BY address_state;


2) COUNT(*) OVER (PARTITION BY address_state)

3) SELECT first_name,
last_name,
address_state,
COUNT(*) OVER (PARTITION BY address_state) AS state_count
FROM student;


b)-> GROUPING SET in standard query language (SQL) can be considered as a sub-clause of GROUP BY clause. For uninitiated, GROUP BY clause is used to group rows having the same values in a column
into summary rows. A grouping set is a set or group of columns by which rows with similar values are grouped together. Functionally, it generates a result set similar to the one generated by a UNION ALL 
of multiple GROUP BY clauses on a single column. Some other sub-clause of GROUP BY clause such as ROLLUP, CUBE etc also produce result sets equivalent to GROUPING SETS.

C) Transactions and Isolataion levels + Locks  
A transaction is a single unit of work. If a transaction is successful, all of the data modifications made during the transaction are committed and become a permanent part of the database. 
If a transaction encounters errors and must be cancelled or rolled back, then all of the data modifications are erased.
SQL Server operates in the following transaction modes:
Autocommit transactions
Each individual statement is a transaction.
Explicit transactions
Each transaction is explicitly started with the BEGIN TRANSACTION statement and explicitly ended with a COMMIT or ROLLBACK statement.
Implicit transactions
A new transaction is implicitly started when the prior transaction completes, but each transaction is explicitly completed with a COMMIT or ROLLBACK statement.
Batch-scoped transactions
Applicable only to multiple active result sets (MARS), a Transact-SQL explicit or implicit transaction that starts under a MARS session becomes a batch-scoped transaction. A batch-scoped transaction 
that is not committed or rolled back when a batch completes is automatically rolled back by SQL Server.
SQL Server provides the following transaction statements:
BEGIN DISTRIBUTED TRANSACTION
ROLLBACK TRANSACTION
BEGIN TRANSACTION
ROLLBACK WORK
COMMIT TRANSACTION
SAVE TRANSACTION
COMMIT WORK
Isolation levels come into play when you need to isolate a resource for a transaction and protect that resource from other transactions. The protection is done by obtaining locks.
What locks need to be set and how it has to be established for the transaction is determined by SQL Server referring to the Isolation Level that has been set. Lower Isolation Levels allow multiple 
users to access the resource simultaneously (concurrency) but they may introduce concurrency related problems such as dirty-reads and data inaccuracy. Higher Isolation Levels eliminate concurrency 
related problems and increase the data accuracy but they may introduce blocking.
SQL Server clients can control transaction-isolation levels for a connection. To control transaction-isolation level, the SQL Server Native Client OLE DB provider consumer uses:
•	DBPROPSET_SESSION property DBPROP_SESS_AUTOCOMMITISOLEVELS for the SQL Server Native Client OLE DB provider default autocommit mode.
The SQL Server Native Client OLE DB provider default for the level is DBPROPVAL_TI_READCOMMITTED.
•	The isoLevel parameter of the ITransactionLocal::StartTransaction method for local manual-commit transactions.
•	The isoLevel parameter of the ITransactionDispenser::BeginTransaction method for MS DTC-coordinated distributed transactions.
SQL Server allows read-only access at the dirty read isolation level. All other levels restrict concurrency by applying locks to SQL Server objects. As the client requires greater concurrency levels, 
SQL Server applies greater restrictions on concurrent access to data. To maintain the highest level of concurrent access to data, the SQL Server Native Client OLE DB provider consumer should intelligently 
control its requests for specific concurrency levels.
The SQLServer:Locks object in Microsoft SQL Server provides information about SQL Server locks on individual resource types. Locks are held on SQL Server resources, such as rows read or modified during 
a transaction, to prevent concurrent use of resources by different transactions. For example, if an exclusive (X) lock is held on a row within a table by a transaction, no other transaction can modify 
that row until the lock is released. Minimizing locks increases concurrency, which can improve performance. Multiple instances of the Locks object can be monitored at the same time, with each instance 
representing a lock on a resource type.
This table describes the SQL Server Locks counters.
SQL Server Locks counters	Description
Average Wait Time (ms)	Average amount of wait time (in milliseconds) for each lock request that resulted in a wait.
Average Wait Time Base	For internal use only.
Lock Requests/sec	Number of new locks and lock conversions per second requested from the lock manager.
Lock Timeouts (timeout > 0)/sec	Number of lock requests per second that timed out, but excluding requests for NOWAIT locks.
Lock Timeouts/sec	Number of lock requests per second that timed out, including requests for NOWAIT locks.
Lock Wait Time (ms)	Total wait time (in milliseconds) for locks in the last second.
Lock Waits/sec	Number of lock requests per second that required the caller to wait.
Number of Deadlocks/sec	Number of lock requests per second that resulted in a deadlock.
SQL Server can lock these resources.
Item	Description
_Total	Information for all locks.
AllocUnit	A lock on an allocation unit.
Application	A lock on an application-specified resource.
Database	A lock on a database, including all objects in the database.
Extent	A lock on a contiguous group of 8 pages.
File	A lock on a database file.
Heap/B-tree	Heap or B-tree. A lock on a heap of data pages, or on the B-tree structure of an index.
Key	A lock on a row in an index.
Metadata	A lock on a piece of catalog information, also called metadata.
Object	A lock on table, stored procedure, view, etc, including all data and indexes. The object can be anything that has an entry in sys.all_objects.
OIB	Lock resource for online index build locks, specifically for a online index build LOB tracking table.
Page	A lock on an 8-kilobyte (KB) page in a database.
RID	Row ID. A lock on a single row in a heap.
RowGroup	Lock resource for a columnstore index rowgroup.
Xact	Lock resource for a transactions.


 d. how do we use inserted and deleted tables outside of trigger (**Hint: Use OUTPUT clause)

e. What are SET operations in SQL (UNION,UNION ALL, INTERSECT, MINUS)
Concatenates the results of two queries into a single result set. You control whether the result set includes duplicate rows:
•	UNION ALL - Includes duplicates.
•	UNION - Excludes duplicates.
A UNION operation is different from a JOIN:
•	A UNION concatenates result sets from two queries. But a UNION does not create individual rows from columns gathered from two tables.
•	A JOIN compares columns from two tables, to create result rows composed of columns from two tables.
The following are basic rules for combining the result sets of two queries by using UNION:
•	The number and the order of the columns must be the same in all queries.
•	The data types must be compatible.
INTERSECT: Returns the intersection of two input sets, optionally retaining duplicates.
The Intersect function returns the intersection of two sets. By default, the function removes duplicates from both sets prior to intersecting the sets. The two sets specified must have the same dimensionality.
The optional ALL flag retains duplicates. If ALL is specified, the Intersect function intersects nonduplicated elements as usual, and also intersects each duplicate in the first set that has a matching 
duplicate in the second set. The two sets specified must have the same dimensionality.
The SQL MINUS operator is used to return all rows in the first SELECT statement that are not returned by the second SELECT statement. Each SELECT statement will define a dataset. The MINUS operator will
retrieve all records from the first dataset and then remove from the results all records from the second dataset.




