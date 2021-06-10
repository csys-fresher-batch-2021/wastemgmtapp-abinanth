package com.abinanth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abinanth.services.PaymentService;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String recidencyNo = (String) session.getAttribute("recidencyNo");

		boolean updatePayment = PaymentService.updatePayment(recidencyNo);
		if (updatePayment) {

			response.sendRedirect("Payment.jsp");
		} else {
			String message = "Unable to process";
			response.sendRedirect("BillGenerator.jsp?message" + message);
		}

	}

}
