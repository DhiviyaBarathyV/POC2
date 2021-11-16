<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/register.css" rel="stylesheet"/>
<title>BookNow</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel Welcomes you!!!</h1>
<h4 class="sub">Booking Form</h4>
<div class="form"></div>
  <div class="text">
  <form:form action="bookingprocess" modelAttribute="book">
 Enter you User Name:<form:input path="username"  /><br><br>
 Room Number:<form:input path="roomno" type="number"/><br><br> 
 Book From:<form:input path="fdate" placeholder="dd-mm-yyyy" value=""  min="1900-01-01" max="2050-12-31" type="date" /><br><br>
 Book To:<form:input path="tdate" placeholder="dd-mm-yyyy" value=""  min="1900-01-01" max="2050-12-31" type="date"/><br><br>
 Phone number:<form:input path="Phoneno" type="number" /><br><br>
 <input type = "submit" value ="submit">
</form:form>  
  </div>
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