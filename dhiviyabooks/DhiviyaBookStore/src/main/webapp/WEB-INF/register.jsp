<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<link href="css/register.css" rel="stylesheet"/>
<title>Registration</title>
</head>
<body>
<h1 class="head">Dhiviya Book Store</h1>
<h4 class="sub">Registration Form</h4>
<div class="form"></div>
  <div class="text">
<form:form action="registrationprocess"  modelAttribute="user">
 Enter Name:<form:input path="name"  /><br><br>
 Enter email:<form:input path="email" type="email"/><br><br> 
 Enter Age:<form:input path="age" type="number"/><br><br>
 Enter City:<form:input path="city"  /><br><br>
 Phone number:<form:input path="phoneNo" type="number" /><br><br>
 Set password:<form:input path="passWord" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" type="password" /><br><br>

 <input type = "submit" value ="submit">
</form:form>  
  </div>
<%--   <form:errors path="fName" cssClass="error"/><br><br>   --%>
<%-- <form:errors path="lName" cssClass="error"/><br><br> --%>
<%-- <form:errors path="uName" cssClass="error"/><br><br> --%>
<%-- <form:errors path="age" cssClass="error"/><br><br> --%>
<%-- <form:errors path="phoneNo" cssClass="error"/><br><br> --%>
<%-- <form:errors path="pWord" cssClass="error"/><br><br> --%>
  <div class="reg">
 <form action="login">
    <button type="submit">Back to login</button>
</form>
 <form action="main" >
    <button type="submit">Back to Home</button>    
</form>
</div>
</body>
</html>