package com.project.buyer.buy;

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

public class BuyerHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BuyerHistory() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		MyConnectionDetail mcd = new MyConnectionDetail();
		
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		String query="select * from BOOKINGINFO where USERNAME=?";
		
		try
		{
			HttpSession session=request.getSession();
			String uname=(String) session.getAttribute("uname");
			
			con=mcd.getConnetion();
			
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, uname);
			
			
			rs=pstmt.executeQuery();
			
			pw.println("<html><head><link rel='stylesheet' type='text/css' href='table.css'> </head><body><nav>");
			pw.println("<ul><li><a href='buyerfirst.jsp'>Home</a></li>");
			pw.println("<li><a href='buyerbuysearch.html'>Buy</a></li>");
			pw.println("<li><a href='buyerrentsearch.html'>Rent</a></li>");
			pw.println("<li><a href='buyerpgsearch.html'>PG</a></li>");
			pw.println("<li><a href='Logout'>Logout</a></li>");
			pw.println("</ul></nav>");
			
			pw.println("<div class='tbl-header'><table border=3 class='box' align='center'>");
			
			pw.println("<tr>");
			pw.println("<th>Booking_Id</th>");
			pw.println("<th>Type</th>");
			pw.println("<th>Buyer username</th>");
			pw.println("<th>Price</th>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
