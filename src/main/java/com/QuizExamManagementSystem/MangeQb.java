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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.DataBase.QuestionBank;

import javax.swing.SpringLayout;
/*
 * Manage Questions from Question Bank. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 31-12-2023 (update). 
 * */
public class MangeQb {

	public JFrame frame;
	private JTextField Qno;
	public JTable table = null;
	public static String Q ;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MangeQb window = new MangeQb();
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
	public MangeQb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame("Question Bank Manage");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

	    frame.setSize(screenWidth,screenHeight);
		frame.setLocationRelativeTo(null);
	
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(0, 0, 1350, 729);
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Manage Question Bank");
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
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 559, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, 699, SpringLayout.WEST, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamPanel.main(null);
			}
			
		});
	
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 153, 51));
		panel.add(btnNewButton);
		
		Qno = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, Qno, 40, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Qno, 79, SpringLayout.SOUTH, lblNewLabel);
		panel.add(Qno);
		Qno.setColumns(10);
		
		JButton Update = new JButton("Update");
		sl_panel.putConstraint(SpringLayout.EAST, Qno, -28, SpringLayout.WEST, Update);
		sl_panel.putConstraint(SpringLayout.NORTH, Update, 36, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, Update, 919, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, Update, 1059, SpringLayout.WEST, panel);
		Update.setFont(new Font("Tahoma", Font.BOLD, 14));
		Update.setBackground(new Color(102, 204, 0));
		Update.setForeground(SystemColor.text);
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				Qbupd.main(null);

			}

		});
		panel.add(Update);
		
		JLabel lblNewLabel_1 = new JLabel("Question Number :");
		sl_panel.putConstraint(SpringLayout.WEST, Qno, 25, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 72, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 184, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 44, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 25, SpringLayout.WEST, panel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, scrollPane);
		sl_panel.putConstraint(SpringLayout.SOUTH, Update, -75, SpringLayout.NORTH, scrollPane);
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 271, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollPane, 626, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 1264, SpringLayout.WEST, panel);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Question No", "Question", "Option 1", "Option 2", "Option 3", "Option 4", "Answer"
			}
		));
		try {
			QuestionBank.questionDataDisplay();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		JButton Delete = new JButton("Delete");
		sl_panel.putConstraint(SpringLayout.NORTH, Delete, 37, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, Delete, -183, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Delete, -75, SpringLayout.NORTH, scrollPane);
		sl_panel.putConstraint(SpringLayout.EAST, Delete, -43, SpringLayout.EAST, panel);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QuestionBank.questionDataDelete(Integer.parseInt(Qno.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Delete.setForeground(Color.WHITE);
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBackground(new Color(255, 153, 51));
		panel.add(Delete);
		
	}
}