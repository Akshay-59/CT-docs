<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Menu</title>
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>

<c:forEach var="menu" items="${adminMenus}">
	<a href="/SpringMVCShoppingDemo${menu.getValue()}"><p>${menu.getKey()}</p></a>
</c:forEach>
<%
	String role = (String) request.getAttribute("role");
	request.getSession().setAttribute("role",role);
%>
</body>
</html>