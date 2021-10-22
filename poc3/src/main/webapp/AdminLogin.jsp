<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="css/logins.css" rel="stylesheet" type="text/css">
<title>AdminLogin</title>
</head>
<body>

<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">Admin LogIn Form</h4>
<div class="form"></div>
  <div class="text">
  <form action="AdminLoginServlet" method="post" style="position: absolute;">
  User Name:<input type="text" name=uname  required><br><br>
  Password:   <input type="password" name=pword  required><br><br>
  <input type = "submit">
  </form>
  </div>
<div class="reg">
 <h4>If you are new employee to this Hotel Please Register here</h4>
 <form action="AdminRegister.jsp">
    <button type="submit">Click to Register</button>
</form>
 <form action="main.jsp" method="post">
    <button type="submit">Back to Home</button>
</form>


</div>
</body>
</html>