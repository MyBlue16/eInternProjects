package com.eintern.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.dao.Advisor;
import com.eintern.dao.UserDAOImpl;

/**
 * Servlet implementation class advisorServlet
 */
public class advisorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDAOImpl user = new UserDAOImpl();
		user.setup();
		ArrayList<Advisor> advisors = user.getAllAdvisors();

		StringBuilder sb = new StringBuilder();

		sb.append("<Advisors>");

		for (int i = 0; i < advisors.size(); i++) {
			sb.append("<advisor><name>" + advisors.get(i).getName() + "</name>"
					+ "   " + "<id>" + advisors.get(i).getAdvisorId() + "</id></advisor>");
		}
		sb.append("</Advisors>");
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
