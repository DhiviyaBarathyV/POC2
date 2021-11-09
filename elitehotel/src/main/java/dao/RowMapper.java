package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;

public class RowMapper implements org.springframework.jdbc.core.RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login l= new Login();
		l.setUname(rs.getString(3));
		l.setPword(rs.getString(4));
		return l;
	}

}
