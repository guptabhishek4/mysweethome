package com.project.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.project.connection.MyConnectionDetail;
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String n = request.getParameter("name");
		ResultSet rs;
		MyConnectionDetail mcd = new MyConnectionDetail();

		if (n.equals("buyer")) {
			String query = "select * from BUYERLOGIN";
			Connection con;
			try {
				con = mcd.getConnetion();
				PreparedStatement pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				pw.println(
						"<html><head><link rel='stylesheet' type='text/css' href='table.css'> </head><body><nav>");
				pw.println("<ul><li><a href='Admin.jsp'>Home</a></li>");
				pw.println("<li><a href='Admin?name=buyer'>View Buyer</a></li>");
				pw.println("<li><a href='Admin?name=seller'>View Seller</a></li>");
				pw.println("<li><a href='report.jsp'>Report</a></li>");
				pw.println("<li><a href='Logout'>Logout</a></li>");
				pw.println("</ul></nav>");
				pw.println("<div class='tbl-header'><table class='box2' align='center'>");
				pw.println("<h2>Buyer Details</h2>");
				pw.println("<form action=\"DeleteBuyer\" method=\"post\"><table border=2 style='width:100%'>" + " <tr>" + "<th></th><th>Name</th>" + "<th>User Name</th>"
						+ "<th>Password</th>" + "<th>Mobile Number</th>" + "<th>Email Id</th>" + "</tr>");
				while (rs.next()) {
					pw.println("<tr>" +"<td><input type=\"checkbox\" name=\"buy\" value=\""+rs.getString(2)+"\"></td>"+ "<td> " + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>"
							+ "<td>" + rs.getString(3) + 
							"</td>" + "<td>" + rs.getLong(4) + "</td>" + "<td>"
							+ rs.getString(5) + "</td>" + "</tr>");

				}
				
				pw.println("</table><br><br><input type='submit' value='Delete' style='width:100px;margin:0 50%;position:relative;left:-50px;background-color:LimeGreen;'></form></div>");
				pw.println("</body></html>");
				con.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (n.equals("seller")) {

			String query1 = "select * from SELLERLOGIN";
			Connection con;
			try {
				con = mcd.getConnetion();
				PreparedStatement pstmt = con.prepareStatement(query1);
				rs = pstmt.executeQuery();

				pw.println(
						"<html><head><link rel='stylesheet' type='text/css' href='table.css'> </head><body><nav>");
				pw.println("<ul><li><a href='Admin.jsp'>Home</a></li>");
				pw.println("<li><a href='Admin?name=buyer'>View Buyer</a></li>");
				pw.println("<li><a href='Admin?name=seller'>View Seller</a></li>");
				pw.println("<li><a href='report.jsp'>Report</a></li>");
				pw.println("<li><a href='Logout'>Logout</a></li>");
				pw.println("</ul></nav>");
				pw.println("<div class='tbl-header'><table class='box2' align='center'>");
				pw.println("<h2>Seller Details</h2>");
				pw.println("<form action=\"DeleteSeller\" method=\"post\"><table border=2 style='width:100%'>" + " <tr>" + "<th></th><th>Name</th>" + "<th>User Name</th>"
						+ "<th>Password</th>" + "<th>Mobile Number</th>" + "<th>Email Id</th>" + "</tr>");
				while (rs.next()) {

					pw.println("<tr>" +"<td><input type=\"checkbox\" name=\"sell\" value=\""+rs.getString(2)+"\"></td>"+ "<td> " + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>"
							+ "<td>" + rs.getString(3) + "</td>" + "<td>" + rs.getLong(4) + "</td>" + "<td>"
							+ rs.getString(5) + "</td>" + "</tr>");

				}
				pw.println("</table><br><br><b><input type='submit' value='Delete' style='width:100px;margin:0 50%;position:relative;left:-50px;background-color:LimeGreen;'></b></form></div>");
				pw.println("</body></html>");
				con.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (n.equals("transaction")) {
			Connection con;
				String query="select * from BOOKINGINFO ";
			
			try
			{	
				PreparedStatement pstmt;
				con=mcd.getConnetion();
				pstmt=con.prepareStatement(query);
				rs=pstmt.executeQuery();
				pw.println("<html><head><link rel='stylesheet' type='text/css' href='table.css'> </head><body><nav>");
				pw.println("<ul><li><a href='Admin.jsp'>Home</a></li>");
				pw.println("<li><a href='Admin?name=buyer'>View Buyer</a></li>");
				pw.println("<li><a href='Admin?name=seller'>View Seller</a></li>");
				pw.println("<li><a href='report.jsp'>Report</a></li>");
				pw.println("<li><a href='Logout'>Logout</a></li>");
				pw.println("</ul></nav>");
				
				pw.println("<div class='tbl-header'><table border=3 class='box' align='center'>");
				
				pw.println("<tr>");
				pw.println("<th>Booking_Id</th>");
				pw.println("<th>Type</th>");
				pw.println("<th>Buyer username</th>");
				pw.println("<th>Amount Paid</th>");
				pw.println("<th>Payment Mode</th>");
				pw.println("<th>Advertisment Id</th>");
				pw.println("<th>Seller Username</th>");
				pw.println("</tr>");
				
				while (rs.next()) 
				{
					pw.println("<tr>");
					pw.println("<td>"+rs.getInt(1) +"</td>");
					pw.println("<td>"+rs.getString(2) +"</td>");
					pw.println("<td>"+rs.getString(3) +"</td>");
					pw.println("<td>"+rs.getInt(4) +"</td>");
					pw.println("<td>"+rs.getString(5) +"</td>");
					pw.println("<td>"+rs.getInt(6) +"</td>");
					pw.println("<td>"+rs.getString(7) +"</td>");
					pw.println("</tr>");
					
				}
				
				pw.println("</table></div>");
				pw.println("</body></html>");
				con.close();
			}catch (Exception e) {e.printStackTrace();}
		}


	}																														
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
