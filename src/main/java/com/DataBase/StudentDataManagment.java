package com.DataBase;
/*
 * SQL logic for handle Student data.
 * @Author Chaitanya Deepak Tawade 
 * @Sign JDK-17 29-12-2023 (update)  
 * */
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.QuizExamManagementSystem.StudData;
import com.QuizExamManagementSystem.StudDis;

public class StudentDataManagment {
	//New Student Data insert from studData page to db
	public static void studentDataAdd(String Name,String Clas,String Address,String Divi,String Stuid,String Mob,String Pass) throws ClassNotFoundException {
		DBConnection.setUpDB();
		String sql = "insert into studinfo"+"(`Name`, `Address`, `Class`, `StudentId`, `Pass`, `Divi`, `MobNo`)"+" values('"+Name+"','"+Address+"','"+Clas+"','"+Stuid+"','"+Pass+"','"+Divi+"','"+Mob+"')";
		try {
			DBConnection.getStmt().executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Data Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
	//Student data display from DB
	public static void studentDataDisplay() throws ClassNotFoundException {
		DBConnection.setUpDB();
		String sql ="select*from studinfo";
		String[] StudentData = null;

		ResultSet rs = null;
		try {

			rs = DBConnection.getStmt().executeQuery(sql);
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
				String tdData[]= {RollNumber,Name,Class,Division,StudentId,Password,MobileNo,Address};
				DefaultTableModel tblModel=(DefaultTableModel)StudDis.table.getModel();
				tblModel.addRow(tdData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void studentDataDelete(int RollNo) throws ClassNotFoundException {
		DBConnection.setUpDB();
		String sql = "DELETE FROM StudInfo WHERE RollNo ="+RollNo;
        

		 try {
			 DBConnection.getStmt().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 
		 JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
		
	}
	


}
