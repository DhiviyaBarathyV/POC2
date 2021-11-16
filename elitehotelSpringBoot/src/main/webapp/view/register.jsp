<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>  
.error{color:red;font:10px}  
</style> 
<meta charset="ISO-8859-1">
<link href="css/register.css" rel="stylesheet"/>
<title>Register</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel Welcomes you!!!</h1>
<h4 class="sub">Registration Form</h4>
<div class="form"></div>
  <div class="text">
<form:form action="registrationprocess"  modelAttribute="user">
 Enter you FirstName:<form:input path="fName"  /><br><br>
 Enter you LastName:<form:input path="lName" /><br><br> 
 Set a user Name:<form:input path="uName" min="5" /><br><br> 
 Enter Age:<form:input path="age" placeholder="above 18" type="number"/><br><br>
 Phone number:<form:input path="phoneNo" type="number" /><br><br>
 Set password:<form:input path="pWord" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" type="password" /><br><br>

 <input type = "submit" value ="submit">
</form:form>  
  </div>
  <form:errors path="fName" cssClass="error"/><br><br>  
<form:errors path="lName" cssClass="error"/><br><br>
<form:errors path="uName" cssClass="error"/><br><br>
<form:errors path="age" cssClass="error"/><br><br>
<form:errors path="phoneNo" cssClass="error"/><br><br>
<form:errors path="pWord" cssClass="error"/><br><br>
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