package com.nt.jdbc;
import java.sql.*;
import java.util.*;

public class SelectTest3 {

	public static void main(String[] args){
		Scanner scn=null;
		String desg1=null;
		String desg2=null;
		String desg3=null;
		boolean flag=false;
		
		Connection con=null;
	Statement st=null;
	String query=null;
	ResultSet rs=null;
	
	
		try {
			scn=new Scanner(System.in);
			if(scn!=null) {
			System.out.println("Enter the desg1 :");
			desg1=scn.nextLine().toUpperCase();
			System.out.println("Enter the desg2 :");
			desg2=scn.nextLine().toUpperCase();
			System.out.println("Enter the desg3 :");
			desg3=scn.nextLine().toUpperCase();
			} 
			String cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the connection 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// prepare the statement object
			 if(con!=null)
				 st=con.createStatement();
				 // send the execute query 
				query="select empno,ename,job,sal from emp where job in"+cond+"order by job";
			 rs=st.executeQuery(query);
			 if(rs!=null)
			 while(rs.next()){
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));	
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

			 // close the objects
			