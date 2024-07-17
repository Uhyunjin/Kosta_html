package com.kosta.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dao.BoardDAO;
import com.kosta.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class InsertBoardOKAction implements KostaAction {
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao=new BoardDAO();
		
		
		//업로드할 폴더(upload)의 실 경로를 알아옵니다.
		String path=request.getServletContext().getRealPath("upload");
		System.out.println("path : "+path);
		
		//객체를 생성하는 순간 파일은 서버의 지정한 경로가 업로드되고 
		//나머지 사용자 입력한 정보를 멀티 객체가 갖고있다
		MultipartRequest multi=new MultipartRequest(request,path,1024*1024*1024, "UTF-8",
				 new DefaultFileRenamePolicy());
				
		request.setCharacterEncoding("UTF-8");
		String fname=multi.getOriginalFileName("uploadFile");
		File file=new File(path+"/"+fname);
		int fsize=(int)file.length();
		String title=multi.getParameter("title");
		String writer=multi.getParameter("writer");
		String pwd=multi.getParameter("pwd");
		String content=multi.getParameter("content");
		
		BoardVO vo=new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setPwd(pwd);
		vo.setContent(content);
		vo.setFname(fname);
		vo.setFsize(fsize);
		
		int re=dao.insert(vo);
		request.setAttribute("re", re);
		
		return "insertBoardOK.jsp";
	}
}
