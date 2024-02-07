package com.QuizExamManagementSystem;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
 * Admin Login Page. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 27-12-2023 (update). 
 * */

public class AdminLogin {

	private JFrame frmAdminLogin;
	private JPasswordField pass;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
 	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAdminLogin = new JFrame("Admin Login");
		//frmAdminLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/img/Admin.png")));
		Toolkit kit = Toolkit.getDefaultToolkit();
	   
		Dimension screenSize=kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		frmAdminLogin.setSize(screenWidth/2,screenHeight/2);
		frmAdminLogin.setLocationRelativeTo(null);
	
		frmAdminLogin.setResizable(false);
		
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmAdminLogin.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frmAdminLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frmAdminLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 321, SpringLayout.NORTH, frmAdminLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 624, SpringLayout.WEST, frmAdminLogin.getContentPane());
		panel.setBackground(Color.WHITE);
		frmAdminLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/img/logo.jpg")));
		lblNewLabel.setBounds(0, 0, 310, 321);
		panel.add(lblNewLabel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon("O:\\java assignment\\QuizApp\\img\\line.png"));
		lblNewLabel_1.setBounds(333, 0, 0, 310);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(333, 128, 61, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password :");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(334, 195, 87, 14);
		panel.add(lblNewLabel_2_1);
		
		pass = new JPasswordField();
		lblNewLabel_2_1.setLabelFor(pass);
		pass.setBounds(420, 189, 178, 30);
		panel.add(pass);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(new Color(255, 51, 51));
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    String Id = id.getText();
			    String Pass = pass.getText();
			   

			    if(Id.equals("Admin") && Pass.equals("admin1234") ) {
			    	
			    	AdminPanel.main(null);
			    	
			    }else {
			    	JOptionPane.showMessageDialog(null,"Invalid Login");
			    }

			}
		});
		btnNewButton.setBounds(420, 230, 178, 30);
		panel.add(btnNewButton);
		
		id = new JTextField();
		id.setToolTipText("");
		lblNewLabel_2.setLabelFor(id);
		id.setBounds(420, 122, 178, 30);
		panel.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ADMIN LOGIN");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(303, 45, 321, 31);
		panel.add(lblNewLabel_3);
		
	}
}
