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
public class BuyerBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BuyerBuy() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int pmin = Integer.parseInt(request.getParameter("pricemin"));
		int pmax = Integer.parseInt(request.getParameter("pricemax"));
		int sqfeet = Integer.parseInt(request.getParameter("sqfeet"));
		String city = request.getParameter("city");
		String location = request.getParameter("location");
		int bedroomno = Integer.parseInt(request.getParameter("bedroom"));
		int bathroomno = Integer.parseInt(request.getParameter("bathroom"));
		String type = request.getParameter("type");
		MyConnectionDetail mcd = new MyConnectionDetail();
		String query = "select * from sellerselling where(price BETWEEN ? and ?) AND (lower(CITY)=? AND lower(location)=?) AND (bedrooms_no=? AND BATHROOMS_NO=?) AND type=? and SQUAREFooT<=?";
		if ( location.isEmpty() && city.isEmpty() && type.isEmpty() )
		{
			pw.println("atleast one value should be entered");
		}
		
		try {

			Connection con = mcd.getConnetion();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pmin);
			pstmt.setInt(2, pmax);
			pstmt.setString(3, city);
			pstmt.setString(4, location);
			pstmt.setInt(5, bedroomno);
			pstmt.setInt(6, bathroomno);
			pstmt.setString(7, type);
			pstmt.setInt(8, sqfeet);
			ResultSet rs = pstmt.executeQuery();
			pw.println("<html><head>");
			pw.println("<link rel='stylesheet' href='stylepicpage.css'>");
			pw.println("<body bgcolor='pink'>");
			pw.println("<nav><ul><li><a href='buyerfirst.jsp'>Home</a></li><li><a href='buyerbuysearch.html'>Buy</a></li><li><a href='buyerrentsearch.html'>Rent</a></li><li><a href='buyerpgsearch.html'>P.G</a></li><li><a href='Logout'>Logout</a></li></ul></nav>");
			pw.println("<h1 style='text-align: center'>Results</h1>");
			pw.println("<div class='row'>");
			while (rs.next()) {
				pw.println("<div class='column'>");
				pw.println("<a href='bookbuy?id="+rs.getInt(12)+"'><img width='300' height='300' src=DisplayPhoto?id=" +  rs.getInt(12) + " style='width:100%'></a>");
				pw.println("<div class='desc'><h3>" + rs.getString(2)+" "+rs.getString(3) + "</h3></div></div>");
			}
			pw.println("</div></body></html>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				doGet(request, response);
	}

}
