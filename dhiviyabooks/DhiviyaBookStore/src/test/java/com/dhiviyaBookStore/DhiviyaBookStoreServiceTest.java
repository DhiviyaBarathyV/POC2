package com.dhiviyaBookStore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhiviyaBookStore.model.Books;
import com.dhiviyaBookStore.repository.BookRepository;
import com.dhiviyaBookStore.service.DhiviyaBookStoreService;

@SpringBootTest
class DhiviyaBookStoreServiceTest 
{
	@Mock
	BookRepository bookRepository;
	@InjectMocks
	DhiviyaBookStoreService dhiviyaBookStoreService;	
	
	@Test
	@DisplayName("Verify methos getAvailable book")
	void testgetAvailablebook() 
	{
		List<Books> allbooks=bookRepository.findAll();
		when(bookRepository.findAll()).thenReturn(allbooks);
		assertEquals(allbooks,dhiviyaBookStoreService.getAvailablebooks());
		verify(bookRepository,times(2)).findAll();
	}
	@Test
	@DisplayName("Verify Library is not empty")
	void test() 
	{
		List<Books> allbooks=bookRepository.findAll();
		when(bookRepository.findAll()).thenReturn(allbooks);
		assertNotNull(dhiviyaBookStoreService.getAvailablebooks(),"The library is empty");
		verify(bookRepository,times(2)).findAll();
	}

}
