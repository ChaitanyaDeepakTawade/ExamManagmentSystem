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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

/*
 * Edit Questions from Question Bank. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 31-12-2023 (update). 
 * */
public class Qbupd {
	private JFrame frame;
	private JTextPane question;
	private JComboBox answer;
	private JTextField A;
	private JTextField C;
	private JTextField D;
	private JTextField B;
	private JTextField Qid;
	
	void add(String que,String a,String b,String c,String d, int ans,int id) throws ClassNotFoundException 
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
		 String sql = "UPDATE question SET Question= '"+que+"' ,OpA ='"+a+"' ,OpB ='"+b+"' ,OpC ='"+c+"' ,OpD ='"+d+"' ,Ans ="+ans+" WHERE QId ="+id+"";
		 try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 JOptionPane.showMessageDialog(null,"Question Number "+id+" Is Updated Sucessfully");
		    frame. dispose();
			Qbupd window = new Qbupd();
			window.frame .setVisible(true);
			
	}
	
	
	
	
     
	public static void main(String args[]) {
		// TODO Auto-generated method stub
	
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qbupd window = new Qbupd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param qid 
	 */
	public Qbupd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		springLayout.putConstraint(SpringLayout.NORTH, panel, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 681, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1264, SpringLayout.WEST, frame.getContentPane());
		panel.setBackground(new Color(51, 51, 51));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("A ");
		lblNewLabel_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(26, 352, 96, 46);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("C");
		lblNewLabel_2_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(18, 443, 96, 46);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("D");
		lblNewLabel_2_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2_2.setBounds(641, 443, 89, 46);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("B");
		lblNewLabel_2_3.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2_3.setBounds(624, 352, 106, 46);
		panel.add(lblNewLabel_2_3);
		
		A = new JTextField();
		A.setFont(new Font("Tahoma", Font.PLAIN, 16));
		A.setBounds(170, 355, 456, 46);
		panel.add(A);
		A.setColumns(10);
		
		C = new JTextField();
		C.setFont(new Font("Tahoma", Font.PLAIN, 16));
		C.setColumns(10);
		C.setBounds(170, 446, 456, 46);
		panel.add(C);
		
		D = new JTextField();
		D.setFont(new Font("Tahoma", Font.PLAIN, 16));
		D.setColumns(10);
		D.setBounds(783, 446, 456, 46);
		panel.add(D);
		
		B = new JTextField();
		B.setFont(new Font("Tahoma", Font.PLAIN, 16));
		B.setColumns(10);
		B.setBounds(783, 352, 456, 46);
		panel.add(B);
		
		JLabel lblNewLabel_3 = new JLabel("Answer :");
		lblNewLabel_3.setForeground(SystemColor.textHighlightText);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(530, 520, 96, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Add Question");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_4.setBounds(0, 11, 1350, 37);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Update Question");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent arg0) {
     
				 Qbupd obj = new Qbupd();
				 int id = Integer.parseInt(Qid.getText());
			     String ques = question.getText();
			     
		         String a = A.getText();
		         String b = B.getText();
		         String c = C.getText();
		         String d = D.getText();

		         int ans=0; 
		         ans= answer.getSelectedIndex(); 
		         
		         
		         if(a.length() != 0 && b.length() != 0 && c.length()!= 0 && d.length()!= 0)
		         {
		        	 if(ans==0)

		        	 {
		        		 ans=1;
		        		 
		        		 try {
		        			 obj.add(ques,a,b,c,d,ans,id);

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
		        			 obj.add(ques,a,b,c,d,ans,id);
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
		        			 obj.add(ques,a,b,c,d,ans,id);
		        		 } catch (ClassNotFoundException e) {
		        			 // TODO Auto-generated catch block
		        			 e.printStackTrace();
		        		 }
		        		 ans= answer.getSelectedIndex(); 
		        	 }
		        	 if(ans==3)
		        	 {
		        		 ans= 4;
		        		 try {
		        			 obj.add(ques,a,b,c,d,ans,id);
		        		 } catch (ClassNotFoundException e) {
		        			 // TODO Auto-generated catch block
		        			 e.printStackTrace();
		        		 }
		        		 ans= answer.getSelectedIndex(); 


		        	 }
		        	 Qid.setText("");
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
		
		
		btnNewButton.setBounds(530, 573, 160, 37);
		panel.add(btnNewButton);
		
		
		 String s1[] = { "A", "B", "C", "D" };
		 
		answer = new JComboBox(s1);
		answer.setSelectedIndex(-1);
	
		answer.setBounds(668, 521, 226, 33);
		panel.add(answer);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				ExamPanel.main(null);
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBackground(new Color(204, 0, 51));
		btnBack.setBounds(734, 572, 160, 37);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(0, 158, 1263, 161);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		question = new JTextPane();
		question.setFont(new Font("Tahoma", Font.PLAIN, 16));
		question.setBounds(219, 28, 1014, 97);
		panel_1.add(question);
		
		JLabel lblQuestion = new JLabel("Question :");
		lblQuestion.setForeground(SystemColor.textHighlightText);
		lblQuestion.setBackground(new Color(255, 255, 255));
		lblQuestion.setBounds(72, 27, 107, 81);
		panel_1.add(lblQuestion);
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel = new JLabel("Question Number :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(110, 89, 190, 28);
		panel.add(lblNewLabel);
		
		Qid = new JTextField();
		Qid.setBounds(341, 80, 652, 46);
		panel.add(Qid);
		Qid.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Serach");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setForeground(SystemColor.textHighlightText);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
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
					   String id1 = Qid.getText();
					   
					   int id=Integer.parseInt(id1);
					  
					  String sql ="SELECT Question, OpA, OpB, OpC, OpD, Ans FROM question Where QId="+id;
						   
						ResultSet rs = null;
						try {
							rs = st.executeQuery(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				
						
					   try {
						while(rs.next()) {
						
							question.setText(rs.getString(1));
							
							A.setText(rs.getString(2));
							
						    B.setText(rs.getString(3));
				
							C.setText(rs.getString(4));
							D.setText(rs.getString(5));
							
						    int a =(rs.getInt(6));	
							
							if(a==1) {
								
								answer.setSelectedIndex(0);
							}if(a==2) {
								
								answer.setSelectedIndex(1);
							}if(a==3) {
								
								answer.setSelectedIndex(2);
							}if(a==4) {
								
								answer.setSelectedIndex(3);
							}
							
							
							
							
						   }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(1050, 87, 147, 37);
		panel.add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, menuBar, 0, SpringLayout.EAST, frame.getContentPane());
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
