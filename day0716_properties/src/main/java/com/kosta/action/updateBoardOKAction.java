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

public class updateBoardOKAction implements KostaAction {
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path=request.getServletContext().getRealPath("upload");
		System.out.println(path);
		MultipartRequest multi=new MultipartRequest(request, path, 1024*1024*1024*5,"UTF-8", new DefaultFileRenamePolicy());
		
		BoardDAO dao=new BoardDAO();
		
		int no=Integer.parseInt(multi.getParameter("no"));
		String title=multi.getParameter("title");
		String writer=multi.getParameter("writer");
		String pwd=multi.getParameter("pwd");
		String content=multi.getParameter("content");
		String oldFname=multi.getParameter("fname");
		int oldFsize = Integer.parseInt(multi.getParameter("fzise"));
		
		
		
		BoardVO vo=new BoardVO();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setPwd(pwd);
		vo.setContent(content);
		vo.setFname(oldFname);
		vo.setFsize(oldFsize);
		
		String fname=multi.getOriginalFileName("uploadFile");
		
		//만약 업로드한 파일이 있다면
		if (fname!=null) {
			File file=new File(path+'/'+fname);
			int fsize =(int)file.length();
			vo.setFname(fname);
			vo.setFsize(fsize);
		}
		
		if(fname==null) {
			System.out.println("첨부파일 없음");
		}else {
			System.out.println("첨부파일 있음");
		}
		
		int re=dao.update(vo);
		
		//게시물 수정에 성공했고 파일도 수정했다면 원래의 파일을 삭제합니다
		if(re>0 && fname!=null) {
			File file = new File(path+'/'+oldFname);
			file.delete();
		}
		
		request.setAttribute("re", re);
		return "insertBoardOK.jsp";
	}

}
