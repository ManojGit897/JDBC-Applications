package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class CsTest2 {
	public static void main(String[] args) throws SQLException{
		   Connection con=null;
		    CallableStatement cs=null;
		   String query=null;
		   Scanner scn=null;
		   int no=0;
		   int result1=0;
		   int result2=0;
	     	try {                            
	     	// read inputs	
			scn=new Scanner(System.in);
			System.out.println("Enter the No");
			no=scn.nextInt();
		
			//scn.nextLine();
				// Establish  the connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
    // prepare sql query calling PL/SQL procedure 
	query="{call empdetails(?,?,?)}";
	
	// create the callableStatement object
	if(con!=null)
		cs=con.prepareCall(query);
	if(cs!=null) {
		// register the out param values 
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.registerOutParameter(3,Types.INTEGER);
	
	// set values IN params
	cs.setInt(1,no); 
	// excecute the PL/SQL procedure 
	cs.execute();
	// gaather the out param value
	
	System.out.println("EmpName "+cs.getString(2));
	System.out.println("EmpName "+cs.getInt(3));
	
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
		      catch(SQLException se) {
		    	  se.printStackTrace();
	                  }
		      try {
			     	if(cs!=null)
					cs.close();
			         }
			      catch(SQLException se) {
			    	  se.printStackTrace();
	                   }
		    
	}
    }
           }

