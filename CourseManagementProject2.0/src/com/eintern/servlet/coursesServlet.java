package com.eintern.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.dao.Courses;
import com.eintern.dao.UserDAOImpl;

/**
 * Servlet implementation class coursesServlet
 */
public class coursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserDAOImpl user = new UserDAOImpl();
		user.setup();
		ArrayList<Courses> courses = user.getAllCourses();
		
		System.out.println(courses.toString());
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<Courses>");
		
		for(int i = 0; i < courses.size(); i++){
			sb.append("<course><name>"+courses.get(i).getCourseName()+"</name>" + "   "+ "<id>"+courses.get(i).getId()+"</id></course>" );
		}
		sb.append("</Courses>");
		String xml = sb.toString();
		
		PrintWriter out = response.getWriter();
		out.println(xml);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
