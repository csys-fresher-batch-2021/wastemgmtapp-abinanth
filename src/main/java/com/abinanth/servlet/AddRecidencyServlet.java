package com.abinanth.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abinanth.services.AddProductRecidency;
import com.abinanth.services.RecidencyTypeService;

/**
 * Servlet implementation class AddRecidencyServlet
 */
@WebServlet("/AddRecidencyServlet")
public class AddRecidencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/**
	 * // add data to arraylist
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		System.out.println("servlet Works");
		
		
		String newRecidency = request.getParameter("recidency");

		boolean isValid = AddProductRecidency.addRecidencyType(newRecidency);
		if (isValid == true) {

			response.sendRedirect("TypeOfRecidency.jsp");

		} else {
			String errorMessage = "Already exists";
			response.sendRedirect("addRecidency.jsp?errorMessage=" + errorMessage);
		}

	}

}
