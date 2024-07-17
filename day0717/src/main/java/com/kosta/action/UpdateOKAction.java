package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.GoodsDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateOKAction implements KostaAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDAO dao=new GoodsDAO();
		String viewPage="";
		String fname=request.getParameter("fname");
		String path=request.getServletContext().getRealPath("images/"+fname);
		request.setCharacterEncoding("UTF-8");
		MultipartRequest multi=new MultipartRequest(request, path, 1024*1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		int no=Integer.parseInt(multi.getParameter("no"));
		String item=multi.getParameter("item");
		int price=Integer.parseInt(multi.getParameter("price"));
		int qty=Integer.parseInt(multi.getParameter("qty"));
		fname=multi.getParameter("fname");
		
		if (fname!=null) {
			
		}
		return viewPage;
	}

}
