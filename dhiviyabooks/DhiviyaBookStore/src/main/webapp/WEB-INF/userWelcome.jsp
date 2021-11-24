<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/welcome.css" rel="stylesheet"/>
<title>User</title>
</head>
<body>
<h1 class="head">Dhiviya Book store</h1>
<h4 class="sub">Welcome ${login.userName} </h4>
<h4 class="sub">Available Books</h4>

<div class="search">
 <form:form action="searchUser" method="get" modelAttribute="search">
    <form:input path="value" placeholder="Search.."/>
    <button type="submit">Search</button>
</form:form>
</div>
<br><br>
<form:form modelAttribute="allBooks" >
<table  border="2"  width="100%" > 
<tr>  
<th>Book Id</th>  
<th><a href="sortBookname">L</a> Book Name <a href="sortBooknamedesc">H</a></th>  
<th>Category</th> 
<th>Author</th> 
<th> <a href="sortPrice">L</a> Price <a href="sortPriceDES">H</a></th> 
<th>Delete Book</th> 
</tr>  
<c:forEach var="ta" items="${allBooks}">  
<tr>  
<td><c:out value="${ta.bookId}"/> </td> 
<td><c:out value="${ta.bookName}"/></td>  
<td><c:out value="${ta.category}"/></td>  
<td><c:out value="${ta.author}"/></td>  
<td><c:out value="${ta.price}"/></td>    
<td><a href="buyBook/${ta.bookId}/${ta.bookName}" > buy </a></td> 
</tr>  
</c:forEach>  
</table>
</form:form>

 <div class="reg">
 <form action="mybooks" method="get">
    <button type="submit">My Books</button>
</form>
 <form action="login" method="get">
    <button type="submit">Log Out</button>
</form>
</div>

</body>
</html>