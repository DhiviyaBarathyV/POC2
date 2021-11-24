<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/welcome.css" rel="stylesheet"/>
<title>My Books</title>
</head>
<body>
<h1 class="head">Dhiviya Book store</h1>
<h4 class="sub">Welcome ${login.userName} </h4>
<h4 class="sub">My Order</h4>
<form:form modelAttribute="details" >
<table  border="2"  width="100%" >  
<tr>  
<th>Name</th>  
<th>BookId</th>  
<th>BookName</th>  
<th>Amount</th>  
</tr>  
<c:forEach var="t" items="${details}">  
<tr>  
<td><c:out value="${t.name}"/></td>  
<td><c:out value="${t.bookId}"/></td>  
<td><c:out value="${t.bookName}"/></td>    
<td><c:out value="Rs.${t.amount}"/></td>  
</tr>  
</c:forEach>  
</table>
</form:form>
<div class="reg">
 <form action="backu" method="get">
    <button type="submit">Back</button>
</form>
</div>
</body>
</html>