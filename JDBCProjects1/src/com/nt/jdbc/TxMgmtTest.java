package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest {
	
	public static void main(String[] args){   
		Statement st=null;
		Connection con=null;
		int result[]=null;
		int total=0;
		float amt1=0,accno=0, amt2=0;
		Scanner sc=null;
		 boolean flag=false;
		try {
			sc=new Scanner(System.in);
			System.out.println("enter the  deposite ammt :");
			amt1=sc.nextFloat();
			
			System.out.println("enter the  withdraw ammt :");
			amt2=sc.nextFloat();
			
			//register the driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the driver
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			
			if(con!=null) {
				con.setAutoCommit(false);
				// create the statement object
				st=con.createStatement();
			}
			// add queries to the batch
			if(st!=null) {
			
			    st.addBatch("update bank set balance=balance+"+amt1+" where accno=101");
			    st.addBatch("update bank set balance=balance-"+amt2+" where accno=102");
			    
				 //st.addBatch("update bank set balance=balance+100 where accno=101");
		  // execute the batch
			result=st.executeBatch();	
			}
			if(result!=null) {
			for(int i=0;i<result.length;i++) {
				if(result[i]==0) {
				flag=true;
				break;
				}//if
			}// for loop
			if(flag==true) {
			con.rollback();
			System.out.println(" tx rollback -- money not transfered ");
			}
			else {
				con.commit();
				System.out.println("tx committed ------ money sucessfully transfered..");
			}
						 
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
		
		//tx committed ------ money sucessfully transfered..
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
