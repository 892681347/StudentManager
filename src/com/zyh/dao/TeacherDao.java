package com.zyh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyh.model.Info;
import com.zyh.model.Student;
import com.zyh.model.Teacher;
import com.zyh.util.DButil;

public class TeacherDao {
	public static void main(String[] args) {
		TeacherDao teacherDao = new TeacherDao();
//		Teacher teacher = teacherDao.finByAccountAndPwd("lsls", "123456");
//		System.out.println(teacher);
		List<Teacher> list = teacherDao.findTeacherByClass("203");
		System.out.println(list);
	}
	public Teacher finByAccountAndPwd(String account, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DButil.getConnection();
		String sql = "SELECT * FROM teacher WHERE account = ? AND password = ?";
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
				String tclass = rs.getString(5);
				String avatar = rs.getString(6);
				Teacher teacher = new Teacher(id2,username,account2,password2,tclass,avatar);
				return teacher;
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
		String sql = "SELECT * FROM teacherinfo where account=?";
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
	 * 通过班级查找全班老师
	 * @param tclass 当前老师的班级
	 * @return 返回查询到的全班老师信息
	 */
	public List<Teacher> findTeacherByClass(String tclass){
		List<Teacher> list = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM teacher where tclass=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tclass);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				String name = rs.getString(2);
				String account = rs.getString(3);
				String tclass1 = rs.getString(5);
				String avatar = rs.getString(6);
				
				Teacher teacher = new Teacher(name,account,tclass1,avatar);
				list.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
		return list;
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
			String sql = "UPDATE teacher SET avatar=? WHERE account=?";
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
	/**
	 * 添加老师账户
	 * @param name 姓名
	 * @param account 账号
	 * @param password 密码
	 * @param sclass 班级
	 */
	public void addTeacher(String name,String account,String password,String tclass){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备要执行的sql语句
			String sql = "INSERT INTO teacher (name,account,password,tclass) VALUES(?,?,?,?);";
			//获取sql语句的执行器对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, account);
			pstmt.setString(3, password);
			pstmt.setString(4, tclass);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DButil.ConnectionClose(conn, pstmt);
		}
	}
	/**
	 * 在数据库中新增老师的基本信息
	 * @param account 该老师的账号
	 */
	public void addTeacherInfo(String account){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备要执行的sql语句
			String sql = "INSERT INTO teacherinfo (account) VALUES(?);";
			//获取sql语句的执行器对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DButil.ConnectionClose(conn, pstmt);
		}
	}
}
