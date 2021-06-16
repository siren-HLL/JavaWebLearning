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

		//��ȡ��ǰҳ���Session���󣨹��� 
		HttpSession session=req.getSession();
		//��ȡSession�е��û���Ϣ���� 
		Loginer loginer=(Loginer)session.getAttribute("loginer");

		if(loginer==null){
			//�û�δ��¼����ת��¼ҳ��
			resp.sendRedirect("/BookShop/login.html");
		}else{
			//�û��ѵ�¼����ת��ҳ��
			resp.sendRedirect("/BookShop/mainframe.html");
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
	   doGet(req,resp);
	}

}
