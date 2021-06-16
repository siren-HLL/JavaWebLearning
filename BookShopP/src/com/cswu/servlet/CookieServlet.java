package com.cswu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �Ự������Cookie����
 * @author Administrator
 *
 */
public class CookieServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		String lastTime=null;
		
		//获取浏览器中的Cookie（key-value）
		Cookie[] myCookies=req.getCookies();//Cookies����
		
		//遍历Cookie列表
		for(int i=0; myCookies !=null && i< myCookies.length;i++){
			if(myCookies[i].getName().equals("lastAccess")){
				lastTime=myCookies[i].getValue();
				break;
			}
		}
		
		String str="";
		if(lastTime==null){
			str="This is your first visit to this site little motherfucker!!";
		}else{
			str="你上次访问的时间是："+lastTime;
		}
		
		//输出中文
		resp.setHeader("Content-Type", "text/html;charset=utf-8");
		
		PrintWriter pw=resp.getWriter();
		pw.write(str);
		
		//��ȡ��ǰϵͳʱ��
		String time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		
		Cookie cookie=new Cookie("lastAccess",time);
		cookie.setMaxAge(3000);//����Cookie����Чʱ�䣬��λ ����
		resp.addCookie(cookie); //����������Cookie
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}
}
