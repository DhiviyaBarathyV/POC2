package com.elitehotel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.elitehotel.model.AvailableRooms;
import com.elitehotel.model.Bill;
import com.elitehotel.model.BookRoom;
import com.elitehotel.model.Login;
import com.elitehotel.service.UserService;

@Controller
@SessionAttributes({"login"})
public class LoginController
{
	@Autowired
	private UserService service; 
	
	@GetMapping("/login")
	public ModelAndView showLogin()
	{
		Login login = new Login();
		ModelAndView mav= new ModelAndView("login");
		mav.addObject("login",login);
		return mav ;
	}
	@PostMapping("/loginprocess")
	public ModelAndView loginProcess( @ModelAttribute("login")Login login)
	{
		ModelAndView mav= null;
		System.out.println("name"+login.getUname());
		System.out.println("pword"+login.getPword());
		
		if(login.getUname().endsWith(".elite.hotel"))
		{
			if(service.adminValidation(login))
			{
				mav= new ModelAndView("adminWelcome");
				List<AvailableRooms> available=service.getAvailablerooms();
				List<BookRoom> bookedroom=service.getBookedRooms();
				mav.addObject("login",login);
				mav.addObject("available",available);
				mav.addObject("booked",bookedroom);
			}
			else
			{
				mav= new ModelAndView("login");
			}
		}
		else
		{
			if(service.userValidation(login))
			{
				
				mav= new ModelAndView("userWelcome");
				List<AvailableRooms> available=service.getAvailablerooms();
				mav.addObject("login",login);
				mav.addObject("available",available);
			}
			else
			{
				mav= new ModelAndView("login");
			}
			
		}
			
		return mav;
	}
	
	@GetMapping("/bookingPage")
	public ModelAndView bookingPage()
	{
		BookRoom book = new BookRoom();
		ModelAndView mav= new ModelAndView("bookRoom");
		mav.addObject("book",book);
		return mav ;
	}
	@PostMapping("/bookingprocess")
	public String bookingPage( @ModelAttribute("login")Login login,@ModelAttribute("available") AvailableRooms available ,@Valid @ModelAttribute("book") BookRoom book,BindingResult br ,Model model)
	{
		
		if(br.hasErrors())
		{
			return "bookRoom";
		}
			
			service.deleteroom(book.getRoomno());
			service.bookRoom(book);
			List<AvailableRooms> avai=service.getAvailablerooms();
			model.addAttribute("available",avai);
			model.addAttribute("login",login);
			return "userWelcome"	;		
	}
	
	@GetMapping("/yourroom")
	public ModelAndView yourRoom(@ModelAttribute("login")Login login)
	{
		
		ModelAndView mav= new ModelAndView("yourBooking");
		mav.addObject("login",login);
		List<BookRoom> myroom= service.getMyRoom(login.getUname());
		mav.addObject("myroom",myroom);
		
		return mav ;
	}
	
	@GetMapping("/backtowelcome")
	public ModelAndView userWelcome(@ModelAttribute("login")Login login)
	{
		ModelAndView mav= new ModelAndView("userWelcome");
		List<AvailableRooms> available=service.getAvailablerooms();
		mav.addObject("login",login);
		mav.addObject("available",available);
		return mav;
	}
	@GetMapping("/bill")
	public ModelAndView bill(@ModelAttribute("login")Login login)
	{
		ModelAndView mav= new ModelAndView("bill");
		mav.addObject("login",login);
		List<Bill> bill= service.getBill(login.getUname());
		mav.addObject("bill",bill);
		System.out.println(bill);
		return mav;
	}
	
}