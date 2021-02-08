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

public class BuyerRent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BuyerRent() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String location = request.getParameter("loc");
		String city = request.getParameter("city");
		String bedroom = request.getParameter("nob");
		String bathroom = request.getParameter("nobath");
		String rent = request.getParameter("rent");
		String pmode=request.getParameter("type");
		String deposit = request.getParameter("deposit");

		if ( location.isEmpty() && city.isEmpty() && bedroom.isEmpty() && bathroom.isEmpty()
				&& rent.isEmpty() && deposit.isEmpty()) {
			pw.println("atleast one value should be entered");
		}
		
		MyConnectionDetail cd = new MyConnectionDetail();
		Connection con = null;
		PreparedStatement pstmt;
		ResultSet rs;

		String query = "select * from SELLERRENTAL where  (lower(LOCATION)=? AND lower(CITY)=?) AND (BEDROOM<=? AND BATHROOM<=?) AND (RENT<=? AND DEPOSIT<=?)";

		try {

			con = cd.getConnetion();

			pstmt = con.prepareStatement(query);

		
			pstmt.setString(1, location);
			pstmt.setString(2, city);
			pstmt.setInt(3, Integer.parseInt(bedroom));
			pstmt.setInt(4, Integer.parseInt(bathroom));
			pstmt.setInt(5, Integer.parseInt(rent));
			pstmt.setInt(6, Integer.parseInt(deposit));
			rs = pstmt.executeQuery();
			pw.println("<link rel='stylesheet' href='stylepicpage.css'>");
			pw.println("<body bgcolor='pink'>");
			pw.println("<nav><ul><li><a href='buyerfirst.jsp'>Home</a></li><li><a href='buyerbuysearch.html'>Buy</a></li><li><a href='buyerrentsearch.html'>Rent</a></li><li><a href='buyerpgsearch.html'>P.G</a></li><li><a href='Logout'>Logout</a></li></ul></nav>");
			pw.println("<h1 style='text-align: center'>Results</h1>");
			pw.println("<div class='row'>");
			while (rs.next()) {
				pw.println("<div class='column'>");
				pw.println("<a href='bookrent?id="+rs.getInt(10)+"'><img width='300' height='300' src=DisplayServlet2?id=" +  rs.getInt(10) + " style='width:100%'></a>");
				pw.println("<div class='desc'><h3>" + rs.getString(3)+" "+rs.getString(2) + "</h3></div></div>");
			}
			pw.println("</div></body></html>");
		} catch (Exception e) {
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
