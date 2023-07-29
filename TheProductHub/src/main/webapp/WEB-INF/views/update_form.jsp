<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<head>
<meta charset="ISO-8859-1">
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./base.jsp"%>
</head>
<body>

<div class="container mt-3" >
     <div class="row">
         <div class="col-md-6 offset-md-3">

<h1 class="text-center mb-3"> Change Product Details</h1>
<br>

 <!-- This is add Product form -->
<form action="/TheProductHub/handle-product" method="post">
   
   <input type="hidden" value="${product.id}" name ="id"/>

  <div class="mb-3">
    <label for="title" class="form-label">Product Name</label>
    <input name="name" required type="text" class="form-control" id="name" aria-describedby="emailhelp" placeholder="Enter here"
    value="${product.name}"
    >
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">Product Description</label>
    <textarea required
    id="description"
    name="description"
    placeholder="Enter your Description here "
    class="form-control"
    style="height:120px;">${product.description}
    </textarea>
  </div>

  <div class="mb-3">
      <label for="price" class="form-label">Product Price</label>
      <input name="price" required type="text" class="form-control" id="price" placeholder="Enter here"  value="${product.price}">
    </div>

  <div class="container text-center">
  <a href="/TheProductHub/"
         class="btn btn-outline-danger">Back</a>
  <button type="submit" class="btn btn-warning">Update</button>
  </div>

</form>

</body>
</html>