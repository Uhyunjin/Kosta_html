package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.GoodsDAO;

public class DetailAction implements KostaAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no=Integer.parseInt(request.getParameter("no"));
		GoodsDAO dao=new GoodsDAO();
		request.setAttribute("vo", dao.findByNo(no));
		return "detailGoods.jsp";
	}

}
