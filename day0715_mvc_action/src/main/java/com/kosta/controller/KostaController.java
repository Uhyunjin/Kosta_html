package com.kosta.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.action.DeleteCustomerAction;
import com.kosta.action.DetailCustomerAction;
import com.kosta.action.InsertCustomerAction;
import com.kosta.action.InsertCustomerOKAction;
import com.kosta.action.KostaAction;
import com.kosta.action.ListCustomerAction;
import com.kosta.action.UpdateCustomerAction;
import com.kosta.action.UpdateCustomerOKAction;
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
		
		request.setCharacterEncoding("UTF-8");
		KostaAction action=null;
		
		if(cmd.equals("listCustomer.do")) {
			action=new ListCustomerAction();
		}else if(cmd.equals("insertCustomer.do")) {
			action=new InsertCustomerAction();
		}else if(cmd.equals("insertCustomerOK.do")) {
			action=new InsertCustomerOKAction();
		}else if (cmd.equals("detailCustomer.do")) {
			action=new DetailCustomerAction();
		}else if (cmd.equals("updateCustomer.do")) {
			action=new UpdateCustomerAction();
		}else if (cmd.equals("updateCustomerOK.do")) {
			action=new UpdateCustomerOKAction();
		}else if (cmd.equals("deleteCustomer.do")) {
			action=new DeleteCustomerAction();
		}
		
		String viewPage=action.pro(request, response);
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
