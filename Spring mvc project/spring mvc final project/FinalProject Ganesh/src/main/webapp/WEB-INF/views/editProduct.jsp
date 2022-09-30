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
<title>Edit Product</title>
</head>
<body>

<button type="button" name="back" onclick="history.back()">back</button>
<h2>Edit Product</h2>

<form action="addEditProduct", method="post">


<h4>Select a product you want to edit</h4>
<c:forEach var="product" items="${products}" varStatus="prodIndex">

    	<input type="radio" id="${product.getId()}"  required name="id" value="${product.getId()}"  />
    	<label for="${product.getId()}">

    	<span>${product.getName()} ---- Rs.${product.getPrice()} </span>
    	 <span> ----- Category : <c:out value="${productCategories[prodIndex.index]}"/> </p>
    	</label><br>


    </c:forEach>

<br>
<br>

Enter Product Name = <input type="text"  name="name" />
<br/>
Enter Product Price = <input type="number"  name="price" />
<br/>

Select a Product Category :

<c:forEach var="category" items="${categories}">

<br>
<input type="radio" id="${category.getId()}" required name="productCategoryId" value="${category.getId()}" />

    	<label for="${category.getId()}">

    	<span>${category.getName()}</span>
    	</label><br>
</c:forEach>
<br>
<br>
<input type="submit" value="Submit"/>

</form>
</body>
</html>