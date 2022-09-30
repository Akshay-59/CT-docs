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
<title>Edit Customer</title>
</head>
<body>

<button type="button" name="back" onclick="history.back()">back</button>
<h2>Edit Customer</h2>

<form action="addEditCustomer", method="post">


<h4>Select a User you want to edit</h4>
<c:forEach var="user" items="${users}" varStatus="userIndex">

    	<input type="radio" id="${user.getId()}"  required name="id" value="${user.getId()}"  />
    	<label for="${user.getId()}">

    	<span>Username : ${user.getUsername()} </span>
    	 <span> ----- Password : <c:out value="${user.getPassword()}"/> </p>
    	</label><br>


    </c:forEach>

<br>
<br>

Enter User Name = <input type="text"  name="username" />
<br/>
Enter User Password = <input type="password"  name="password" />

<br>
<br>
<input type="submit" value="Submit"/>

</form>
</body>
</html>