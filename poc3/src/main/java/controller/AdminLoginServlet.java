package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost (HttpServletRequest request, HttpServletResponse response)  throws IOException ,ServletException 
	{
		String usname= request.getParameter("uname");
		String paword= request.getParameter("pword");
		LoginModel login = new LoginModel();
		login.setUserName(usname);
		login.setPassWord(paword);
		
		int loginSuccess = AdminLoginDao.LoginSuccess(login);
		if(loginSuccess>1) {
			HttpSession session= request.getSession();
			session.setAttribute("username", usname);
			session.setAttribute("password", paword);
			RequestDispatcher rd= request.getRequestDispatcher("Adminwelcome.jsp");
			rd.forward(request, response);
			}
		else {
			RequestDispatcher rd1= request.getRequestDispatcher("AdminLogin.jsp");
			rd1.forward(request, response);
		}
	}

}
