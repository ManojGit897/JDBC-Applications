package com.nt.jdbc;
import java.sql.*;
import java.util.*;
public class SensitiveTest {

	public static void main(String[] args){   
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		int count=0;
		try {
            // register the jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
		// Establish the connection 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// prepare the statement object
			 if(con!=null)
				 st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				 // send the execute query 
				query="select sno,sname,sloc,savg from student";
			 rs=st.executeQuery(query);
			 System.out.println("Modify data from sql promt");
			 if(rs!=null)
			 while(rs.next()){
				 if(count==0)
					 Thread.sleep(50000);
				 rs.refreshRow();
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));	
				 count++;
			 }
		}// try
		
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//finally
		
		finally {
			
			try {
				if(con!=null)
					con.close();
		}
			catch(SQLException e) {
				e.printStackTrace();   
			}      
	
			try {
				if(st!=null)
					st.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
				
			try {
				if(rs!=null)
					rs.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

			 