package com.abinanth.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectRecidencyType
 */
@WebServlet("/SelectRecidencyType")
public class SelectRecidencyType extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recidency=request.getParameter("recidencyType");
		String city=request.getParameter("cityName");
		boolean isValid=com.abinanth.services.SelectRecidencyType.getRecidencyTypeCity(recidency, city);
		if(isValid) {
			
			request.getRequestDispatcher("BillGenerator.jsp").forward(request, response);;
		} 
	}


	

}
