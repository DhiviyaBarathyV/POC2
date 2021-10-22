package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AdminRegdao {
	public static int registerAdminUser(RegisterModel users) {
		int val=0;
	try {
		String dbUrl = "jdbc:mysql://localhost:3306/poc";
		String user = "root";
		String pass = "Vdb@1997";
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con1 = null;
    con1 = DriverManager.getConnection(dbUrl,user,pass);
    String sql="INSERT INTO adminreg VALUES (?,?,?,?,?,?)";
	PreparedStatement ps3=con1.prepareStatement(sql); 
	
	ps3.setString(1,users.getfName());
	ps3.setString(2,users.getlName());
	ps3.setString(3,users.getuName());
	ps3.setString(4,users.getpWord());
	ps3.setString(5,users.getDob());
	ps3.setString(6,users.getPhoneNo());
	 val = ps3.executeUpdate(); 
	System.out.println(val+" rows updated");
	con1.close();
	
	}catch(SQLException | ClassNotFoundException e) {
		System.out.println("Error: "+e.getMessage());
		
	}
	return val;
	
}
}