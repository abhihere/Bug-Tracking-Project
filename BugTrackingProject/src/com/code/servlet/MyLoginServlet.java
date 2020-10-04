package com.code.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.service.UserServiceImpl;
import com.code.bean.User;

/**
 * Servlet implementation class MyLoginServlet
 */
@WebServlet("/MyLoginServlet")
public class MyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");

		UserServiceImpl userService = new UserServiceImpl();
		User user;
		try {
			user = userService.validateUser(userName, password);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("type", user.getType());
				session.setAttribute("user", user);
				RequestDispatcher dispatcher = null;
				switch (user.getType()) {
				case "manager":
					dispatcher = request.getRequestDispatcher("manager.jsp");
					dispatcher.forward(request, response);
					break;

				case "developer":
					dispatcher = request.getRequestDispatcher("developer.jsp");
					dispatcher.forward(request, response);
					break;

				case "tester":
					dispatcher = request.getRequestDispatcher("tester.jsp");
					dispatcher.forward(request, response);
					break;

				default:
					break;
				}
			} else {
				out.println("<h4 style='color=red'>Invalid User Name and Passsword</h4>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			out.println("<h4 style='color=red'>Error Occured</h4>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
			dispatcher.include(request, response);
		}
	}

}
