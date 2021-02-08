package com.login;

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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  PrintWriter pw=response.getWriter();
    	  response.setContentType("text/html");
    	  String username=request.getParameter("uname");
    	  String password=request.getParameter("pass");
    	  String type=request.getParameter("type");
    	  MyConnectionDetail ds = new MyConnectionDetail();
    	  String query = "select * from buyerlogin where username=? and password=?";
    	  String query2="select * from sellerlogin where username=? and password=?";
    	  String query3="select * from admin_login where username=? and password=?";
    	  Connection con=null;
    	  PreparedStatement pstmt=null;
    	  ResultSet rs ;
    	  if(type.equals("Buyer")){
    	   
    	   
    	    try {
    	     con = ds.getConnetion();
    	     pstmt = con.prepareStatement(query);
    	     pstmt.setString(1, username);
    	     pstmt.setString(2, password);
    	      rs = pstmt.executeQuery();
    	      boolean flag=false;
    	      while(rs.next()){
    	       if(username.equals(rs.getString(2))&&password.equals(rs.getString(3))){
    	       flag=true;
    	       HttpSession session=request.getSession();
    	       session.setAttribute("uname", username);
    	    	response.sendRedirect("buyerfirst.jsp");
    	       }  
    	       }
    	       if(flag==false){
    	    	   pw.println("<script language='javascript'>window.alert('Sorry Incorect User Id And Password!!!');window.location='login.jsp';</script>");
    	       
    	       }
    	      
    	   } catch (Exception e) {
    	    	   e.printStackTrace();
    	   }
    	    
    	   
    	   }
    	  else if(type.equals("Seller")){
    	   try{
    	     con = ds.getConnetion();
    	     pstmt = con.prepareStatement(query2);
    	     pstmt.setString(1, username);
    	     pstmt.setString(2, password);
    	      rs = pstmt.executeQuery();
    	      boolean flag=false;
    	      while(rs.next()){
    	       if(username.equals(rs.getString(2))&&password.equals(rs.getString(3))){
    	       flag=true;
    	       HttpSession session=request.getSession();
    	       session.setAttribute("uname", username);
    	       response.sendRedirect("sellerfirst.jsp");
    	        
    	       }
    	       }
    	       
    	     	    	   if(flag==false){
        	    	   pw.println("<script language='javascript'>window.alert('Sorry Incorect User Id And Password!!!');window.location='login.jsp';</script>");
    	       
    	       
    	      }
    	    
    	    
    	   }catch(Exception e){
    	    e.printStackTrace();
    	   }
    	  }
    	
    	  else if(type.equals("Admin")){
       	   try{
       	     con = ds.getConnetion();
       	     pstmt = con.prepareStatement(query3);
       	     pstmt.setString(1, username);
       	     pstmt.setString(2, password);
       	      rs = pstmt.executeQuery();
       	      boolean flag=false;
       	      while(rs.next()){
       	       if(username.equals(rs.getString(1))&&password.equals(rs.getString(2))){
       	       flag=true;
       	       HttpSession session=request.getSession();
       	       session.setAttribute("uname", username);
       	       response.sendRedirect("Admin.jsp");
       	        
       	       }
       	       }
       	       
       	     	    	   if(flag==false){
           	    	   pw.println("<script language='javascript'>window.alert('Sorry Incorect User Id And Password!!!');window.location='login.jsp';</script>");
       	       
       	       
       	      }
       	    
       	    
       	   }catch(Exception e){
       	    e.printStackTrace();
       	   }
       	  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
