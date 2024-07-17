package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.CustomerDAO;
import com.kosta.vo.CustomerVO;

/**
 * Servlet implementation class DetailCutomer
 */
@WebServlet("/detailCustomer.do")
public class DetailCutomer extends HttpServlet {
	private CustomerDAO dao;
	public DetailCutomer() {
		dao = new CustomerDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custid = Integer.parseInt(request.getParameter("custid"));
		CustomerVO c= dao.findByCustid(custid);
		request.setAttribute("c", c);
		String viewPage = "detailCustomer.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}









