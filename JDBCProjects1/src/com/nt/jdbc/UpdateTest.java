package com.nt.jdbc;
import java.sql.*;


public class UpdateTest {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		int count = 0;
     
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		
			// prepare the statement obj 
			if(con!=null)
				st=con.createStatement();
			// prepare the query 
			if(st!=null)
				// write the query select * from emp;
				//query="create table temp(sno number ,name varchar2(20))";
 			count=st.executeUpdate("create table temp1(sno number(5))");	
			if(count==0) {
			System.out.println("Table not created ");
			}
			else
				System.out.println("Table created..");
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
				
			
		}
	}

}
