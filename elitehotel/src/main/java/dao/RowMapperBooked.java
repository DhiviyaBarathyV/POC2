package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.BookedData;

public class RowMapperBooked implements RowMapper<BookedData> 
{

	@Override
	public BookedData mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		BookedData booked= new BookedData();
		booked.setRoomno(rs.getInt(2));
		booked.setName(rs.getString(1));
		booked.setRoomtype(rs.getString(3));
		booked.setFdate(rs.getString(5));
		booked.setTdate(rs.getString(6));
		
		return booked;
	}

}
