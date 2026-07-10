package com.coforge.servlet1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CircleInputServlet
 */
@WebServlet("/CircleInputServlet")
public class CircleInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int radius = Integer.parseInt(request.getParameter("radius"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AreaServlet");
		request.setAttribute("radius", radius);
		dispatcher.forward(request, response);
		
		
	}

}
