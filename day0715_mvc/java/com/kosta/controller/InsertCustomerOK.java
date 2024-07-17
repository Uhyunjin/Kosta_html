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

@WebServlet("/insertCustomerOK.do")
public class InsertCustomerOK extends HttpServlet {
	
	private CustomerDAO dao;
	public InsertCustomerOK() {
		dao = new CustomerDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int custid = Integer.parseInt(request.getParameter("custid"));
		String name= request.getParameter("name");
		String address= request.getParameter("address");
		String phone= request.getParameter("phone");
		
		CustomerVO c= new CustomerVO();
		c.setCustid(custid);
		c.setName(name);
		c.setAddress(address);
		c.setPhone(phone);
		
		int re = dao.insert(c);
		if(re > 0) {
			request.setAttribute("msg", "고객등록에 성공하였습니다.");
		}else {
			request.setAttribute("msg", "고객등록에 실패하였습니다.");
		}
		String viewPage = "insertCustomerOK.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}










