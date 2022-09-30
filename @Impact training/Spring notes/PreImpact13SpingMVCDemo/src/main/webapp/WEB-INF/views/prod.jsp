<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>

<form action="prd" method="post">
<h2>Add New Product</h2>
Product ID =<input type="text" name="prod_id">
<br/>
Product Name = <input type="text" name="prod_name" />
<br/>
Product Price = <input type="text" name="prod_price">
<br/>
<input type="submit" value="Add Product"/>
</form>

</body>
</html>