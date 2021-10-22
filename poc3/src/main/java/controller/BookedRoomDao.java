package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookedRoomDao {
	public static int bookUser(BookedRoomModel book) {
		int val=0;
		int vals=0;
	try {
		String dbUrl = "jdbc:mysql://localhost:3306/poc";
		String user = "root";
		String pass = "Vdb@1997";
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = null;
    con = DriverManager.getConnection(dbUrl,user,pass);
    
    String sql="INSERT INTO bookedrooms VALUES (?,?,?,?,?,?,?,?)";
    String sql1="DELETE FROM roomdetails WHERE RoomNo=?";
	PreparedStatement ps=con.prepareStatement(sql); 
	PreparedStatement ps1=con.prepareStatement(sql1); 
	ps.setString(1,book.getUsername());
	ps.setInt(2,book.getRoomno());
	ps.setString(3,book.getRoomtype());
	ps.setInt(4,book.getCapacity());
	ps.setString(5,book.getFromD());
	ps.setString(6,book.getToDa());
	ps.setString(7,book.getPhone());
	ps.setString(8,"");
	
	ps1.setInt(1,book.getRoomno());
			
	 val = ps.executeUpdate(); 
	 vals=ps1.executeUpdate(); 
	System.out.println(val+" rows updated");
	System.out.println(vals+" rows updated");
	con.close();
	
	}catch(SQLException | ClassNotFoundException e) {
		System.out.println("Error: "+e.getMessage());
		
	}
	return val;
	
}

}
