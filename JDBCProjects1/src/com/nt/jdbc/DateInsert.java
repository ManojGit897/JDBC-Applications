package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
 
public class DateInsert {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=null;
		int no=0;
		String name=null;
		String dob=null;
		String doj=null;
		java.sql.Date sqldob=null,sqldoj=null;
		java.util.Date udoj=null,udob=null;
	   SimpleDateFormat sdf=null;
	   long ms=0;
	   Connection con=null;
	   PreparedStatement ps=null;
	   int result=0;
	   
	   
		
		try {
			sc=new Scanner(System.in);
			if(sc!= null) {
				System.out.println("Eneter the  student number :");
				no=sc.nextInt();
				System.out.println("Eneter the student name :");
				name=sc.next();
				System.out.println("Enetr the DOB(dd-mm-yyyy) :");
				dob=sc.next();
				System.out.println("Enter the DOJ(yyyy-mm-dd)");
				doj=sc.next();
			}
			//convert the date values to java.sql.Date class objects
			// for DOB
			sdf=new SimpleDateFormat("dd-MM-YYYY");
			if(sdf!=null)
				udob=sdf.parse(dob); // gives util.Date object
			if(udob!=null)
				ms=udob.getTime();
			sqldob=new java.sql.Date(ms);  // gives java.sql.DateClass  object
			
			//sqldob=java.sql.Date.valueOf(dob);
			
			// FOR DOJ  
			
			sqldoj=java.sql.Date.valueOf(doj);
			
			
			// register the jdbc driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection 
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//  create the prepareStatement object 
			if(con!=null)
				ps=con.prepareStatement("insert into student1 values(?,?,?,?)");
			// set the values 
			if(ps!=null) {
				ps.setInt(1, no);
			ps.setString(2,name);
			ps.setDate(3,sqldob);
			ps.setDate(4,sqldoj);
			}
			if(ps!=null)
           result=ps.executeUpdate();
			
			// process the result set
			if(result==0)
				System.out.println("Records are not inserted");
			else
				System.out.println("Records are inserted");	
			} //try
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
				if(ps!=null)
					ps.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
				
			try {
				if(sc!=null)
					sc.close();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}
}