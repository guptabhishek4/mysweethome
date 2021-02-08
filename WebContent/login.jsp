<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>MySweetHomeLogin.com</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body >

	<div class="login-box">
		<img src="avatar.png" class="avatar">
		<h1 >Login Here</h1>
		<form action="./LoginServlet" method="post">
			<p>Username</p>
			<input type="text" name="uname" placeholder="Enter Username">
			<p>Password</p>
			<input type="password" name="pass" placeholder="Enter Password">
			<p>Type</p>
			<select name="type">
			    <option value=""><---Choose---></option>
				<option value="Admin">Admin</option>
				<option value="Buyer">Buyer</option>
				<option value="Seller">Seller</option>
			</select>
		 <input type="submit" name="submit" value="Login"> <a
				href="abhi.html"><u>Register Here !!!</u></a>
		</form>


	</div>


</body>
</html>