package com.abinanth.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abinanth.services.BillGeneratorService;
import com.abinanth.util.Logger;

/**
 * Servlet implementation class BillGeneratorServlet
 */
@WebServlet("/BillGeneratorServlet")
public class BillGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = new Logger();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.print("######## Bill Generator Servlet #########");

		String userYear = request.getParameter("date");
		String recidencyType = request.getParameter("recidencyType");

		logger.print("Year=" + userYear + ",recidencyType=" + recidencyType);

		String amount = BillGeneratorService.generateBill(recidencyType, userYear);
		logger.print("Amount=" + amount);
		HttpSession session = request.getSession();
		session.setAttribute("amount", amount);

		session.setAttribute("recidencyType", recidencyType);
		response.sendRedirect("BillGenerator.jsp");
	}

}
