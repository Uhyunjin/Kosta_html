package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.BoardDAO;
import com.kosta.vo.BoardVO;

public class UpdateBoardAction implements KostaAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao= new BoardDAO();
		
		int no=Integer.parseInt(request.getParameter("no"));
		BoardVO b=dao.findByNo(no);
		//son.png
		String ext=b.getFname().split("\\.")[1];
		ext=ext.toLowerCase();
		String isImg="no";
		if (ext.equals("png")||ext.equals("jpg")||ext.equals("gif")) {
			isImg="yes";
		}
		request.setAttribute("b", dao.findByNo(no));
		
		return "updateBoard.jsp";
	}

}
