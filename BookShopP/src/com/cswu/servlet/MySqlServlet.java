package com.cswu.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʵ��Java����Mysql������
 * @author Administrator
 *
 */
public class MySqlServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse resp){
		
		try{
		//Java����Mysql���ݿ�Ĳ��裺
		//1.ע��MySql���������� 
		  Class.forName("com.mysql.jdbc.Driver");
		//2.����һ�����ݿ�����(Connection����)
		  String url="jdbc:mysql://localhost:3306/bookstore";
		  Connection conn=DriverManager.getConnection(url,"root","yxf1204mr1010");
		//3.�������ݿ����ӵ�״̬(Statement���� )
		  Statement stmt=conn.createStatement();
		//4.ͨ��Statement����ִ��Sql��� 
		  boolean b=stmt.execute("insert into users ()Values()");//ִ�в��롢ɾ�������µ���䣬����boolean
		  ResultSet result=stmt.executeQuery("select * from users");//ִ�в�ѯ��䣬����ResultSet�����
		  
		  //���������
		  while(result.next()){
			  result.getString(0);//ͨ���е�������Ž��з���ֵ 
			  result.getString("name");//ͨ���ֶ����Ʒ���ֵ 
			  result.getInt("age");			  
		  }	  		  
		  
		//5.�ر����ӣ��ͷ���Դ
		  result.close();
		  stmt.close();
		  conn.close();	  
		  
		}catch(Exception e){
			
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse resp){
		
	}

}
