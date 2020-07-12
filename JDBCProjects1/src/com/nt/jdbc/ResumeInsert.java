package com.nt.jdbc;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ResumeInsert {
 //  public static private String query="insert into jobportal values(101,?,?,?)";
   
	

	public static void main(String[] args) {
		Scanner sc=null;
        String name=null,qlfy=null,resumepath=null;
        File file=null;
        Reader reader=null;
        long length=0;
        String query=null;
        Connection con=null;
        PreparedStatement ps=null;
        int result =0;
        
        
        
		
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter the name");
				name=sc.next();
				System.out.println("Enter the qualification ");
				qlfy=sc.next();
				System.out.println("Enter the resume path :");
				resumepath=sc.next();//C:\\Users\\nmano\\OneDrive\Desktop\\manojresume.docx
			}
				file=new File(resumepath);
				reader=new FileReader(file);
				length=file.length();
				query="insert into jobportal values(s1.nextval,?,?,?)";
				
				// register the driver 
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//establish connectonion 
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
				if(con!=null)
					ps=con.prepareStatement(query);
				//
				if(ps!=null)
					ps.setString(1,name);
				ps.setString(2,qlfy);
				ps.setCharacterStream(3,reader,length);
				if(ps!=null)
					result=ps.executeUpdate();
				if(result==0)
					System.out.println("insertion failed ");
				else 
					System.out.println("records are inserted  :");
		
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

		
	