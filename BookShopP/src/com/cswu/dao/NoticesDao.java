package com.cswu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
 
import com.cswu.entity.Notice; 
import com.cswu.utils.C3P0Utils;

/**
 * ֪ͨ������Ϣ���ݲ�����
 * @author Administrator
 *
 */
public class NoticesDao {
	// ������Ϣ
		public boolean insert(Notice notice) {

			Connection conn = null;
			Statement stmt = null;

			String regtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Insert Into  notices (title,detail, createtime,remark) Values('"
						+ notice.getTitle()+ "','" + notice.getDetail()+ regtime + "',''";
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
				String sql = "Delete From  notices Where id=" + id;
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
		public boolean update(Notice notice) {
			Connection conn = null;
			Statement stmt = null;

			String regtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Update notices Set title='" + notice.getTitle() + "',detail='" + notice.getDetail() + "',createtime='" + regtime + "',remark='" + notice.getRemark()
						+ "' Where id=" + notice.getId();
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
		public ArrayList<Notice> findAll() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			ArrayList<Notice> list = new ArrayList<Notice>();
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From notices";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Notice notice = new Notice();
					notice.setId(rs.getInt("id"));
					notice.setTitle(rs.getString("title"));
					notice.setDetail(rs.getString("detail"));
					notice.setCreatetime(rs.getDate("createtime"));
					notice.setRemark(rs.getString("remark"));

					list.add(notice);
				}
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}

		// ��id��ѯ��Ϣ
		public Notice find(int id) {

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = C3P0Utils.getConnection();

				stmt = conn.createStatement();
				String sql = "Select * From notices Where id=" + id;
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Notice notice = new Notice();
					notice.setId(rs.getInt("id"));
					notice.setTitle(rs.getString("title"));
					notice.setDetail(rs.getString("detail"));
					notice.setCreatetime(rs.getDate("createtime"));
					notice.setRemark(rs.getString("remark"));

					return notice;
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;
		}
}
