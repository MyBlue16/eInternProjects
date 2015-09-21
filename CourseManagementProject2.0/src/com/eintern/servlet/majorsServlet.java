package com.eintern.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eintern.dao.Major;
import com.eintern.dao.UserDAOImpl;

/**
 * Servlet implementation class majorsServlet
 */
public class majorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public majorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDAOImpl user = new UserDAOImpl();
		user.setup();
		ArrayList<Major> majors = user.getAllMajors();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<majors>");
		
		for(int i = 0; i < majors.size(); i++){
			sb.append("<major>"+majors.get(i).getname()+"</major>" );
		}
		sb.append("</majors>");
		String xml = sb.toString();
		
		PrintWriter out = response.getWriter();
		out.println(xml);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
