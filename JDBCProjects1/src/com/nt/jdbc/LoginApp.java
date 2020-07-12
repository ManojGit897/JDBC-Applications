package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class LoginApp{
public static final String Query="SELECT count(*) from login where username=? and password=?";
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		//String query=null;
		ResultSet rs=null;
		int count=0;
		PreparedStatement ps=null;
		String user=null;
		String pass=null;
		Scanner sc=null;
		
		try {
			sc=new Scanner(System.in);

			System.out.println("enter the username :");
			user=sc.nextLine();
			System.out.println("enter the password :");
			pass=sc.nextLine();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			if(con!=null)
		//		st=con.createStatement();
		ps=con.prepareStatement(Query);
			
			
			if(ps!=null) 
		ps.setString(1,user);
		ps.setString(2,pass);
			if(ps!=null)	
			rs=ps.executeQuery();
		if(ps!=null) {
		rs.next();
		count=rs.getInt(1);
		if(count==1) {
			System.out.println("Login Sucessfully");
			System.out.println("Mr "+user+" Welcome to our world ");}
		else {
			System.out.println(" Mr "+user+"   your entered wrong password");
		System.out.println(" Plese enter the valid password");}
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
		//finally
		
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
				
			try {
				if(rs!=null)
					rs.close();
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	

	}

}
