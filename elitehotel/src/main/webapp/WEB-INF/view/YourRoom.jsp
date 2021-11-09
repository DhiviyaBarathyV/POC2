<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/elitehotel/resources/css/welcomes.css">
<title>your Booked Room</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">Welcome ${uname} </h4>
<h4 class="sub">your Booked Room</h4>
<form:form modelAttribute="brooms">
<c:forEach var="t" items="${brooms}"> 
 <hr>
<div class= "boxer">
 <h3 > Name: ${t.username}</h3>
 <h3 >Room No: ${t.roomno}</h3> 
 <h3 >Room Type: ${t.roomtype}</h3>
 <h3 >Room Capacity: ${t.capacity}</h3>
 <h3 >Booked From: ${t.fdate}</h3>
 <h3 >Booked To: ${t.tdate}</h3> 
 </div>

 </c:forEach>
 </form:form>
 <hr>
 <div class="reg">
  <form action="backtowelcome" method="get">
    <button type="submit">back</button>
</form>
<form action="bill" method="get">
    <button type="submit">View bill</button>
</form>
 <form action="login" method="get">
    <button type="submit">Log Out</button>
</form>
</div>
</body>
</html>