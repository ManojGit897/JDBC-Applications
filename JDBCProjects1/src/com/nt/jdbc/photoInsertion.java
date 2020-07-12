package com.nt.jdbc;

import java.io.*;

import java.sql.*;

import java.util.*;

public class photoInsertion {

	public static void main(String[] args){
	Connection con=null;
		PreparedStatement ps=null;
		File file=null;
		InputStream is=null;
		
		
		
		String name=null,photopath=null,loc=null;;
		Scanner sc=null;
		int age=0;
		float sal= 0.0f;
		long pno=0,length=0;
		int result=0;
		int no=0;
		
	 try {
		 sc=new Scanner(System.in);
		 
		 if(sc!=null) {
			 
		 System.out.println("Enter the name :");
		 name=sc.next();
		 System.out.println("Enter the age");
		 age=sc.nextInt();
		 System.out.println("Enter the salary");
		 sal=sc.nextFloat();
		 System.out.println("Enter the phone number :");
		 pno=sc.nextLong();
		 System.out.println("enter the photo path :");
         photopath=sc.next();
	 }
		 
		
		 
		 file=new File(photopath);
		// length=file.length();
		 is=new FileInputStream(file);
		 int size=(int) file.length();
		
		 // load the jdbc driver 
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 // estabish the connection
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		 // create the prepared ststement object 
		 if(con!=null)
			 ps=con.prepareStatement("insert into matrimony_profile values(s1.nextval,?,?,?,?,?)");
			 //ps=con.prepareStatement("insert into photo values(?,?,?,?)");
		 //set the values to sql querys
		 if(ps!=null)
			ps.setString(1,name);
		     ps.setInt(2,age);
		     ps.setFloat(3,sal);
		     ps.setLong(4,pno);
		     ps.setBinaryStream(5,is,size);
		     
			/* ps.setInt(1,no);
	     ps.setString(2,name);
	     
	     
	     ps.setString(3,loc);
	     ps.setBinaryStream(4,is);*/
		 // processing the result 
		     if(ps!=null)
		    	 result=ps.executeUpdate();
		     if(result==0)
		    	 System.out.println("Records are not inserted ");
		     else
		    	 System.out.println("records are inserted ");
		 
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

	