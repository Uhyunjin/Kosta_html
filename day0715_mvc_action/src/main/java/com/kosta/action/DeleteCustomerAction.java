package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.CustomerDAO;

public class DeleteCustomerAction implements KostaAction {
	private CustomerDAO dao=new CustomerDAO();
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custid=Integer.parseInt(request.getParameter("custid"));
		int re=dao.delete(custid);
		if (re>0) {
			request.setAttribute("msg", "성공");
		}else {
			request.setAttribute("msg", "실패");
		}
		String viewPage="deleteCustomerOK.jsp";
		return viewPage;
	}

}
