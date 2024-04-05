package org.myeongdong.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class MySQLDB implements SqlLang {
	final static String DRIVER = "org.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/kh";
	final static String USERID = "system";
	final static String USERPW = "1234";
	
	Connection  con = null;
	
	public Connection Connect() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e1) {
				e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(URL,USERID,USERPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(Connection con, PreparedStatement pstmt, Resultset rs) {
		if(rs != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
