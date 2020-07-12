/**
 * 
 */
package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public  class GUIFrontEndApp extends JFrame implements ActionListener {

	private static final String query ="insert into student values(s1.nextval,?,?,?)";
	private JLabel lno,lname,laddrs,lavg,lreg;
	private JTextField tname,taddrs,tavg;
	private JButton binsert;
	private Connection con;
	private PreparedStatement ps;
	
	public GUIFrontEndApp() {
		System.out.println("0-param constutor");
		// super class methods invoked in sub class directly
		setTitle("GUIFrontApp");
		setBackground(Color.GRAY);
		setLayout(new FlowLayout());
		setSize(400,400);
		
		// add components 
		
		lname=new JLabel("Student Name ");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		
		laddrs=new JLabel("Student addrs ");
		add(laddrs);
		taddrs=new JTextField(10);
		add(taddrs);
		
		lavg=new JLabel("Student avg marks ");
		add(lavg);
		tavg=new JTextField(10);
		add(tavg);
		
		binsert=new JButton("insert");
		add(binsert);
		
		// register the actionEvent  lisners on button component 
		binsert.addActionListener(this);
		lreg=new JLabel();
		lreg.setForeground(Color.red);
		add(lreg);
		
		// register the WindowLisners for the name
		
		addWindowListener(new MyAdapter());
		//close frame window  when (x) button is clicked 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set visible
		setVisible(true);
		makeConnection();
		
	}  //constuctor
		
	private void makeConnection() {
		// TODO Auto-generated method stub
		System.out.println("makeConnection() method ");
		
		try {
			// create jdbc connection 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create the statement object
			if(con!=null)
				ps=con.prepareStatement(query);
		}// try
		catch(SQLException se) {
			System.out.println("registratio failed ");
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("GUIFrontApp:ActionPerformed(-)");
		String name=null,addr=null;
		Float avgs=null;
		int result=0;
		try{
			// read from data/text boxes data
			name=tname.getText();
			addr=taddrs.getText();
			avgs=Float.parseFloat(tavg.getText());
			//set values query param
			ps.setString(1,name);
			ps.setString(2,addr);
			ps.setFloat(3,avgs);
			// execute the query 
			result=ps.executeUpdate();
			if(result==0) {
			lreg.setText(" student registration failed");
				//System.out.println("registration failed ");
			}
			
			
			else
				lreg.setText(" student registration Done");
				//System.out.println("Registration sucessfull");
		}//try
		catch(SQLException se) {
			lreg.setText(" student registration failed");
			se.printStackTrace();
		
		}

	}

public static void main(String[] args) {
	System.out.println("main method start");
	new GUIFrontEndApp();
	System.out.println("0-param constructor ");
	System.out.println("main method end");
}
	// TODO Auto-generated method stub

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



}// main
