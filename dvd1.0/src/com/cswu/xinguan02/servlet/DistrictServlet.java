package com.cswu.xinguan02.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu02.other.DB;
import com.cswu02.other.Place;
import com.google.gson.Gson;

/**
 * Servlet implementation class DistrictServlet
 */
@WebServlet("/DistrictServlet")
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");//跨域请求放行
		response.setCharacterEncoding("UTF-8");
		String city = request.getParameter("city");
		System.out.print("city"+city);
		String sql = "Select * from place where parent_id = "+city;
		ResultSet rs = DB.getRS(sql);
//		Set<Place> placise = new HashSet<Place>();//不可重复
		List<Place> placise = new ArrayList<Place>();//可重复，有顺序
		if(rs != null) {
			try {
				while (rs.next()) {
					Place p = new Place();
					p.setId(rs.getInt("id"));
					p.setParent_id(rs.getInt("parent_id"));
					p.setCname(rs.getString("cname"));
					placise.add(p);
				}
				Gson gson = new Gson();
				String json = gson.toJson(placise);
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
