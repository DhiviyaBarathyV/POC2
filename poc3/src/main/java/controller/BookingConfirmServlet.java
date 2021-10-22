package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BookingConfirmServlet")
public class BookingConfirmServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException  {
		String un =request.getParameter("uname");
		Integer rn=Integer.parseInt(request.getParameter("roomno"));
		String rt=request.getParameter("type");
		Integer cap=Integer.parseInt(request.getParameter("capacity"));
		String fdt=request.getParameter("fdate");
		String tdt=request.getParameter("tdate");
		String ph=request.getParameter("phone");
		BookedRoomModel book = new BookedRoomModel();
		book.setUsername(un);
		book.setRoomno(rn);
		book.setRoomtype(rt);
		book.setCapacity(cap);
		book.setFromD(fdt);
		book.setToDa(tdt);
		book.setPhone(ph);
		 int bookingSuccess;
			bookingSuccess = BookedRoomDao.bookUser(book);
			if(bookingSuccess==1) {
				RequestDispatcher rd= request.getRequestDispatcher("YourRoom.jsp");
				rd.forward(request, response);
				}
		
	}
}