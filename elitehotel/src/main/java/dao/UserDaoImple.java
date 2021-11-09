package dao;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.AvailableRooms;
import model.BillModel;
import model.BookModel;
import model.BookedData;
import model.BookedRooms;
import model.Login;
import model.User;


public class UserDaoImple implements UserDao 
{
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Autowired
	public void setDatasource(DataSource datasource) 
	{
		this.jdbctemplate= new JdbcTemplate(datasource);
		
	}


	@Override
	public void register(User user) 
	{
		String sql="insert into details values( '"+user.getfName()+"','"+user.getlName()+"','"+user.getuName()+"','"+user.getpWord()+"','"+user.getDob()+"','"+user.getPhoneNo()+"')";  
		 jdbctemplate.update(sql);

	}
	
	@Override
	public void adminRegister(User user) 
	{
		String sql="insert into admin values( '"+user.getfName()+"','"+user.getlName()+"','"+user.getuName()+"','"+user.getpWord()+"','"+user.getDob()+"','"+user.getPhoneNo()+"')";  
		 jdbctemplate.update(sql);
		
		
	}
	
	
	@Override
	public boolean validateUser(Login lg)
	{
		String user=lg.getUname();
		if(user.endsWith(".dhiviyaelite"))
		{
			String sql="select * from admin where username='"+lg.getUname()+"' and password='"+lg.getPword()+"' ";
			List<Login> logins=	jdbctemplate.query(sql,new RowMapper());
			for(Login l:logins)
			{
				if((l.getUname().equalsIgnoreCase(lg.getUname()))&&(l.getPword().equals(lg.getPword())))
						return true;
			}
		}
		else
		{
		String sql="select * from details where username='"+lg.getUname()+"' and password='"+lg.getPword()+"' "; 
		List<Login> logins=	jdbctemplate.query(sql,new RowMapper());
		for(Login l:logins)
		{
			if((l.getUname().equalsIgnoreCase(lg.getUname()))&&(l.getPword().equals(lg.getPword())))
					return true;
		}
		}
		return false;
		
		
	}


	@Override
	public List<BookedRooms> getUserRooms(Login lg) 
	{
		
		String sql="select * from bookedrooms where username= '"+lg.getUname()+"' ";
		List<BookedRooms> rooms =jdbctemplate.query(sql,new RowMapperRooms());
		
		return rooms;
	
	}


	@Override
	public List<AvailableRooms> getAvailableRooms() 
	{
		String sql="select * from roomdetails";
		List<AvailableRooms> availablerooms = jdbctemplate.query(sql,new RowMapperAvailableRooms());
		return availablerooms;
	}


	@Override
	public List<BookedData> getbookedrooms() {
		String sql="select * from bookedrooms";
		List<BookedData> allrooms = jdbctemplate.query(sql,new RowMapperBooked());
		return allrooms;
		
	}


	@Override
	public void bookroom(BookModel b) 
	{
		String sql="insert into bookedrooms values( '"+b.getUname()+"','"+b.getRoomno()+"','"+b.getRoomtype()+"','"+b.getCapacity()+"','"+b.getFdate()+"','"+b.getTdate()+"','"+b.getPhone()+"')";  
		 jdbctemplate.update(sql);
		
		
	}


	@Override
	public List<BookModel> autoselect(BookModel b) {
		
		String sql= "select * from allroom where roomno='"+b.getRoomno()+"' ";
	 List<BookModel> bookeasy = jdbctemplate.query(sql,new RowMapperBookEasy());
		return bookeasy;
	}


	@Override
	public void deleteroom(BookModel b) 
	{
		String query="delete from roomdetails where roomno='"+b.getRoomno()+"' "; 
	    jdbctemplate.update(query);  
		
	}


	@Override
	public List<BillModel> getbill(Login lg) 
	{
		String sql="select * from bookedrooms where username='"+lg.getUname()+"'";
		List<BillModel> bill = jdbctemplate.query(sql,new RowMapperBill());
		return bill;
	}


}
