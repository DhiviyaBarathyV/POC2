package controllers;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;

import java.util.List;

import model.AmountModel;
import model.AvailableRooms;
import model.BillModel;
import model.BookModel;
import model.BookedData;
import model.BookedRooms;
import model.Login;
import services.UserService;

@Controller
@SessionAttributes("login")
public class LoginController 
{
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserDao userdao;
	@Autowired
	UserService userservice;
	
	@GetMapping("/login")
	public ModelAndView showRegister(HttpServletRequest request,HttpServletResponse  response)
	{
		logger.info("Entering login page");
		ModelAndView mav3= new ModelAndView("login");
		mav3.addObject("login", new Login());
		return mav3 ;
	}
	
	@PostMapping("/Loginprocess")
	public ModelAndView loginProcess(@RequestParam("uname") String uname,@RequestParam("pword") String pword,
			HttpServletRequest request,HttpServletResponse  response,
			@ModelAttribute("login") Login lg)
	{
		ModelAndView mav4=null;
		lg.setUname(uname);
		lg.setPword(pword);
		boolean validate=userservice.validate(lg);
		logger.info("login validated");
		if(validate)
		{
			if(lg.getUname().endsWith(".dhiviyaelite"))
			{
				logger.info("admin"+lg.getUname()+ " logging in");
				List<AvailableRooms> arooms= userservice.getAvailableRooms();
				List<BookedData> brooms= userservice.getbookedrooms();
				mav4=new ModelAndView("Adminwelcome");
				mav4.addObject("uname", lg.getUname());	
				mav4.addObject("availableroom", arooms);
				mav4.addObject("broom", brooms);
				
			}
			else
			{
				logger.info("user"+lg.getUname()+" is logging in");
			List<AvailableRooms> arooms= userservice.getAvailableRooms();
			mav4=new ModelAndView("welcome");
			mav4.addObject("uname", lg.getUname());	
			mav4.addObject("availableroom", arooms);
			}
		}
		else
		{
			mav4=new ModelAndView("login");
			
		}
		return mav4 ;
		
	}
	@GetMapping("/YourRoom")
	public ModelAndView YourRooms(HttpServletRequest request,HttpServletResponse  response,
			@ModelAttribute("login") Login lg)
	{
		logger.info(lg.getUname()+"Entering Welcome page");
		ModelAndView mav5=new ModelAndView("YourRoom");
		List<BookedRooms> brooms= userservice.getbookedrooms(lg);
		mav5.addObject("brooms",brooms);
		mav5.addObject("uname",lg.getUname());
		return mav5;	
	}
	@GetMapping("/bookingpage")
	public ModelAndView bookingpage(HttpServletRequest request,HttpServletResponse  response,
			@ModelAttribute("login") Login lg) 
	{
		ModelAndView mav9=new ModelAndView("bookingslot");
		return mav9;
	}
	
	@PostMapping("/booking")
	public ModelAndView bookingProcess(@RequestParam("uname") String uname, @RequestParam("roomno")Integer roomno,
			@RequestParam("type") String roomtype,@RequestParam("capacity") int capacity ,
			@RequestParam("fdate") String fdate,@RequestParam("tdate") String tdate,@RequestParam("phone") String phone,HttpServletRequest request,HttpServletResponse  response,
			@ModelAttribute("login") Login lg)
	{
		 BookModel b= new  BookModel();
	
		b.setUname(uname);
		b.setRoomno(roomno);
		b.setRoomtype(roomtype);
		b.setCapacity(capacity);
		b.setFdate(fdate);
		b.setTdate(tdate);
		b.setPhone(phone);
		userservice.bookroom(b); 
		userservice.deleteroom(b); 
		ModelAndView mav8=new ModelAndView("welcome");
		List<AvailableRooms> arooms= userservice.getAvailableRooms();
		mav8.addObject("uname", lg.getUname());	
		mav8.addObject("availableroom", arooms);
////		List<BookModel>bookeasy=userservice.autoselect(b);
////		mav8.addObject("easy",bookeasy);
//		ModelAndView mav8=new ModelAndView("YourRoom");
//		List<BookedRooms> brooms= userservice.getbookedrooms(lg);
//		mav8.addObject("brooms",brooms);
//		mav8.addObject("uname",lg.getUname());
//		System.out.println("yourroom "+lg.getUname());	
		logger.info(b.getUname()+"booked room successfully");
     	return mav8;
	}
     	@GetMapping("/backtowelcome")
     	public ModelAndView welcomepage(HttpServletRequest request,HttpServletResponse  response,
			@ModelAttribute("login") Login lg)
     	{
     		ModelAndView mav9=new ModelAndView("welcome");
     		List<AvailableRooms> arooms= userservice.getAvailableRooms();
    		mav9.addObject("uname", lg.getUname());	
    		mav9.addObject("availableroom", arooms);
     		return mav9;
     	}
     	@GetMapping("/bill" )
     	public ModelAndView billing(HttpServletRequest request,HttpServletResponse  response,
    			@ModelAttribute("login") Login lg)
     	{
     		logger.info(lg.getUname()+" to view bill amount");
     		
     		ModelAndView mav0=new ModelAndView("bill");
     		List<AmountModel> bill=userservice.getbill(lg);
     		mav0.addObject("uname", lg.getUname());	
    		mav0.addObject("bill", bill);
     		return mav0;
     		
     	}
   
	
}
