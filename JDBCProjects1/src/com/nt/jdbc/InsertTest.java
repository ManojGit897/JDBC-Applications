package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest {

	public static void main(String[] args) {
		   Statement st=null;
		   Connection con=null;
		   Scanner scn = null;
          int no;
          String sname;
          String loc;
          Float avg;
          String name;
          String sloc;
          String query;
		   int count=0;
		   
		try {
			scn=new Scanner(System.in);
			//System.out.println("Enter the sno :");
			//no=scn.nextInt();
			System.out.println("Enter the student name :");
			sname=scn.next();
			System.out.println("Enter the student location :");
			loc=scn.next();
			System.out.println("Enter the avg marks :");
			avg=scn.nextFloat();
			
			name="'"+sname+"'";
			sloc="'"+loc+"'";
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//nEstablish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// create the statement object
			st=con.createStatement();    
		// send and execute the query
	//  insert into student values (101,'manoj','hyd',90.6);
			query="INSERT INTO STUDENT VALUES(s1.nextval"+","+name+","+sloc+","+avg+")"; 
			
			if(st!=null)
				count=st.executeUpdate(query);
		   if(count==0) {
			   System.out.println(" record insertion failed ");
		   }
		   else
			   System.out.println("record insertion succeded");
		}//try
		
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
       if(scn!=null)
		   scn.close();
			
			
        }// finnaly
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
