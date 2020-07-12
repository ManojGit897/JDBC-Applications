package com.nt.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class PSInsertTest {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=null;
		int count=0;
		int no=0;
		String name=null;
		String loc=null;
		Float avg;
		int result=0;
		
		
		
		String query="INSERT INTO STUDENT VALUES(1020,?,?,?)";
		try {
			sc=new Scanner(System.in);
			System.out.println("Enter the number of students registration :");
			count=sc.nextInt();
			for(int i=1;i<=count;i++) {
				System.out.println("Enter the "+i+" registration ");
			//System.out.println("Eneter the student number : ");
			//no=sc.nextInt();
			System.out.println("Enter the Student name :");
			name=sc.next();
			System.out.println("Enetr the student location :"); 
            loc=sc.next();
            System.out.println("Enetr the Student Avg  marks");
            avg=sc.nextFloat();
            
            
            
			
			// register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the Connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// create the preparedstatement object
			if(con!=null)
				ps=con.prepareStatement(query);
			if(ps!=null)
			//	ps.setInt(1,new Random().nextInt());
			    ps.setString(1,name);
			    ps.setString(2,loc);
			    ps.setFloat(3,avg);
			    
			result=ps.executeUpdate();
			if(result==0) {
				System.out.println("Records not insertion ");
			}
			else {
				System.out.println("recods are inserted ");
			}
			}//for	
			
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
		
		
		// finally
		finally {
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally
		
	}

}
