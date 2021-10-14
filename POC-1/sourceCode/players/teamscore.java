package players;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class teamscore {

	public static void main(String[] args)  
	{
		try
		{
		FileWriter fw= new FileWriter("csk.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String pass = "Vdb@1997";
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection(dbUrl, user, pass);
	    Statement st= con.createStatement();
	    System.out.println("Score of CSK");
	    String sql="select TeamId ,TeamName ,PlayerName, Score from scores WHERE TeamName='CSK' ORDER BY Score ASC";
	    ResultSet rs=st.executeQuery(sql);
	    System.out.println("TeamID"+" "+"TeamName"+" "+"Player"+" "+"Score");
	    while(rs.next())
	    {
	    	
	    	System.out.println(rs.getString(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"   "+rs.getString(4));
	    
	    String joinString=String.join("	",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
	    bw.write(joinString);
	    bw.newLine();
	    bw.flush();
	    }
	    System.out.println("--------------------------------------------------------");
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(SQLException ex) 
		{
			System.out.println(ex.getMessage());
		}
		catch(IOException  exe) 
		{
			System.out.println(exe.getMessage());
		}

	}

}
