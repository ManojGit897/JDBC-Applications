package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PSBathTest {
	
	public static void main(String[] args){   
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		Connection con=null;
		int result[]=null;
		int total=0;
		try {
			//register the driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the driver
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			
			if(con!=null)
				ps1=con.prepareStatement("insert into student values(?,?,?,?)");
			   ps2=con.prepareStatement("update student set sname='kavitha' where sno=? ");
			// add queries to the batch
			if(ps1!=null&& ps2!=null) {
				ps1.setInt(1,333);
				ps1.setString(2,"kavya");
				ps1.setString(3,"pdtr");
				ps1.setFloat(4,(float) 99.5);
				
				
				
				ps1.addBatch();
				
				ps2.setInt(1,111);
				ps2.addBatch();
			
				
				
		  // execute the batch
			result=ps1.executeBatch();	
			result=ps2.executeBatch();
			}
			if(result!=null) {
			for(int i=0;i<result.length;i++) {
				total=total+result[i];
						 
			}
			System.out.println("No of records are effected "+total); 
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
finally {
			
			try {
				if(con!=null)
					con.close();
		}
			catch(SQLException e) {
				e.printStackTrace();   
			}      
	
			try {
				if(ps1!=null)
					ps1.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(ps2!=null)
					ps2.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
				
			
		}
	
	}//main

}//class
