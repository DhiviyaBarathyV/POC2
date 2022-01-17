package com.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController 
{
	@RequestMapping("/test")
	public ModelAndView test()
	{
		ModelAndView mav= new ModelAndView("home");
		return mav;
	}
	@RequestMapping("/login")
	public ModelAndView loginPage()
	{
		ModelAndView mav= new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/logout-success")
	public ModelAndView logoutPage()
	{
		ModelAndView mav= new ModelAndView("logout");
		return mav;
	}

}
