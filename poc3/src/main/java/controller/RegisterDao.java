package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	public static int registerUser(RegisterModel users) {
		int val=0;
	try {
		String dbUrl = "jdbc:mysql://localhost:3306/poc";
		String user = "root";
		String pass = "Vdb@1997";
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = null;
    con = DriverManager.getConnection(dbUrl,user,pass);
    String sql="INSERT INTO details VALUES (?,?,?,?,?,?)";
	PreparedStatement ps2=con.prepareStatement(sql); 
	
	ps2.setString(1,users.getfName());
	ps2.setString(2,users.getlName());
	ps2.setString(3,users.getuName());
	ps2.setString(4,users.getpWord());
	ps2.setString(5,users.getDob());
	ps2.setString(6,users.getPhoneNo());
	 val = ps2.executeUpdate(); 
	System.out.println(val+" rows updated");
	con.close();
	
	}catch(SQLException | ClassNotFoundException e) {
		System.out.println("Error: "+e.getMessage());
		
	}
	return val;
	
}
}