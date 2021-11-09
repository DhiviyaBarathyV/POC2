<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
<form:form modelAttribute="availableroom" >
<table  border="2"  width="100%" > 
<tr>  
<th>Room No</th>  
<th>Room Type</th>  
<th>Room Capacity</th>   
</tr>  
<c:forEach var="ta" items="${availableroom}">  
<tr>  
<td><c:out value="${ta.roomno}"/></td>  
<td><c:out value="${ta.roomtype}"/></td>  
<td><c:out value="${ta.capacity}"/></td>    
</tr>  
</c:forEach>  
</table>
</form:form>
<h4 class="sub">Booked Rooms</h4>

<form:form modelAttribute="broom" >
<table  border="2"  width="100%">  
<tr>  
<th>Room No</th>  
<th>Booked By</th>   
<th>Room type</th>
<th>From</th>
<th>To</th>
</tr>  
<c:forEach var="tab" items="${broom}">  
<tr>  
<td><c:out value="${tab.roomno}"/></td>  
<td><c:out value="${tab.name}"/></td> 
<td><c:out value="${tab.roomtype}"/></td>  
<td><c:out value="${tab.fdate}"/></td>
<td><c:out value="${tab.tdate}"/></td>  
   
</tr>  
</c:forEach>  
</table>
</form:form>
 <div class="reg">

<form action="login">
    <button type="submit">Log Out</button>
</form>
</div>
</body>
</html>