<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>

</body>

<div class="row">
  <div class="col-md-6 offset-md-3">
    <h1 class="text-center mb -3">Fill the Product Details</h1>
    <form action="handle-product" method="post">
      <div class="form-group">
        <label for="name">Product Name</label>
        <input
          type="text"
          class="form-control"
          id="name"
          aria-describedby="emailHelp"
          name="name"
          placeholder="Enter the product Name here"
        />
      </div>
      <div class="form-group">
        <label for="description">Product Specifications</label>
        <textarea
          class="form-control"
          name="description"
          id="description"
          rows="5"
          placeholder="Enter the Product specifications"
        ></textarea>
      </div>
      <div class="form-group">
        <label for price>Product Price</label>
        <input
          type="text"
          placeholder="Enter Product price"
          name="price"
          class="form-control"
          id="price"
        />
      </div>
      <div class="container text-center">
          <a href="${pageContext.request.contextPath}/"
          class="btn btn-outline-danger">Back</a>
          <button type="submit" class="btn btn-primary">Add</button>
      </div>
    </form>
    
    
    <form action="login" method="post">
  </div>
</div>



</html>