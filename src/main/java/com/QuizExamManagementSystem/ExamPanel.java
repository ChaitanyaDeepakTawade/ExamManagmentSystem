package com.QuizExamManagementSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
/*
 * Exam Dashboard page. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 31-12-2023 (update). 
 * */
public class ExamPanel {

	private JFrame frmAddExam;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamPanel window = new ExamPanel();
					window.frmAddExam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExamPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddExam = new JFrame();
		frmAddExam.setTitle("Exam Panel");
		frmAddExam.setBounds(100, 100, 450, 300);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenWidth = screenSize.width;
		
		int screenHeight = screenSize.height;
		frmAddExam.setSize(screenWidth,screenHeight);
		frmAddExam.setLocationRelativeTo(null);
		frmAddExam.setResizable(false);
		frmAddExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddExam.getContentPane().setLayout(null);
		panel.setBounds(0, 32, 1264, 649);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		frmAddExam.getContentPane().add(panel);
		
		JButton btnAddEam = new JButton("Add Question Bank");
		btnAddEam.setForeground(Color.WHITE);
		btnAddEam.setIcon(new ImageIcon(ExamPanel.class.getResource("/com/img/qb2.png")));
		btnAddEam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddEam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			AddExam.main(null);
			}
		});
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.WEST, btnAddEam, 480, SpringLayout.WEST, panel);
		panel.setLayout(sl_panel);
		btnAddEam.setBackground(SystemColor.text);
		panel.add(btnAddEam);
		
		JButton btnManageTest = new JButton("Manage Question Bank");
		sl_panel.putConstraint(SpringLayout.WEST, btnManageTest, 874, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnManageTest, -145, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnAddEam, -116, SpringLayout.WEST, btnManageTest);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnManageTest, -203, SpringLayout.SOUTH, panel);
		btnManageTest.setIcon(new ImageIcon(ExamPanel.class.getResource("/com/img/qb.png")));
		btnManageTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MangeQb.main(null);
			}
		});
		btnManageTest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnManageTest.setBackground(Color.WHITE);
		panel.add(btnManageTest);
		
		JLabel lblNewLabel_1 = new JLabel("Add Question Bank");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 524, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -548, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnAddEam, -16, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 462, SpringLayout.NORTH, panel);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1264, 37);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 32, SpringLayout.NORTH, frmAddExam.getContentPane());
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -6, SpringLayout.NORTH, panel);
		frmAddExam.getContentPane().add(panel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, btnManageTest, 226, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAddEam, 226, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 1264, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 300, SpringLayout.WEST, panel);
		panel_2.setBackground(new Color(0, 102, 204));
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 649, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 300, SpringLayout.WEST, panel);
		panel.add(panel_1);
		panel_1.setBackground(new Color(0, 102, 204));
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JSeparator separator = new JSeparator();
		sl_panel_1.putConstraint(SpringLayout.WEST, separator, 13, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, separator, 287, SpringLayout.WEST, panel_1);
		panel_1.add(separator);
		
		JLabel lblNewLabel = new JLabel("Exam Dashboard");
		sl_panel_1.putConstraint(SpringLayout.NORTH, separator, 9, SpringLayout.SOUTH, lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 69, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, 100, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, 300, SpringLayout.WEST, panel_1);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnNewButton);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton, 145, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnNewButton, 213, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton, 300, SpringLayout.WEST, panel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel.main(null);
				
				
			}
		});
		btnNewButton.setSelectedIcon(new ImageIcon("O:\\java assignment\\QuizApp\\img\\cross.png"));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnNewButton.setToolTipText("");
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(51, 102, 204));
		
		JButton ASI = new JButton("Active Student Info ");
		sl_panel_1.putConstraint(SpringLayout.NORTH, ASI, 212, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, ASI, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, ASI, 280, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, ASI, 300, SpringLayout.WEST, panel_1);
		ASI.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		ASI.setBackground(new Color(0, 102, 204));
		panel_1.add(ASI);
		ASI.setForeground(new Color(255, 255, 255));
		
		JButton btnNewButton_1 = new JButton("LogOut");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton_1, 277, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 345, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnNewButton_1, 300, SpringLayout.WEST, panel_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLogin.main(null);
				frmAddExam. dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(0, 102, 204));
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("Manage Question Bank");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, -182, SpringLayout.EAST, panel);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_1_1);
		
		ASI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudDis.main(null);
			}
		});
	}
}
