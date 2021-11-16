<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/welcome.css" rel="stylesheet"/>
<title>welcome</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">Welcome ${login.uname} </h4>
<h4 class="sub">Available Rooms</h4>
<form:form modelAttribute="available" >
<table  border="2"  width="100%" > 
<tr>  
<th>Room No</th>  
<th>Room Type</th>  
<th>Room Capacity</th>   
</tr>  
<c:forEach var="ta" items="${available}">  
<tr>  
<td><c:out value="${ta.roomNo}"/></td>  
<td><c:out value="${ta.type}"/></td>  
<td><c:out value="${ta.capacity}"/></td>    
</tr>  
</c:forEach>  
</table>
</form:form>


<h4 class="sub">Booked Rooms</h4>

<form:form modelAttribute="booked" >
<table  border="2"  width="100%">  
<tr>  
<th>Room No</th>  
<th>Name</th>   
<th>From</th>
<th>To</th>
</tr>  
<c:forEach var="tab" items="${booked}">  
<tr>  
<td><c:out value="${tab.roomno}"/></td>  
<td><c:out value="${tab.username}"/></td> 
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