<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="main_style.css">
</head>
<body>
	<section class="navigation">
	<div class="nav-container">
	<nav>

		<ul class="nav-list">
			<li><a href="./Admin.jsp">Home</a></li>
			<li><a href="sellerfirst.jsp">Sell</a></li>
			<li><a href="Seller_sell.html">Rent</a></li>
			<li><a href="Seller_rent.html">P.G.</a></li>
			<li style="float: right;"><a href="Logout">Logout</a></li>
			<li style="float: right;"><a href="./FAQ.jsp">FAQs</a></li>
			<li style="float: right;"><a href="#!">Status</a>
				<ul class="nav-dropdown">
					<li><a href="">Status for Sell</a></li>
					<li><a href="">Status for Rent</a></li>
					<li><a href="">Status for Sell</a></li>
				</ul></li>

		</ul>
		</nav>
	</div>
	</section>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>

	<script src="main_index.js"></script>
	<h1>
		Hello,
		<%
		out.println(session.getAttribute("uname"));
	%>
		Sell Your Property Here.......
	</h1>
</body>
</html>