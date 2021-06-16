package com.cswu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.cswu.entity.User;
import com.cswu.utils.C3P0Utils;

/**
 * 商品信息数据操作类
 * @author Administrator
 *
 */
public class ProductsDao {
	// 插入信息
		public boolean insert(User user) {

			Connection conn = null;
			Statement stmt = null;

			String regtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Insert Into  users (username,password,gender,email,telephone,introduce,activecode,state,role,registtime,remark) Values('"
						+ user.getUsername() + "','" + user.getPassword() + "','" + user.getGender() + "','"
						+ user.getEmail() + "','" + user.getTelephone() + "','" + user.getIntroduce() + "','',1,'admin','"
						+ regtime + "',''";
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
				String sql = "Delete From  users Where id=" + id;
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
		public boolean update(User user) {
			Connection conn = null;
			Statement stmt = null;

			String regtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Update users Set username='" + user.getUsername() + "',password='" + user.getPassword()
						+ "',gender='" + user.getGender() + "',telephone='" + user.getTelephone() + "',introduce='"
						+ user.getIntroduce() + "',activecode='" + user.getActivecode() + "',state=" + user.getState() + ",role='"
						+ user.getRole() + "',registtime='" + regtime + "',remark='" + user.getRemark()
						+ "' Where id=" + user.getId();
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
		public ArrayList<User> findAll() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			ArrayList<User> list = new ArrayList<User>();
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From users";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setGender(rs.getString("gender"));
					user.setEmail(rs.getString("email"));
					user.setTelephone(rs.getString("telephone"));
					user.setIntroduce(rs.getString("introduce"));
					user.setActivecode(rs.getString("activecode"));
					user.setState(rs.getInt("state"));
					user.setRole(rs.getString("role"));
					user.setRegisttime(rs.getDate("registtime"));
					user.setRemark(rs.getString("remark"));

					list.add(user);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		// 按id查询信息
		public User find(int id) {

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From users Where id=" + id;
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setGender(rs.getString("gender"));
					user.setEmail(rs.getString("email"));
					user.setTelephone(rs.getString("telephone"));
					user.setIntroduce(rs.getString("introduce"));
					user.setActivecode(rs.getString("activecode"));
					user.setState(rs.getInt("state"));
					user.setRole(rs.getString("role"));
					user.setRegisttime(rs.getDate("registtime"));
					user.setRemark(rs.getString("remark"));

					return user;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
}
