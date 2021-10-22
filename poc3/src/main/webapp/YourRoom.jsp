<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/welcomes.css" rel="stylesheet" type="text/css">
<title>your Booked Room</title>
</head>
<%
String name=(String)session.getAttribute("username");
%>
<body>
<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">Welcome <%=name %> </h4>
<h4 class="sub">your Booked Room</h4>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/poc" user="root" password="Vdb@1997"/>
<sql:query var="rs" dataSource="${db}">
Select * from bookedrooms where username=?;
<sql:param value="<%=name %>"></sql:param>
</sql:query>
<c:forEach var="t" items="${rs.rows}"> 

<div class= "boxer">
 <h3 > Name: ${t.username}</h3>
 <h3 >Room No: ${t.roomno}</h3> 
 <h3 >Room Type: ${t.toomtype}</h3>
 <h3 >Room Capacity: ${t.capacity}</h3>
 <h3 >Booked From: ${t.frdate}</h3>
 <h3 >Booked To: ${t.todate}</h3> 
 <h3 > PhoneNo: ${t.phone}</h3>
 </div>
 
 </c:forEach>
 <div class="reg">
 <form action="welcome.jsp">
    <button type="submit">Click for more Bookings</button>
</form>
 <form action="login.jsp" method="post">
    <button type="submit">Log Out</button>
</form>
</div>
</body>
</html>