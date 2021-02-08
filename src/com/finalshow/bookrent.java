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

public class bookrent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public bookrent() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id")) ;
		MyConnectionDetail mcd = new MyConnectionDetail();
		
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		String query="select * from SELLERRENTAL where rentid=?";
		
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
			
			pw.println("<div class='tbl-header'><table  class='box3' align='center'>");
			
			pw.println("<tr>");
			pw.println("<th>House No.</th>");
			pw.println("<th>City</th>");
			pw.println("<th>Location</th>");
			pw.println("<th>Deposit</th>");
			pw.println("<th>Rent</th>");
			pw.println("<th>Bedroom</th>");
			pw.println("<th>Bathroom</th>");
			pw.println("<th>Payment Mode</th>");
			pw.println("<th>Posted On</th>");
			pw.println("</tr>");
			
			
			while(rs.next())
			{
				
				session.setAttribute("addid", id);
				session.setAttribute("suname", rs.getString(11));
				pw.println("<tr>");
				pw.println("<td>"+rs.getString(1)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getInt(9)+"</td>");
				pw.println("<td>"+rs.getInt(7)+"</td>");
				pw.println("<td>"+rs.getInt(4)+"</td>");
				pw.println("<td>"+rs.getInt(5)+"</td>");
				pw.println("<td>"+rs.getString(8)+"</td>");
				pw.println("<td>"+rs.getTimestamp(12)+"</td>");
				pw.println("</tr>");
			}
			session.setAttribute("type","rent");
			pw.println("</table></div>");
			pw.println("<a href='bookingpage.jsp'><input type='submit' value='BOOK NOW' class='book3' style='margin-left: 65%; margin-top: 26%;'</a>/> ");
			pw.println("</body></html>");
			con.close();
		}
		catch (Exception e) {e.printStackTrace();}
	}
}