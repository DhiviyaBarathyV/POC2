<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<link href="css/login.css" rel="stylesheet"/>
<title>Login</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">LogIn Form</h4>
<div class="form"></div>
  <div class="text">
  <form:form action="loginprocess" method="post" style="position: absolute;" modelAttribute="login">
  User Name:<form:input  path="userName" /><br><br>
  Password:   <form:input type="password" path="passWord"/><br><br>
  <input type = "submit" value="submit">
  </form:form>
  </div>
<div class="reg">
 <h4>If you are new to our Store Please Register here</h4>
 <form action="register">
    <button type="submit">Click to Register</button>
</form>
 <form action="main" method="get">
    <button type="submit">Back to Home</button>
</form>
</div>


</body>
</html>