package com.yxf.bookshop.controller.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yxf.bookshop.common.ApiResponseEnum;
import com.yxf.bookshop.common.ApiResponseObject;
import com.yxf.bookshop.model.Notices;
import com.yxf.bookshop.model.Orders;
import com.yxf.bookshop.service.notice.NoticeService;

/**
 * 消息公告控制层
 * @author 余晓枫，0410190109
 * 
 * */
@RestController
@RequestMapping("api/v1")
public class NoticesApiController extends AbstractApiController{
	@Autowired NoticeService noticeService;
	
	//删除订单，传id
		@RequestMapping(value = "notice/deleteNoticePost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject deleteNoticePost(@RequestBody Notices id)throws IllegalAccessException, InvocationTargetException {
			int row = noticeService.deleteNoticeById(id);
			String status = "";
			if(row > 0) {
				System.out.println("成功删除"+row+"条数据");
				status = "true";
			}else {
				System.out.println("删除失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
		
		//新增公告信息
		@RequestMapping(value = "notice/addNoticePost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject addOrderPost(@RequestBody Notices record)throws IllegalAccessException, InvocationTargetException {
			Date now = new Date();
			record.setCreatetime(now);
			int row = noticeService.addNotice(record);
			String status = "";
			if(row > 0) {
				System.out.println("成功新增"+row+"条数据");
				status = "true";
			}else {
				System.out.println("新增失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
		
		//编辑公告信息
		@RequestMapping(value = "notice/editNoticePost", method = RequestMethod.POST, headers = "Accept=application/json")
		public ApiResponseObject editOrdertPost(@RequestBody Notices record )throws IllegalAccessException, InvocationTargetException {
//			Date now = new Date();
//			record.setOrderTime(now);
			int row = noticeService.updateNoticeById(record);
			String status = "";
			if(row > 0) {
				System.out.println("成功更改"+row+"条数据");
				status = "true";
			}else {
				System.out.println("更改失败");
				status = "false";
			}
			return this.reponseJSON(ApiResponseEnum.SUCCESS.getCode(), ApiResponseEnum.SUCCESS.getName(),status);
		}
}
