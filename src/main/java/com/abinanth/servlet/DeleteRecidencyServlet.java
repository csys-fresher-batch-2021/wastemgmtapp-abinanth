package com.abinanth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.abinanth.services.RecidencyTypeService;



@WebServlet("/deleteRecidencyServlet")
public class DeleteRecidencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String deleteRecidency = request.getParameter("recidencyType");

		boolean isValid = RecidencyTypeService.deleteRecidencyType(deleteRecidency);
		if (isValid) {
			String infoMessage="Recidency Deleted Sucessfully";
			response.sendRedirect("TypeOfRecidency.jsp?infoMessage="+ infoMessage);

		} else {
			response.sendRedirect("TypeOfRecidency.jsp");
		}

}
}
