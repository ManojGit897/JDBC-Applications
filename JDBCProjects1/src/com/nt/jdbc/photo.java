package com.nt.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class photo {

	public static void main(String[] args) {
	Scanner sc=null;
	String photopath=null;
	Connection con=null;
	PreparedStatement ps=null;
	File file=null;
	InputStream is=null;
	int result=0;
	
	
	
	
	String query="insert into manu values(?,?)";
	
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
			System.out.println("Enter the photopath :");
			photopath=sc.next();
		}
		file= new File(photopath);
		is=new FileInputStream(file);
		
		
	// register the driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// establish the Connectin 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		// create the prepared Statement obj 
		if(con!=null)
			ps=con.prepareStatement(query);
			//set the sql query param values 
			if(ps!=null)
				ps.setInt(1,101);
			   ps.setBlob(2,is);
			   if(ps!=null)
				result=ps.executeUpdate();
			   if(result==0)
				   System.out.println("record insertion failed");
			   else
				   System.out.println("records inserted ");
	
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

	
		