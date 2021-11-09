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
import org.springframework.web.servlet.ModelAndView;
import model.User;
import services.UserService;
@Controller
public class RegistrationController 
{
	
	private static final Logger logger = Logger.getLogger(RegistrationController.class);
	
	@Autowired
	public UserService userservice;
	
	@GetMapping("/main")
	public ModelAndView showmain(HttpServletRequest request,HttpServletResponse  response)
	{
		logger.info("going to main page");
		ModelAndView mav= new ModelAndView("main");
		return mav ;
		
	}
	
	@GetMapping("/register")
	public ModelAndView showRegister(HttpServletRequest request,HttpServletResponse  response)
	{
		logger.info("going to register page");
		ModelAndView mav1= new ModelAndView("register");
		mav1.addObject("user", new User());
		return mav1 ;
		
	}
	
	@PostMapping("/registerprocess")
	public ModelAndView addUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname,
			@RequestParam("uname") String uname,@RequestParam("dob") String dob,
			@RequestParam("phone") String phone,@RequestParam("pword") String pword,HttpServletRequest request,HttpServletResponse  response,@ModelAttribute("user") User u)
	{
		 
		if(uname.contains(".dhiviyaelite"))
		{
			u.setfName(fname);
			u.setlName(lname);
			u.setuName(uname);
			u.setDob(dob);
			u.setpWord(pword);
			u.setPhoneNo(phone);
			logger.info("Processing the data to db");
			userservice.adminRegister(u);
			logger.info(u.getfName()+"Admin succesfully registered");
		}
		else
		{
			u.setfName(fname);
			u.setlName(lname);
			u.setuName(uname);
			u.setDob(dob);
			u.setpWord(pword);
			u.setPhoneNo(phone);
			logger.info("Processing the data to db");
			userservice.register(u);
			logger.info(u.getuName()+"user succesfully registered");
			
			
		}
		ModelAndView mav6= new ModelAndView("login");
		return  mav6 ;
	}

}
