package com.elitehotel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.elitehotel.model.AvailableRooms;
import com.elitehotel.repository.AvailableRoomRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class Repositorytest 
{
	@Mock
	AvailableRoomRepository availableRoom;

	@Test
	void roomBooking() 
	{
		List<AvailableRooms>allroom=availableRoom.findAll();
		when(availableRoom.findAll()).thenReturn(allroom);
		assertNotNull(allroom,"No room Available to book");
		verify(availableRoom,times(1)).findAll();
		
		
	}

}
