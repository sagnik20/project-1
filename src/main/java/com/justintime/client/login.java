package com.justintime.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.dao.ValidateUser;
import com.justintime.db.HibernateCon;
import com.justintime.model.Employee;
/**
 * @author Sagnik
 *
 */

public class login extends HttpServlet {
	private static final Logger logger = Logger.getLogger("login.class");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email=request.getParameter("id");
		String pwd=request.getParameter("ipass");
		Integer dropdown = Integer.parseInt(request.getParameter("dropdown"));
		logger.info("within login.class file");
		
		switch(dropdown) {
		case 1:{
			//Employee   ValidateUser.check(id, pwd)
			if(ValidateUser.check(email, pwd)) {
				logger.info("Logged in as Employee");
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("email",email);
				s.setAttribute("pass", pwd);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Employee Login Successful</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
						+ "<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
						+ "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
						+ "<link rel=\"stylesheet\" href=\"logout.css\">\r\n"
						+ "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
						+ "</head>\r\n"
						+ "<body>");
				out.println("<div class=\" d-flex justify-content-between nav-color\">\r\n"
						+ "        <h1 class=\"nav-logo \">\r\n"
						+ "            S.\r\n"
						+ "        </h1>\r\n"
						+ "        <form action=\"logout\" method=\"post\">\r\n"
						+ "            <button class=\"btns\" type=\"submit\">Logout</button>\r\n"
						+ "        </form>\r\n"
						+ "\r\n"
						+ "    </div>"
						+ "<div class=\"bg-container\">");
				out.println("<form method=\"post\" action=\"bookcab\" >\r\n"
						+ "<button type=\"submit\" id=\"login-button\" >Book a Cab</button>\r\n"
						+ "</form>");
				out.println("<form method=\"post\" action=\"BookingHistory\" >\r\n"
						+ "<button type=\"submit\" id=\"login-button\" >Booking History</button>\r\n"
						+ "</form>");
				out.println("</div>\r\n"
						+"<div class=\"copyright-container\">\r\n"
						+ "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
						+ "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
						+ "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
						+ "        </div>\r\n"
						+ "    </div>");
				out.println("</body>\r\n"
						+ "</html>");
//				RequestDispatcher rd=request.getRequestDispatcher("Employee.html");
//				rd.include(request, response);
			}
			else {
				logger.info("Wrong Employee Credentials!");
				RequestDispatcher rd=request.getRequestDispatcher("logiin.html");
				rd.include(request, response);
			}
			break;
		}
		case 2:{
			//Manager
			if(ValidateUser.checkMan(email, pwd)) {
				logger.info("Manager logged in");
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("id",email);
				s.setAttribute("pass", pwd);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Insert title here</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
						+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"logout.css\">\r\n"
						+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
						+ "<link rel=\"stylesheet\" href=\"manager.css\">"
						+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.css\" />\r\n"
						+ "<link href=\"https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@200&display=swap\" rel=\"stylesheet\" />\r\n"
						+ "</head>\r\n"
						+ "<body>");
				out.println("<div class=\" d-flex justify-content-between nav-color\">\r\n"
						+ "        <h1 class=\"nav-logo \">\r\n"
						+ "            S.\r\n"
						+ "        </h1>\r\n"
						+ "        <form action=\"logout\" method=\"post\">\r\n"
						+ "            <button class=\"btns\" type=\"submit\">Logout</button>\r\n"
						+ "        </form>\r\n"
						+ "\r\n"
						+ "    </div>"
						+ "<div class=\"bg-container\">");
				out.println("<form method=\"post\" action=\"PendingRequest\" >\r\n"
						+ "<button type=\"submit\" class=\"slide\">\r\n"
						+ "  <div>Slide</div>\r\n"
						+ "  <i class=\"icon-arrow-right\"></i>\r\n"
						+ "</button>"
						+ "</form>");
				out.println("</div> \r\n"
						+ "<div class=\"copyright-container\">\r\n"
						+ "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
						+ "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
						+ "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
						+ "        </div>\r\n"
						+ "    </div>");
				out.println("</body>\r\n"
						+ "</html>");
//				RequestDispatcher rd=request.getRequestDispatcher("Manager.html");
//				rd.include(request, response);
			}
			else {
				logger.info("Wrong Credentials of Manager");
				RequestDispatcher rd=request.getRequestDispatcher("logiin.html");
				rd.include(request, response);
			}
			break;
		}
		case 3:{
			//Admin
			if(ValidateUser.checkMan(email, pwd)) {
				logger.info("Admin Logged In");
				HttpSession s=request.getSession(true);
				s.setMaxInactiveInterval(10000);
				s.setAttribute("id",email);
				s.setAttribute("pass", pwd);
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Admin</title>\r\n"
						+ "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\r\n"
						+ "    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"logout.css\">\r\n"
						+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n"
						+ "</head>\r\n"
						+ "<body>");
				out.println("<div class=\" d-flex justify-content-between nav-color\">\r\n"
						+ "        <h1 class=\"nav-logo \">\r\n"
						+ "            S.\r\n"
						+ "        </h1>\r\n"
						+ "        <form action=\"logout\" method=\"post\">\r\n"
						+ "            <button class=\"btns\" type=\"submit\">Logout</button>\r\n"
						+ "        </form>\r\n"
						+ "\r\n"
						+ "    </div>");
				out.println("<div class=\"bg-container\">");
				out.println("<div class=\"sec-container\">\r\n"
						+ "        <h1 class=\"a_form-name\">!!! Welcome Admin !!!</h1>\r\n"
						+ "        <div class=\"select-container\">\r\n"
						+ "            <a href=\"./EmployeeRegistration.html\"><button class=\"Button-admin\">Add Employee</button></a>\r\n"
						+ "            <a href=\"./CabRegistration.html\"><button class=\"Button-admin\">Add Cab</button></a>\r\n"
						+ "            <form method=\"post\" action=\"AssignCab\" >\r\n\""
						+ "            <button class=\"Button-admin\">Assign Cab</button></form>\r\n"
						+ "        </div>\r\n"
						+ "    </div>");
				out.println("</div>");
				out.println("<div class=\"copyright-container\">\r\n"
						+ "        <div class=\" d-flex flex-row justify-content-center\">\r\n"
						+ "            <i class=\"fa fa-copyright icon\" aria-hidden=\"true\"></i>\r\n"
						+ "            <p class=\"content ml-2\">Made with <b style=\"color: red;\">&#x2764;&#xfe0f;</b> by Sagnik.</p>\r\n"
						+ "        </div>\r\n"
						+ "    </div>");
				out.println("</body>\r\n"
						+ "</html>");
//				RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
//				rd.include(request, response);
			}
			else {
				logger.info("Wrong Admin Credentials");
				RequestDispatcher rd=request.getRequestDispatcher("logiin.html");
				rd.include(request, response);
			}
			break;
		}
			
		}
	}

}
