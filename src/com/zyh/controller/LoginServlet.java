package com.zyh.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyh.util.CodeUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.zyh.dao.AdminDao;
import com.zyh.dao.StudentDao;
import com.zyh.dao.TeacherDao;
import com.zyh.model.Admin;
import com.zyh.model.Teacher;
import com.zyh.model.User;

public class LoginServlet extends HttpServlet{
	public static void main(String[] args) {
//		System.out.println("123"=="123");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		AdminDao adminDao = null;
		StudentDao studentDao = null;
		TeacherDao teacherDao = null;
		String url = request.getServletPath();
		System.out.println(url);
		if("/login.do".equals(url)){
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String code = request.getParameter("vcode");
			String type = request.getParameter("type");
			String realcode = (String)session.getAttribute("code");
			if (code.equalsIgnoreCase(realcode)) {
				User user = null;
//				System.out.println(type.equals("admin"));
//				System.out.println(type.equals("student"));
//				System.out.println(type.equals("teacher"));
				if(type.equals("管理员")){
//					System.out.println("第1");
					adminDao = new AdminDao();
					user = adminDao.finByAccountAndPwd(account, password);
				}else if(type.equals("学生")){
//					System.out.println("第2");
					studentDao = new StudentDao();
					user = studentDao.finByAccountAndPwd(account, password);
				}else{
//					System.out.println("第3");
					teacherDao = new TeacherDao();
					user = teacherDao.finByAccountAndPwd(account, password);
				}
				if(user==null){
					request.setAttribute("msg","账号或密码错误");
					request.getRequestDispatcher("pages/loginfirst.jsp").forward(request, response);
				}else{
					System.out.println("登录成功");
					session.setAttribute("type", type);
					session.setAttribute("user", user);	
//					System.err.println(session.getAttribute("user"));
					request.getRequestDispatcher("pages/main.jsp").forward(request, response);
				}
			}else {
//				System.out.println("我输入的验证码："+code+"  正确的验证码："+realcode);
				request.setAttribute("msg","验证码错误");
				request.getRequestDispatcher("pages/loginfirst.jsp").forward(request, response);
			}
		}else if("/code.do".equals(url)){
			//java画一张图片，传输给浏览器
			//画布
			BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
			//画笔
			Graphics g = image.getGraphics();
			//
			g.setColor(Color.BLACK);
			//
			g.fillRect(0, 0, 100, 30);
			g.setColor(Color.white);
			g.setFont(new Font("",Font.BOLD,20));
			String code = "";
			String s = CodeUtil.str();
			code += s;
			g.drawString(s, 10, 20);
			s = CodeUtil.str();
			code += s;
			g.drawString(s, 30, 20);
			s = CodeUtil.str();
			code += s;
			g.drawString(s, 60, 20);
			s = CodeUtil.str();
			code += s;
			g.drawString(s, 80, 20);
			session.setAttribute("code", code);//保存数据
			//输出流，用来给浏览器传输图片
			OutputStream out = response.getOutputStream();
			//对图片进行jpeg的压缩
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
		}
		
	}
}
