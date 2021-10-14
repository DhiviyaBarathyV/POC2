<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
String usname= request.getParameter("uname");
String paword= request.getParameter("pword");
session.setAttribute("username", usname);
session.setAttribute("password", paword);
%>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/poc" user="root" password="Vdb@1997"/>
<sql:query var="rs" dataSource="${db}">
Select * from hotelreg;
</sql:query> 

<c:forEach var="r" items="${rs.rows}"> 
<c:if test="${(username==(r.Username))}">
  <c:if test ="${(password==(r.Password))}">
   <jsp:forward page="welcome.jsp"></jsp:forward>
  </c:if>
</c:if>
</c:forEach>
<jsp:forward page="login.jsp"></jsp:forward>
</head>
<body>

</body>
</html>