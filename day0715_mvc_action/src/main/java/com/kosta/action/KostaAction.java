package com.kosta.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//미래에 만들어질 해당 요청에 따른 일처리 담당자인 Action들이 가져야 할 공통적인 메서드를 일반화시킨다
public interface KostaAction {
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
