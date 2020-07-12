package com.nt.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.mysql.cj.protocol.Resultset;

public class resumeretriving {

	public static void main(String[] args) {
		
		
		Scanner sc=null;
		String photopath=null;
		Connection con=null;
		PreparedStatement ps=null;
		Reader reader=null;
		Writer writer=null;
		int result=0;
		int no=0;
		ResultSet rs=null;
		byte[] buffer=null;
		int bytesRead=0;
		
		String query="select * from matrimony_profile where sno=?";
		
			try {
				sc=new Scanner(System.in);
				if(sc!=null) {
				System.out.println("Enter the sno :");
				no=sc.nextInt();
				
			}
			
			
		// register the driver 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the Connectin 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// create the prepared Statement obj 
			if(con!=null)
				ps=con.prepareStatement(query);
				//set the sql query param values 
				if(ps!=null) {
					ps.setInt(1,no); 
					rs= ps.executeQuery();
				}
				  // process the result sset 
				if(rs.next()) {
				reader=rs.getCharacterStream(4);
				}
				// create the output stream for dest file 
				writer=new FileWriter("E:\\resume.java");
				//write the buffer based logic to copy file content
				if(reader!=null&&writer!=null) {
				/*buffer=new byte[4096];
				while((bytesRead=is.read(buffer))!=-1) {
				os.write(buffer, 0,bytesRead);
			}*/
					IOUtils.copy(reader,writer);
				System.out.println("photo retrived ");
				}	
				}
			catch(SQLException se) {
	        se.printStackTrace();
	        System.out.println("records insretion failed ");
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


