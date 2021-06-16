package com.cswu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement; 
import java.util.ArrayList; 

import com.cswu.entity.Item; 
import com.cswu.utils.C3P0Utils;

/**
 * 订单项目信息数据操作类
 * @author Administrator
 *
 */
public class ItemsDao {
	// 插入信息
		public boolean insert(Item item) {

			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Insert Into  orderitems (order_id,product_id,buy_num) Values("
						+ item.getOrder_id()+ "," + item.getProduct_id() + "," +item.getBuy_num();
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

		// 删除信息
		public boolean delete(int id) {

			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Delete From  orderitems Where order_id=" + id;
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

		// 更新信息
		public boolean update(Item item) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Update orderitems Set order_id=" + item.getOrder_id() + ",product_id='" + item.getProduct_id()
						+ ",buy_num=" + item.getBuy_num() +" Where id=" + item.getOrder_id();
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

		// 查询所有信息
		public ArrayList<Item> findAll() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			ArrayList<Item> list = new ArrayList<Item>();
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From orderitems";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Item item = new Item();
					item.setOrder_id(rs.getInt("order_id"));
					item.setProduct_id(rs.getInt("product_id"));
					item.setBuy_num(rs.getInt("buy_num"));

					list.add(item);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		// 按id查询信息
		public Item find(int id) {

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From orderitems Where order_id=" + id;
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Item item = new Item();
					item.setOrder_id(rs.getInt("order_id"));
					item.setProduct_id(rs.getInt("product_id"));
					item.setBuy_num(rs.getInt("buy_num"));

					return item;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
}
