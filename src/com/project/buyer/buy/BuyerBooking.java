package com.project.buyer.buy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.connection.MyConnectionDetail;

public class BuyerBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BuyerBooking() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		MyConnectionDetail mcd = new MyConnectionDetail();
		
		Connection con;
		PreparedStatement pstmt;
	
		String query="insert into BOOKINGINFO values(?,?,?,?,?,?,?,?)";
		String pmode=request.getParameter("pmode");
		int amnt=Integer.parseInt(request.getParameter("amnt"));
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		try
		{
			Random rand = new Random(); 
			int rand_int1 = rand.nextInt(10000);
			HttpSession session=request.getSession();
			con=mcd.getConnetion();
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, rand_int1);
			pstmt.setString(2,(String)session.getAttribute("type"));
			pstmt.setString(3, (String)session.getAttribute("uname"));
			pstmt .setInt(4, amnt);
			pstmt.setString(5, pmode);
			pstmt.setInt(6,(int)session.getAttribute("addid"));
			pstmt.setString(7, (String)session.getAttribute("suname"));
			pstmt.setTimestamp(8, date);
			pstmt.executeQuery();
			con.commit();
			con.close();
			 pw.println("<script language='javascript'>window.alert('Booking Successfull');window.location='buyerfirst.jsp';</script>");
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
