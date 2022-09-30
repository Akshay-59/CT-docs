<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You!</title>
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>
<h2>
<%
out.println(request.getAttribute("totalMessage"));
out.println("If you wish to continue please press the back button or close this tab");

%>
</h2>


</body>
</html>