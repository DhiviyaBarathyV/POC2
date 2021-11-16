<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/welcome.css" rel="stylesheet"/>
<title>Bill</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">Welcome ${login.uname} </h4>
<h4 class="sub">Your Bill</h4>
<form:form modelAttribute="bill" >
<table  border="2"  width="100%" >  
<tr>  
<th>Name</th>  
<th>From</th>  
<th>To</th> 
<th>Days</th> 
<th>Amount</th>  
</tr>  
<c:forEach var="t" items="${bill}">  
<tr>  
<td><c:out value="${t.name}"/></td>  
<td><c:out value="${t.fdate}"/></td>  
<td><c:out value="${t.tdate}"/></td>   
<td><c:out value="${t.noOfDays}"/></td>  
<td><c:out value="Rs.${t.amount}"/></td>  
</tr>  
</c:forEach>  
</table>
</form:form>
<div class="reg">
  <form action="backtowelcome" method="get">
    <button type="submit">back</button>
</form>
</div>
</body>
</html>