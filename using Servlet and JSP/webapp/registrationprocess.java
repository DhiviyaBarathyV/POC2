package HotelApp;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/registrationprocess")
public class registrationprocess extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		String fn =request.getParameter("fname");
		String ln=request.getParameter("lname");
		String un=request.getParameter("uname");
		String dt=request.getParameter("dob");
		String ph=request.getParameter("phone");
		String pw=request.getParameter("pword");
		HttpSession session= request.getSession();
		session.setAttribute("firstname",fn);
		session.setAttribute("lastname",ln);
		session.setAttribute("username",un); 
		session.setAttribute("dob",dt);
		session.setAttribute("phoneno",ph);
		session.setAttribute("password",pw);
		
		
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/poc";
			String user = "root";
			String pass = "Vdb@1997";
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
	    con = DriverManager.getConnection(dbUrl,user,pass);
	    String sql="INSERT INTO details VALUES (?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql); 
		
		ps.setString(1,fn);
		ps.setString(2,ln);
		ps.setString(3,un);
		ps.setString(4,pw);
		ps.setString(5,dt);
		ps.setString(6,ph);
		int val = ps.executeUpdate(); 
		if(val==1) {
		RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		}
		System.out.println(val+" rows updated");
		}catch(SQLException | ClassNotFoundException e) {
			PrintWriter out= response.getWriter();
			out.println("Error: "+e.getMessage());
		}
	}
}
