package com.justintime.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.justintime.dao.AssignCabDao;
import com.justintime.dao.AssignCabDaoImpl;

/**
 * Servlet implementation class Assign
 */
public class Assign extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		List requestId = (ArrayList) s.getAttribute("requestId");
		List<Integer> abc = new ArrayList<Integer>();
		for(Iterator iterator = requestId.iterator(); iterator.hasNext();) {
			abc.add((Integer)iterator.next());
		}
		Integer val = Integer.parseInt(request.getParameter("acceptBtn"));
		
		
		AssignCabDao ac = new AssignCabDaoImpl();
		ac.assign(abc.get(val));
		
		RequestDispatcher rd=request.getRequestDispatcher("AssignCab");
		rd.include(request, response);
	}

}
