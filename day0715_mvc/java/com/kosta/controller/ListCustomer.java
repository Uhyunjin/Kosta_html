package com.kosta.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.CustomerDAO;
import com.kosta.vo.CustomerVO;

@WebServlet("/listCustomer.do")
public class ListCustomer extends HttpServlet {	
	
	private CustomerDAO dao;
	public ListCustomer() {
		dao = new CustomerDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CustomerVO> list = dao.findAll();
		
		//View(jsp)에서 사용할 수 있도록 상태유지 합니다.
		request.setAttribute("list", list);
		request.setAttribute("msg", "hello kosta");
		
		//결과를 보여줄 jsp를 변수에 저장합니다.
		String viewPage = "listCustomer.jsp";
		
		//결과를 보여줄 jsp로 이동시키기 위한 RequestDipatcher 객체를 생성합니다.
		RequestDispatcher dispatcher
		= request.getRequestDispatcher(viewPage);
		
		//jsp로 이동합니다.
		dispatcher.forward(request, response);
		
	}
}









