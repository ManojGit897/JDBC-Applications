package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessTest {
	
	public static void main(String[] args){   
		Statement st=null;
		Connection con=null;
		int result[]=null;
		int total=0;
		try {
			//register the driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the driver
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			
			if(con!=null)
				st=con.createStatement();
			// add queries to the batch
			if(st!=null) {
				st.addBatch("insert into student values(100,'manuu','bag',50.6)");
			    st.addBatch("update student set sname='kumar' where sno=101");
			    st.addBatch("delete from student where sno=1001");
		  // execute the batch
			result=st.executeBatch();	
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
				if(st!=null)
					st.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
				
			
		}
	
	}//main

}//class
