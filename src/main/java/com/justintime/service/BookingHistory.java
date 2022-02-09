package com.justintime.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.justintime.dao.BookingHistoryDao;
import com.justintime.dao.BookingHistoryDaoImpl;
import com.justintime.db.HibernateCon;
import com.justintime.model.BookingDetails;

/**
 * @author Sagnik
 *
 */

public class BookingHistory extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Here is Employee Booking History");
		
		HttpSession s=request.getSession(false);
		String email = (String) s.getAttribute("email");
		String pass = (String) s.getAttribute("pass");
		BookingHistoryDao bh = new BookingHistoryDaoImpl();
		List<BookingDetails> bd= bh.bookingHistory(email, pass);
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Employee Login Successful</title>\r\n"
				+ "    <style>\r\n"
				+ "        table {\r\n"
				+ "          border-collapse: collapse;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        th, td {\r\n"
				+ "          padding: 8px;\r\n"
				+ "          text-align: left;\r\n"
				+ "          border-bottom: 1px solid #DDD;\r\n"
				+ "        }\r\n"
				+ "        tr:nth-child(even) {\r\n"
				+ "          background-color: rgba(157, 229, 173, 0.651);\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        th:nth-child(even),td:nth-child(even) {\r\n"
				+ "          background-color: rgba(150, 212, 212, 0.4);\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        tr:hover {background-color: #D6EEEE;}\r\n"
				+ "        </style>\r\n"
				+ "</head>\r\n"
				+ "<body");
		out.println("<form method=\"post\" action=\"bookcab\" >\r\n"
				+ "<button type=\"submit\" id=\"login-button\" >Book a Cab</button>\r\n"
				+ "</form>");
		out.println("<center>\r\n"
				+ "    <table>\r\n"
				+ "        <thead>\r\n"
				+ "            <tr>\r\n"
				+ "                <th>Booking Id</th>\r\n"
				+ "                <th>Cab No</th>\r\n"
				+ "            </tr>\r\n"
				+ "        </thead>\r\n"
				+ "        <tbody>");
		for(BookingDetails b :bd) {
			out.println("            <tr>");
			out.format("<td>%s</td>", b.getBookingId());
			out.format("<td>%s</td>", b.getCabNo());
			out.println("            <tr>");
		}
		out.println("        </tbody>\r\n"
				+ "    </table>\r\n"
				+ "    </center>");
		out.println("</body>\r\n"
				+ "</html>");
		
	}

}
