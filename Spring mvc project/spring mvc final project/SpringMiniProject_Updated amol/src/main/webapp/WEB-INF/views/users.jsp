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

	<h1>Users</h1>

<c:forEach var="user" items="${users}" varStatus="userIndex">
	<p> ${userIndex.index+1}. Username :  ${user.getUsername()}</p>
	<p> Password : ${user.getPassword()}</p>

</c:forEach>
</body>
</html>