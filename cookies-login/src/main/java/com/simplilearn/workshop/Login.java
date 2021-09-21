package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//display the links in current page
		RequestDispatcher requestDispatcherLinks=request.getRequestDispatcher("links.html");
		requestDispatcherLinks.include(request, response);
		
		String username=request.getParameter("USERNAME");
		String password=request.getParameter("PASSWORD");
		if(username.equals("simplilearn")&& password.equals("simplilearn")) {
			out.println("<h1>You are successfully logged in</h1>");
			out.println("<br><h3> Welcome, " +username+ "</h3>");
			
			Cookie cookie=new Cookie("username",username);
			response.addCookie(cookie);
		}else {
			out.println("<h1>Sorry, username and password error");
			//display the login page in current page
			RequestDispatcher requestDispatcherLogin=request.getRequestDispatcher("login.html");
			requestDispatcherLogin.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
