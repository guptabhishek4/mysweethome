package com.project.register;

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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String uname = request.getParameter("uname");
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String type = request.getParameter("Type");
		MyConnectionDetail mcd = new MyConnectionDetail();

		if (type.equals("Buyer")) {
			try {
				String query = "insert into buyerlogin values(?,?,?,?,?)";
				Connection con = mcd.getConnetion();
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(2, uname);
				ps.setString(1, name);
				ps.setString(3, password);
				ps.setString(5, email);
				ps.setLong(4, Long.parseLong(mobile));
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					pw.println("<script language='javascript'>window.alert('You Are Successfuly added!!!');window.location='login.jsp';</script>");
				}
				con.close();

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

		else if (type.equals("Seller")) {
			try {
				String query = "insert into sellerlogin values(?,?,?,?,?)";
				Connection con = mcd.getConnetion();
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(2, uname);
				ps.setString(1, name);
				ps.setString(3, password);
				ps.setString(5, email);
				ps.setLong(4, Long.parseLong(mobile));
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					pw.println("<script language='javascript'>window.alert('You are Successfully Added!!!');window.location='login.jsp';</script>");
				}
				
				con.close();

			} catch (Exception e) {

				e.printStackTrace();

			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
