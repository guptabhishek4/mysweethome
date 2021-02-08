package com.displayphoto;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.connection.MyConnectionDetail;

public class DisplayPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MyConnectionDetail mcd=new MyConnectionDetail();
            Connection con=mcd.getConnetion();
            PreparedStatement ps;
            int id;
				String query1="select image from sellerselling where sellid = ?";
				id = Integer.parseInt(request.getParameter("id"));
				ps=con.prepareStatement(query1);
				ps.setInt(1,id);
	            ResultSet rs = ps.executeQuery();
	            rs.next();
	            Blob b = rs.getBlob("image");
			            response.setContentType("image/jpeg");
            response.setContentLength((int) b.length());
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            os.write(buf);
            os.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
}
}