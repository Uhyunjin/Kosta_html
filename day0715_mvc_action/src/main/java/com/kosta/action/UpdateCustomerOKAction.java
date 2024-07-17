package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.CustomerDAO;
import com.kosta.vo.CustomerVO;

public class UpdateCustomerOKAction implements KostaAction {
	
	private CustomerDAO dao = new CustomerDAO();
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String viewPage="updateCustomerOK.jsp";
		return viewPage;
	}

}
