package com.abinanth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abinanth.services.AdminLogin;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("adminUserName");
		String password = request.getParameter("adminPassword");
		boolean isValid = AdminLogin.checkAdminLogin(username, password);
		if (isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_Admin", username);
			response.sendRedirect("TypeOfRecidency.jsp");
		} else {
			String errorMessage = "Invalid Credentials";
			response.sendRedirect("Login.jsp?errorMessage=" + errorMessage);
		}
	}
}
