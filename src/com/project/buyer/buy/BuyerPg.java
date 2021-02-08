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

import com.project.connection.MyConnectionDetail;

/**
 * Servlet implementation class BuyerPg
 */
public class BuyerPg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BuyerPg() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String location = request.getParameter("loc");
		String city = request.getParameter("city");
		String rent = request.getParameter("rent");
		String deposit = request.getParameter("deposit");
		
		
		if ( location.isEmpty() && city.isEmpty() && rent.isEmpty() && deposit.isEmpty())
		{
			pw.println("atleast one value should be entered");
		}
		
		
		
		MyConnectionDetail cd = new MyConnectionDetail();
		Connection con = null;
		PreparedStatement pstmt;
		ResultSet rs;
		
		String query="select * from sellerpg where  (lower(LOCATION)=? AND lower(CITY)=?) AND (RENT<=? AND DEPOSIT<=?)";
		
		try
		{
			con = cd.getConnetion();
			pstmt = con.prepareStatement(query);
			pstmt.setString(2, location);
			pstmt.setString(1, city);
			pstmt.setInt(4, Integer.parseInt(rent));
			pstmt.setInt(3,Integer.parseInt(deposit));
			rs = pstmt.executeQuery();
			pw.println("<link rel='stylesheet' href='stylepicpage.css'>");
			pw.println("<body bgcolor='pink'>");
			pw.println("<nav><ul><li><a href='buyerfirst.jsp'>Home</a></li><li><a href='buyerbuysearch.html'>Buy</a></li><li><a href='buyerrentsearch.html'>Rent</a></li><li><a href='buyerpgsearch.html'>P.G</a></li><li><a href='Logout'>Logout</a></li></ul></nav>");
			pw.println("<h1 style='text-align: center'>Results</h1>");
			pw.println("<div class='row'>");
			while (rs.next()) {
				pw.println("<div class='column'>");
				pw.println("<a href='bookpg?id="+rs.getInt(6)+"'><img width='300' height='300' src=DisplayPhoto3?id=" +  rs.getInt(6) + " style='width:100%'></a>");
				pw.println("<div class='desc'><h3>" + rs.getString(1)+" "+rs.getString(2) + "</h3></div></div>");
			}
			pw.println("</div></body></html>");

		}
		catch (Exception e) {e.printStackTrace();}
		
	}
	

}
