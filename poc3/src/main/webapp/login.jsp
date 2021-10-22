
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <link href="css/logins.css" rel="stylesheet" type="text/css">
    <title>Dhiviya Elite Hotel</title>
</head>
<body>

<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">LogIn Form</h4>
<div class="form"></div>
  <div class="text">
  <form action="LoginServlet" method="post" style="position: absolute;">
  User Name:<input type="text" name=uname  required><br><br>
  Password:   <input type="password" name=pword  required><br><br>
  <input type = "submit">
  </form>
  </div>
<div class="reg">
 <h4>If you are new to our Hotel Please Register here</h4>
 <form action="AdminLogin.jsp" method="post">
    <button type="submit">Admin Login</button>
</form>
 <form action="register.jsp">
    <button type="submit">Click to Register</button>
</form>
 <form action="main.jsp" method="post">
    <button type="submit">Back to Home</button>
</form>


</div>
</body> 
</html>