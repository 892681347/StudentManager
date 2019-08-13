package com.zyh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyh.model.Admin;
import com.zyh.model.Course;
import com.zyh.model.Info;
import com.zyh.model.Student;
import com.zyh.model.Teacher;
import com.zyh.util.DButil;

public class StudentDao {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
//		Student student = studentDao.finByAccountAndPwd("zstx", "123456");
//		System.out.println(student);
		List<Student> list = studentDao.findStudentByClass("203");
		System.out.println(list);
	}
	public Student finByAccountAndPwd(String account, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM student WHERE account = ? AND password = ?";
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
				String sclass = rs.getString(5);
				String avatar = rs.getString(6);
				Student student = new Student(id2,username,account2,password2,sclass,avatar);
				return student;
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
		String sql = "SELECT * FROM studentinfo where account=?";
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
	 * 通过班级查找全班同学
	 * @param sclass 当前同学的班级
	 * @return 返回查询到的全班同学信息
	 */
	public List<Student> findStudentByClass(String sclass){
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM student where sclass=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sclass);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				String name = rs.getString(2);
				String account = rs.getString(3);
				String sclass1 = rs.getString(5);
				String avatar = rs.getString(6);
				
				Student student = new Student(name,account,sclass1,avatar);
				list.add(student);
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
			String sql = "UPDATE student SET avatar=? WHERE account=?";
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
	 * 查询所有可选课程
	 * @return 返回课程的List<String>
	 */
	public List<String> queryAllSubjects(){
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT courseName FROM courses";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				String course = rs.getString(1);
				list.add(course);
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
	 * 通过一个学生的account和他所选课程的集合，将所选课程录入数据库
	 * @param account 学生学号
	 * @param subjects 课程集合
	 */
	public void saveSubject(String account,List<String> subjects){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备要执行的sql语句
			String sql = "INSERT INTO studentcourse (account,courseName) VALUES(?,?);";
			//获取sql语句的执行器对象
			for(String subject:subjects){
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, account);
				pstmt.setString(2, subject);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DButil.ConnectionClose(conn, pstmt);
		}
	}
	/**
	 * 删除学号为account的同学选的所有课程
	 * @param account 该同学的学号（账号）
	 */
	public void removeSubject(String account){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备sql语句
			String sql = "DELETE FROM studentcourse WHERE account=?";
			//获取sql语句执行器对象
			pstmt = conn.prepareStatement(sql);
			//为？赋值
			pstmt.setString(1, account);
			//执行sql语句
			pstmt.executeUpdate();
			//关闭资源
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
	}
	/**
	 * 通过学生账号，先查到他所选的课，再返回所选课的信息的list集合
	 * @param account 学生账号
	 * @return
	 */
	public List<Course> queryMySubjects(String account){
		List<Course> list = new ArrayList<Course>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM studentcourse where account=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				String course = rs.getString(2);
				Course course2 = querySubject(course);
				list.add(course2);
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
	 * 通过课程名查找课程的全部信息（课程名，开课日期，开课节次，课程表显示颜色）
	 * @param courseName 课程名
	 * @return
	 */
	public Course querySubject(String courseName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		Course course = new Course();
		String sql = "SELECT * FROM courses where courseName=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, courseName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				int courseDay = rs.getInt(2);
				int courseTime = rs.getInt(3);
				String color = rs.getString(4);
				course.setSubject(courseName);
				course.setDay(courseDay);
				course.setTime(courseTime);
				course.setColor(color);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
		return course;
	}
	/**
	 * 通过账号返回他所选的全部课程的名称集合
	 * @param account 学生账号
	 * @return
	 */
	public List<String> queryMySubjectsName(String account){
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM studentcourse where account=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				String course = rs.getString(2);
				list.add(course);
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
	 * 在学生表中通过name查找account
	 * @param studentName
	 * @return
	 */
	public String queryAccountBySName(String studentName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String account = null;
		String sql = "SELECT * FROM student where name=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studentName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				account = rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
		return account;
	}
	/**
	 * 更新成绩
	 * @param account 学生账号
	 * @param courseName 课程名称
	 * @param grades 成绩
	 */
	public void saveGrades(String account,String courseName,String grades){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备要执行的sql语句
			String sql = "UPDATE studentcourse SET grades=? WHERE account=? and courseName=?";
			//获取sql语句的执行器对象
			
//			System.out.println("StudentDao:  account: "+account+" courseName: "+courseName+" grade: "+grades);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grades);
			pstmt.setString(2, account);
			pstmt.setString(3, courseName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DButil.ConnectionClose(conn, pstmt);
		}
	}
	/**
	 * 通过账户和课程名查找成绩
	 * @param account 学生账号
	 * @param courseName 课程名
	 * @return
	 */
	public String queryMyGrade(String account,String courseName){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String grade = null;
		String sql = "SELECT * FROM studentcourse where account=? and courseName=?";
		try {
			conn = DButil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, courseName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//指标往下移动一行
				grade = rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
		return grade;
	}
	/**
	 * 添加学生账户
	 * @param name
	 * @param account
	 * @param password
	 * @param sclass
	 */
	public void addStudent(String name,String account,String password,String sclass){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备要执行的sql语句
			String sql = "INSERT INTO student (name,account,password,sclass) VALUES(?,?,?,?);";
			//获取sql语句的执行器对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, account);
			pstmt.setString(3, password);
			pstmt.setString(4, sclass);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DButil.ConnectionClose(conn, pstmt);
		}
	}
	/**
	 * 在数据库中新增学生的基本信息
	 * @param account 该学生的账号
	 */
	public void addStudentInfo(String account){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备要执行的sql语句
			String sql = "INSERT INTO studentinfo (account) VALUES(?);";
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
	/**
	 * 添加课程
	 * @param courseName 课程名称
	 * @param courseDay 开课星期
	 * @param courseTime 开课时间
	 * @param color 课程表中的颜色
	 */
	public void addSubject(String courseName, String courseDay, String courseTime, String color) {
		System.out.println("这是StudentDao:  "+courseDay+" "+courseDay+" "+courseTime+" "+color);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//加载驱动
			//连接数据库
			conn = DButil.getConnection();
			//准备要执行的sql语句
			String sql = "INSERT INTO courses (courseName,courseDay,courseTime,color) VALUES(?,?,?,?);";
			//获取sql语句的执行器对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, courseName);
			pstmt.setString(2, courseDay);
			pstmt.setString(3, courseTime);
			pstmt.setString(4, color);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DButil.ConnectionClose(conn, pstmt);
		}
		
	}
	
	
}
