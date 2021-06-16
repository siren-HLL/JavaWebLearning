package com.cswu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.cswu.entity.Menu;
import com.cswu.entity.User;
import com.cswu.utils.C3P0Utils;

/**
 * �˵���Ϣ���ݲ�����
 * @author Administrator
 *
 */
public class MenusDao {
	// ������Ϣ
		public boolean insert(Menu menu) {

			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Insert Into  menus ( name,url,target,remark) Values('"
						+ menu.getName() + "','" + menu.getUrl() + "','" + menu.getTarget() + "','"
						+  menu.getRemark() + "'";
				int num = stmt.executeUpdate(sql);

				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}

		// ɾ����Ϣ
		public boolean delete(int id) {

			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Delete From  menus Where id=" + id;
				int num = stmt.executeUpdate(sql);

				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}

		// ������Ϣ
		public boolean update(Menu menu) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Update users Set name='" + menu.getName() + "',url='" + menu.getUrl()
						+ "',target='" + menu.getTarget()+ "',remark='" + menu.getRemark()
						+ "' Where id=" + menu.getId();
				int num = stmt.executeUpdate(sql);

				if (num > 0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}

		// ��ѯ������Ϣ
		public ArrayList<Menu> findAll() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			ArrayList<Menu> list = new ArrayList<Menu>();
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From menus";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Menu menu = new Menu();
					menu.setId(rs.getInt("id"));
					menu.setName(rs.getString("name"));
					menu.setUrl(rs.getString("url"));
					menu.setTarget(rs.getString("target"));					
					menu.setRemark(rs.getString("remark"));

					list.add(menu);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		// ��id��ѯ��Ϣ
		public Menu find(int id) {

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From menus Where id=" + id;
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Menu menu = new Menu();
					menu.setId(rs.getInt("id"));
					menu.setName(rs.getString("name"));
					menu.setUrl(rs.getString("url"));
					menu.setTarget(rs.getString("target"));					
					menu.setRemark(rs.getString("remark"));

					return menu;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
}
