 package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class ScrollFrame extends JFrame implements ActionListener{

	private JLabel lempno,lename,ljob,lesal;
	private JTextField tempno,tename,tjob,tesal;
	private JButton bfirst,blast,bnext,bprevious;
    private PreparedStatement ps=null;
    private Connection con=null; 
    private ResultSet rs=null;
	public ScrollFrame() {
		System.out.println("constructor");
		setTitle("ScrollFrame");
		setSize(300,300);
		setLayout(new FlowLayout());
		setBackground(Color.GREEN);
		
		// add All Components
		lempno=new JLabel("Emp no");
		add(lempno);
		tempno=new JTextField(10);
		add(tempno);  
		
		lename=new JLabel("Emp name");
		add(lename);
		tename=new JTextField(10);
		add(tename);
		
		ljob=new JLabel("Emp Job");
		add(ljob);
		tjob=new JTextField(10);
		add(tjob);
		
		lesal=new JLabel("Emp sal");
		add(lesal);
		tesal=new JTextField(10);
		add(tesal);
		
		bfirst=new JButton("First");
		add(bfirst);
		bfirst.addActionListener(this);
		
		blast=new JButton("Last");
		add(blast);
		blast.addActionListener(this);
		
		bnext=new JButton("Next");
		add(bnext);
		bnext.addActionListener(this);
		
		bprevious=new JButton("Previous");
		add(bprevious);
		bprevious.addActionListener(this);
		
		
		Makeconnection();
		
		addWindowListener(new MyAdapter());
		
		
		
		setVisible(true);
	}
	
	
	
	
	private void Makeconnection() {
		
		System.out.println("make connection ");
		
		try {
			//register the connection 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			// create preparedstatement object
			if(con!=null)
				ps=con.prepareStatement("select *from emp",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			if(ps!=null)
				rs=ps.executeQuery();	
		}
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}




	public static void main(String[] args) {
		new ScrollFrame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(" actionPerformed");
	
		boolean flag=false;
		try {
			if(e.getSource()==bfirst) {
				System.out.println("first button");
				rs.first();
				flag=true;
			}
			
			else if(e.getSource()==blast) {
				System.out.println("last button");
				rs.last();
				flag=true;
			}
			
			else if(e.getSource()==bnext) {
				System.out.println(" next button ");
				if(!rs.isLast()) {
				rs.next();
				flag=true;
			}
			}
			else {
				System.out.println(" privious button" );
		   if(!rs.isFirst()) {
				rs.previous();
				flag=true;
			}//if
			}//else
				
			//select record valuesto text boxes 
			if(flag==true) {
				tename.setText(rs.getString(2));
				tempno.setText(rs.getString(1));
				tjob.setText(rs.getString(3));
				tesal.setText(rs.getString(4));
				
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e1) {
			e1.printStackTrace();
			
		}
		
		
	}

	private class MyAdapter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windows closing()");
			
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
			
			
		}
	}

}
