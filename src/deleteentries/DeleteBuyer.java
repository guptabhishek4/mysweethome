package deleteentries;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.connection.MyConnectionDetail;

public class DeleteBuyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteBuyer() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String values[]=request.getParameterValues("buy");
		PrintWriter pw=response.getWriter();
		MyConnectionDetail mcd=new MyConnectionDetail();
		try {
			Connection con = mcd.getConnetion();
		for (String s : values) {
			PreparedStatement pst = con.prepareStatement("delete from Buyerlogin where username=?");
			pst.setString(1, s);
			pst.executeQuery();
		
				}
		}catch (Exception e) {
					e.printStackTrace();
				}
		 pw.println("<script language='javascript'>window.alert('Record Deleted Successfully!!!');window.location='Admin.jsp';</script>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
