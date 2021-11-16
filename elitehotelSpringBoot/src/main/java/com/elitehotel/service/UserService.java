package com.elitehotel.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elitehotel.model.AvailableRooms;
import com.elitehotel.model.Bill;
import com.elitehotel.model.BookRoom;
import com.elitehotel.model.Login;
import com.elitehotel.model.User;
import com.elitehotel.repository.AvailableRoomRepository;
import com.elitehotel.repository.BookingRepository;
import com.elitehotel.repository.HotelRepository;


@Service
public class UserService 
{
	@Autowired
	public HotelRepository hotelRepo;
	@Autowired
	public AvailableRoomRepository availableRoom;
	@Autowired
	public BookingRepository bookroom;
	
	public void addUser(@Valid User user) 
	{
		hotelRepo.save(user);
	}

	public boolean userValidation(Login login) 
	{
		List<User> user= new ArrayList<>();
		hotelRepo.findAll().forEach(user::add);
		for(User use:user)
		{
			if((use.getuName().equalsIgnoreCase(login.getUname())&&(use.getpWord().equals(login.getPword()))))
					{
				      return true;
					}	
		}
		return false;
	}

	public boolean adminValidation(Login login) 
	{
		List<User> user= new ArrayList<>();
		hotelRepo.findAll().forEach(user::add);
		for(User use:user)
		{
			if((use.getuName().equalsIgnoreCase(login.getUname())&&(use.getpWord().equals(login.getPword()))))
					{
				      return true;
					}	
		}
		return false;
	}

	public List<AvailableRooms> getAvailablerooms() 
	{
		List<AvailableRooms> list= availableRoom.findAll();
		return list;
	}

	public void bookRoom(@Valid BookRoom book) 
	{
		
		bookroom.save(book);
	}

	public void deleteroom(Integer roomno) 
	{
		availableRoom.deleteById(roomno);
	}

	public List<BookRoom> getBookedRooms() 
	{
		List<BookRoom> book= bookroom.findAll();
		return book;
	}

	public List<BookRoom> getMyRoom(String uname) 
	{
		List<BookRoom> all= bookroom.findAll();
		List<BookRoom> myroom= new ArrayList<>();
		for(BookRoom book:all)
		{
			if(book.getUsername().equalsIgnoreCase(uname))
			{
				myroom.add(book);
				System.out.println(myroom);
			}
		}
		return myroom;
	}

	public List<Bill> getBill(String uname) 
	{
		List<BookRoom> all= bookroom.findAll();
		List<BookRoom> myroom= new ArrayList<>();
		List<Bill> bill= new ArrayList<>();
		 SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd"); 
		for(BookRoom book:all)
		{
			if(book.getUsername().equalsIgnoreCase(uname))
			{
				myroom.add(book);
				
			}
		}
		for(BookRoom my:myroom)
		{
		
			try
			{
				Date date1 = obj.parse(my.getFdate());   
	            Date date2 = obj.parse(my.getTdate()); 
	            long time_difference = date2.getTime() - date1.getTime(); 
	            long noOfDays= TimeUnit.MILLISECONDS.toDays(time_difference) % 365; 
	            Integer amt= (int) (noOfDays)*1000;
	            Bill b = new Bill();
	            b.setName(uname);
	            b.setFdate(my.getFdate());
	            b.setTdate(my.getTdate());
	            b.setNoOfDays((int)noOfDays);
	            b.setAmount(amt);
	            bill.add(b);
			}
			 catch(Exception e)
     	   {
     		   System.out.println(e);
     	   }
		
		}
		
		return bill;
	}
	
	
}
