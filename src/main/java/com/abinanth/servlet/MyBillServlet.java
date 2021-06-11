package com.abinanth.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abinanth.model.PaymentModel;
import com.abinanth.services.PaymentService;

/**
 * Servlet implementation class MyBillServlet
 */
@WebServlet("/MyBillServlet")
public class MyBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("LOGGED_IN_USER");
		List<PaymentModel> myBill=PaymentService.getUserBills(username);
		request.setAttribute("bills", myBill);
		RequestDispatcher dispacher=request.getRequestDispatcher("DisplayAllDetails.jsp");
		dispacher.forward(request, response);
	}
	

}
