package com.justintime.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Sagnik
 */
 /* 
 * Servlet implementation class Manager
 */
public class Manager extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		
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
				+ "    <link rel=\"stylesheet\" href=\"manager.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.css\" />\r\n"
				+ "	   <link href=\"https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@200&display=swap\" rel=\"stylesheet\" />"
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
	}

}
