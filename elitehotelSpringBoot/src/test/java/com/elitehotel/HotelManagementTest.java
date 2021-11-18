package com.elitehotel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.elitehotel.model.AvailableRooms;
import com.elitehotel.repository.AvailableRoomRepository;
import com.elitehotel.service.UserService;

@SpringBootTest
class HotelManagementTest 
{
	
	@Mock
	AvailableRoomRepository availableRoom;
	@InjectMocks
	UserService service;
	
	@Test
	@DisplayName("Is there room available to book")
	void testAvailableRooms() 
	{
		List<AvailableRooms>allroom=new ArrayList<>();
		allroom=availableRoom.findAll();
		System.out.println(allroom);
		when(availableRoom.findAll()).thenReturn(allroom);
		List<AvailableRooms>rooms=service.getAvailablerooms();
		System.out.println(rooms);
		assertTrue(rooms.size()>1,"No room available to book, Booking are full");
		verify(availableRoom,times(1)).findAll();
	}

}
