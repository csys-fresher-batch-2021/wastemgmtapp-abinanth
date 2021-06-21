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

import com.abinanth.exception.DBException;
import com.abinanth.model.PaymentModel;
import com.abinanth.services.PaymentService;
import com.abinanth.util.Logger;

/**
 * Servlet implementation class SearchRecidencyDetails
 */
@WebServlet("/SearchRecidencyDetailsServlet")
public class SearchRecidencyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Logger log = new Logger();
		String word = request.getParameter("search");
		try {
			List<PaymentModel> search = PaymentService.findRecidencyDetails(word);
			log.print(search);
			request.setAttribute("recidencyList", search);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("SearchRecidencyDetails.jsp");
			requestDispatcher.forward(request, response);
		} catch (DBException e) {
			String message = e.getMessage();
			session.setAttribute("message", message);
			response.sendRedirect("SearchRecidencyDetails.jsp?message=" + message);
		}
	}
}
