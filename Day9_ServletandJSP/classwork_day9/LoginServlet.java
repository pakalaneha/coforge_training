package com.coforge.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login") // annotation is @WebServlet and it has url pattern 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// overriding doGet from 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username !=null && username.equals("admin") && password.equals("123")) {
			// out.println("<b><font color = green>WELCOME ADMIN!</font></b>");
			
			//session is on server side -- secure -- slow
			HttpSession session = request.getSession();
			session.setAttribute("username", username);//key - variable
			 // cookie is on client side -- faster
			Cookie cookie = new Cookie("username",username);
			response.addCookie(cookie);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
			dispatcher.forward(request, response);
			// dispatcher.include(request, response); to include pages server side
			//forward is sever side redirection
			//sendRedirect is client side redirection
			//response.sendRedirect("LoginSuccess.jsp");
			
		}
		else {
			//	out.println("<b><font color = red>Invalid User</font></b>");
			response.sendRedirect("LoginFailure.jsp");
		}
		
		out.close();
	}


}
