package com.cswu;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义MyServlet类，实现Servlet接口
 * 两个默认接口实现类(Servlet)：GenericServlet(抽象类),HttpServlet(GenericServlet的子类)
 * 只需继承HttpServlet
 * 
 * @author Siren
 * */
public class MyServlet implements Servlet{//实现接口

	// 初始化方法
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	// 获取配置信息web.xml
	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}
	
	// 获取Servlet基本信息
	@Override
	public String getServletInfo() {
		
		return null;
	}

	//服务方法：实现接收请求ServletRequest，返回响应数据ServletResponse
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
	}
	
	// Servlet销毁
	@Override
	public void destroy() {
		
		
	}

}
