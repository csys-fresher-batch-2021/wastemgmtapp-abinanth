package com.abinanth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BillGeneratorServlet
 */
@WebServlet("/BillGeneratorServlet")
public class BillGeneratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}