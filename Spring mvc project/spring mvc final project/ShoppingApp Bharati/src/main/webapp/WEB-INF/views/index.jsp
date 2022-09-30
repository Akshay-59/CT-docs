
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   isELIgnored="false"% pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col"> Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${product}" var="p">
					
						<tr>
							<td scope="row">${ p.id }</td>
							<td>${ p.name }</td>
							<td>${ p.description}</td>
							<td>${ p.price }</td>
							<td><a href="delete/${p.id} ">Delete</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<br>
				
				<div class="container text-center" style="center">
				<a href="add_product" class="btn btn-outline-success">Add Product</a>
				</div> &nbsp;
				

			</div>
		</div>
	</div>
</body>
</html>
