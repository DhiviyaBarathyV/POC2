<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/register.css" rel="stylesheet"/>
<title>Add Book</title>
</head>
<body>
<h1 class="head">Dhiviya Book Store</h1>
<h4 class="sub">Add Book</h4>
<div class="form"></div>
  <div class="text">
<form:form action="addingBook"  modelAttribute="book">
 Book Id:<form:input path="bookId"  type="number"/><br><br>
 Book Name:<form:input path="bookName" /><br><br> 
 Category:<form:input path="Category" /><br><br>
 Author:<form:input path="author"  /><br><br>
 Price:<form:input path="price" /><br><br>
 <input type = "submit" value ="submit">
</form:form>  
  </div>
  <div class="reg">
 <form action="back" >
    <button type="submit">Back</button>
</form>
</div>

</body>
</html>