package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.CustomerDAO;
import com.kosta.vo.CustomerVO;

public class UpdateCustomerAction implements KostaAction {

	private CustomerDAO dao=new CustomerDAO();
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custid=Integer.parseInt(request.getParameter("custid"));
		CustomerVO vo=dao.findByCustid(custid);
		request.setAttribute("vo", vo);
		String viewPage="updateCustomer.jsp";
		return viewPage;
	}

}
