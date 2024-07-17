package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.BoardDAO;

public class DeleteBoardOKAction implements KostaAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="";
		int no=Integer.parseInt(request.getParameter("no"));
		String pwd=request.getParameter("pwd");
		BoardDAO dao = new BoardDAO();
		int re=dao.delete(no,pwd);
		
		if (re>0) {
			viewPage="listBoard.jsp";
		}else {
			request.setAttribute("msg", "게시물 삭제에 실패하였습니다");
			viewPage="error.jsp";
		}
		return viewPage;
	}

}
