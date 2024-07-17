package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.MemberDAO;
import com.kosta.vo.MemberVO;

public class JoinOKAction implements KostaAction {
	private MemberDAO dao;
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao=new MemberDAO();
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		MemberVO vo=new MemberVO(id,pwd,name);
		int re=dao.insert(vo);
		request.setAttribute("re", re);
		return "joinOK.jsp";
	}

}
