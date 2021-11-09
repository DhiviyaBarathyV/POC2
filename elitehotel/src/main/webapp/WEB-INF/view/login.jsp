<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <link rel="stylesheet" type="text/css" href="/elitehotel/resources/css/logins.css">
    <title>Dhiviya Elite Hotel</title>
</head>
<body>

<h1 class="head">Dhiviya Elite Hotel</h1>
<h4 class="sub">LogIn Form</h4>
<div class="form"></div>
  <div class="text">
  <form:form action="Loginprocess" method="post" style="position: absolute;" modelAttribute="login">
  User Name:<input type="text" name=uname  required><br><br>
  Password:   <input type="password" name=pword  required><br><br>
  <input type = "submit">
  </form:form>
  </div>
<div class="reg">
 <h4>If you are new to our Hotel Please Register here</h4>
 <form action="register">
    <button type="submit">Click to Register</button>
</form>
 <form action="main" method="get">
    <button type="submit">Back to Home</button>
</form>


</div>
</body> 
</html>