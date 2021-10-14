package players;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class players 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException 
	{  
		try
		{
		String dbUrl = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String pass = "Vdb@1997";
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection(dbUrl, user, pass);
	    String sql="INSERT INTO scores VALUES (?,?,?,?) ";
		PreparedStatement ps=con.prepareStatement(sql); 
		FileReader fr= new FileReader("C:\\Users\\D.Vivekanandhan\\Desktop\\POC\\Cricket_Players.txt");
	    BufferedReader br = new BufferedReader(fr);
	    String line= br.readLine();
	    while(line!=null) 
	    {
	    int i=1;
	    Scanner sc=new Scanner(line);
	    while(sc.hasNext()) 
	    {
	    String tokens=sc.next();
	    System.out.println(tokens);
	      if(i==1) 
	      {
	      ps.setString(i,tokens);	
	      }
	      if(i==2) 
	      {
	      ps.setString(i,tokens);	
	      }
	      if(i==3) 
	      {
	      ps.setString(i,tokens);
	      i++;
	      }
	      if(i==4) 
	      {
	          Scanner in=new Scanner(System.in); 
			  System.out.println("Enter the score for this player:");
	          int score =in.nextInt();
			  ps.setInt(i,score);
			  
	      }
	      if(sc.hasNext()) 
	      {
	      i++;	
	      }
	      
	    }
	    line=br.readLine();
	    int k=0;
	    k=ps.executeUpdate();
	    }
	     
	    System.out.println("Database updated successfully with  records !!!");
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch (SQLException exp)
		{
			System.out.println(exp.getMessage());
		}
		}
		}

