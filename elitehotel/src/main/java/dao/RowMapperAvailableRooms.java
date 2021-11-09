package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.AvailableRooms;

public class RowMapperAvailableRooms implements RowMapper<AvailableRooms> 
{

	@Override
	public AvailableRooms mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		AvailableRooms avr=new AvailableRooms();
		avr.setRoomno(rs.getInt(1));
		avr.setRoomtype(rs.getString(2));
		avr.setCapacity(rs.getInt(3));
		return avr;
	}

}
