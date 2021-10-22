<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/registers.css" rel="stylesheet" type="text/css">
<title>Book Your Slot</title>
</head>
<body>
<h1 class="head">Dhiviya Elite Hotel Welcomes you!!!  </h1>
<h1 class="head">Have a wonderful Experience.</h1>
<h4 class="sub">Booking Form</h4>
<div class="form"></div>
  <div class="text">
<form  action="BookingConfirmServlet" method="post">
 Enter you user Name:<input type="text" name=uname min="5" required><br><br>
 Select Room No:<select name=roomno required>
  <option value="">--Room No--</option>
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
			<option value="04">4</option>
			<option value="05">5</option>
			<option value="06">6</option>
			<option value="07">7</option>
			<option value="08">8</option>
			<option value="09">9</option>
			<option value="10">10</option>
			</select><br><br>
Select Room Type:<select name=type required>
  <option value="">--Room type--</option>
			<option value="Dulex">Dulex</option>
			<option value="Ultra">Ultra</option>
			</select><br><br>
Select capacity:<select name=capacity required>
  <option value="">--capacity--</option>
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
			<option value="04">4</option>
			<option value="05">5</option>
			</select><br><br>
Booking date From:<input type="date" name=fdate placeholder="dd-mm-yyyy" value=""  min="1900-01-01" max="2050-12-31" required><br><br>
Booking date To:<input type="date" name=tdate placeholder="dd-mm-yyyy" value=""  min="1900-01-01" max="2050-12-31" required><br><br>
 Phone number:<input type="number" name=phone  min="10" required><br><br>
  <input type = "submit">
  </form>
  
  </div>
</body>


</body>
</html>
