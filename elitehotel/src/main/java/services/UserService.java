package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import controllers.RegistrationController;
import dao.UserDao;
import model.AmountModel;
import model.AvailableRooms;
import model.BillModel;
import model.BookModel;
import model.BookedData;
import model.BookedRooms;
import model.Login;
import model.User;

public class UserService 
{
	private static final Logger logger = Logger.getLogger(RegistrationController.class);
	@Autowired
	UserDao userdao;
	
	public void register(User user)
	{
		userdao.register(user);
	}
	public void adminRegister(User user) 
	{
		userdao.adminRegister(user);
	
	}
	
	public boolean validate(Login lg) 
	{
		
		return userdao.validateUser(lg);
	}

	public List<AvailableRooms> getAvailableRooms() {
		
		return userdao.getAvailableRooms();
	}
	public List<BookedData> getbookedrooms() {
		
		return userdao.getbookedrooms();
	}
	
	public List<BookedRooms> getbookedrooms(Login lg)
	{
		logger.info(lg.getUname()+"sent for validation");
		return userdao.getUserRooms(lg);
	}
	public void bookroom(BookModel b) {
		 userdao.bookroom(b);
		
	}
	public List<BookModel> autoselect(BookModel b) 
	{
		return userdao.autoselect(b);
	
		
	}
	public void deleteroom(BookModel b) {
		 userdao.deleteroom(b);
		
	}
	public List<AmountModel> getbill(Login lg) 
	{
		List<BillModel> bill= userdao.getbill(lg);
		
		 SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");  
		
		List<AmountModel> billing= new ArrayList<AmountModel>();
		
	           for(BillModel b:bill) 
	           {
	        	   try {
	            Date date1 = obj.parse(b.getFdate());   
	            Date date2 = obj.parse(b.getTdate());  
	            long time_difference = date2.getTime() - date1.getTime(); 
	            long noOfDays= TimeUnit.MILLISECONDS.toDays(time_difference) % 365; 
	            Integer amt= (int) (noOfDays)*1500;
	        	   
	            AmountModel a= new AmountModel();
		           a.setName(b.getName());
		           a.setFdate(b.getFdate());
		           a.setTdate(b.getTdate());
		           a.setAmount(amt);
		           
		           billing.add(a);
	        	   }
	        	   catch(Exception e)
	        	   {
	        		   System.out.println(e);
	        	   }
	           }
	           
	           
		return billing;
	}
	

	
}
