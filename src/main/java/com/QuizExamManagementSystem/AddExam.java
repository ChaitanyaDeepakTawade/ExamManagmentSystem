package com.QuizExamManagementSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.SpringLayout;
/*
 * Add New Question Page. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 31-12-2023 (update). 
 * */
public class AddExam {

	private JFrame frame;
	private JTextField A;
	private JTextField C;
	private JTextField D;
	private JTextField B;
	private JComboBox answer;
	private JTextPane question;
	

   	void add(String que,String a,String b,String c,String d, int ans) throws ClassNotFoundException 
	{
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
		 String sql = "insert into question"+"(`Question`, `OpA`, `OpB`, `OpC`, `OpD`, `Ans`)"+" values('"+que+"','"+a+"','"+b+"','"+c+"','"+d+"',"+ans+")";
		 try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
		 JOptionPane.showMessageDialog(null,"Data Inserted");
			
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddExam window = new AddExam();
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
	public AddExam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("O:\\java assignment\\QuizApp\\img\\exam_sheet_test_school_study_icon_209289.png"));
		frame.setBounds(100, 100, 450, 300);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth = screenSize.width;
		
		int screenHeight = screenSize.height;
		frame.setSize(screenWidth,screenHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1264, SpringLayout.WEST, frame.getContentPane());
		panel.setBackground(new Color(51, 51, 51));
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel_2 = new JLabel("A ");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 121, SpringLayout.WEST, panel);
		lblNewLabel_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("C");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 68, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_1, 10, SpringLayout.WEST, panel);
		lblNewLabel_2_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("D");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_2, 3, SpringLayout.NORTH, lblNewLabel_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_2, 688, SpringLayout.WEST, panel);
		lblNewLabel_2_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("B");
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_2, 0, SpringLayout.EAST, lblNewLabel_2_3);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2_3, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_3, 754, SpringLayout.WEST, panel);
		lblNewLabel_2_3.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel_2_3);
		
		A = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2_3, 88, SpringLayout.EAST, A);
		sl_panel.putConstraint(SpringLayout.WEST, A, 64, SpringLayout.EAST, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.EAST, A, 555, SpringLayout.WEST, panel);
		panel.add(A);
		A.setColumns(10);
		
		C = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, C, 430, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, A, -54, SpringLayout.NORTH, C);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -70, SpringLayout.WEST, C);
		sl_panel.putConstraint(SpringLayout.WEST, C, 185, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, C, -133, SpringLayout.WEST, lblNewLabel_2_2);
		C.setColumns(10);
		panel.add(C);
		
		D = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, D, -3, SpringLayout.NORTH, lblNewLabel_2_1);
		sl_panel.putConstraint(SpringLayout.WEST, D, 825, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, D, 470, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, D, -69, SpringLayout.EAST, panel);
		D.setColumns(10);
		panel.add(D);
		
		B = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, B, 0, SpringLayout.NORTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.WEST, B, 71, SpringLayout.EAST, lblNewLabel_2_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, B, 0, SpringLayout.SOUTH, A);
		sl_panel.putConstraint(SpringLayout.EAST, B, -69, SpringLayout.EAST, panel);
		B.setColumns(10);
		panel.add(B);
		
		JLabel lblNewLabel_3 = new JLabel("Answer :");
		sl_panel.putConstraint(SpringLayout.SOUTH, C, -34, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 504, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 612, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 501, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 538, SpringLayout.NORTH, panel);
		lblNewLabel_3.setForeground(SystemColor.textHighlightText);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add Question");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 27, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_4, 1264, SpringLayout.WEST, panel);
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Add Question");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 518, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -20, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -594, SpringLayout.EAST, panel);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
		

		

			public void actionPerformed(ActionEvent arg0) {
				 AddExam obj = new AddExam();
			     String ques = question.getText();
			     
		         String a = A.getText();
		         String b = B.getText();
		         String c = C.getText();
		         String d = D.getText();
		         
		         
		         int ans=0; 
		         ans= answer.getSelectedIndex(); 
		         
		         
		         if(A.getText().length() != 0 && B.getText().length() != 0 && C.getText().length()!= 0 && D.getText().length()!= 0)
		         {
		         if(ans==0)
		        	 
		            {
		               ans=1;
		               try {
						obj.add(ques,a,b,c,d,ans);
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						 
					}
		               ans= answer.getSelectedIndex(); 
		            }
		            if(ans==1)
		            {
		            	ans=2;
		            	  try {
								obj.add(ques,a,b,c,d,ans);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		            	  ans= answer.getSelectedIndex(); 
		            }
		            if(ans==2)
		            {
		            	ans=3;
		            	  try {
								obj.add(ques,a,b,c,d,ans);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		            	  ans= answer.getSelectedIndex(); 
		            }
		            if(ans==3)
		            {
		            	ans=4;
		            	  try {
								obj.add(ques,a,b,c,d,ans);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		            	  ans= answer.getSelectedIndex(); 
		            	  
		            	  
		            }
		            question.setText("");
  		            A.setText("");
  		            B.setText("");	           
  		            C.setText("");
  		            D.setText("");
  		          answer.setSelectedItem("A");
  		          
		         }else {
		        	 
		        	 JOptionPane.showMessageDialog(null,"Please Enter All Fields ");
		        	 
		         }  
		            
	
   			}
			
			
			
			
		});
		panel.add(btnNewButton);
		
		
		 String s1[] = { "A", "B", "C", "D" };
		 
		answer = new JComboBox(s1);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 22, SpringLayout.SOUTH, answer);
		sl_panel.putConstraint(SpringLayout.NORTH, answer, -128, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, answer, 643, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, answer, -82, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, answer, 837, SpringLayout.WEST, panel);
		panel.add(answer);
		
		JButton btnBack = new JButton("Back");
		sl_panel.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.WEST, btnBack, 42, SpringLayout.EAST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnBack, 0, SpringLayout.SOUTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnBack, -400, SpringLayout.EAST, panel);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExamPanel.main(null);
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(new Color(204, 0, 51));
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, A, 80, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 80, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 85, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 256, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 1264, SpringLayout.WEST, panel);
		panel_1.setBackground(new Color(255, 153, 0));
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		question = new JTextPane();
		sl_panel_1.putConstraint(SpringLayout.NORTH, question, 37, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, question, 262, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, question, 134, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, question, 1216, SpringLayout.WEST, panel_1);
		panel_1.add(question);
		
		JLabel lblQuestion = new JLabel("Question :");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblQuestion, 48, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblQuestion, 76, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblQuestion, 129, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblQuestion, 231, SpringLayout.WEST, panel_1);
		lblQuestion.setForeground(SystemColor.textHighlightText);
		lblQuestion.setBackground(new Color(255, 255, 255));
		panel_1.add(lblQuestion);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.SOUTH, menuBar);
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, menuBar, 0, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frame.getContentPane());
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.setBackground(new Color(255, 153, 0));
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.setForeground(SystemColor.textHighlightText);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setIcon(new ImageIcon("O:\\java assignment\\QuizApp\\img\\cross.png"));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
	}
}
