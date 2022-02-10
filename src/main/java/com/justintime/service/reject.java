package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.justintime.dao.RejectRequest;
import com.justintime.dao.RejectRequestDao;

/**
 * @author Sagnik
 */

 /* 
 * Servlet implementation class reject
 */
public class reject extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		Integer requestId = (Integer) s.getAttribute("requestId");
		
		RejectRequest rq = new RejectRequestDao();
		boolean confirm = rq.rejct(requestId);
		
		RequestDispatcher rd=request.getRequestDispatcher("PendingRequest");
		rd.include(request, response);
	}

}
