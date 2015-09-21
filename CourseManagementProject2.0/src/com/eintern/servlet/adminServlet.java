package com.eintern.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.dao.Administrator;
import com.eintern.dao.UserDAOImpl;

/**
 * Servlet implementation class adminServlet
 */
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDAOImpl user = new UserDAOImpl();
		user.setup();
		ArrayList<Administrator> admins = user.getAllAdmins();

		StringBuilder sb = new StringBuilder();

		sb.append("<Admins>");

		for (int i = 0; i < admins.size(); i++) {
			sb.append("<admin><name>" + admins.get(i).getName() + "</name>"
					+ "   " + "<id>" + admins.get(i).getAdministrator_id()	+ "</id></admin>");
		}
		sb.append("</Admins>");
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

