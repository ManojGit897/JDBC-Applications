package com.nt.jdbc;
import java.sql.*;


public class ScrollableTest {

	public static void main(String[] args)  {
		
		Connection con=null;
		Statement st=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		String query=null;
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
		
			// prepare the statement obj 
			if(con!=null)
				ps=con.prepareStatement("select * from emp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			// prepare the query 
			if(ps!=null)
				rs=ps.executeQuery();
			
			if(rs!=null) {
				System.out.println("Top to bottom");
			
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
				}//while
				
				System.out.println("bottom to top");
				while(rs.previous()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
				}
				
			System.out.println("-------------------------------------------------");
               // first record 
			rs.first();
			System.out.println("first record ");
			System.out.println(rs.getRow()+"---> "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
			
			rs.last();
			System.out.println("last");
			System.out.println(rs.getRow()+"---> "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
			
			//3rd record from the top
			rs.absolute(3);
			System.out.println("3rd record from top");
			System.out.println(rs.getRow()+"---> "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
			
			//3rd record from bottom
			System.out.println("3rd record from bottom");
			rs.absolute(-3);
			System.out.println(rs.getRow()+"---> "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
		 
			//relative
			System.out.println("relative +sign");
			rs.relative(2);
			System.out.println(rs.getRow()+"---> "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
			System.out.println("relative -sign");
			rs.relative(-4);
			System.out.println(rs.getRow()+"---> "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));	
			
			
			
		
		
		
		
		
		
		
		
		
		
			}
		
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
