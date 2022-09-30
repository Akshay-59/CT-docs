<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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


<c:forEach var="product" items="${products}" varStatus="prodIndex">
	<p>${prodIndex.index+1}.<span>${product.getName()}</span>
	<p> Price : Rs. ${product.getPrice()} </p>
	 <p>Category : <c:out value="${categories[prodIndex.index]}"/> </p>
	 <p>--------------------------------------------------</p>
	 </p></a>
</c:forEach>
</body>
</html>