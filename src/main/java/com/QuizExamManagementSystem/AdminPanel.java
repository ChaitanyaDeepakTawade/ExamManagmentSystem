package com.QuizExamManagementSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
/*
 * Admin Dashboard page. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 28-12-2023 (update). 
 * */
public class AdminPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
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
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		frame.setSize(screenWidth,screenHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, 36, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, menuBar, 1264, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Logout");
		menuBar.add(mnNewMenu);
		
		JButton AddStudButton = new JButton("Add Student");
		AddStudButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudData.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, AddStudButton, 92, SpringLayout.SOUTH, menuBar);
		AddStudButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/com/img/AddStud.png")));
		frame.getContentPane().add(AddStudButton);
		
		JButton DeleteStudButton = new JButton("Delete Student Data");
		springLayout.putConstraint(SpringLayout.NORTH, DeleteStudButton, 92, SpringLayout.SOUTH, menuBar);
		springLayout.putConstraint(SpringLayout.SOUTH, DeleteStudButton, 0, SpringLayout.SOUTH, AddStudButton);
		springLayout.putConstraint(SpringLayout.EAST, DeleteStudButton, -239, SpringLayout.EAST, frame.getContentPane());
		DeleteStudButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudDel.main(null);
			}
		});
		DeleteStudButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/com/img/DelStud.png")));
		frame.getContentPane().add(DeleteStudButton);
		
		JButton UpdateStudButton = new JButton("Edit Student Information");
		UpdateStudButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudUpd.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, AddStudButton, -283, SpringLayout.WEST, UpdateStudButton);
		springLayout.putConstraint(SpringLayout.NORTH, UpdateStudButton, 92, SpringLayout.SOUTH, menuBar);
		springLayout.putConstraint(SpringLayout.SOUTH, UpdateStudButton, -373, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, AddStudButton, -97, SpringLayout.WEST, UpdateStudButton);
		springLayout.putConstraint(SpringLayout.WEST, UpdateStudButton, 539, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, UpdateStudButton, -539, SpringLayout.EAST, frame.getContentPane());
		UpdateStudButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/com/img/EditStud.png")));
		frame.getContentPane().add(UpdateStudButton);
		
		JButton ExammanagementButton = new JButton("Exam Managment");
		springLayout.putConstraint(SpringLayout.SOUTH, AddStudButton, -69, SpringLayout.NORTH, ExammanagementButton);
		springLayout.putConstraint(SpringLayout.NORTH, ExammanagementButton, 377, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, ExammanagementButton, -118, SpringLayout.SOUTH, frame.getContentPane());
		ExammanagementButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/com/img/AddExam.png")));
		ExammanagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamPanel.main(null);
			}
		});
		frame.getContentPane().add(ExammanagementButton);
		
		JButton ExamResultButton = new JButton("Exam Resulta");
		ExamResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, ExammanagementButton, -283, SpringLayout.WEST, ExamResultButton);
		springLayout.putConstraint(SpringLayout.EAST, ExammanagementButton, -97, SpringLayout.WEST, ExamResultButton);
		springLayout.putConstraint(SpringLayout.NORTH, ExamResultButton, 69, SpringLayout.SOUTH, UpdateStudButton);
		springLayout.putConstraint(SpringLayout.SOUTH, ExamResultButton, -118, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, ExamResultButton, 0, SpringLayout.WEST, UpdateStudButton);
		springLayout.putConstraint(SpringLayout.EAST, ExamResultButton, 0, SpringLayout.EAST, UpdateStudButton);
		ExamResultButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/com/img/Result.png")));
		frame.getContentPane().add(ExamResultButton);
		
		JButton ViewStudDataButton = new JButton("View Student");
		ViewStudDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudDis.main(null);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, DeleteStudButton, 0, SpringLayout.WEST, ViewStudDataButton);
		springLayout.putConstraint(SpringLayout.WEST, ViewStudDataButton, -425, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, ViewStudDataButton, -239, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, ViewStudDataButton, 377, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, ViewStudDataButton, -118, SpringLayout.SOUTH, frame.getContentPane());
		ViewStudDataButton.setIcon(new ImageIcon(AdminPanel.class.getResource("/com/img/ViewStud.png")));
		frame.getContentPane().add(ViewStudDataButton);
	}
}
