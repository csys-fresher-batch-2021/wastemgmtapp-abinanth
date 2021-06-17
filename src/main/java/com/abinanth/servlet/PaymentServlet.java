package com.abinanth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abinanth.services.PaymentService;
import com.abinanth.util.Logger;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger log = new Logger();

		int paymentId = Integer.parseInt(request.getParameter("paymentId"));

		boolean updatePayment = PaymentService.updatePayment(paymentId);
		log.print(updatePayment);
		if (updatePayment) {

			response.sendRedirect("MyBillServlet?paymentId="+paymentId);
		} else {
			String message = "Unable to process";
			response.sendRedirect("BillGenerator.jsp?message" + message);
		}

	}

}
