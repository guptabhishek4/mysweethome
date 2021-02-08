package com.project.seller.status;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.connection.MyConnectionDetail;

public class SellerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SellerInfo() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		MyConnectionDetail mcd = new MyConnectionDetail();
		Connection con;
		HttpSession session = request.getSession();
		String uid = (String) session.getAttribute("uname");
		
		
		String query3 = "select * from sellerselling where userid=?";
		try {
			con = mcd.getConnetion();
			PreparedStatement ps3 = con.prepareStatement(query3);
			ps3.setString(1, uid);
			
			ResultSet rs3 = ps3.executeQuery();
			pw.println("<html><head><link rel='stylesheet' type='text/css' href='statustable.css'> </head><body><nav>");
			pw.println("<ul><li><a href='sellerfirst.jsp'>Home</a></li>");
			pw.println("<li><a href='Seller_sell.html'>Sell</a></li>");
			pw.println("<li><a href='Seller_rent.html'>Rent</a></li>");
			pw.println("<li><a href='Seller_pg.html'>PG</a></li>");
			pw.println("<li><a href='Logout'>Logout</a></li>");
			pw.println("</ul></nav>");
			
			pw.println("<div class='tbl-header'><table class='box2' align='center'>");
			
				pw.println("<table align='center' border=3><tr>");
				pw.println("<th>House_no</th>");
				pw.println("<th>Location</th>");
				pw.println("<th>City</th>");
				pw.println("<th>Bedroom</th>");
				pw.println("<th>Bathroom</th>");
				pw.println("<th>Type</th>");
				pw.println("<th>Extra Facility</th>");
				pw.println("<th>Image</th>");
				pw.println("<th>Price</th>");
				pw.println("<th>Payment_mode</th>");
				pw.println("<th>SquareFoot</th>");
				pw.println("<th>Posted On</th>");
				pw.println("</tr");

				while (rs3.next()) {
					pw.println("<tr>");
					pw.println("<td>" + rs3.getString(1) + "</td>");
					pw.println("<td>" + rs3.getString(3) + "</td>");
					pw.println("<td>" + rs3.getString(2) + "</td>");
					pw.println("<td>" + rs3.getInt(5) + "</td>");
					pw.println("<td>" + rs3.getInt(6) + "</td>");
					pw.println("<td>" + rs3.getString(7) + "</td>");
					pw.println("<td>" + rs3.getString(8) + "</td>");
					pw.println(
							"<td><img width='100' height='100' src=DisplayPhoto?id=" + rs3.getInt(12) + ">" + "</td>");
					pw.println("<td>" + rs3.getInt(4) + "</td>");
					pw.println("<td>" + rs3.getInt(11) + "</td>");
					pw.println("<td>" + rs3.getString(10) + "</td>");
					pw.println("<td>" + rs3.getTimestamp(14) + "</td>");
					pw.println("</tr>");
				}
				pw.println("</table><br><br><br></div></body></html>");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
