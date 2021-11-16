package com.elitehotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.elitehotel.model.User;
import com.elitehotel.service.UserService;

@Controller
public class RegisterController 
{
	@Autowired
	private UserService service; 
	@GetMapping("/main")
	public ModelAndView showmain()
	{
		ModelAndView mav= new ModelAndView("main");
		return mav ;
		
	}
	
	@GetMapping("/register")
	public ModelAndView showRegister()
	{
		User user= new User();
		ModelAndView mav= new ModelAndView("register");
		mav.addObject("user", user);
		return mav ;
		
	}
	@PostMapping("/registrationprocess")
	public String addUser(@Valid @ModelAttribute("user") User user,BindingResult br)
	{
		System.out.println(user.getfName());
		if(br.hasErrors())
		{
		 return "register";
		}
		
			service.addUser(user);
		
		  return "main";
		
	}

}
