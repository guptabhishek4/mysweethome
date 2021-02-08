package com.project.seller.addvertise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class SellerPg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SellerPg() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random random = new Random(System.nanoTime());
		  int id = random.nextInt(1000000000);
		 HttpSession session=request.getSession();
		  String uid=(String) session.getAttribute("uname");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String hno = request.getParameter("hno");
		String city=request.getParameter("city");
		String location=request.getParameter("location");
		int deposit=Integer.parseInt(request.getParameter("deposit"));
		int rent=Integer.parseInt(request.getParameter("rent"));
		Part part = request.getPart("pic");
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		MyConnectionDetail mcd=new MyConnectionDetail();
		String query="insert into SELLERPG values(?,?,?,?,?,?,?,?,?)";
		try {
			Connection con=mcd.getConnetion();
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, city);
			pstmt.setString(2, location);
			pstmt.setInt(3, deposit);
			pstmt.setInt(4, rent);
			pstmt.setBinaryStream(5, part.getInputStream(), (int) part.getSize());
			pstmt.setInt(6,id);
			pstmt.setString(7, uid);
			pstmt.setTimestamp(8, date);
			pstmt.setString(9,hno);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				pw.println("<script language='javascript'>window.alert('Property Successfully Added!!!');window.location='sellerfirst.jsp';</script>");
				
			}
						
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
