package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		String fn =request.getParameter("fname");
		String ln=request.getParameter("lname");
		String un=request.getParameter("uname");
		String dt=request.getParameter("dob");
		String ph=request.getParameter("phone");
		String pw=request.getParameter("pword");
		
		RegisterModel reg = new RegisterModel();
		reg.setfName(fn);
		reg.setlName(ln);
		reg.setuName(un);
		reg.setDob(dt);
		reg.setPhoneNo(ph);
		reg.setpWord(pw);
	    int registerSuccess;
	registerSuccess = RegisterDao.registerUser(reg);
	if(registerSuccess==1) {
		RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		}
		
	}
}