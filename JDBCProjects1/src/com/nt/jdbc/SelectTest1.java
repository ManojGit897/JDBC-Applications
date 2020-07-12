package com.nt.jdbc;
import java.sql.*;

public class SelectTest1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con=null;
	Statement st=null;
	String query=null;
	ResultSet rs=null;
	
	
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the connection 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// prepare the statement object
			 if(con!=null)
				 st=con.createStatement();
				 // send the execute query 
				query="select * from student";
			 rs=st.executeQuery(query);
			 if(rs!=null)
			 while(rs.next()){
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));	
			 }
			 // close the objects
			 rs.close();
			 st.close();
			 con.close();

             }
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}

