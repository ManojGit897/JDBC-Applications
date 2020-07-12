package com.nt.jdbc;
import java.sql.*;
import java.util.*;
public class UpdatableTest {

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
			 
			 if(rs!=null) {
			 while(rs.next()){
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));	
			 }//wlile
	//  update operation
			 rs.absolute(3);
			 rs.updateString(2,"Express");
			 rs.updateRow();
			 System.out.println("3rd record update");
			 rs.moveToInsertRow();
			 rs.updateInt(1,8897);
			 rs.updateInt(4,100);
			 rs.updateString(3,"Nagesulu");
			 rs.insertRow();
			 System.out.println("record inserted");
			 
			 
			 
			 
			 
			 
			 
			 }//if		 
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

			 