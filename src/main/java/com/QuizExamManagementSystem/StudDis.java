package com.QuizExamManagementSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.DataBase.StudentDataManagment;

import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.SpringLayout;
/*
 * Student data display page. 
 * @Author Chaitanya Deepak Tawade.
 * @Sign JDK-17 29-12-2023 (update).  
 * */
public class StudDis {

	private JFrame frame;
	public static JTable table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudDis window = new StudDis();
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
	public StudDis() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Student Data Display");
		
	
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
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 681, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 1264, SpringLayout.WEST, frame.getContentPane());
		panel.setBackground(new Color(47, 79, 79));
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Student Data");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 90, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 131, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, 1261, SpringLayout.WEST, panel);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
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
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Edit Student Information");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudUpd.main(null);
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Student Information");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudDis.main(null);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Delete Student Data");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudDel.main(null);
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
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
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 619, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 578, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, 660, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 770, SpringLayout.WEST, panel);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdminPanel.main(null);
				frame. dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 0));
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 142, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 608, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 1261, SpringLayout.WEST, panel);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBorder(new CompoundBorder(UIManager.getBorder("CheckBoxMenuItem.border"), null));
		table.setBackground(SystemColor.menu);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Roll Number", "Name", "Class", "Division", "Student ID", "Password", "Mobile No", "Address"
			}
		));
			
		try {
			StudentDataManagment.studentDataDisplay();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
