<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/welcome.css" rel="stylesheet"/>
<title>Deleted</title>
</head>
<body>
<h1 class="head">Dhiviya Book store</h1>
<h4 class="sub">Welcome ${login.userName} </h4>
<h4 class="sub">Book with id ${id} have been deleted successfully!!!</h4>
<div class="reg">
 <form action="/back" method="get">
    <button type="submit">Back</button>
    </form>
    </div>
</body>
</html>