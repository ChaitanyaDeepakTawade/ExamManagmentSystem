package com.QuizExamManagementSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.DataBase.DBConnection;
import com.DataBase.StudentDataManagment;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpringLayout;
/*
 * New Student data insert page. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 28-12-2023 (update). 
 * */
public class StudData {

	private JFrame frame;
	private JTextField name;
	private JTextField address;
	private JTextField cl;
	private JTextField studid;
	private JTextField rollno;
	private JTextField mob;
	private JTextField pass;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudData window = new StudData();
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
	public StudData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add Student Page");
	
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
		springLayout.putConstraint(SpringLayout.NORTH, panel, 51, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 681, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1264, SpringLayout.WEST, frame.getContentPane());
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add New Student");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 46, 1265, 50);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(70, 172, 104, 35);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Address :");
		lblNewLabel_1_1.setForeground(SystemColor.text);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(70, 272, 104, 35);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Class :");
		lblNewLabel_1_2.setForeground(SystemColor.text);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(70, 372, 104, 35);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Division :");
		lblNewLabel_1_3.setForeground(SystemColor.text);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(684, 370, 104, 35);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Student Id :");
		lblNewLabel_1_4.setForeground(SystemColor.text);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(70, 472, 104, 35);
		panel.add(lblNewLabel_1_4);

		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.BOLD, 16));
		name.setBackground(SystemColor.control);
		name.setBounds(173, 165, 370, 50);
		panel.add(name);
		name.setColumns(10);

		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.BOLD, 16));
		address.setBackground(SystemColor.control);
		address.setColumns(10);
		address.setBounds(173, 265, 370, 50);
		panel.add(address);

		cl = new JTextField();
		cl.setFont(new Font("Tahoma", Font.BOLD, 16));
		cl.setBackground(SystemColor.control);
		cl.setColumns(10);
		cl.setBounds(173, 365, 370, 50);
		panel.add(cl);

		studid = new JTextField();
		studid.setFont(new Font("Tahoma", Font.BOLD, 16));
		studid.setBackground(SystemColor.control);
		studid.setColumns(10);
		studid.setBounds(173, 465, 370, 50);
		panel.add(studid);

		JLabel lblNewLabel_1_5 = new JLabel("Mobile Number :");
		lblNewLabel_1_5.setForeground(SystemColor.text);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_5.setBounds(656, 170, 167, 35);
		panel.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Roll Number :");
		lblNewLabel_1_6.setForeground(SystemColor.text);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_6.setBounds(684, 270, 139, 35);
		panel.add(lblNewLabel_1_6);

		rollno = new JTextField();
		rollno.setEditable(false);
		rollno.setForeground(new Color(255, 0, 0));
		rollno.setText("*Roll Number is system generated");
		rollno.setFont(new Font("Tahoma", Font.ITALIC, 16));
		rollno.setBackground(SystemColor.control);
		rollno.setColumns(10);
		rollno.setBounds(833, 265, 370, 50);
		panel.add(rollno);

		mob = new JTextField();
		mob.setFont(new Font("Tahoma", Font.BOLD, 16));
		mob.setBackground(SystemColor.control);
		mob.setColumns(10);
		mob.setBounds(833, 165, 370, 50);
		panel.add(mob);

		pass = new JTextField();
		pass.setFont(new Font("Tahoma", Font.BOLD, 16));
		pass.setBackground(SystemColor.control);
		pass.setColumns(10);
		pass.setBounds(833, 465, 370, 50);
		panel.add(pass);

		final JComboBox div = new JComboBox();
		div.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
		div.setBounds(833, 367, 370, 50);
		panel.add(div);

		JLabel lblNewLabel_1_3_1 = new JLabel("Password :");
		lblNewLabel_1_3_1.setForeground(SystemColor.text);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3_1.setBounds(684, 470, 158, 35);
		panel.add(lblNewLabel_1_3_1);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(0, 204, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				String Pass = pass.getText();
				String Mob = mob.getText();
				String Stuid = studid.getText();
				String Divi = (String) div.getSelectedItem();
				String Address = address.getText();
				String Clas = cl.getText();
				String Name = name.getText();

				if(pass.getText().length() != 0 && mob.getText().length() != 0 && studid.getText().length()!= 0 && Divi.length()!= 0 && address.getText().length()!= 0 && cl.getText().length()!= 0 && name.getText().length()!= 0  )
				{
					// creating one object 

					StudData obj = new StudData();

					try {
						StudentDataManagment.studentDataAdd(Name,Clas,Address,Divi,Stuid,Mob,Pass);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					StudData window = new StudData();
					window.frame.setVisible(true);

				}

				else {
					JOptionPane.showMessageDialog(null,"Please Enter All Fields");
				}

			}

		});
		btnNewButton.setBounds(600, 555, 147, 50);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame. dispose();
				AdminPanel.main(null);
			
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 0, 51));
		btnNewButton_1.setBounds(382, 555, 147, 50);
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(255, 102, 0));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudData.main(null);
			}
		});
		btnNewButton_1_1.setBounds(821, 555, 147, 50);
		panel.add(btnNewButton_1_1);



		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, menuBar, 1350, SpringLayout.WEST, frame.getContentPane());
		menuBar.setBackground(new Color(255, 153, 0));
		frame.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));

		mnNewMenu.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu);

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

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Delete Student Data");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudDel.main(null);
			}

		});
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_2.setIcon(new ImageIcon("D:\\java\\QuizApp\\img\\cross.png"));
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.main(null);
			}
		});


	}
}
