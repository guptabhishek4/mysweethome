<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><link rel="stylesheet" href="buyer.css"></head>
<body>

<div class="formPart">
<form action="BuyerBooking" id="usrform" method="get">
  <div class="container">
 <h1>Booking Details</h1>
    <hr>
 <label for="price"><b>Enter the initial amount to be made:</b></label>
<input type="number" placeholder="Amount" name="amnt" required>
<br> <label for="payment"><b>Payment Mode</b></label><br>
				<select name="pmode">
					<option value="Cash">Cash</option>
					<option value="Loan">Loan</option>
					<option value="Cheque">Cheque</option>
				</select><br> <br> 
    <button type="submit" class="registerbtn">Book</button>
</div>
</form>
</div>
</body>
</html>