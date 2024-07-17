package com.kosta.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.action.JoinAction;
import com.kosta.action.JoinOKAction;
import com.kosta.action.KostaAction;
import com.kosta.action.LoginAction;
import com.kosta.action.LoginOKAction;

/**
 * Servlet implementation class KostaController
 */
@WebServlet("*.do") //모든 .do 패턴일 때 코스타 컨트롤러가 동작한다
public class KostaController extends HttpServlet {
	
	HashMap<String, KostaAction> map;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 생성자에서 초기화해도 되지만 초기화할때 사용하라고 만들어놓은 서블릿 메서드
		map= new HashMap<String, KostaAction>();
		map.put("join.do", new JoinAction());
		map.put("joinOK.do", new JoinOKAction());
		map.put("login.do", new LoginAction());
		map.put("loginOK.do", new LoginOKAction());
	}

	protected void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();	//요청한 uri 알아오기
		String cmd=uri.substring(uri.lastIndexOf("/")+1);	//uri의 끝에서부터 슬래시를 만나는 부분까지 자르기
		System.out.println(cmd);
		KostaAction action=null;
		request.setCharacterEncoding("UTF-8");
		
//		if (cmd.equals("join.do")) {
//			action=new JoinAction();
//		}else if (cmd.equals("joinOK.do")) {
//			action=new JoinOKAction();
//		}else if (cmd.equals("login.do")) {
//			action=new LoginAction();
//		}else if (cmd.equals("loginOK.do")) {
//			action=new LoginOKAction();
//		}
		// if ~ else문이 아래 한 줄로 끝났다!
		action=map.get(cmd);
		
		String viewPage=action.pro(request, response);
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);	// 해당 액션에서 필요한 데이터를 상태유지해서 보낸다.
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pro(request, response);
	}

}
