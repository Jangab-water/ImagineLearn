package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/before_value")
public class before_value extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		/* int a =Integer.parseInt(request.getParameter("before_value")); */
		String a =request.getParameter("before_value");
		
		
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		HttpSession session = request.getSession();
		
		session.setAttribute("before_value2", a);
		
		
		if(a!=null) {
			response.sendRedirect("elen-master/game.jsp");
			
		}
		
	}

}
