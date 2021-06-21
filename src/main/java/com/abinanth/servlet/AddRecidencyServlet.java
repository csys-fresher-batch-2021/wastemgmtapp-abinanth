package com.abinanth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abinanth.model.RecidencyModel;
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
		String newRecidency = request.getParameter("recidency");
		RecidencyModel recidencyPackage = new RecidencyModel(newRecidency);
		boolean isValid = RecidencyTypeService.addRecidencyType(recidencyPackage);
		if (isValid) {
			response.sendRedirect("TypeOfRecidency.jsp");
		} else {
			String errorMessage = "Already exists";
			response.sendRedirect("addRecidency.jsp?errorMessage=" + errorMessage);
		}
	}
}
