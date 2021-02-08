package com.project.seller.addvertise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.project.connection.MyConnectionDetail;
@MultipartConfig
public class SellerSell extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SellerSell() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MyConnectionDetail mcd = new MyConnectionDetail();
        Random random = new Random(System.nanoTime());
		  int id = random.nextInt(1000000000);
        try {
           
        	String hno = request.getParameter("hno");
    		String location = request.getParameter("location");
    		String city = request.getParameter("city");
    		int sqfoot = Integer.parseInt(request.getParameter("sqfoot"));
    		int nob = Integer.parseInt(request.getParameter("nob"));
    		int nobath = Integer.parseInt(request.getParameter("nobath"));
    		String typeprop = request.getParameter("typeprop");
    		String facility = request.getParameter("comment");
    		double price = Double.parseDouble(request.getParameter("price"));
            Part photo =  request.getPart("pic");
            String type=request.getParameter("type");
            HttpSession session=request.getSession();
  		  String uid=(String) session.getAttribute("uname");
  		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            Connection con = mcd.getConnetion();
			PreparedStatement ps = con.prepareStatement("insert into SellerSelling values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,hno );
            ps.setString(3,location);
            ps.setString(2,city);
            ps.setInt(11,sqfoot);
            ps.setInt(5,nob);
            ps.setInt(6,nobath);
            ps.setString(7,typeprop);
            ps.setString(8, facility);
            ps.setDouble(4,price);
            ps.setBinaryStream(9, photo.getInputStream(), (int)  photo.getSize());
            ps.setString(10,type);
            ps.setInt(12,id);
            ps.setString(13, uid);
            ps.setTimestamp(14, date);
            
            ps.executeUpdate();
            con.commit();
            con.close();
            out.println("<script language='javascript'>window.alert('Property Successfully Added!!!');window.location='sellerfirst.jsp';</script>");
        } 
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {            
            out.close();
        }
	}

}
