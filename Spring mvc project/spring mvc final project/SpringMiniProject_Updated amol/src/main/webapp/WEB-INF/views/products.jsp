<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>

	<h1>Products</h1>

    <form action="submitOrder" method="post">
    <c:forEach var="product" items="${products}">

    	<input type="radio" id="${product.getId()}" required name="productId" value="${product.getId()}" />
    	<label for="${product.getId()}">

    	<span>${product.getName()} ---- Rs.${product.getPrice()} </span>
    	</label><br>


    </c:forEach>


    Enter Quantity = <input type="number" name="quantity" required/>
    <input type="submit" value="Submit"/>
    </form>

</body>
</html>