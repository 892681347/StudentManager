package com.zyh.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zyh.dao.AdminDao;
import com.zyh.dao.InfoDao;
import com.zyh.dao.StudentDao;
import com.zyh.dao.TeacherDao;
import com.zyh.model.Course;
import com.zyh.model.Grades;
import com.zyh.model.Info;
import com.zyh.model.Student;
import com.zyh.model.Teacher;
import com.zyh.model.User;
import com.zyh.util.FileCopy;

public class MainServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AdminDao adminDao = new AdminDao();
		StudentDao studentDao = new StudentDao();
		TeacherDao teacherDao = new TeacherDao();
		InfoDao infoDao = null;
		String url = request.getServletPath();
		System.out.println(url);
		HttpSession session = request.getSession();
		if("/personinfo.do".equals(url)){
			Info info = null;
			User user = (User)session.getAttribute("user");
//			System.out.println("这是user:"+user);
			String type = (String)session.getAttribute("type");
			if(type.equals("管理员")){
				info = adminDao.findByid(user.getAccount());
			}else if(type.equals("学生")){
				info = studentDao.findByid(user.getAccount());
			}else {
				info = teacherDao.findByid(user.getAccount());
			}
			double per = percentage(info);
//			System.out.println("这是MainServlet的方法"+per);
			session.setAttribute("info", info);
			request.setAttribute("per", per);
			request.getRequestDispatcher("pages/personinfo.jsp").forward(request, response);
		}else if("/changeinfo.do".equals(url)){
			String sex = request.getParameter("sex");
			String bloodtype = request.getParameter("bloodtype");
			String age = request.getParameter("age");
			String qq = request.getParameter("qq");
			String constellation = request.getParameter("constellation");
			String site = request.getParameter("site");
			String interest = request.getParameter("interest");
			Info info = new Info(sex,bloodtype,age,site,qq,constellation,interest);
			String type = (String)session.getAttribute("type");
			String account = ((User)session.getAttribute("user")).getAccount();
			infoDao = new InfoDao();
			infoDao.setInfo(account, info, type);
			session.setAttribute("info", info);
			double per = percentage(info);
			request.setAttribute("per", per);
			request.getRequestDispatcher("pages/personinfo.jsp").forward(request, response);
		}else if("/class.do".equals(url)){
			String stclass = null;
			String type = (String)session.getAttribute("type");
			if(type.equals("老师")){
				stclass = ((Teacher)session.getAttribute("user")).getTclass();
			}else{
				stclass = ((Student)session.getAttribute("user")).getSclass();
			}
			
			List<Student> slist = studentDao.findStudentByClass(stclass);
			List<Teacher> tlist = teacherDao.findTeacherByClass(stclass);
			
			session.setAttribute("slist", slist);
			session.setAttribute("tlist", tlist);
			request.getRequestDispatcher("pages/student/class.jsp").forward(request, response);
		}else if("/upload.do".equals(url)){
			//文件上传
			System.out.println("MainServlet开始上传");
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    DiskFileItemFactory dfif = new DiskFileItemFactory();
		    ServletFileUpload parser = new ServletFileUpload(dfif);
		    List<FileItem> items = null;
		    try {
		        items = parser.parseRequest(request);
		    }catch(Exception e) {
		       e.printStackTrace();
		    }
		    
		    //处理请求内容
		    if(items!=null){
		        for(FileItem item:items){
		            if(item.isFormField()){
		                
		            }else{
		            	String oldName = item.getName();
		            	
		                //确定要上传到服务器的位置
		            	String path = request.getServletContext().getRealPath("/upload");
		            	
//		            	String path1 = request.getServletContext().getRealPath("/upload")+"../../../upload";
//		            	String path1 = "E:\\2019.6实训\\eclipse-workplace\\StudentManager\\WebContent\\upload";
		            	//文件名
		            	User user = (User) session.getAttribute("user");
		            	String name = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+user.getAccount()+oldName.substring(oldName.lastIndexOf("."));
		            	String serverFile = "E:\\apache-tomcat-7.0.94\\webapps\\StudentManager\\upload\\"+name;
		            	String localFile = "E:\\2019.6实训\\eclipse-workplace\\StudentManager\\WebContent\\avatar\\"+name;
		            	String serverFile1 = "E:\\apache-tomcat-7.0.94\\webapps\\StudentManager\\avatar\\"+name;
		            	try {
							item.write(new File(path, name));
							FileCopy.copyFile(new File(serverFile), new File(localFile));
							FileCopy.copyFile(new File(localFile), new File(serverFile1));
							
						} catch (Exception e) {
							e.printStackTrace();
						}
		            	String account = user.getAccount();
		            	String avatarPath = "http://localhost:8081/StudentManager/avatar/"+name;
		            	user.setAvatar(avatarPath);
		            	session.setAttribute("user", user);
		            	String type = (String)session.getAttribute("type");
		            	if(type.equals("管理员")){
		            		adminDao.modifyAvatar(avatarPath, account);
		            	}else if(type.equals("学生")){
		            		studentDao.modifyAvatar(avatarPath, account);
		            	}else {
							teacherDao.modifyAvatar(avatarPath, account);
						}
		            }
		        }
		    }
		    out.write("上传成功！");
		}else if("/refresh.do".equals(url)){
			request.getRequestDispatcher("pages/main.jsp").forward(request, response);
		}else if("/subject.do".equals(url)){
			List<String> list = studentDao.queryAllSubjects();
			request.setAttribute("courses", list);
//			System.out.println(list);
			request.getRequestDispatcher("pages/student/subject.jsp").forward(request, response);
		}else if("/saveCourse.do".equals(url)){
			String account = ((User)session.getAttribute("user")).getAccount();
			String[] courses = request.getParameterValues("select");
			List<String> subjects = Arrays.asList(courses);
			studentDao.removeSubject(account);
			studentDao.saveSubject(account, subjects);
			
			//转到课程表页面
			List<Course> list = studentDao.queryMySubjects(account);
			System.out.println(list);
			session.setAttribute("myCourse", JSONArray.toJSONString(list));
			
			request.getRequestDispatcher("pages/student/myCourse.jsp").forward(request, response);
		}else if("/myCourse.do".equals(url)){
			String account = ((User)session.getAttribute("user")).getAccount();
			List<Course> list = studentDao.queryMySubjects(account);
			System.out.println(list);
			session.setAttribute("myCourse", JSONArray.toJSONString(list));
			
			request.getRequestDispatcher("pages/student/myCourse.jsp").forward(request, response);
		}else if("/mark.do".equals(url)){
			String tclass = ((Teacher)session.getAttribute("user")).getTclass();
			List<Student> slist = studentDao.findStudentByClass(tclass);
			session.setAttribute("tclass", tclass);
			session.setAttribute("slist", slist);
			
			request.getRequestDispatcher("pages/teacher/mark.jsp").forward(request, response);
		}else if("/eachMark.do".equals(url)){
			String userName = request.getParameter("select");
			String userAccount = studentDao.queryAccountBySName(userName);
			List<String> list = studentDao.queryMySubjectsName(userAccount);
			session.setAttribute("userAccount", userAccount);
			session.setAttribute("myCourseName", list);
			session.setAttribute("UName", userName);
			request.getRequestDispatcher("pages/teacher/eachMark.jsp").forward(request, response);
		}else if("/saveGrades.do".equals(url)){
			String userAccount = (String)session.getAttribute("userAccount");
			@SuppressWarnings("unchecked")
			List<String> courseNameList = (List<String>)session.getAttribute("myCourseName");
			for(String courseName:courseNameList){
				String grade = request.getParameter(courseName);
//				System.out.println(" courseName "+courseName+"  ,grade为 "+grade);
				studentDao.saveGrades(userAccount, courseName, grade);
			}
			//跳转到打分首页
			String tclass = ((Teacher)session.getAttribute("user")).getTclass();
			List<Student> slist = studentDao.findStudentByClass(tclass);
			session.setAttribute("tclass", tclass);
			session.setAttribute("slist", slist);
			request.getRequestDispatcher("pages/teacher/mark.jsp").forward(request, response);
		}else if("/searchGrades.do".equals(url)){
			List<Grades> gradeList = new ArrayList<Grades>();
			String userAccount = ((User)session.getAttribute("user")).getAccount();
			List<String> list = studentDao.queryMySubjectsName(userAccount);
			for(String courseName:list){
				String grade = studentDao.queryMyGrade(userAccount, courseName);
				if(grade==null){
					grade = "老师未打分";
				}
				gradeList.add(new Grades(courseName,grade));
			}
			System.out.println(gradeList);
			request.setAttribute("myGrades", gradeList);
			request.getRequestDispatcher("pages/student/grades.jsp").forward(request, response);
		}else if("/addStudent.do".equals(url)){
			String name = request.getParameter("name");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String sclass = request.getParameter("sclass");
			studentDao.addStudent(name, account, password, sclass);
			studentDao.addStudentInfo(account);
			request.getRequestDispatcher("pages/admin/addSucess.jsp").forward(request, response);
		}else if("/addTeacher.do".equals(url)){
			String name = request.getParameter("name");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String tclass = request.getParameter("tclass");
			teacherDao.addTeacher(name, account, password, tclass);
			teacherDao.addTeacherInfo(account);
			request.getRequestDispatcher("pages/admin/addSucess.jsp").forward(request, response);
		}else if("/addSubject.do".equals(url)){
			String courseName = request.getParameter("name");
			String courseDay = request.getParameter("daySelect");
			String courseTime = request.getParameter("timeSelect");
			String color = request.getParameter("colorSelect");
			System.out.println("这是MainServlet:  "+courseName+" "+courseDay+" "+courseTime+" "+color);
			studentDao.addSubject(courseName,courseDay,courseTime,color);
			request.getRequestDispatcher("pages/admin/addSucess.jsp").forward(request, response);
		}
		
	}
	
	
	

	/**
	 * 计算当前信息完善比例
	 * @param info 一个Info对象，记录用户的信息
	 * @return 返回信息完善比例，只有百分号前面的数据
	 */
	public double percentage(Info info){
		double total = 0;
		if(!info.getSex().equals("未设置")){
			total++;
		}
		if(!info.getBloodType().equals("未设置")){
			total++;
		}
		if(!info.getAge().equals("未设置")){
			total++;
		}
		if(!info.getSite().equals("未设置")){
			total++;
		}
		if(!info.getQq().equals("未设置")){
			total++;
		}
		if(!info.getConstellation().equals("未设置")){
			total++;
		}
		if(!info.getInterest().equals("未设置")){
			total++;
		}
		double res = total/7;
		DecimalFormat df = new DecimalFormat("######0.0000");
		String result = df.format(res); 
		return Double.valueOf(result.toString())*100;
	}
}



