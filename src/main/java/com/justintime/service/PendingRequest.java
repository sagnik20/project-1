package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.justintime.dao.RequestPendingDao;
import com.justintime.dao.RequestPendingDaoImpl;
import com.justintime.model.Request;

/**
 * @author Sagnik
 * Servlet implementation class PendingRequest
 */
public class PendingRequest extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		
		RequestPendingDao pr = new RequestPendingDaoImpl();
		List<Request> lst = pr.cabRequest();
	}

}
