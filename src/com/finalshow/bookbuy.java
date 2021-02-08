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
public class bookbuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public bookbuy() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		MyConnectionDetail mcd = new MyConnectionDetail();
		int id=Integer.parseInt(request.getParameter("id")) ;
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
		
		String query="select * from SELLERSELLING where sellid=?";
		try
		{
			con=mcd.getConnetion();
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			
			session.setAttribute("addid", id);
			
			pw.println("<html><head><link rel='stylesheet' type='text/css' href='table.css'> </head><body><nav>");
			pw.println("<ul><li><a href='buyerfirst.jsp'>Home</a></li>");
			pw.println("<li><a href='buyerbuysearch.html'>Buy</a></li>");
			pw.println("<li><a href='buyerrentsearch.html'>Rent</a></li>");
			pw.println("<li><a href='buyerpgsearch.html'>PG</a></li>");
			pw.println("<li><a href='Logout'>Logout</a></li>");
			pw.println("</ul></nav>");
			
			pw.println("<div class='tbl-header'><table class='box2' align='center'>");
			
		    pw.println("<tr>");
			pw.println("<th>House_no</th>");
			pw.println("<th>City</th>");
			pw.println("<th>Location</th>");
			pw.println("<th>Price</th>");
			pw.println("<th>Bedrooms</th>");
			pw.println("<th>Bathroom</th>");
			pw.println("<th>Type</th>");
			pw.println("<th>Facility</th>");
			pw.println("<th>Payment mode</th>");
			pw.println("<th>Square Foot</th>");
			pw.println("<th>Posted On</th>");
			pw.println("</tr");
			
			while (rs.next()) 
			{session.setAttribute("suname", rs.getString(13));
				pw.println("<tr>");
				pw.println("<td>"+rs.getString(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getInt(4)+"</td>");
				pw.println("<td>"+rs.getInt(5)+"</td>");
				pw.println("<td>"+rs.getInt(6)+"</td>");
				pw.println("<td>"+rs.getString(7)+"</td>");
				pw.println("<td>"+rs.getString(8)+"</td>");
				pw.println("<td>"+rs.getString(10)+"</td>");
				pw.println("<td>"+rs.getInt(11)+"</td>");
				pw.println("<td>"+rs.getTimestamp(14)+"</td>");
				
				pw.println("</tr>");
				
			}	
			session.setAttribute("type", "Buy");
	        pw.println("</table></div>");
	        pw.println("<a href='bookingpage.jsp'><input type='submit' value='BOOK NOW' class='book1' style='margin-left: 78%; margin-top: 27%;'/></a> ");
			pw.println("</body></html>");
			con.close();
		}
		catch (Exception e) {e.printStackTrace();}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
