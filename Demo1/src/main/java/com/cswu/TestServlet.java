package com.cswu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Siren 
 * TextServlet继承HttpServlet类：两个方法doPost;doGet(重写
 * HttpServletRequest:浏览器提交的数据
 * HttpServletResponse：输出到浏览器的数据
 * 这个文件不用注释配置，servlet映射关系在web.xml里
 * 教材第三章：创建项目，servlet多重映射，ServletConfig和ServletContext
 * ServletConfig配置信息，辅助信息
 * ServletContext实现多个servlet之间的信息共享
 * 做ServletContext的时候需要注意先运行信息存储的那个servlet，将信息保存到上下文中，再运行需要使用其信息的servlet
 * 请求数据包（只能获取），响应数据包
 * 
 * 
 * 
 */

//@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet{
	@Override
//	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
//		try {
//			PrintWriter pw = resp.getWriter();//获取响应对象的输出流
//			pw.write("hello world");//输出字符串
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
			//请求数据包：（请求头部+请求体）浏览器版本，http版本，编码语言..
			//请求头只能获取不能写
			//响应数据包：（响应头部+响应体）状态404，服务器版本，http版本，服务器信息..
			resp.setContentType("text/html;charset=utf-8");//设置响应头部的ContentType字段
			//resp.setStatus(404);
		
			PrintWriter pw = resp.getWriter();//获取响应对象的输出流
			pw.write("hello world");//输出字符串
			
			ServletConfig sc = this.getServletConfig();//ServletConfig接口,配置信息
			String t = sc.getInitParameter("test");//返回的是初始化参数名为test的值
			pw.write("test="+t);
			
			//将name的值存储在ServletContext（上下文）
			ServletContext sct = this.getServletContext();//返回context(上下文)对象，实现多个servlet之间的信息共享
			sct.setAttribute("name", "zhangsan");
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}
