package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SrvOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		

		request.setAttribute("user", "Praveen");
		request.setAttribute("pws", "834638n");

		RequestDispatcher rd = request.getRequestDispatcher("/one.jsp");
		rd.forward(request, response);

	}

}
