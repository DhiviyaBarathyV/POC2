package com.dhiviyaBookStore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dhiviyaBookStore.model.Books;
import com.dhiviyaBookStore.repository.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class DhiviyaBookStoreRepository 
{
	@Mock
	BookRepository bookRepository;

	@Test
	void test() 
	{
		List<Books> allbooks=bookRepository.findAll();
		assertEquals(allbooks,bookRepository.findAll());
		verify(bookRepository,times(2)).findAll();
		
	}

}
