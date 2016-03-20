package com.bookstore.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String loginUrl = request.getContextPath() + "/login";
		if (request.getSession().getAttribute("loginUser") == null) {
			System.out.println("No login********");
			response.sendRedirect(loginUrl);
			return false;
		}
		return true;
	}

}
