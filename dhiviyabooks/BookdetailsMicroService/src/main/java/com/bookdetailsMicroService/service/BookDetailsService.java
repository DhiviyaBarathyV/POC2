package com.bookdetailsMicroService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookdetailsMicroService.model.Books;
import com.bookdetailsMicroService.repository.BookRepository;

@Service
public class BookDetailsService 
{
	@Autowired
	private BookRepository bookRepository;

	public List<Books> bookDetails(String keyword) 
	{
		List<Books> allbooks= bookRepository.findAll();
		List<Books> booksAuthor = new ArrayList<>();
				for(Books b:allbooks)
				{
					if(b.getAuthor().contains(keyword))
					{
						booksAuthor.add(b);
					}
				}
				
				return booksAuthor;
	}

}
