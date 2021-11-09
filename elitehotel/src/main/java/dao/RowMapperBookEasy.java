package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.BookModel;

public class RowMapperBookEasy implements RowMapper<BookModel>
{

	@Override
	public BookModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookModel b= new BookModel();
		b.setUname(rs.getString(1));
		b.setRoomno(rs.getInt(2));
		b.setRoomtype(rs.getString(3));
		b.setCapacity(rs.getInt(4));
		b.setFdate(rs.getString(5));
		b.setTdate(rs.getString(6));
		return b;
	}

}
