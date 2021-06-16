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
import com.cswu02.other.DVD;
import com.google.gson.Gson;
/**
 * Servlet implementation class DVDServlet
 */
@WebServlet("/DVDServlet")
public class DVDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DVDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决跨域问题
		response.setHeader("Access-Control-Allow-Origin", "*");   
		
		
		String filter = request.getParameter("filter");
		String titleCondition = request.getParameter("title-condition");
		String title = request.getParameter("title");
		String binderMin = request.getParameter("binder-min");
		String binderMax = request.getParameter("binder-max");
		String yearMin = request.getParameter("year-min");
		String yearMax = request.getParameter("year-max");
		String viewed = request.getParameter("viewed");
		
		System.out.println(filter + "=========" + titleCondition);
		String titleSql = "";
		String binderSql = "";
		String yearSql = "";
		String viewedSql = "";
		
		if(titleCondition != null){
			if(titleCondition.equals("contains")){
				titleSql = "title like '%" + title + "%'";
			}else if(titleCondition.equals("starts-with")){
				titleSql = "title like '" + title + "%'";
			}else if(titleCondition.equals("ends-with")){
				titleSql = "title like '%" + title + "'";
			}else if(titleCondition.equals("equals")){
				titleSql = "title = '" + title + "'";
			}
		}else{
			titleSql = "1 = 1";
		}
		
		if(binderMin != null){
			if(!binderMin.equals("")){
				binderSql = " and binder >= " + binderMin;
			}
		}
		
		if(binderMax != null){
			if(!binderMax.equals("")){
				binderSql = binderSql + " and binder <= " + binderMax;
			}
		}
		
		if(yearMin != null){
			if(!yearMin.equals("")){
				yearSql = " and year >= " + yearMin;
			}
		}
		if(yearMax != null){
			if(!yearMax.equals("")){
				yearSql = yearSql + " and year <= " + yearMax;
			}
		}
		
		if(viewed != null){
			viewedSql = " and viewed = '" + viewed + "'";
		}
		
		
		
		String sql = "select * from dvd where " + titleSql + binderSql + yearSql + viewedSql;
		
		System.out.println(sql);
		ResultSet rs = DB.getRS(sql);
		List<DVD> dvds = new ArrayList<DVD>();
		try {
			while(rs.next()){
				DVD dvd = new DVD();
				dvd.setTitle(rs.getString("title"));
				dvd.setViewed(rs.getString("viewed"));
				dvd.setPage(rs.getInt("page"));
				dvd.setSlot(rs.getInt("slot"));
				dvd.setYear(rs.getInt("year"));
				dvd.setBinder(rs.getInt("binder"));
				dvds.add(dvd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(dvds);
		response.getWriter().println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
