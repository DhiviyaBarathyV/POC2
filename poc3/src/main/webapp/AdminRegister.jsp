<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/registers.css" rel="stylesheet" type="text/css">
<title>Admin Registration</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel Welcomes you!!!</h1>
<h4 class="sub">Admin Registration Form</h4>
<div class="form"></div>
  <div class="text">
<form  action="AdminRegServlet" method="post">
 Enter you FirstName:<input type="text" name=fname min="5" required><br><br>
 Enter you LastName:<input type="text" name=lname min="5" required><br><br>
 Set a user Name:<input type="text" name=uname min="5" required><br><br>
 Enter DOJ:<input type="date" name=dob placeholder="dd-mm-yyyy" value=""  min="1900-01-01" max="2050-12-31" required><br><br>
 Phone number:<input type="number" name=phone  min="10" required><br><br>
 Set password:<input type="password" name=pword pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br><br>
 Confirm password:<input type="password" name=cpword required><br><br>
  <input type = "submit">
  </form>
  
  </div>
  <div class="reg">
 <form action="AdminLogin.jsp">
    <button type="submit">Back to login</button>
</form>
 <form action="main.jsp" >
    <button type="submit">Back to Home</button>
    </form>
    </div>
</body>
</html>