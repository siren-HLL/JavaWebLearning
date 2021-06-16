package com.yxf.bookshop.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxf.bookshop.mapper.NoticesMapper;
import com.yxf.bookshop.model.Notices;

/**
 * 订单信息业务层接口
 * @author 余晓枫，0410190109
 * 
 * */
@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired NoticesMapper noticesMapper;
	
	@Override
	public List<Notices> findAllNotices() {
		// TODO Auto-generated method stub
		return noticesMapper.selectAllNotices();
	}

	@Override
	public Notices findNoticeById(Notices id) {
		// TODO Auto-generated method stub
		return noticesMapper.selectById(id);
	}

	@Override
	public int deleteNoticeById(Notices id) {
		// TODO Auto-generated method stub
		return noticesMapper.deleteById(id);
	}

	@Override
	@Transactional
	public int updateNoticeById(Notices Notice) {
		// TODO Auto-generated method stub
		return noticesMapper.updateByPrimaryKeySelective(Notice);
	}

	@Override
	@Transactional
	public int addNotice(Notices Notice) {
		// TODO Auto-generated method stub
		return noticesMapper.insertSelective(Notice);
	}

}
