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

public class KostaController extends HttpServlet {
	private CustomerDAO dao;
	public KostaController() {
		dao=new CustomerDAO();
	}
	
	public void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("kosta controller 동작함");
//		String url=request.getRequestURL().toString();
//		String uri=request.getRequestURI().toString();
		
		String uri=request.getRequestURI();
		String cmd=uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);
		String viewPage="";
		request.setCharacterEncoding("UTF-8");
		
		if(cmd.equals("listCustomer.do")) {
			ArrayList<CustomerVO> list = dao.findAll();
			request.setAttribute("list", list);
			viewPage="listCustomer.jsp";
		}else if(cmd.equals("insertCustomer.do")) {
			viewPage="insertCustomer.jsp";
		}else if(cmd.equals("insertCustomerOK.do")) {
			int custid=Integer.parseInt(request.getParameter("custid"));
			String name=request.getParameter("name");
			String addr=request.getParameter("addr");
			String phone=request.getParameter("phone");
			
			CustomerVO vo = new CustomerVO();
			vo.setCustid(custid);
			vo.setName(name);
			vo.setAddress(addr);
			vo.setPhone(phone);
			int re=dao.insert(vo);
			if (re>0) {
				request.setAttribute("msg", "성공");
			}else {
				request.setAttribute("msg", "실패");
			}
			viewPage="insertCustomerOK.jsp";
			
		}else if (cmd.equals("detailCustomer.do")) {
			int custid=Integer.parseInt(request.getParameter("custid"));
			CustomerVO vo=dao.findByCustid(custid);
			request.setAttribute("vo", vo);
			viewPage="detailCustomer.jsp";
			
		}else if (cmd.equals("updateCustomer.do")) {
			int custid=Integer.parseInt(request.getParameter("custid"));
			CustomerVO vo=dao.findByCustid(custid);
			request.setAttribute("vo", vo);
			viewPage="updateCustomer.jsp";
		}else if (cmd.equals("updateCustomerOK.do")) {
			int custid=Integer.parseInt(request.getParameter("custid"));
			String name=request.getParameter("name");
			String addr=request.getParameter("addr");
			String phone=request.getParameter("phone");
			CustomerVO vo=new CustomerVO();
			vo.setCustid(custid);
			vo.setName(name);
			vo.setAddress(addr);
			vo.setPhone(phone);
			int re=dao.udpate(vo);
			if (re>0) {
				request.setAttribute("msg", "성공");
			}else {
				request.setAttribute("msg", "실패");
			}
			viewPage="updateCustomerOK.jsp";
			
		}else if (cmd.equals("deleteCustomer.do")) {
			
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pro(request, response);
	}

}
