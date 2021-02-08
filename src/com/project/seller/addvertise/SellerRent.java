package com.project.seller.addvertise;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.project.connection.MyConnectionDetail;

@MultipartConfig
public class SellerRent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SellerRent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Random random = new Random(System.nanoTime());

		  int id = random.nextInt(1000000000);
		  HttpSession session=request.getSession();
		  String uid=(String) session.getAttribute("uname");
		String houseno = request.getParameter("hno");
		String loc = request.getParameter("location");
		String city = request.getParameter("city");
		int bedroom = Integer.parseInt(request.getParameter("nob"));
		int bathroom = Integer.parseInt(request.getParameter("nobath"));
		Part part = request.getPart("pic");
		int rent = Integer.parseInt(request.getParameter("rent"));
		String pmode = request.getParameter("type");
		int deposit = Integer.parseInt(request.getParameter("deposit"));
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		MyConnectionDetail cd = new MyConnectionDetail();
		Connection con = null;
		PreparedStatement pstmt;
		String query = "insert into SELLERRENTAL values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			con = cd.getConnetion();

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, houseno);

			pstmt.setString(2, loc);

			pstmt.setString(3, city);

			pstmt.setInt(4, bedroom);

			pstmt.setInt(5, bathroom);

			pstmt.setBinaryStream(6, part.getInputStream(), (int) part.getSize());

			pstmt.setInt(7, rent);

			pstmt.setString(8, pmode);

			pstmt.setInt(9, deposit);
			pstmt.setInt(10, id);
			pstmt.setString(11,uid);
			pstmt.setTimestamp(12, date);
			
			ResultSet rs = pstmt.executeQuery();
			con.commit();
			if(rs.next()){
				pw.println("<script language='javascript'>window.alert('Property Successfully Added!!!');window.location='sellerfirst.jsp';</script>");
			}
			
		} catch (Exception e) {
		}

	}

}
