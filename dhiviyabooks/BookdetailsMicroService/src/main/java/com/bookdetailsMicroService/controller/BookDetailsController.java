package com.bookdetailsMicroService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookdetailsMicroService.model.Books;
import com.bookdetailsMicroService.service.BookDetailsService;

@RestController
public class BookDetailsController 
{
	@Autowired
	private BookDetailsService bookDetailsService;
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello";
	}
	@GetMapping("/bookdetails/{keyword}")
	public List<Books> getBookDetails(@PathVariable String keyword )
	{
		List<Books> getBookDetails= bookDetailsService.bookDetails(keyword);
		return getBookDetails;
	}
	

}
