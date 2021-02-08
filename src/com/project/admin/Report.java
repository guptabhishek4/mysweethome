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

public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String bs = request.getParameter("report");
		String dt = request.getParameter("date1");
		int number = Integer.parseInt(request.getParameter("no"));
		ResultSet rs;
		MyConnectionDetail mcd = new MyConnectionDetail();
		String query = null;
		if (bs.equals("buyer1")) {
			if (dt.equals("weekly")) {
				query = "select * from BOOKINGINFO where bOOKED_ON >= ((sysdate-7*?))";
				Connection con;
				try {
					con = mcd.getConnetion();
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, number);
					rs = pstmt.executeQuery();
					pw.println(
							"<html><head><link rel='stylesheet' type='text/css' href='report.css'> </head><body><nav>");
					pw.println("<ul><li><a href='Admin.jsp'>Home</a></li>");
					pw.println("<li><a href='Admin?name=buyer'>View Buyer</a></li>");
					pw.println("<li><a href='Admin?name=seller'>View Seller</a></li>");
					pw.println("<li><a href='report.jsp'>Report</a></li>");
					pw.println("<li><a href='Logout'>Logout</a></li>");
					pw.println("</ul></nav>");
					pw.println("<div class='tbl-header'><table class='box2' align='center'>");
					pw.println("<h2 align='center'> Buyer Booking on " + number + " Week basis</h2>");
					pw.println("<table border=2 style='width:100%'>" + " <tr>" + "<th>Booking Id</th>" + "<th>Type</th>"
							+ "<th>UserId</th>" + "<th>Initial Amount</th>" + "<th>Booking Date</th>"
							+ "<th>Addvertisement_id</th>" + "<th>SellerId</th>" + "</tr>");
					while (rs.next()) {

						pw.println("<tr>" + "<td> " + rs.getInt(1) + "</td>" + "<td>" + rs.getString(2) + "</td>"
								+ "<td>" + rs.getString(3) + "</td>" + "<td>" + rs.getInt(4) + "</td>" + "<td>"
								+ rs.getTimestamp(8) + "</td>" + "<td>" + rs.getInt(6) + "</td>" + "<td>"
								+ rs.getString(7) + "</td>" + "</tr>");
					}

					pw.println("</table></div>");
					pw.println("</body></html>");
					con.close();

				}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (dt.equals("monthly")) {
				query = "select * from BOOKINGINFO where BOOKED_ON  >= ((sysdate-30*?))";
				Connection con;
				try {
					con = mcd.getConnetion();
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, number);
					rs = pstmt.executeQuery();
					pw.println(
							"<html><head><link rel='stylesheet' type='text/css' href='report.css'> </head><body><nav>");
					pw.println("<ul><li><a href='Admin.jsp'>Home</a></li>");
					pw.println("<li><a href='Admin?name=buyer'>View Buyer</a></li>");
					pw.println("<li><a href='Admin?name=seller'>View Seller</a></li>");
					pw.println("<li><a href='report.jsp'>Report</a></li>");
					pw.println("<li><a href='Logout'>Logout</a></li>");
					pw.println("</ul></nav>");
					pw.println("<div class='tbl-header'><table class='box2' align='center'>");
					pw.println("<h2>Buyer Booking on " + number + " Month basis</h2>");
					pw.println("<table border=2 style='width:100%'>" + " <tr>" + "<th>User Id</th>" + "<th>Name</th>"
							+ "<th>Booking Id</th>" + "<th>Contact Number</th>" + "<th>Booking Date</th>"
							+ "<th>Addvertisement_id</th>" + "SellerName" + "</tr>");
					while (rs.next()) {

						pw.println("<tr>" + "<td> " + rs.getInt(1) + "</td>" + "<td>" + rs.getString(2) + "</td>"
								+ "<td>" + rs.getString(3) + "</td>" + "<td>" + rs.getInt(4) + "</td>" + "<td>"
								+ rs.getTimestamp(8) + "</td>" + "<td>" + rs.getInt(6) + "</td>" + "<td>"
								+ rs.getString(7) + "</td>" + "</tr>");
					}
					pw.println("</table></div>");
					pw.println("</body></html>");
					con.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else if (bs.equals("seller1")) {
			if (dt.equals("weekly")) {

				Connection con;
				try {
					con = mcd.getConnetion();
					query = "select * from SELLERSELLING where POSTED_ON  >= ((sysdate-7*?))";

					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, number);
					rs = pstmt.executeQuery();
					pw.println(
							"<html><head><link rel='stylesheet' type='text/css' href='report.css'> </head><body><nav>");
					pw.println("<ul><li><a href='Admin.jsp'>Home</a></li>");
					pw.println("<li><a href='Admin?name=buyer'>View Buyer</a></li>");
					pw.println("<li><a href='Admin?name=seller'>View Seller</a></li>");
					pw.println("<li><a href='report.jsp'>Report</a></li>");
					pw.println("<li><a href='Logout'>Logout</a></li>");
					pw.println("</ul></nav>");
					pw.println("<div class='tbl-header'><table class='box2' align='center'>");
					pw.println("<h2>Seller Post on " + number + " Week basis</h2>");

					pw.println("<table border=2 style='width:100%'>" + " <tr>" + "<th>House No</th>" + "<th>City</th>"
							+ "<th>Location</th>" + "<th>Price</th>" + "<th>Type</th>" + "<th>Payment Mode</th>"
							+ "<th>ADD_ID</th>" + "<th>SellerID</th>" + "<th>Booking Date</th>" + "</tr>");
					while (rs.next()) {

						pw.println("<tr>" + "<td> " + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>"
								+ "<td>" + rs.getString(3) + "</td>" + "<td>" + rs.getInt(4) + "</td>" + "<td>"
								+ rs.getString(7) + "</td>" + "<td>" + rs.getString(10) + "</td>" + "<td>"
								+ rs.getInt(12) + "</td><td>" + rs.getString(13) + "</td>" + "<td>"
								+ rs.getTimestamp(14) + "</td>" + "</tr>");

					}

					pw.println("</table></div>");
					pw.println("</body></html>");
					con.close();
				}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (dt.equals("monthly")) {

				Connection con;

				try {
					con = mcd.getConnetion();
					query = "select * from SELLERSELLING where POSTED_ON  >= ((sysdate-30*?))";

					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setInt(1, number);
					rs = pstmt.executeQuery();
					pw.println(
							"<html><head><link rel='stylesheet' type='text/css' href='report.css'> </head><body><nav>");
					pw.println("<ul><li><a href='Admin.jsp'>Home</a></li>");
					pw.println("<li><a href='Admin?name=buyer'>View Buyer</a></li>");
					pw.println("<li><a href='Admin?name=seller'>View Seller</a></li>");
					pw.println("<li><a href='report.jsp'>Report</a></li>");
					pw.println("<li><a href='Logout'>Logout</a></li>");
					pw.println("</ul></nav>");
					pw.println("<div class='tbl-header'><table class='box2' align='center'>");
					pw.println("<h2>Seller Post on " + number + " Month basis</h2>");

					pw.println("<table border=2 style='width:100%'>" + " <tr>" + "<th>House No</th>" + "<th>City</th>"
							+ "<th>Location</th>" + "<th>Price</th>" + "<th>Type</th>" + "<th>Payment Mode</th>"
							+ "<th>ADD_ID</th>" + "<th>SellerID</th>" + "<th>Booking Date</th>" + "</tr>");
					while (rs.next()) {

						pw.println("<tr>" + "<td> " + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>"
								+ "<td>" + rs.getString(3) + "</td>" + "<td>" + rs.getInt(4) + "</td>" + "<td>"
								+ rs.getString(7) + "</td>" + "<td>" + rs.getString(10) + "</td>" + "<td>"
								+ rs.getInt(12) + "</td><td>" + rs.getString(13) + "</td>" + "<td>"
								+ rs.getTimestamp(14) + "</td>" + "</tr>");

					}
					pw.println("</table></div>");
					pw.println("</body></html>");
					con.close();
				}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
