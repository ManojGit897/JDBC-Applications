package com.nt.jdbc;
import java.sql.*;


public class ConnectionEstabish {

	
	
	public static void main(String[] args) throws Exception{
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			*/
			Class.forName("com.mysql.jdbc.Driver");
			// Establish the connection 
	 Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manoj123","root","root");
			
			if(con!=null)
				System.out.println("Connection established ");
			else
				System.out.println("Connetion not established ");
		}
		
		catch(SQLException e) {
		e.printStackTrace();
	}

}
}