package com.QuizExamManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.DataBase.StudentDataManagment;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
/*
 * Student Record Delete Page. 
 * @Author Shutdown Deepak Tawade. 
 * @Sign JDK-17 28-12-2023 (update). 
 * */
public class StudDel {

	private JFrame frmDeleteStudentData;
	private JTextField RollNo;
	public static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudDel window = new StudDel();
					window.frmDeleteStudentData.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudDel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmDeleteStudentData = new JFrame("Edit Student Data");
		frmDeleteStudentData.setTitle("Delete Student Data");
		frmDeleteStudentData.setBounds(0, 54, 1350, 675);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		frmDeleteStudentData.setSize(screenWidth,screenHeight);
		frmDeleteStudentData.setLocationRelativeTo(null);
	
		frmDeleteStudentData.setResizable(false);
		frmDeleteStudentData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmDeleteStudentData.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frmDeleteStudentData.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frmDeleteStudentData.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 681, SpringLayout.NORTH, frmDeleteStudentData.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1264, SpringLayout.WEST, frmDeleteStudentData.getContentPane());
		panel.setBackground(new Color(153, 0, 0));
		frmDeleteStudentData.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Delete Student Data");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 76, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 117, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 1264, SpringLayout.WEST, panel);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		sl_panel.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, menuBar, 52, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, menuBar, 1264, SpringLayout.WEST, panel);
		menuBar.setBackground(new Color(255, 153, 51));
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		
		JMenuItem mntmNewMenuItem3 = new JMenuItem("Add Student Information");
		mntmNewMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudUpd.main(null);
			}
		});
		mntmNewMenuItem3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Edit Student Information");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudUpd.main(null);
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
		
	
		
		JButton btnNewButton = new JButton("Back");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 623, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 590, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, 664, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 767, SpringLayout.WEST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPanel.main(null);
				frmDeleteStudentData. dispose();
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 51));
		panel.add(btnNewButton);
		
		RollNo = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, RollNo, 140, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, RollNo, 447, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, RollNo, 181, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, RollNo, 856, SpringLayout.WEST, panel);
		panel.add(RollNo);
		RollNo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Delete");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 138, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton_1, 910, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 179, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton_1, 1077, SpringLayout.WEST, panel);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(0, 51, 255));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String rollno = RollNo.getText();
				
				 
				    
				  int rollno1 =Integer.parseInt(rollno);
				    try {
				    	StudentDataManagment.studentDataDelete(rollno1);
				    	StudDel window = new StudDel();
						window.frmDeleteStudentData.setVisible(true);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   
				
				
			}
		});
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Roll Number :");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 142, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 269, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 170, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 436, SpringLayout.WEST, panel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 214, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 612, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 1247, SpringLayout.WEST, panel);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Roll Number", "Name", "Class", "Division", "Student ID", "Password", "Mobile No", "Address"
				}
			));
		

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
			   
			   String sql ="select*from studinfo";
		
				   
				ResultSet rs = null;
				try {
					rs = st.executeQuery(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
				
			   try {
				while(rs.next()) {
					String RollNumber=String.valueOf(rs.getInt("RollNo"));
					String Name=rs.getString("Name");
					String Class=rs.getString("Class");
					String Division=rs.getString("Divi");
					String StudentId=rs.getString("StudentId");
					String Password=rs.getString("Pass");
					String MobileNo=rs.getString("MobNo");
					String Address=rs.getString("Address");
					
					String tdData[]= {RollNumber,Name,Class,Division,Password,StudentId,MobileNo,Address};
					
					DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					tblModel.addRow(tdData);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
}
