package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 退出当前登录的Servlet
 * @author Administrator
 *
 */
public class LogoutServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		//获取当前页面的Session对象 
		HttpSession session=req.getSession();
		//删除Session中的用户信息
		session.removeAttribute("loginer");
		
		//跳转到首页
		resp.sendRedirect("/BookShop/index");
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		doGet(req,resp);
	}

}
