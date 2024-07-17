package com.kosta.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.print.DocFlavor.READER;
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
//		map.put("join.do", new JoinAction());
//		map.put("joinOK.do", new JoinOKAction());
//		map.put("login.do", new LoginAction());
//		map.put("loginOK.do", new LoginOKAction());

		
		//프로퍼티 파일이 있는 실제경로를 알아옵니다
		String path=config.getServletContext().getRealPath("/WEB-INF");
		try {
			//프로퍼티 파일을 문자단위로 읽어들이기 위한 스트림생성
			Reader reader=new FileReader(path+"/kosta.properties");			
			//프로퍼티 파일을 처리하기 위한 객체를 생성
			Properties prop=new Properties();
			//프로퍼티 객체에 파일을 읽어들인다
			prop.load(reader);
			//프로퍼티 객체로부터 키를 뽑아온다
			Set keys=prop.keySet();
			//key의 수 만큼 반복실행시키기 위해서 이터레이터로 만들어준다
			Iterator iter = keys.iterator();
			//key를 갖고 있는 set을 반복시키기 위한 iterator에 데이터가 있는 만큼 반복실행한다.
			while(iter.hasNext()) {
				String key=(String)iter.next();	//iter에 데이터를 꺼내오면 key
				String clsName=prop.getProperty(key);
				//프로퍼티 객체로부터 key에 해당하는 객체를 꺼내어오는것이 일처리를 위한 action클래스 이름
				
				//clsName에는 클래스이름이 문자열로 저장되어있다
				//com.kosta.action.JoinAction
				//이것으로 객체를 생성해야한다.(new)
				Object obj=Class.forName(clsName).newInstance();
				
				//생성된 객체와 key를 map에 등록한다
				map.put(key, (KostaAction)obj);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
