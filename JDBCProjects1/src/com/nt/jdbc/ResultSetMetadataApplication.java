package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class ResultSetMetadataApplication {
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;  
		Statement st=null;
		ResultSet rs=null;
	     ResultSetMetaData rsmd=null;
	    int colCount=0;
		
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//estabilsh the driver
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// crate the statement  object
			st=con.createStatement();
			if(st!=null)
			rs=st.executeQuery("select * from student");
			if(rs!=null) {
				//create the Resultsetmetadata
		    rsmd=rs.getMetaData();
		    colCount=rsmd.getColumnCount();
		    //display the column names 
		    for(int i=1;i<=colCount;i++) {
		    	System.out.print(rsmd.getColumnLabel(i)+" ");   
		    }//for
		   System.out.println();
		   //display the col types 
		   for(int i=1;i<=colCount;i++) {
			   System.out.print(rsmd.getColumnTypeName(i)+" ");
			   
		   }
		System.out.println();
		while(rs.next()) {
			for(int i=1;i<=colCount;i++) {
				System.out.print(rs.getString(i)+" ");
			}
			System.out.println();
		}
				
			}//if

		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();                                                                             
		}

finally {
			
			try {
				if(con!=null)
					con.close();
		}
			catch(SQLException e) {
				e.printStackTrace();   
			}      
	
			
		
		}
	}

}

			 
