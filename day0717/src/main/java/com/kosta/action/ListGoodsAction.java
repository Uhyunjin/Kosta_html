package com.kosta.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.GoodsDAO;
import com.kosta.vo.GoodsVO;

public class ListGoodsAction implements KostaAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDAO dao=new GoodsDAO();
		request.setAttribute("list", dao.findAll());
		return "listGoods.jsp";
	}

}
