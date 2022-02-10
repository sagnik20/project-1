package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.justintime.dao.RegisterEmployee;
import com.justintime.dao.RegisterEmployeeImpl;
import com.justintime.model.Employee;

/**
 * @author Sagnik
 *
 */

public class EmployeeRegistration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("Redirected after Employee Registration details");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String dept = request.getParameter("dept");
		Integer manager = Integer.parseInt(request.getParameter("dropdown"));
		String pwd = name+"123";
		
		Employee emp = new Employee(name,email,manager,1,dept,pwd);
		
//		out.println("Send Employee object to database");
//		out.println(manager);
		
		RegisterEmployee rEmp = new RegisterEmployeeImpl();
		
		Boolean confirm = rEmp.register1(emp);
		
		if(confirm) {
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
					+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"logout.css\">\r\n"
					+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "    <div class=\" d-flex justify-content-between nav-color\">\r\n"
					+ "        <h1 class=\"nav-logo \">\r\n"
					+ "            S.\r\n"
					+ "        </h1>\r\n"
					+ "        <form action = \"logout\" method=\"post\">\r\n"
					+ "            <button class=\"btns\" type=\"submit\">Logout</button>\r\n"
					+ "        </form>\r\n"
					+ "\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    <div class=\"bg-container\">");
			out.println("Employee Registration Success<br>");
			out.println("<form method=\"post\" action=\"Admin\" >\r\n"
					+ "<button type=\"submit\" id=\"login-button\" >Return to home</button>\r\n"
					+ "</form>");
			out.println("    </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    <div class=\"copyright-container\">\r\n"
					+ "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
					+ "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
					+ "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>\r\n"
					+ "");
		}
		else {
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "\r\n"
					+ "<head>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
					+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"logout.css\">\r\n"
					+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</head>\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "    <div class=\" d-flex justify-content-between nav-color\">\r\n"
					+ "        <h1 class=\"nav-logo \">\r\n"
					+ "            S.\r\n"
					+ "        </h1>\r\n"
					+ "        <form action = \"logout\" method=\"post\">\r\n"
					+ "            <button class=\"btns\" type=\"submit\">Logout</button>\r\n"
					+ "        </form>\r\n"
					+ "\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    <div class=\"bg-container\">");
			out.println("Registraion Failed<br>");
			out.println("<form method=\"post\" action=\"Admin\" >\r\n"
					+ "<button type=\"submit\" id=\"login-button\" >Return to home</button>\r\n"
					+ "</form>");
			out.println("    </div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    <div class=\"copyright-container\">\r\n"
					+ "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
					+ "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
					+ "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "\r\n"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>\r\n"
					+ "");
			
		}
	}

}
