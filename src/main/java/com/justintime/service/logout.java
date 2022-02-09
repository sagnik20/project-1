package com.justintime.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.justintime.dao.ValidateUser;

/**
 * @author SagniK
 */
/**
 * Servlet implementation class logout
 */
public class logout extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession s=request.getSession(false);
		ValidateUser.elist=null;
		s.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("logIn.html");
		rd.include(request, response);
	}

}
