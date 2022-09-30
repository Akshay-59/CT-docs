<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp</title>
</head>
<body>
	<h1>Employee Added Successfully</h1>
	<%
	int eid = (Integer) request.getAttribute("emp_id");

	String ename = (String) request.getAttribute("emp_name");

	List<String> employees = (List<String>) request.getAttribute("emps");
	

	out.println(eid);
	out.println(ename);
	%>
	<h2>Employee ID = ${emp_id}</h2>
	<h2>Employee Name = ${emp_name}</h2>
	<h3>${emps}</h3>

	<%
	for (String emp : employees) {
	%>
	<h2>
		<%
		out.println(emp);
		%>
	</h2>
	<%
	}
	%>

<h1>Try using JSTL</h1>
<c:forEach var="emp" items="${emps}">
	<h2>${emp}</h2>
</c:forEach>


</body>
</html>