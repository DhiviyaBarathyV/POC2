<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/elitehotel/resources/css/welcomes.css">
<title>Welcome to Dhiviya Elite Hotel</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">Welcome ${uname} </h4>
<h4 class="sub">Available Rooms</h4>

<table  border="2"  width="100%" modelAttribute="availableroom">  
<tr>  
<th>Room No</th>  
<th>Room Type</th>  
<th>Room Capacity</th>   
</tr>  
<c:forEach var="t" items="${availableroom}">  
<tr>  
<td><c:out value="${t.roomno}"/></td>  
<td><c:out value="${t.roomtype}"/></td>  
<td><c:out value="${t.capacity}"/></td>   
</tr>  
</c:forEach>  
</table>
 <div class="reg">
 <form action="bookingpage">
    <button type="submit">Book your slot</button>
</form>
<form action="YourRoom">
    <button type="submit">Your Booking</button>
</form>
 <form action="login" method="get">
    <button type="submit">Log Out</button>
</form>
</div>
</body>
</html>