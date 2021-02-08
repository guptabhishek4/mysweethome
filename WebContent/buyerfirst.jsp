<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link href=https://fonts.googleapis,com/css?family=Montserrat:400,800" rel="stylesheet">
<link rel="stylesheet" href="sellerfirst.css">

</head>
<body>
<div class="header">
<div class="inner_header">
<div class="logo_header">
<a href="buyerfirst.jsp"><h1>Home<span>Sweet</span></h1></a>
</div>
<ul class="navigation">
<b><a href="buyerfirst.jsp"><li>Home</li></a></b>
<b><a href="buyerbuysearch.html"><li>Buy</li></a></b>
<b><a href="buyerrentsearch.html"><li>Rent</li></a></b>
<b><a href="buyerpgsearch.html"><li>P.G</li></a></b>
<b><a href="BuyerHistory"><li>Booking History</li></a></b>
<b><a href="Logout"><li>Logout</li></a></b>
</ul>
</div>
<h2>Hello, 
<%
out.println(session.getAttribute("uname"));
%>
Search and buy Your Property Here.......</h2>
</div>
</body>
</html>