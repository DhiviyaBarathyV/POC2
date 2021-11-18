package com.elitehotel;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.elitehotel.model.AvailableRooms;
import com.elitehotel.repository.AvailableRoomRepository;
import com.elitehotel.service.UserService;

@SpringBootTest
class ServiceTest 
{
	
	@Mock
	AvailableRoomRepository availableRoom;
	@InjectMocks
	UserService service;
	
	@Test
	@DisplayName("Is there room available to book")
	void testAvailableRooms() 
	{
		List<AvailableRooms>allroom=availableRoom.findAll();
		when(availableRoom.findAll()).thenReturn(allroom);
		 Assertions.assertThat(service.getAvailablerooms()).isEmpty();
		 verify(availableRoom,times(2)).findAll();
	}

}
