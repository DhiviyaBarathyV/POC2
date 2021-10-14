package HotelApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
@WebServlet("/loginprocess")
public class loginprocess extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException {
		String usname= request.getParameter("uname");
		String paword= request.getParameter("pword");
		HttpSession session= request.getSession();
		session.setAttribute("username", usname);
		session.setAttribute("password", paword);	
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/poc";
			String user = "root";
			String pass = "Vdb@1997";
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		
	    con = DriverManager.getConnection(dbUrl, user, pass);
	    Statement st = con.createStatement();
		ResultSet rs=st.executeQuery("select * from details"); 
		while(rs.next()) {
		if(usname==rs.getString(3)) {	
		if(paword==rs.getString(4)) {
				RequestDispatcher rd= request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			
		}
		}
	 
		}catch(Exception e) {
			PrintWriter out= response.getWriter();
			out.println(e.getMessage());
		}
	}

}
