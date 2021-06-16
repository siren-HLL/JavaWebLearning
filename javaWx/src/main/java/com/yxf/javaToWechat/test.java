package com.yxf.javaToWechat;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");//处理客户端请求乱码问题
		
		// 设置响应头允许ajax跨域访问，星号表示所有异域请求都可以接受
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序传递的参数并打印
		String studentId = req.getParameter("studentId");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String time = req.getParameter("time");
		String schoolName = req.getParameter("schoolName");
		String subject = req.getParameter("subject");
		String[] skills = req.getParameterValues("skills");
		//处理客户端请求乱码问题（doget方法）
		//transInfo =new String(transInfo.getBytes("iso8859-1"),"utf-8");
		
		System.out.println("接收到小程序传递的数据:"+name);
		System.out.println("接收到小程序传递的数据:"+id);
		System.out.println("接收到小程序传递的数据:"+schoolName);
		for(int i = 0;i < skills.length; i++) {
			if (i+1 == skills.length) {
				System.out.println("接收到小程序传递的数据:"+skills[i]);
			} else {
				System.out.println("接收到小程序传递的数据:"+skills[i]+",");
			}
		}
		//向小程序传递数据
		Writer out = resp.getWriter();
		out.write("嗨，我已经接收到你的表单数据啦!");
		out.flush();
	}

}
