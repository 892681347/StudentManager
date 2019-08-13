package com.zyh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zyh.model.Admin;
import com.zyh.model.Info;
import com.zyh.util.DButil;;

public class AdminDao {
	public static void main(String[] args) {
		AdminDao adminDao = new AdminDao();
		Admin admin= adminDao.finByAccountAndPwd("zyh","123456");
		System.out.println(admin);
	}
	/**
	 * 通过账户和密码查找用户 用于登录
	 * @param account
	 * @param password
	 * @return
	 */
	public Admin finByAccountAndPwd(String account, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DButil.getConnection();
		String sql = "SELECT * FROM admin WHERE account = ? AND password = ?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				int id2 = rs.getInt (1);
				String username = rs.getString(2);
				String account2 = rs.getString(3);
				String password2 = rs.getString(4);
				String avatar = rs.getString(5);
				Admin admin = new Admin(id2,username,account2,password2,avatar);
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
		return null;
	}
	public Info findByid(String account){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM admininfo where account=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				String sex = rs.getString(2);
				String  bloodType = rs.getString(3);
				String age = rs.getString(4);
				String site = rs.getString(5);
				String qq = rs.getString(6);
				String constellation = rs.getString(7);
				String interest = rs.getString(8);				
				Info info = new Info(sex,bloodType,age,site,qq,constellation,interest);
				return info;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
		return null;
	}
	/**
	 * 修改数据库中的头像路径
	 * @param avatarPath 头像路径
	 * @param account 用户的账号
	 */
	public void modifyAvatar(String avatarPath,String account){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DButil.getConnection();
			String sql = "UPDATE admin SET avatar=? WHERE account=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, avatarPath);
			pstmt.setString(2, account);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
	}
	
}
