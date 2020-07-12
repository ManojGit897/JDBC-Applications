package com.nt.jdbc;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

import java.util.*;

public class Propstest {

	public static void main(String[] args){
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		Properties props=null;
		InputStream is=null;
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the connection 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// prepare the statement object
			 if(con!=null)
				 st=con.createStatement();
				 // send the execute query 
			is=new FileInputStream("src/com/nt/commons/personalDetails.properties");
			// load the properties files data into java.util.Properties files
			props=new Properties();
			props.load(is);
			System.out.println(" Files Details ..............................");
			System.out.println("props data :"+props);
			System.out.println("name key value "+props.getProperty("name"));
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

			 