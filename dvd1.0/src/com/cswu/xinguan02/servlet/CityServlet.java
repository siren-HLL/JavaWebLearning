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
import com.google.gson.Gson;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin", "*");//跨域请求放行
		response.setCharacterEncoding("UTF-8");
		String province_id =  request.getParameter("province");
		System.out.println("province"+province_id);
		String sql = "Select * from place where parent_id = "+province_id; 
		ResultSet rs = DB.getRS(sql);
		List<Place> places = new ArrayList<Place>();
		if(rs != null) {
			try {
				while (rs.next()) {//一般和ResultSet对象和while循环一起使用，去迭代结果集，并在循环中调用getXXX(intfieldIndex)/getXXX(String columnName)方法获取字段值。
					Place p = new Place();
					p.setId(rs.getInt("id"));
					p.setParent_id(rs.getInt("parent_id"));
					p.setCname(rs.getString("cname"));
					places.add(p);
				}
				Gson gson = new Gson();
				String json = gson.toJson(places);
				response.getWriter().println(json);
			} catch (SQLException e) {
				e.printStackTrace();//打印堆栈踪迹
			}
			
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
