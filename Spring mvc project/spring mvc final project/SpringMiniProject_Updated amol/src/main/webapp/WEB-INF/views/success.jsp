<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>
<h2>
<%
out.println(request.getAttribute("successMessage"));
%>
</h2>
</body>
</html>