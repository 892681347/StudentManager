package com.zyh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DButil {
	/**
	 * 加载驱动并且获取连接数据库的对象
	 * @return 返回conn连接数据库对象
	 */
	public static Connection getConnection(){
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement?serverTimezone=UTC&characterEncoding=utf-8", "root", "x5");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	/**
	 * 关闭连接好的数据库对象和执行器对象
	 * @param conn 连接对象
	 * @param pstmt 执行器对象
	 */
	public static void ConnectionClose(Connection conn,PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
