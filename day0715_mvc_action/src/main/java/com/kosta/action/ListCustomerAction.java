package com.kosta.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.action.KostaAction;
import com.kosta.dao.CustomerDAO;
import com.kosta.vo.CustomerVO;

public class ListCustomerAction implements KostaAction {
	private CustomerDAO dao=new CustomerDAO();

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CustomerVO> list = dao.findAll();
		request.setAttribute("list", list);
		String viewPage="listCustomer.jsp";
		return viewPage;
	}

}
