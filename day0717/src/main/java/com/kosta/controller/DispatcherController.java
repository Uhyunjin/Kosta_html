package com.kosta.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.action.KostaAction;

@WebServlet("*.do")
public class DispatcherController extends HttpServlet {
	HashMap<String, KostaAction> map;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map=new HashMap<String, KostaAction>();
		try {
			String path=config.getServletContext().getRealPath("/WEB-INF");					
			Reader reader=new FileReader(path+"/kosta.properties");
			Properties prop=new Properties();
			prop.load(reader);
			Set keys=prop.keySet();
			Iterator iter=keys.iterator();
			while(iter.hasNext()) {
				String key=(String)iter.next();
				String clsName=prop.getProperty(key);
				Object obj=Class.forName(clsName).newInstance();
				map.put(key, (KostaAction)obj);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		KostaAction action=null;
		String uri=request.getRequestURI();
		String key=uri.substring(uri.lastIndexOf("/")+1);
		action= map.get(key);
		String viewPage=action.pro(request, response);
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pro(request,response);
	}

}
