<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.ArrayList"%>
    <%@ page import ="java.util.List"%>
    <%@ page session="true"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>

<h2>Add User</h2>
<form action="addEditCustomer", method="post">

Enter User Name = <input type="text"  name="username" />
<br/>
Enter Password = <input type="password"  name="password" />

<br>
<br>
<input type="submit" value="Submit"/>

</form>
</body>
</html>