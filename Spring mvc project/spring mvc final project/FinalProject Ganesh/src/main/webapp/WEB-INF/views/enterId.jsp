<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter ID</title>
</head>
<body>

<%
String req = (String) request.getAttribute("action");
out.println(req);
%>

<form action="${req}" >
Enter Id =<input type="number" required name="id" />
<br/>
<input type="submit" value="Submit"/>
<% String message = (String) request.getAttribute("message"); %>
<%
if(message!=null) {
%>
<h3> ${message} </h3>

<% } %>
</form>
</body>
</html>