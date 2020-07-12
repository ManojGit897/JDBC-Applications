package com.nt.jdbc;

import java.awt.Color;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public  class AllStatements_GUIApplication extends JFrame implements ActionListener {  //implements ActionListener 
	
	private JLabel lno,lname,lm1,lm2,lm3,lres;
	private JTextField tname,tm1,tm2,tm3,tres;
	private JButton bdetails,bresults;
	private JComboBox tno;
	private Connection con;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet r1,r2;
	private CallableStatement cs;
	
	//constrctor 
	public AllStatements_GUIApplication() {
	               
		System.out.println("AllStatements_GUIApplication: 0 param constuctor ");
		setTitle("Mini Project");
		setSize(400,400);
		setLayout(new FlowLayout());
		setBackground(Color.GRAY);
		//add Components
		lno=new JLabel("Student id ");
		add(lno);
		tno=new JComboBox();
		add(tno);
		bdetails=new JButton("Details");
		bdetails.addActionListener(this);
		add(bdetails);
		
	
		lname= new JLabel("Student Name ");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		
		lm1= new JLabel("Marks 1");
		add(lm1);
		tm1=new JTextField(10);
		add(tm1);
		
		lm2= new JLabel("Marks2 ");
		add(lm2);
		tm2=new JTextField(10);
		add(tm2);
		
		lm3= new JLabel("marks3 ");
		add(lm3);
		tm3=new JTextField(10);
		add(tm3);
		
		bresults=new JButton("Result");
		bresults.addActionListener(this);
		add(bresults);
		
		lres= new JLabel("result");
		add(lres);
		tres=new JTextField(10);
		add(tres);
		
		//this.addWindowListener(new MyWindowAdaptor());
		// disable editing of components
		tname.setEditable(false);
		tm1.setEditable(false);
		tm2.setEditable(false);
		tm3.setEditable(false);
		tres.setEditable(false);
		
		
		
		setVisible(true);
		
		
		addWindowListener(new MyAdapter());
	 	MakeConnections();
	 	
	 	
		
	}// constructor 
	
	private void MakeConnections() {
		// TODO Auto-generated method stub
		System.out.println(" Load the items ");
		try {
		// register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create the Statement
			if(con!=null)
			st=con.createStatement();
			//execute the query
			if(st!=null)
			r1=st.executeQuery("select sno from all_Student");
			if(r1!=null)
				while(r1.next()) {
					tno.addItem(r1.getInt(1));
		}//while 
			
			//creating prering ststement object
			if(con!=null)
				ps=con.prepareStatement("select * from all_student where sno=?");
			//create callablestatement 
			if(con!=null) {
				cs=con.prepareCall("{call FIND_PASS_FAIL(?,?,?,?)}");
			   cs.registerOutParameter(4,Types.VARCHAR);
			}  
		
	}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch (ClassNotFoundException cnf) {
			// TODO: handle exception
		cnf.printStackTrace();	
		}

	}//makeconnectins
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllStatements_GUIApplication test=new AllStatements_GUIApplication();
		
	}








	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		int m1=0,m2=0,m3=0;
		String result=null;
		System.out.println("Action performed");
		if(ae.getSource()==bdetails) {
			System.out.println("details button is clicked ");
			try {
				//get the selected value from combobox
				int no=(Integer)tno.getSelectedItem();
				//set value to param query
				if(ps!=null) {
					ps.setInt(1,no);
				// execute the query
				r2=ps.executeQuery();
			}
				//set Resultset object record to textboxes 
				if(r2!=null) {
					if(r2.next()) {
						tname.setText(r2.getString(2));
			            tm1.setText(r2.getString(3));
			            tm2.setText(r2.getString(4));
			            tm3.setText(r2.getString(5));     
				}//if
					
			}//if
			
		}
			catch (SQLException se) {
				se.printStackTrace();
			}
			
			
	}//aeif
		else {
			System.out.println("result button is clicked ");
			m1=Integer.parseInt(tm1.getText());
			m2=Integer.parseInt(tm2.getText());
			m3=Integer.parseInt(tm3.getText());
			
			//set values to n param
			try {
			if(cs!=null) {
				cs.setInt(1,m1);
			cs.setInt(2,m2);
			cs.setInt(3,m3);
			//execute the pl/sql procedure
			cs.execute();
			//gathering the out param value 
			result=cs.getString(4);
			tres.setText(result);
			}
		}
			catch(SQLException se) {
				se.printStackTrace();
			}

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
				
				if(r1!=null)
					r1.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
             
             try {
 				
 				if(r2!=null)
 					r2.close();
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
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}






}
