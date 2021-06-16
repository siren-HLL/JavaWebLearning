package com.cswu.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cswu.entity.Loginer;

public class IndexServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{

		//获取当前页面的Session对象（共享） 
		HttpSession session=req.getSession();
		//获取Session中的用户信息对象 
		Loginer loginer=(Loginer)session.getAttribute("loginer");

		if(loginer==null){
			//用户未登录，跳转登录页面
			resp.sendRedirect("/BookShop/login.html");
		}else{
			//用户已登录，跳转主页面
			resp.sendRedirect("/BookShop/mainframe.html");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
	   doGet(req,resp);
	}

}
