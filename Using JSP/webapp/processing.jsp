<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="fn" scope="request" value="${fname}"/> 
<c:set var="ln" scope="request" value="${lname}"/> 
<c:set var="un" scope="request" value="${uname}"/> 
<c:set var="dt" scope="request" value="${dob}"/> 
<c:set var="ph" scope="request" value="${phone}"/> 
<c:set var="pw" scope="request" value="${pword}"/> 
<%
String fn =request.getParameter("fname");
String ln=request.getParameter("lname");
String un=request.getParameter("uname");
String dt=request.getParameter("dob");
String ph=request.getParameter("phone");
String pw=request.getParameter("pword");
session.setAttribute("firstname",fn);
session.setAttribute("lastname",ln);
session.setAttribute("username",un);
session.setAttribute("dob",dt);
session.setAttribute("phoneno",ph);
session.setAttribute("password",pw);
%>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/poc" user="root" password="Vdb@1997"/>
<sql:update dataSource="${db}" var="entry">
INSERT INTO hotelreg VALUES (?,?,?,?,?,?);
            <sql:param value= "${firstname}"/>
            <sql:param value= "${lastname}"/>
            <sql:param value="${username}"/>
            <sql:param value="${password}"/>
            <sql:param value="${dob}"/>
            <sql:param value= "${phoneno}"/>
</sql:update>
<c:out value="Data successfully updated"></c:out>
<jsp:forward page="login.jsp"></jsp:forward>

</body>
</html>