package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SelectNonselect {

	public static void main(String[] args) throws SQLException{
	   Connection con=null;
	   Statement st=null;
	   ResultSet rs;
	   String query;
	   Scanner scn=null;
	   int no=0;
	   int count=0;
	   boolean flag=false;
     	try {                            
     		
		scn=new Scanner(System.in);
		System.out.println("Enter the sql qyery :");
   query=scn.nextLine();
	
		//scn.nextLine();
			// Establish  the connection
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// create the statement object 
			if(con!=null)
				st=con.createStatement();
			// send and execute the query 
			// delete student where sno=104;
			//query= ("DELETE FROM STUDENT WHERE SNO="+no);
			
			if(st!=null) 
			flag=st.execute(query);
			if(flag==true) {
				System.out.println("Select query is executed  ");
			rs=st.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			}
			else
			{
				System.out.println("Non select query is executed.");
			count=st.getUpdateCount();
			System.out.println("No of records that are effected"+count);
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
				     	if(st!=null)
						st.close();
				         }
				      catch(SQLException se) {
				    	  se.printStackTrace();
		                   }
			      try {
			      if(scn!=null)
					   scn.close();
			      }
			      catch(Exception se) {
			    	  se.printStackTrace();
	                   }
    	}
	    }
               }
