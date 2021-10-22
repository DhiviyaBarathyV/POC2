<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/welcomes.css" rel="stylesheet" type="text/css">
<title>Welcome to Dhiviya Elite Hotel</title>
</head>
<%
String name=(String)session.getAttribute("username");
%>
<body>
<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">Welcome <%=name %> </h4>
<h4 class="sub">Available Rooms</h4>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/poc" user="root" password="Vdb@1997"/>
<sql:query var="rs" dataSource="${db}">
Select * from roomdetails;
</sql:query>
<table  border="2"  width="100%">  
<tr>  
<th>Room No</th>  
<th>Room Type</th>  
<th>Room Capacity</th>   
</tr>  
<c:forEach var="t" items="${rs.rows}">  
<tr>  
<td><c:out value="${t.RoomNo}"/></td>  
<td><c:out value="${t.RoomType}"/></td>  
<td><c:out value="${t.capacity}"/></td>   
</tr>  
</c:forEach>  
</table>
 <div class="reg">
 <form action="BookingSlot.jsp">
    <button type="submit">Book your slot</button>
</form>
<form action="YourRoom.jsp">
    <button type="submit">Your Booking</button>
</form>
 <form action="login.jsp" method="post">
    <button type="submit">Log Out</button>
</form>
</div>
</body>
</html>