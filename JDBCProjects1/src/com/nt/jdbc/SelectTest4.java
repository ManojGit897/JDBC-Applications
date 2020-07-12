package com.nt.jdbc;
import java.sql.*;


public class SelectTest4 {

	public static void main(String[] args)  {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		
		
		
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
				query="SELECT DEPTNO,ENAME,JOB,SAL FROM EMP WHERE SAL=(SELECT MAX(SAL) FROM EMP)";
			rs=st.executeQuery(query);
			if(rs!=null)
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
					
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
