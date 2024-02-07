package com.QuizExamManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpringLayout;
/*
 * Student data update page. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 28-12-2023 (update). 
 * */
public class StudUpd {

	private JFrame frame;
	private JTextField RollNo;
	private JTextField mob;
	private JTextField pass;
	private JTextField studid;
	private JComponent div;
	private JTextField cl;
	private JTextField address;
	private JComponent name;
	private JTextField studname;
	private JTextField txtDiv;
    
	
	void update(int rollno1,String Name,String Clas,String Address,String Divi,String Stuid,String Mob,String Pass) throws ClassNotFoundException {

		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = null;
	     Statement stmt = null;
		   try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/quizapp","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	     try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    String sql="UPDATE studinfo SET Name = '"+Name+"' , Address = '"+Address+"' ,Class ='" +Clas+ "',StudentId='" + Stuid + "',Pass ='" +Pass+ "',Divi ='" +Divi+ "',MobNo ='" +Mob+ "' WHERE RollNo = " + rollno1+" ";
		
	    try {
			 
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
	    
		 JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
		        frame. dispose();
			StudUpd window = new StudUpd();
			window.frame .setVisible(true);
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudUpd window = new StudUpd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudUpd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Edit Student Data");
		frame.setBounds(0, 54, 1350, 675);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		frame.setSize(screenWidth,screenHeight);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 681, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1264, SpringLayout.WEST, frame.getContentPane());
		panel.setBackground(new Color(102, 51, 102));
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Update Student Data");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 76, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 117, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 1264, SpringLayout.WEST, panel);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		

		JLabel lblNewLabel_1 = new JLabel("Name :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 276, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 65, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 311, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 169, SpringLayout.WEST, panel);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 361, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 65, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 396, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 169, SpringLayout.WEST, panel);
		lblNewLabel_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Class :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 437, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 65, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_2, 472, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_2, 169, SpringLayout.WEST, panel);
		lblNewLabel_1_2.setForeground(SystemColor.text);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Division :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3, 361, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_3, 622, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3, 396, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_3, 726, SpringLayout.WEST, panel);
		lblNewLabel_1_3.setForeground(SystemColor.text);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Student Id :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_4, 507, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_4, 65, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_4, 542, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_4, 169, SpringLayout.WEST, panel);
		lblNewLabel_1_4.setForeground(SystemColor.text);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_4);
		
		
		
		address = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, address, 357, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, address, 172, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, address, 402, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, address, 542, SpringLayout.WEST, panel);
		address.setFont(new Font("Tahoma", Font.BOLD, 16));
		address.setBackground(SystemColor.control);
		address.setColumns(10);
		panel.add(address);
		
		cl = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, cl, 433, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, cl, 172, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, cl, 478, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cl, 542, SpringLayout.WEST, panel);
		cl.setFont(new Font("Tahoma", Font.BOLD, 16));
		cl.setBackground(SystemColor.control);
		cl.setColumns(10);
		panel.add(cl);
		
	
		
		studid = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, studid, 507, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, studid, 172, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, studid, 552, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, studid, 542, SpringLayout.WEST, panel);
		studid.setFont(new Font("Tahoma", Font.BOLD, 16));
		studid.setBackground(SystemColor.control);
		studid.setColumns(10);
		panel.add(studid);
		
		JLabel lblNewLabel_1_5 = new JLabel("Roll Number :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_5, 160, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_5, 283, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_5, 195, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_5, 422, SpringLayout.WEST, panel);
		lblNewLabel_1_5.setForeground(SystemColor.text);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_5);
		
		mob = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, mob, 272, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, mob, 746, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, mob, 317, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, mob, 1116, SpringLayout.WEST, panel);
		mob.setFont(new Font("Tahoma", Font.BOLD, 16));
		mob.setBackground(SystemColor.control);
		mob.setColumns(10);
		panel.add(mob);
		
		pass = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, pass, 433, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, pass, 746, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, pass, 478, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, pass, 1116, SpringLayout.WEST, panel);
		pass.setFont(new Font("Tahoma", Font.BOLD, 16));
		pass.setBackground(SystemColor.control);
		pass.setColumns(10);
		panel.add(pass);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Password :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3_1, 437, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_3_1, 622, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3_1, 472, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_3_1, 726, SpringLayout.WEST, panel);
		lblNewLabel_1_3_1.setForeground(SystemColor.text);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_3_1);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		sl_panel.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, menuBar, 52, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, menuBar, 1264, SpringLayout.WEST, panel);
		menuBar.setBackground(new Color(255, 153, 0));
		panel.add(menuBar);
		
		
		
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem3 = new JMenuItem("Add Student Information");
		mntmNewMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudData.main(null);
			}
		});
		mntmNewMenuItem3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Delete Student Information");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudDel.main(null);
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("View Student Information");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudDis.main(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
	
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_2.setIcon(new ImageIcon("O:\\java assignment\\QuizApp\\img\\cross.png"));
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.main(null);
			}
		});
		
		
		JButton btnNewButton = new JButton("Update");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 613, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 580, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, 658, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 760, SpringLayout.WEST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String Pass = pass.getText();
		         String Mob = mob.getText();
		         String Stuid = studid.getText();
		         String Divi = txtDiv.getText();
		         String Address = address.getText();
		         String Clas = cl.getText();
		         String Name = studname.getText();
		         String rollno = RollNo.getText();
					
		         if(pass.getText().length() != 0 && mob.getText().length() != 0 && studid.getText().length()!= 0 && txtDiv.getText().length()!= 0 && address.getText().length()!= 0 && cl.getText().length()!= 0 && studname.getText().length()!= 0  ){
						
				  StudUpd obj = new StudUpd();
				    
				  int rollno1 =Integer.parseInt(rollno);
				
				  try {
					obj.update(rollno1,Name,Clas,Address,Divi,Stuid,Mob,Pass);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                }
		         
		         else {
		        	 JOptionPane.showMessageDialog(null,"Please Enter All Fields");
		         }
		
		       
					// creating one object 
		        
			    
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 204, 0));
		panel.add(btnNewButton);
		
		RollNo = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, RollNo, 160, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, RollNo, 432, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, RollNo, 201, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, RollNo, 841, SpringLayout.WEST, panel);
		panel.add(RollNo);
		RollNo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 613, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 362, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 658, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, 542, SpringLayout.WEST, panel);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 0, 51));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel.main(null);
				frame. dispose();
			}
		});
		panel.add(btnNewButton_1);
		

		
		JButton btnReset = new JButton("Reset");
		sl_panel.putConstraint(SpringLayout.NORTH, btnReset, 613, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnReset, 797, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnReset, 658, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnReset, 977, SpringLayout.WEST, panel);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudUpd window = new StudUpd();
				window.frame.setVisible(true);
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBackground(new Color(255, 153, 51));
		panel.add(btnReset);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Mobile No :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_3_2, 276, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_3_2, 622, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_3_2, 311, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_3_2, 726, SpringLayout.WEST, panel);
		lblNewLabel_1_3_2.setForeground(Color.WHITE);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_3_2);
		
		studname = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, studname, 272, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, studname, 172, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, studname, 324, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, studname, 542, SpringLayout.WEST, panel);
		studname.setFont(new Font("Tahoma", Font.BOLD, 16));
		studname.setColumns(10);
		studname.setBackground(SystemColor.menu);
		panel.add(studname);
		
		txtDiv = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtDiv, 357, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtDiv, 746, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtDiv, 402, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtDiv, 1116, SpringLayout.WEST, panel);
		txtDiv.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDiv.setColumns(10);
		txtDiv.setBackground(SystemColor.menu);
		panel.add(txtDiv);
		
		JButton btnNewButton_1_1 = new JButton("Search");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 158, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 895, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1_1, 199, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1_1, 1072, SpringLayout.WEST, panel);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 Connection conn = null;
				     Statement st = null;
					   try {
						conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/quizapp","root","");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					   try {
						st = (Statement) conn.createStatement();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					   String rollno = RollNo.getText();
					   String sql ="select Name , Address, Class, StudentId, Pass, Divi, MobNo FROM studinfo Where RollNo="+rollno;
				
						   
						ResultSet rs = null;
						try {
							rs = st.executeQuery(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				
						
					   try {
						while(rs.next()) {
						
							studname.setText(rs.getString(1));
							
							address.setText(rs.getString(2));
							
							cl.setText(rs.getString(3));
				
							studid.setText(rs.getString(4));
							pass.setText(rs.getString(5));
							txtDiv.setText(rs.getString(6));
						    mob.setText(rs.getString(7));
						    
						   }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
			
			
			
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBackground(SystemColor.textHighlight);
		panel.add(btnNewButton_1_1);
	}
}
