package com.dhiviyaBookStore.service;

import java.util.ArrayList;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.dhiviyaBookStore.model.Books;
import com.dhiviyaBookStore.model.Login;
import com.dhiviyaBookStore.model.OrderDetails;
import com.dhiviyaBookStore.model.User;
import com.dhiviyaBookStore.repository.BookRepository;
import com.dhiviyaBookStore.repository.OrderRepository;
import com.dhiviyaBookStore.repository.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DhiviyaBookStoreService 
{
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	  private RestTemplate restTemplate;

	public void addUser(@Valid User user) 
	{
		userRepository.save(user);
	}

	public boolean userValidation(Login login)
	{
		List<User> user= new ArrayList<>();
		userRepository.findAll().forEach(user::add);
		for(User use:user)
		{
			if((use.getName().equalsIgnoreCase(login.getUserName())&&(use.getPassWord().equals(login.getPassWord()))))
					{
				      return true;
					}	
		}
		return false;
	}

	public boolean adminValidation(Login login) 
	{
		List<User> user= new ArrayList<>();
		userRepository.findAll().forEach(user::add);
		for(User use:user)
		{
			if((use.getName().equalsIgnoreCase(login.getUserName())&&(use.getPassWord().equals(login.getPassWord()))))
					{
				      return true;
					}	
		}
		return false;
		}

	public List<Books> getAvailablebooks() 
	{
		List<Books> allbooks= bookRepository.findAll();
		return allbooks;
	}
	@HystrixCommand(fallbackMethod ="fallbackmethod")
	public List<Books> getSearchBook(String keyword)
	{
		List<Books> searchbooks= new ArrayList<>();
			List<Books> books= bookRepository.findAll();
			for(Books b:books)
			{
				if(b.getBookName().contains(keyword))
				{
					searchbooks.add(b);
				}
				else if(b.getAuthor().contains(keyword))
				{
					 List<Books> bo = restTemplate.exchange(
					    	    "http://localhost:8001/bookdetails/{keyword}", HttpMethod.GET, null, new
					    	    ParameterizedTypeReference<List<Books>>(){}, keyword).getBody();
					return bo;
				}
				else if(b.getCategory().contains(keyword))
				{
					searchbooks.add(b);
				}
			}
			return searchbooks;
	}
	public List<Books>fallbackmethod(String keyword) 
	  {
		 System.out.println("fall back method");
		 Books book=new Books(0,"nill","nill","nill",0);
		   List<Books> defaultbook=new ArrayList<>();
		   defaultbook.add(book);
		   return defaultbook;
	  }
	public void addBook(Books book) 
	{
		bookRepository.save(book);
		
	}
	public void deleteBook(int Id)
	{
		bookRepository.deleteById(Id);	
	}
	public List<OrderDetails> buyBook(int id, String bookname, Login login) 
	{
		
		List<OrderDetails> buyBook= new ArrayList<>();
		List<OrderDetails> myallbooks=getMyBooks(login.getUserName());
		System.out.println("mybooks:"+myallbooks.size());
		OrderDetails or= new OrderDetails();
		for(OrderDetails boo:myallbooks)
		{
			if(boo.getBookName().equalsIgnoreCase(bookname))
			{
				or.setBookName(boo.getBookName()); 
				System.out.println("bookname:"+boo.getBookName());
				throw new DataIntegrityViolationException(bookname);
			}
			else
			{
				List<Books> books= bookRepository.findAll();
				for(Books b:books)
				{
					if(b.getBookId()==id)
					{
						OrderDetails order = new OrderDetails();
						order.setBookId(id);
						order.setName(login.getUserName());
						order.setBookName(b.getBookName());
						order.setAmount(b.getPrice());
						buyBook.add(order);
						orderRepository.save(order);
					}	
				}	
		}
		
		}		
		return buyBook;
	}

	public List<OrderDetails> getMyBooks(String userName) 
	{
		List<OrderDetails> myBooks=new ArrayList<>();
		List<OrderDetails> alldetails=orderRepository.findAll();
		for(OrderDetails o:alldetails)
		{
			if(o.getName().equals(userName))
			{
				myBooks.add(o);
			}
		}
		
		return myBooks;
	}

	public List<Books> getAvailablebooksSortedByName(String field) 
	{
		List<Books> sortedName=bookRepository.findAll(Sort.by(Sort.Direction.ASC,field));
		return sortedName;
	}

	public List<Books> getAvailablebooksSortedByNameDES(String field) 
	{
		return bookRepository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
}
