<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>
<h2>
<%
out.println(request.getAttribute("errorMessage"));
%>
</h2>


</body>
</html>