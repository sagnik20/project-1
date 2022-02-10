package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.justintime.dao.AcceptRequest;
import com.justintime.dao.AcceptRequestDao;

/**
 * @author Sagnik
 */

/* 
 * Servlet implementation class accept
 */
public class accept extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		Integer requestId = (Integer) s.getAttribute("requestId");
		
		AcceptRequest ar = new AcceptRequestDao();
		boolean confirm = ar.acept(requestId);
		
		RequestDispatcher rd=request.getRequestDispatcher("PendingRequest");
		rd.include(request, response);
	}

}
