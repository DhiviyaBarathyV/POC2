package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.BillModel;

public class RowMapperBill implements RowMapper<BillModel>
{

	@Override
	public BillModel mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		BillModel b=new BillModel();
		b.setName(rs.getString(1));
		b.setFdate(rs.getString(5));
		b.setTdate(rs.getString(6));
		return b;
	}

}
