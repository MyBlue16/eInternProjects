package com.eintern.servlet;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.dao.Student;
import com.eintern.dao.UserDAOImpl;

/**
 * Servlet implementation class studentsServlet
 */
public class studentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDAOImpl user = new UserDAOImpl();
		user.setup();
		ArrayList<Student> students = user.getAllStudents();

		StringBuilder sb = new StringBuilder();

		sb.append("<Students>");

		for (int i = 0; i < students.size(); i++) {
			sb.append("<student><name>" + students.get(i).getName() + "</name>"
					+ "   " + "<id>" + students.get(i).getId()
					+ "</id></student>");
		}
		sb.append("</Students>");
		String xml = sb.toString();

		PrintWriter out = response.getWriter();
		out.println(xml);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
