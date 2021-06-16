package com.yxf.bookshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yxf.bookshop.model.Menus;
import com.yxf.bookshop.model.Notices;
import com.yxf.bookshop.model.Orders;
import com.yxf.bookshop.service.menu.MenuService;
import com.yxf.bookshop.service.notice.NoticeService;


/**
 * 商城后台消息公告页面
 * @author 余晓枫，0410190109
 * 
 * */
@Controller
public class NoticeController {
	@Autowired MenuService menuService;
	@Autowired NoticeService noticeService;
	
	
	 //公告信息页面
	@RequestMapping(value = "/admin/noticeInfo", method = RequestMethod.GET)
	public ModelAndView noticeInfoPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("notice/noticeInfo");
		List<Notices> notice = noticeService.findAllNotices();
		List<Menus> menuInfo = menuService.findAllMenus();
		model.addObject("menus", menuInfo);
		model.addObject("notice", notice);
		return model;
	}
	//公告编辑版面
	@RequestMapping(value = "/admin/notice/EditGet", method = RequestMethod.GET)
	public ModelAndView editProduct(Notices id){
		ModelAndView model = new ModelAndView();
		Notices notice = noticeService.findNoticeById(id);
		List<Menus> menuInfo = menuService.findAllMenus();
		model.addObject("menus", menuInfo);
		model.addObject("notice", notice);
		model.setViewName("notice/noticeEdit");
		return model;
	}
}
