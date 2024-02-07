package com.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * SQL DataBase Connection Code.
 * @Author Chaitanya Deepak Tawade 
 * @Sign JDK-17 28-12-2023 (update)  
 * */
public class DBConnection {
	private static DBConnection DBConn;
	private static Connection conn = null;
	private static Statement stmt = null;
	
	public DBConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
		
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
	}
	
	public static Statement getStmt() {
		return stmt;
		
	}
	
	public static void setUpDB() throws ClassNotFoundException {
		if(DBConn==null) {
			DBConn = new DBConnection();
		}
	}
	
	public static void ConnectionClose() {
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		conn=null;
	}

}
