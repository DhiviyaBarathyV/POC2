package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.BookedRooms;

public class RowMapperRooms implements RowMapper<BookedRooms> {

	@Override
	public BookedRooms mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookedRooms r= new BookedRooms();
		r.setUsername(rs.getString(1));
		r.setRoomno(rs.getInt(2));
		r.setRoomtype(rs.getString(3));
		r.setCapacity(rs.getString(4));
		r.setFdate(rs.getString(5));
		r.setTdate(rs.getString(6));
		r.setPhoneno(rs.getString(7));
		return r;
	}

}
