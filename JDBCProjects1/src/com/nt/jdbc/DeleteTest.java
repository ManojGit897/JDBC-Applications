package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DeleteTest {

	public static void main(String[] args) throws SQLException{
	   Connection con=null;
	   Statement st=null;
	   String query;
	   Scanner scn=null;
	   int no=0;
	   int count=0;
     	try {                            
     		
		scn=new Scanner(System.in);
		System.out.println("Enter the no deletion");
		no=scn.nextInt();
	
		//scn.nextLine();
			// Establish  the connection
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// create the statement object 
			if(con!=null)
				st=con.createStatement();
			// send and execute the query 
			// delete student where sno=104;
			query= ("DELETE FROM STUDENT WHERE SNO="+no);
			
			if(st!=null) 
			count=st.executeUpdate(query);
			if(count==0)
				System.out.println("No records deletion ");
			else
				System.out.println(count+": records are deletion ");
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
				     	if(st!=null)
						st.close();
				         }
				      catch(SQLException se) {
				    	  se.printStackTrace();
		                   }
			    
    	}
	    }
               }
