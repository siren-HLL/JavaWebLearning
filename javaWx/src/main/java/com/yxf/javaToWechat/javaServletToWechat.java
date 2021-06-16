package com.yxf.javaToWechat;


import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class javaServletToWechat
 */
@WebServlet("/javaServletToWechat")
public class javaServletToWechat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1)姓名：字符串  2)性别：对象数组  3)专业爱好：对象数组  4)意见：字符串
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//post	
		//设置响应头允许ajax跨域访问,星号表示所有的异域请求都可以接受
		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST"); 
        
      //定义一个map
      Map<String, Object> formValue = new LinkedHashMap<String,Object>();
      //String[] str = new String[]{"","","","",""}; 
      formValue.put("name","李七");
      formValue.put("gender",new gender[]{new gender("男","1","false"),
				                          new gender("女","0","true")});
      formValue.put("skills",new skills[]{new skills("HTML","html","false"),
					                      new skills("CSS","css","false"),
	                                      new skills("JavaScript","js","false"),
	                                      new skills("Photoshop","ps","false")});
      formValue.put("opinion","测试问卷调查-余晓枫");
      
      //将对象数组转为json
      Gson gson = new Gson();
      String json = gson.toJson(formValue);	
      System.out.println(json);
      Writer out = response.getWriter();
      out.write(json);
      out.flush();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this.doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");//处理客户端请求乱码问题
		
		// 设置响应头允许ajax跨域访问，星号表示所有异域请求都可以接受
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		//获取微信小程序传递的参数并打印
		String opinion = request.getParameter("opinion");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] skills = request.getParameterValues("skills");
		//处理客户端请求乱码问题（doget方法）
		//transInfo =new String(transInfo.getBytes("iso8859-1"),"utf-8");
		
		System.out.println("接收到小程序传递的数据:"+name);
		System.out.println("接收到小程序传递的数据:"+gender);
		System.out.println("接收到小程序传递的数据:"+opinion);
		for(int i = 0;i < skills.length; i++) {
			if (i+1 == skills.length) {
				System.out.println("接收到小程序传递的数据:"+skills[i]);
			} else {
				System.out.println("接收到小程序传递的数据:"+skills[i]+",");
			}
		}
		//向小程序传递数据
		Writer out = response.getWriter();
		out.write("嗨，我已经接收到你的表单数据啦!");
		out.flush();

	}

}
