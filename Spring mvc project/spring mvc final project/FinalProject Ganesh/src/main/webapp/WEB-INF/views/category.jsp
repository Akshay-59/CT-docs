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

	<h1>Categories</h1>


<c:forEach var="category" items="${categories}">
	<a href="/SpringMVCShoppingDemo/getProductBasedOnCategory?categoryId=${category.getId()}"><p>${category.getId()}.<span>${category.getName()}</span></p></a>
</c:forEach>
</body>
</html>