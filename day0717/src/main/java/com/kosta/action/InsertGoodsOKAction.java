package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.GoodsDAO;
import com.kosta.vo.GoodsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertGoodsOKAction implements KostaAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//다른 데이터들과 함께 파일도 받기 위해서는 multipartRequest 객체를 생성해야 한다.
		//1.파일을 복사할 실제 경로 알아보기
		String path=request.getServletContext().getRealPath("images");
		MultipartRequest multi=new MultipartRequest(request, path, 1024*1024*1024*5, "UTF-8", new DefaultFileRenamePolicy());
		
		
//		int no=Integer.parseInt(multi.getParameter("no"));
		String item=multi.getParameter("item");
		int price = Integer.parseInt(multi.getParameter("price"));
		int qty=Integer.parseInt(multi.getParameter("qty"));
		String fname=multi.getOriginalFileName("uploadFile");
		GoodsVO vo=new GoodsVO();
		vo.setItem(item);
		vo.setPrice(price);
		vo.setQty(qty);
		vo.setFname(fname);
		GoodsDAO dao=new GoodsDAO();
		int re= dao.insert(vo);
		request.setAttribute("re", re);
		
		return "insertGoodsOK.jsp";
	}

}
