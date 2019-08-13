package com.zyh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zyh.model.Info;
import com.zyh.util.DButil;

public class InfoDao {
	public static void main(String[] args) {
		Info info = new Info("女","ss","24","长沙","792681347","天蝎座","跑步");
		String account = "zstx";
		String type = "学生";
		new InfoDao().setInfo(account, info, type);
	}
	public void setInfo(String account,Info info,String type){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String table = null;
		if(type.equals("学生")){
			table = "studentinfo";
		}else if(type.equals("老师")){
			table = "teacherinfo";
		}else table = "admininfo";
		try {
			conn = DButil.getConnection();
			String sql = "UPDATE "+ table +" SET 性别=?,血型=?,年龄=?,居住地=?,QQ=?,星座=?,兴趣爱好=? WHERE account=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getSex());
			pstmt.setString(2, info.getBloodType());
			pstmt.setString(3, info.getAge());
			pstmt.setString(4, info.getSite());
			pstmt.setString(5, info.getQq());
			pstmt.setString(6, info.getConstellation());
			pstmt.setString(7, info.getInterest());
			pstmt.setString(8, account);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DButil.ConnectionClose(conn, pstmt);
		}
	}
}
