<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='report.css'>
</head>
<body>
	<nav>
	<ul>
		<li><a href='Admin.jsp'>Home</a></li>
		<li><a href='Admin?name=buyer'>View Buyer</a></li>
		<li><a href='Admin?name=seller'>View Seller</a></li>
		<li><a href='report.jsp'>Report</a></li>

		<li><a href='Logout'>Logout</a></li>
	</ul>
	</nav>
</head>
<title>Report</title>

<body>
	<div class="formPart">
		<form action="Report">

			<select name="report">
			<option value="null">Select</option>
				<option value="buyer1">Buyer</option>
				<option value="seller1">Seller</option>

			</select> <select name="date1">
			<option value="null">Select</option>
				<option value="weekly">Weekly</option>
				<option value="monthly">Monthly</option>

			</select> <input type="text" placeholder="Enter the number of period" name="no"><br>

			<button type="submit" class="registerbtn">Search</button>

		</form>
	</div>
</body>

</html>