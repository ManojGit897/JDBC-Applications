package com.nt.jdbc;
import java.sql.*;

public class MysqltSelectTest1{

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con=null;
	Statement st=null;
	String query=null;
	ResultSet rs=null;
	
	//mysql-connctor-java-5.1.c.jar(mvnrepository.com)
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Establish the connection 
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/manoj123","root","root");
			// prepare the statement object
			 if(con!=null)
				 st=con.createStatement();
				 // send the execute query 
				query="select * from manoj";
			 rs=st.executeQuery(query);
			 if(rs!=null)
			 while(rs.next()){
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));	
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

