<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href=https://fonts.googleapis,com/css?family=Montserrat:400,800" rel="stylesheet">
<link rel="stylesheet" href="sellerfirst.css">

</head>
<body>
<div class="header">
<div class="inner_header">
<div class="logo_header">
<a href="Admin.jsp"><h1>Home<span>Sweet</span></h1></a>
</div>
<ul class="navigation">
<b><a href="Admin.jsp"><li>Home</li></a></b>
<b><a href="Admin?name=buyer"><li>View Buyer</li></a></b>
<b><a href="Admin?name=seller"><li>View Seller</li></a></b>
<b><a href="report.jsp"><li>Report</li></a></b>
<b><a href="Admin?name=transaction"><li>Transaction</li></a></b>
<b><a href="Logout"><li>Logout</li></a></b>
</ul>
</div>
<h2>WELCOME, Admin
<%
out.println(session.getAttribute("uname"));
%></h2>
</div>
</body>
</html>