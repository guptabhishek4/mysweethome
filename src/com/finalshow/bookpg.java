package com.finalshow;

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

public class bookpg extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public bookpg() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		MyConnectionDetail mcd = new MyConnectionDetail();
		
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		int id=Integer.parseInt(request.getParameter("id")) ;
		String query="select * from SELLERPG where pgid=?";
		
		
		try
		{
		con=mcd.getConnetion();
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1,id);
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
		pw.println("<th>House No.</th>");
		pw.println("<th>Location</th>");
		pw.println("<th>City</th>");
		pw.println("<th>Rent</th>");
		pw.println("<th>Deposit</th>");
		pw.println("<th>Posted On</th>");
		pw.println("</tr>");
		
		
		while (rs.next()) 
		{
		session.setAttribute("addid", id);
		session.setAttribute("suname", rs.getString(7));
			pw.println("<tr>");
			pw.println("<td>"+rs.getString(9) +"</td>");
			pw.println("<td>"+rs.getString(1) +"</td>");
			pw.println("<td>"+rs.getString(2) +"</td>");
			pw.println("<td>"+rs.getInt(4) +"</td>");
			pw.println("<td>"+rs.getInt(3) +"</td>");
			pw.println("<td>"+rs.getTimestamp(8) +"</td>");
			pw.println("</tr>");
			
		}
		
		pw.println("</table></div>");
		session.setAttribute("type","P.G.");
		pw.println("<a href='bookingpage.jsp'><input type='submit' value='BOOK NOW' class='book'/> </a>");
		
		pw.println("</body></html>");
        con.close();
        
        
       
		
		}
		
	
		catch (Exception e) {e.printStackTrace();}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
