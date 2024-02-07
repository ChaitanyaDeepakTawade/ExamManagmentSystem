package com.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.QuizExamManagementSystem.MangeQb;

/*
 * SQL Login for Manage Questions from Question Bank. 
 * @Author Chaitanya Deepak Tawade. 
 * @Sign JDK-17 04-01-2024 (update). 
 * */
public class QuestionBank{
	
	public static void questionDataDisplay() throws ClassNotFoundException {
		DBConnection.setUpDB();
		String sql ="select*from question";
		ResultSet rs = null;
		try {
			rs = DBConnection.getStmt().executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				String QId=String.valueOf(rs.getInt("QId"));
				String Question=rs.getString("Question");
				String OpA=rs.getString("OpA");
				String OpB=rs.getString("OpB");
				String OpC=rs.getString("OpC");
				String OpD=rs.getString("OpD");
				String Ans=rs.getString("Ans");
				String tdData[]= {QId,Question,OpA,OpB,OpC, OpD,Ans};
                MangeQb objMangeQb = new MangeQb();     
				DefaultTableModel tblModel=(DefaultTableModel)objMangeQb.table.getModel();
				tblModel.addRow(tdData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
    public static void questionDataInsert() {
		
	}
    
    public static void questionDataUpdate() {
		
	}
    
    public static void questionDataDelete(int questionNo) throws ClassNotFoundException {
    	DBConnection.setUpDB();
    	 String sql = "DELETE FROM question WHERE QId ="+questionNo;
		 try {
			 DBConnection.getStmt().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
		 JOptionPane.showMessageDialog(null,"Question Deleted Successfully");
			MangeQb window = new MangeQb();
			window.frame.setVisible(true);
	}
       
}
