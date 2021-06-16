package com.yxf.bookshop.service.notice;

import java.util.List;

import com.yxf.bookshop.model.Notices;

/**
 * 通知公告业务层接口
 * @author 余晓枫，0410190109
 * 
 * */
public interface NoticeService {
	//查询所有公告
		public List<Notices> findAllNotices();
		//通过id查找公告
		public Notices findNoticeById(Notices id);
		//通过id删除公告
		public int deleteNoticeById(Notices id);
		//通过id更新公告
		public int updateNoticeById(Notices Notice);
		//新增公告
		public int addNotice(Notices Notice);
}
