package com.nt.jdbc;
import java.sql.*;

import java.util.*;

public class SelectTest2 {

	public static void main(String[] args){
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		try {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the name :");
		int  no=scn.nextInt();
		scn.nextLine();
		//no="'"+no+"'";
		
		
		

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the connection 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// prepare the statement object
			 if(con!=null)
				 st=con.createStatement();
				 // send the execute query 
				query="select * from emp where deptno="+"no";
			 rs=st.executeQuery(query);
			 if(rs!=null)
			 while(rs.next()){
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));	
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

			 