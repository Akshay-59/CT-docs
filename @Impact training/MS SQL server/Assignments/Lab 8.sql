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