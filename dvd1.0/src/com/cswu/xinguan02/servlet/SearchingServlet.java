package com.cswu.xinguan02.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cswu02.other.DB;
import com.cswu02.other.DVD;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchingServlet
 */
@WebServlet("/SearchingServlet")
public class SearchingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public SearchingServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");//跨域请求放行
		String title = request.getParameter("title");//获取前台传的数值
		List<DVD> dvds = new ArrayList<DVD>();
		if(!title.equals("")) {
			String sql = "select * from dvd where title like '%" +title+ "%'";
			ResultSet rs = DB.getRS(sql);
			try {
				while (rs.next()) {
					DVD dvd = new DVD();
					dvd.setTitle(rs.getString("title"));
					dvds.add(dvd);
				}
				Gson gson = new Gson();
				String json = gson.toJson(dvds);
				response.getWriter().println(json);
				System.out.println(title);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
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
