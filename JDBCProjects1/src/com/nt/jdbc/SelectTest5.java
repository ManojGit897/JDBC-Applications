package com.nt.jdbc;
import java.sql.*;


public class SelectTest5 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		int count=0;
     
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
				query="SELECT COUNT(*) FROM EMP";
			rs=st.executeQuery(query);
			if(rs!=null)

				while(rs.next()) {
					count=rs.getInt("count(*)");
					System.out.println(rs.getInt(1));   
					
				}
			System.out.println(" recods count :"+count);
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
