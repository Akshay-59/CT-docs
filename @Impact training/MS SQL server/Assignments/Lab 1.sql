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