package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class DBCapabilities {
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;  
	     java.sql.DatabaseMetaData dbmd=null;
		
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//estabilsh the driver
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//get meta data
			dbmd=con.getMetaData();
			if(dbmd!=null) {
			System.out.println("Database name"+dbmd.getDatabaseProductName());
			System.out.println("Database vsrsion "+dbmd.getDatabaseProductVersion());
			System.out.println("Database major version"+dbmd.getDatabaseMajorVersion());
			System.out.println("Database minor version "+dbmd.getDatabaseMinorVersion());
			
			System.out.println("JDbc driver major version"+dbmd.getDriverMajorVersion());
			System.out.println("Jdbc driver minor version"+dbmd.getDriverMinorVersion());
			System.out.println("Jdbc  major version :"+dbmd.getJDBCMajorVersion());
			System.out.println("jdbc  minor vertion :"+dbmd.getJDBCMinorVersion());
			System.out.println("All Sql key words :"+dbmd.getSQLKeywords());
			System.out.println("All numaric funtions :"+dbmd.getNumericFunctions());
			System.out.println("All system functions"+dbmd.getSystemFunctions());
			System.out.println("All string funtions :"+dbmd.getStringFunctions());
			System.out.println("Max table lengh :"+dbmd.getMaxTableNameLength());
			System.out.println(" Max column name Length :"+dbmd.getMaxColumnNameLength());
		}
		}
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

			 
