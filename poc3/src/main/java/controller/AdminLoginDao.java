package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminLoginDao {
	public static int LoginSuccess(LoginModel login) 
	{
	int val=1;
	try 
	{
		String dbUrl = "jdbc:mysql://localhost:3306/poc";
		String user = "root";
		String pass = "Vdb@1997";
		
	Connection conn = null;
	Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(dbUrl, user, pass);
    Statement st = conn.createStatement();
	ResultSet rs=st.executeQuery("select * from adminreg"); 
	
	while(rs.next()) 
	{
		
	if((login.getUserName().equalsIgnoreCase(rs.getString(3)))&&(login.getPassWord().equals((rs.getString(4)))))
	{	
	 val++;
	
	}
	}
	conn.close();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	return val;
	}

}
