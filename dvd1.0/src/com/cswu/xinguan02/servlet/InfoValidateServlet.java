package com.cswu.xinguan02.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu02.other.DB;
import com.cswu02.other.Place;
import com.cswu02.other.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmailCheck
 */
@WebServlet("/InfoValidateServlet")
public class InfoValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");//跨域请求放行
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String email = request.getParameter("email");
		System.out.println(email);
		if(!email.equals("")) {
			String sql = "Select * from user where email = "+ "\'"+email+ "\'";
			ResultSet rs = DB.getRS(sql);
			List<User> users = new ArrayList<User>();
			try {
				if(rs.next()) {
					response.getWriter().print("false");
				}else {
					response.getWriter().print("true");
				}
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}else {
			System.out.println("空");
			response.getWriter().print("");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
