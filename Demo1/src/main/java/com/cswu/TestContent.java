package com.cswu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***/
public class TestContent extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取上下文对象（获取其他servlet内的信息）
		//需要注意先执行信息存储的那个servlet
		ServletContext sct =this.getServletContext();
		String n = sct.getAttribute("name").toString();
		
		PrintWriter pw = resp.getWriter();
		pw.write("name="+n);
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}
