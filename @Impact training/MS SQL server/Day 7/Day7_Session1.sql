SELECT ProductID,Name,StandardCost FROM RedProducts

---EXPLICIT CURSORS
DECLARE cur_prods CURSOR FOR 
	SELECT ProductID,Name,StandardCost FROM RedProducts;
DECLARE  @ProdID INT;
DECLARE @ProdName VARCHAR(30);
DECLARE @StdCost NUMERIC(10,4);
OPEN cur_prods;
FETCH NEXT FROM cur_prods INTO @ProdID,@ProdName,@StdCost
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT '--------------------------------------------';
	PRINT 'Product ID: ' + CAST(@ProdID AS VARCHAR);
	PRINT 'Product Name: ' + @ProdName;
	PRINT 'Standard Cost: ' + CAST(@StdCost AS VARCHAR);
	PRINT '--------------------------------------------';
	FETCH NEXT FROM cur_prods INTO @ProdID,@ProdName,@StdCost
END;
CLOSE cur_prods;
DEALLOCATE cur_prods;
------------------------------------------------------------------------------------------
/*
Lab: Suppose you have two tables:
Tab1: CodeQuantityMaster (CodeID, Code, Quantity)
CodeID	Code	Quantity
111		WRIUPI	10
112		S20@QO	15
113		HKP#4E	12
114		OYT$7R	50
115		JJ**L25	25

Tab2: TestProduct (ProductID,ProductName, Color, Code)
**Note: Fill some sample data in TestProductTable using the below query
INSERT INTO TestProduct(ProductID,ProductName,Color)
SELECT ProductID,Name,Color FROM Production.Product

As a sql dveloper you are asked to update code against each product in TestProduct table. 
The value of code should come from CodeQuantityMaster table for the no. of products mentioned in Quantity column of 
CodeQuantityMaster. Reapeat the codes from intital one after all the codes are used.
*/

------------------------------------------------------------------------------------------------------
--CTE (Common Table Expresssion)
--EX

--GET THE SECOND COSTLIEST PROD.
SELECT * FROM 
(
	SELECT ProductID,ProductNumber,Name,Color,StandardCost,
	DENSE_RANK()OVER(Order BY StandardCost DESC) AS DR
	FROM Production.Product
) AS prd WHERE DR = 2

--Alternate command using CTE
WITH Prods_CTE(ProdID,PNumber,PName,Color,StdCost,DR) AS
(
	SELECT ProductID,ProductNumber,Name,Color,StandardCost,
	DENSE_RANK()OVER(Order BY StandardCost DESC) 
	FROM Production.Product
)
SELECT * FROM Prods_CTE WHERE DR = 2

--EX2 for CTE

WITH Prods_CTE(ProdID,PNumber,PName,Color,StdCost,SubCatID,DR) AS
(
	SELECT ProductID,ProductNumber,Name,Color,StandardCost,ProductSubcategoryID,
	DENSE_RANK()OVER(Order BY StandardCost DESC) 
	FROM Production.Product
),
Prod_Info (SubCatID, SubCategoryName, CatgID,CatgName)AS
(
	SELECT PSC.ProductSubcategoryID, PSC.Name, PCT.ProductCategoryID, PCT.Name
	FROM Production.ProductSubcategory PSC LEFT OUTER JOIN Production.ProductCategory PCT
	ON PSC.ProductCategoryID = PCT.ProductCategoryID
)
SELECT * FROM Prods_CTE P LEFT OUTER JOIN Prod_Info PD 
ON P.SubCatID = PD.SubCatID
WHERE P.DR = 2
-------------------------------------------------------------------------------------------------
/*
LAB:::
Explore and document:
a. What are Analytical functions. Document Description and examples on any 5 analytical functions
b. What are grouping sets with examples and variations
c. Transactions and Isolataion levels + Locks
d. how do we use inserted and deleted tables outside of trigger (**Hint: Use OUTPUT clause)
e. What are SET operations in SQL (UNION,UNION ALL, INTERSECT, MINUS)
*/
